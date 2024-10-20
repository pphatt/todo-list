import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application)
    alias(kotlinx.plugins.jetbrains.kotlin.android)

    alias(libs.plugins.google.dagger.hilt.android)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "app.todolist"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.todolist"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    packaging {
        resources.excludes.addAll(
            listOf(
                "META-INF/DEPENDENCIES",
                "LICENSE.txt",
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/README.md",
                "META-INF/NOTICE",
                "META-INF/NOTICE.txt",
                "META-INF/ASL2.0",
                "META-INF/*.kotlin_module",
                // temporary solution
                "META-INF/gradle/incremental.annotation.processors"
            ),
        )
    }
}

dependencies {
    implementation(project(":presentation-core"))

    // Compose
    implementation(compose.activity)
    implementation(compose.foundation)
    implementation(compose.material3.core)
    implementation(compose.material.icons)
    implementation(compose.animation)
    implementation(compose.animation.graphics)
    implementation(compose.ui)
    debugImplementation(compose.ui.tooling)
    implementation(compose.ui.tooling.preview)
    implementation(compose.ui.graphics)
    implementation(compose.ui.util)

    implementation(platform(compose.bom))

    // Image loading
    implementation(platform(libs.coil.bom))
    implementation(libs.bundles.coil)

    // AndroidX libraries
    implementation(androidx.corektx)

    implementation(androidx.bundles.navigation)

    implementation(androidx.bundles.lifecycle)

    implementation(androidx.work.runtime)

    implementation(libs.androidx.compose.material.window)

    implementation(kotlinx.bundles.coroutines)

    // UI library
    implementation(libs.material)

    // Libraries
    implementation(libs.leakcanary)

    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.moshi)

    implementation(libs.bundles.okhttp)

    // Dagger - Hilt
    ksp(libs.androidx.hilt.compiler)
    ksp(libs.google.hilt.android.compiler)
    implementation(libs.androidx.hilt.work)
    implementation(libs.google.hilt.android)
    implementation(libs.google.hilt.android.testing)
    implementation(libs.google.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Tests
    testImplementation(libs.bundles.test)

    androidTestImplementation(platform(compose.bom))
}

tasks {
    // See https://kotlinlang.org/docs/reference/experimental.html#experimental-status-of-experimental-api(-markers)
    // https://stackoverflow.com/a/44143253
    withType<KotlinCompile> {
        compilerOptions.freeCompilerArgs.addAll(
            "-opt-in=androidx.compose.foundation.layout.ExperimentalLayoutApi",
            "-opt-in=androidx.compose.material.ExperimentalMaterialApi",
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
            "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
            "-opt-in=androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi",
        )
    }
}

hilt {
    enableAggregatingTask = false
}
