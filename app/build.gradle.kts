import com.android.build.api.variant.FilterConfiguration
import org.gradle.api.provider.Property

plugins {
    id("org.autojs.build.utils")
    id("org.autojs.build.versions")
    id("org.autojs.build.signs")
    id("org.autojs.build.jvm-convention")
    id("com.android.application")
}

val globalApplicationId = "io.github.supermonster003.autojs6.plugin.paddleocr.v6"

val buildTypeDebug = "debug"
val buildTypeRelease = "release"

android {

    namespace = globalApplicationId
    compileSdk = versions.sdkVersionCompile

    defaultConfig {
        applicationId = globalApplicationId

        minSdk = 26
        targetSdk = versions.sdkVersionTarget

        versionCode = versions.appVersionCode
        versionName = versions.appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "VERSION_DATE", "\"${utils.getDateString("MMM d, yyyy", "GMT+08:00")}\"")
        buildConfigField("String", "PLUGIN_ENGINE", "\"paddle-ocr\"")
        buildConfigField("String", "PLUGIN_VARIANT", "\"v6\"")

        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }
    }

    flavorDimensions += "ocrProfile"

    productFlavors {
        create("tiny") {
            dimension = "ocrProfile"
            applicationIdSuffix = ".tiny"
            versionNameSuffix = "-tiny"
            buildConfigField("String", "PLUGIN_ID", "\"paddle-ocr-pp-ocrv6-tiny\"")
            buildConfigField("String", "MODEL_PROFILE", "\"tiny\"")
            resValue("string", "app_name", "Paddle OCR (PP-OCRv6 Tiny)")
        }

        create("small") {
            dimension = "ocrProfile"
            applicationIdSuffix = ".small"
            versionNameSuffix = "-small"
            buildConfigField("String", "PLUGIN_ID", "\"paddle-ocr-pp-ocrv6-small\"")
            buildConfigField("String", "MODEL_PROFILE", "\"small\"")
            resValue("string", "app_name", "Paddle OCR (PP-OCRv6 Small)")
        }

        create("medium") {
            dimension = "ocrProfile"
            applicationIdSuffix = ".medium"
            versionNameSuffix = "-medium"
            buildConfigField("String", "PLUGIN_ID", "\"paddle-ocr-pp-ocrv6-medium\"")
            buildConfigField("String", "MODEL_PROFILE", "\"medium\"")
            resValue("string", "app_name", "Paddle OCR (PP-OCRv6 Medium)")
        }
    }

    lint {
        abortOnError = false
    }

    signingConfigs {
        if (signs.isValid) {
            create(buildTypeRelease) {
                storeFile = signs.properties["storeFile"]?.let { file(it as String) }
                keyPassword = signs.properties["keyPassword"] as String
                keyAlias = signs.properties["keyAlias"] as String
                storePassword = signs.properties["storePassword"] as String
            }
        }
    }

    buildTypes {
        val proguardFiles = arrayOf<Any>(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro",
        )
        val niceSigningConfig = takeIf { signs.isValid }?.let {
            signingConfigs.getByName(buildTypeRelease)
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(*proguardFiles)
            niceSigningConfig?.let { signingConfig = it }
        }
        release {
            isMinifyEnabled = true
            proguardFiles(*proguardFiles)
            niceSigningConfig?.let { signingConfig = it }
        }
    }

    buildFeatures {
        aidl = true
        buildConfig = true
        resValues = true
    }

    @Suppress("DEPRECATION")
    packagingOptions {
        jniLibs.useLegacyPackaging = false

        listOf(
            "META-INF/DEPENDENCIES",
            "META-INF/LICENSE",
            "META-INF/LICENSE.*",
            "META-INF/LICENSE-notice.*",
            "META-INF/license.*",
            "META-INF/NOTICE",
            "META-INF/NOTICE.*",
            "META-INF/notice.*",
            "META-INF/ASL2.0",
            "META-INF/*.kotlin_module",
        ).let { resources.pickFirsts.addAll(it) }
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("arm64-v8a", "armeabi-v7a")
            isUniversalApk = true
        }
    }
}

androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            val architecture = output.filters.find {
                it.filterType == FilterConfiguration.FilterType.ABI
            }?.identifier ?: "universal"
            val outputFileNameProperty = output.javaClass.methods.firstOrNull {
                it.name == "getOutputFileName" && it.parameterTypes.isEmpty()
            }?.invoke(output) as? Property<*>

            @Suppress("UNCHECKED_CAST")
            (outputFileNameProperty as? Property<String>)?.set(
                output.versionName.map { versionName ->
                    val version = versionName.replace("\\s".toRegex(), "-")
                    val extension = utils.FILE_EXTENSION_APK
                    "${rootProject.name}-v$version-$architecture.$extension".lowercase()
                },
            )
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.21")
    implementation("org.jetbrains:annotations:26.0.2")

    implementation(files("$rootDir/libs/common-plugin-api.aar"))
    implementation(files("$rootDir/libs/paddle-ocr-api.aar"))

    implementation(project(":libs:ppocr-android-sdk"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation(libs.core.ktx)
}

tasks {
    withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }

    register<Copy>("appendDigestToReleasedFiles") {
        val src = buildTypeRelease
        val dst = "${src}s"
        val ext = utils.FILE_EXTENSION_APK

        if (!file(src).isDirectory) {
            return@register
        }

        from(src); into(dst); include("*.$ext")

        rename { name ->
            utils.digestCRC32(file("${src}/$name")).let { digest ->
                name.replace(Regex("^(.+?)(\\.$ext)$"), "$1-$digest$2")
            }
        }

        doLast { println("Destination: ${file(dst)}") }
    }
}

extra {
    versions.handleIfNeeded(project, listOf(buildTypeDebug, buildTypeRelease))
}
