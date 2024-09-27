/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin

import org.gradle.api.Project
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.gradle.api.tasks.TaskProvider
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask
import org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask
import org.jetbrains.kotlin.gradle.tasks.*
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.tasks.configuration.KaptGenerateStubsConfig
import org.jetbrains.kotlin.gradle.tasks.configuration.KaptWithoutKotlincConfig
import org.jetbrains.kotlin.gradle.tasks.configuration.KotlinCompileConfig
import org.jetbrains.kotlin.gradle.utils.KotlinJvmCompilerOptionsDefault
import org.jetbrains.kotlin.gradle.utils.injected
import javax.inject.Inject

/** Plugin that can be used by third-party plugins to create Kotlin-specific DSL and tasks (compilation and KAPT) for JVM platform. */
abstract class KotlinBaseApiPlugin : DefaultKotlinBasePlugin(), KotlinJvmFactory {

    private lateinit var myProject: Project
    private val taskCreator = KotlinTasksProvider()

    @get:Inject
    override val providerFactory: ProviderFactory
        get() = injected

    override fun apply(project: Project) {
        super.apply(project)
        myProject = project
        setupAttributeMatchingStrategy(project, isKotlinGranularMetadata = false)
    }

    override fun addCompilerPluginDependency(dependency: Provider<Any>) {
        myProject.dependencies.addProvider(
            PLUGIN_CLASSPATH_CONFIGURATION_NAME,
            dependency
        )
    }

    override fun getCompilerPlugins(): FileCollection {
        return myProject.configurations.getByName(PLUGIN_CLASSPATH_CONFIGURATION_NAME)
    }

    override fun createCompilerJvmOptions(): KotlinJvmCompilerOptions {
        return myProject.objects.KotlinJvmCompilerOptionsDefault(myProject)
    }

    @Suppress("DEPRECATION")
    @Deprecated("Replaced by compilerJvmOptions", replaceWith = ReplaceWith("createCompilerJvmOptions()"))
    override fun createKotlinJvmOptions(): KotlinJvmOptions {
        return object : KotlinJvmOptions {
            override val options: KotlinJvmCompilerOptions = createCompilerJvmOptions()
        }
    }

    override val kotlinExtension: KotlinProjectExtension by lazy {
        myProject.objects.newInstance(KotlinProjectExtension::class.java, myProject)
    }

    override val kaptExtension: KaptExtension by lazy {
        myProject.objects.newInstance(KaptExtension::class.java)
    }

    @Deprecated(
        message = "Replaced by registerKotlinJvmCompileTask with module name",
        replaceWith = ReplaceWith("registerKotlinJvmCompileTask(taskName, TODO(), TODO())")
    )
    override fun registerKotlinJvmCompileTask(taskName: String): TaskProvider<out KotlinJvmCompile> {
        val extension = kotlinExtension
        return registerKotlinJvmCompileTask(
            taskName,
            createCompilerJvmOptions(),
            providerFactory.provider { extension.explicitApi }
        )
    }

    @Deprecated(
        "Replaced by registerKotlinJvmCompileTask with compiler options and explicit API mode",
        replaceWith = ReplaceWith("registerKotlinJvmCompileTask(taskName, TODO(), TODO())")
    )
    override fun registerKotlinJvmCompileTask(taskName: String, moduleName: String): TaskProvider<out KotlinJvmCompile> {
        val compilerOptions = createCompilerJvmOptions()
        compilerOptions.moduleName.convention(moduleName)
        val extension = kotlinExtension
        return registerKotlinJvmCompileTask(
            taskName,
            compilerOptions,
            providerFactory.provider { extension.explicitApi }
        )
    }

    override fun registerKotlinJvmCompileTask(
        taskName: String,
        compilerOptions: KotlinJvmCompilerOptions,
        explicitApiMode: Provider<ExplicitApiMode>,
    ): TaskProvider<out KotlinJvmCompile> {
        val taskCompilerOptions = createCompilerJvmOptions()
        KotlinJvmCompilerOptionsHelper.syncOptionsAsConvention(compilerOptions, taskCompilerOptions)
        val registeredKotlinJvmCompileTask = taskCreator.registerKotlinJVMTask(
            myProject,
            taskName,
            taskCompilerOptions,
            KotlinCompileConfig(
                myProject,
                explicitApiMode,
            )
        )
        registeredKotlinJvmCompileTask.configure {
            @Suppress("DEPRECATION")
            it.moduleName.set(taskCompilerOptions.moduleName)
        }
        return registeredKotlinJvmCompileTask
    }

    override fun registerKaptGenerateStubsTask(taskName: String): TaskProvider<out KaptGenerateStubs> {
        val taskConfig = KaptGenerateStubsConfig(
            myProject,
            providerFactory.provider { kotlinExtension.explicitApi },
            kaptExtension
        )
        return myProject.registerTask(taskName, KaptGenerateStubsTask::class.java, listOf(myProject)).also {
            taskConfig.execute(it)
        }
    }

    override fun registerKaptTask(taskName: String): TaskProvider<out Kapt> {
        val taskConfiguration = KaptWithoutKotlincConfig(myProject, kaptExtension)
        return myProject.registerTask(taskName, KaptWithoutKotlincTask::class.java, emptyList()).also {
            taskConfiguration.execute(it)
        }
    }
}