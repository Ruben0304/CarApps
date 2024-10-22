import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    kotlin("plugin.serialization") version "2.0.0"
    id("com.google.relay") version "0.3.12"
    alias(libs.plugins.apollo)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            // Navigation
            implementation(libs.androidx.navigation.compose)
            implementation(libs.kotlinx.serialization.json)

            // Icons (similar a tus íconos de lucide-react)
            implementation("io.ktor:ktor-client-core:2.2.0")
            implementation("io.ktor:ktor-client-cio:2.2.0")
            implementation("io.ktor:ktor-client-content-negotiation:2.2.0")
            implementation("io.ktor:ktor-serialization-gson:2.2.0")
            implementation("io.ktor:ktor-client-serialization:2.2.0")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            implementation(libs.androidx.animation)
            // For swipe-to-refresh, placeholder loading, etc.
            implementation(libs.accompanist.systemuicontroller)
            implementation(libs.accompanist.navigation.animation)
            implementation(libs.androidx.material.icons.extended)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.androidx.ui.text.google.fonts)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.coil.compose)
            implementation(libs.androidx.ui.text.google.fonts.v150)
            implementation(libs.accompanist.pager)
            implementation(libs.coil.kt.coil.svg)
            implementation(libs.apollo.runtime)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation("com.google.accompanist:accompanist-pager-indicators:0.29.1-alpha")

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.ui.text.google.fonts)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha08")

        }
    }
}

android {
    namespace = "ruben.hernandez.rentalcar"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "ruben.hernandez.rentalcar"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

// Asegúrate que en el build.gradle.kts del módulo común tienes:
kotlin {
    sourceSets {
        commonMain {

            resources.srcDirs("src/commonMain/resources")
        }
    }
}
apollo {
    service("service") {
        packageName.set("ruben.hernandez.rentalcar")
        introspection {
            endpointUrl.set("https://car-app-backend-lac.vercel.app/graphql")
//            headers.put("api-key", "1234567890abcdef")
            schemaFile.set(file("src/main/graphql/schema.graphqls"))
        }
    }
}

dependencies {
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.text.google.fonts)
}

