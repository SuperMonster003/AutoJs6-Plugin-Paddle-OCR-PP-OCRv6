<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>مكون Paddle OCR PP-OCRv6 الإضافي للـ OCR المحلي</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### اللغات (Languages)

******

يدعم README.md الحالي اللغات التالية:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ru.md)
- العربية [ar] # الحالي

******

### مقدمة

******

يوفر مكون AutoJs6 Paddle OCR PP-OCRv6 الإضافي كشف النص والتعرف عليه محليا في AutoJs6 باستخدام Paddle OCR PP-OCRv6. يبني ملفات APK منفصلة لملفات تعريف النماذج Tiny و Small و Medium.

******

### الميزات

******

- يوفر خدمة مكون OCR المشتركة بمعرفات المكون `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, والمحرك `paddle-ocr`, والمتغير `v6`.
- يكشف واجهة OCR AIDL عبر `org.autojs.plugin.PADDLE_OCR` ويعمل مع مسار اكتشاف مكونات OCR في مضيف AutoJs6.
- يدعم `recognizeText` لقوائم أسطر النص و `detect` للنص والثقة وحدود السطر وإحداثيات الشكل الرباعي وبيانات الوقت.
- يدعم إدخال الصور المشفرة وإدخال مخزن صور خام `ARGB_8888`.
- `small` هو الافتراضي الموصى به في Android, و `tiny` يستهدف الأجهزة الضعيفة وأسرع OCR محلي, و `medium` يستهدف OCR أعلى دقة.
- يوفر `scripts/prepare_ppocrv6_assets.py` لإعداد أصول نموذج PP-OCRv6 ووضع كل ملف تعريف في دليل assets خاص بالـ flavor.
- تمت ترجمة بيانات المكون الإضافي وتعليمات الاستخدام و README و CHANGELOG إلى الإسبانية والفرنسية والروسية والعربية واليابانية والكورية والإنجليزية والصينية المبسطة والصينية التقليدية في هونغ كونغ والصينية التقليدية في تايوان.
- مبني على `com.microsoft.onnxruntime:onnxruntime-android` و OpenCV 4.8.0.

******

### ملفات تعريف النماذج

******

```text
tiny: الأجهزة الضعيفة وأسرع OCR محلي
small: الافتراضي الموصى به في Android
medium: OCR عالي الدقة مع أصول نموذج أكبر
```

يتم حزم كل ملف تعريف كـ product flavor مستقل بحيث يحتوي APK على أصول النموذج المحدد فقط

******

### واجهة المكون الإضافي

******

يمكن للمضيف اكتشاف المكون الإضافي واستدعاؤه بالهوية التالية:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

يعيد `recognizeText` قائمة سلاسل; ويعيد `detect` كائنات نتائج OCR تحتوي على `text` و `confidence` و `bounds` و `quad` و `detectionTimeMs` و `recognitionTimeMs` و `totalTimeMs` و `coldLoadTimeMs`.

******

### أصول النماذج

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

ينزل السكربت أصول ONNX الرسمية لـ PP-OCRv6, أو يحول أرشيفات نماذج Paddle الثابتة المحلية عند توفير `--source-dir`. تكتب الأصول افتراضيا في `app/src/<profile>/assets`.

******

### سجل الإصدارات

******

# v1.0.0

###### 2026/09/01

* `ميزة` تمت إضافة خدمة مكون Paddle OCR PP-OCRv6 الإضافي بمعرفات `paddle-ocr-pp-ocrv6-tiny` و `paddle-ocr-pp-ocrv6-small` و `paddle-ocr-pp-ocrv6-medium`, والمحرك `paddle-ocr`, والمتغير `v6`
* `ميزة` تمت إضافة اكتشاف المضيف والاستدعاء عبر إجراء OCR AIDL المشترك `org.autojs.plugin.PADDLE_OCR`
* `ميزة` تمت إضافة واجهتي `recognizeText` و `detect`, اللتين تعيدان النص المتعرف عليه, وقيم الثقة, وحدود السطر, وإحداثيات الشكل الرباعي, وزمن الكشف/التعرف
* `ميزة` تمت إضافة ملفات تعريف النماذج Tiny و Small و Medium, مع `small` كافتراضي Android الموصى به
* `ميزة` تمت إضافة دعم إدخال الصور المشفرة ومخازن الصور الخام `ARGB_8888`
* `ميزة` تمت إضافة سكربت إعداد أصول نموذج PP-OCRv6, مع تنزيلات ONNX الرسمية وتحويل نماذج Paddle الثابتة المحلية عبر `--source-dir`
* `ميزة` تمت إضافة بيانات المكون الإضافي وتعليمات الاستخدام المترجمة للإسبانية والفرنسية والروسية والعربية واليابانية والكورية والإنجليزية والصينية المبسطة والصينية التقليدية في هونغ كونغ والصينية التقليدية في تايوان
* `ميزة` تمت إضافة ملفات مصدر JSON ومسار إنشاء `.python/generate_markdown.py` لملفات README و CHANGELOG
* `ميزة` تمت إضافة بناء APK مقسم حسب ABI لـ `arm64-v8a` و `armeabi-v7a` وحزمة APK `universal`
* `ميزة` تتضمن أسماء ملفات APK في release الإصدار و flavor ومتغير ABI وملخص CRC32 اختياري من مهمة أرشفة release
* `إصلاح` تعذر تنشيط المكون الإضافي من مركز المكونات الإضافية بعد التثبيت على بعض الأنظمة
* `تحسين` توحيد تخطيط README وطريقة إدارة إصدارات منصة Gradle

##### لمزيد من سجل الإصدارات

* [CHANGELOG-ar.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-ar.md)

******

### البناء

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

بناء Release:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

تأتي معلمات البناء من `version.properties`; الحد الأدنى لـ SDK في app هو 26 والـ SDK المستهدف هو 36.

******

### بنية الموارد

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

يحتوي `strings.xml` على أوصاف المكون الإضافي المترجمة; ويحتوي `plugin_instruction.md` على تعليمات الاستخدام التي يعرضها المضيف. يتم إنشاء README و CHANGELOG من مصادر JSON بواسطة `.python/generate_markdown.py`.

******

### الروابط

******

- وثائق AutoJs6: https://docs.autojs6.com
- مشروع PaddleOCR الرسمي: https://github.com/PaddlePaddle/PaddleOCR
- مشروع PaddleX الرسمي: https://github.com/PaddlePaddle/PaddleX
