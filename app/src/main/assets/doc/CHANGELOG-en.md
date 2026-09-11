******

### Release History

******

# v1.0.1

###### 2026/09/11

* `Improvement` Build verification of 16 KB page alignment for 64-bit native libraries, including manifest contract checks and JSON reports

# v1.0.0

###### 2026/09/01

* `Feature` Added the Paddle OCR PP-OCRv6 plugin service with plugin IDs `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, and `paddle-ocr-pp-ocrv6-medium`, engine `paddle-ocr`, and variant `v6`
* `Feature` Added host discovery and invocation through the shared OCR AIDL action `org.autojs.plugin.PADDLE_OCR`
* `Feature` Added `recognizeText` and `detect` interfaces that return recognized text, confidence values, line bounds, quadrilateral coordinates, and detection/recognition timing
* `Feature` Added Tiny, Small, and Medium model profiles, with `small` as the recommended Android default
* `Feature` Added support for encoded image input and raw `ARGB_8888` image buffer input
* `Feature` Added the PP-OCRv6 model asset preparation script, with official ONNX downloads and local Paddle static model conversion through `--source-dir`
* `Feature` Added localized plugin metadata and usage instructions for Spanish, French, Russian, Arabic, Japanese, Korean, English, Simplified Chinese, Hong Kong Traditional Chinese, and Taiwan Traditional Chinese
* `Feature` Added JSON source files and `.python/generate_markdown.py` generation flow for README and CHANGELOG files
* `Feature` Added ABI split APK builds for `arm64-v8a`, `armeabi-v7a`, and a `universal` APK
* `Feature` Release APK filenames include the version, flavor, ABI variant, and optional CRC32 digest from the release archive task
* `Fix` The plugin could not be activated from Plugin Center after installation on some systems
* `Improvement` Standardize the README layout and Gradle platform version management
