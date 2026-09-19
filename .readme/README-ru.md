<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Плагин Paddle OCR PP-OCRv6 для локального OCR</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Языки (Languages)

******

Текущий README.md поддерживает следующие языки:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ko.md)
- Русский [ru] # текущий
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ar.md)

******

### Введение

******

Плагин AutoJs6 Paddle OCR PP-OCRv6 предоставляет AutoJs6 локальное обнаружение и распознавание текста на основе Paddle OCR PP-OCRv6. Он собирает отдельные APK для профилей моделей Tiny, Small и Medium.

******

### Функции

******

- Предоставляет общий сервис OCR-плагина с ID плагинов `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, движком `paddle-ocr` и вариантом `v6`.
- Открывает OCR AIDL интерфейс через `org.autojs.plugin.PADDLE_OCR` и совместим с механизмом обнаружения OCR-плагинов хостом AutoJs6.
- Поддерживает `recognizeText` для списка строк текста и `detect` для текста, уверенности, границ строк, четырехугольных координат и временных метаданных.
- Поддерживает ввод кодированных изображений и необработанных буферов изображений `ARGB_8888`.
- `small` является рекомендуемым профилем по умолчанию для Android, `tiny` предназначен для слабых устройств и самого быстрого локального OCR, а `medium` предназначен для более точного OCR.
- Предоставляет `scripts/prepare_ppocrv6_assets.py` для подготовки модельных assets PP-OCRv6 и размещения каждого профиля в отдельном каталоге assets flavor.
- Метаданные плагина, инструкции, README и CHANGELOG локализованы на испанский, французский, русский, арабский, японский, корейский, английский, упрощенный китайский, гонконгский традиционный китайский и тайваньский традиционный китайский.
- Основан на `com.microsoft.onnxruntime:onnxruntime-android` и OpenCV 4.8.0.
- Изображения могут содержать до 16777216 пикселей; размер буферов необработанных изображений ограничен 64 MiB
- Размер закодированного изображения ограничен 64 MiB с поддержкой файловых дескрипторов и каналов

******

### Профили Моделей

******

```text
tiny: слабые устройства и самый быстрый локальный OCR
small: рекомендуемый профиль Android по умолчанию
medium: высокоточный OCR с более крупными модельными assets
```

Каждый профиль упакован как отдельный product flavor, поэтому APK содержит только выбранные модельные assets

******

### Интерфейс Плагина

******

Хост может обнаружить и вызвать плагин со следующими идентификаторами:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText` возвращает список строк; `detect` возвращает объекты результата OCR, содержащие `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs` и `coldLoadTimeMs`.

******

### Модельные Assets

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

Скрипт загружает официальные ONNX assets PP-OCRv6 или преобразует локальные архивы статических моделей Paddle, если указан `--source-dir`. По умолчанию assets записываются в `app/src/<profile>/assets`.

******

### История Выпусков

******

# v1.0.4

###### 2026/09/19

* `Исправление` Предупреждения чтения SDK XML v4 с AGP 9.1 и ошибочный запуск проверки выравнивания нативных библиотек APK при сборке модульных тестов JVM, устраненные общими плагинами сборки 1.8.3
* `Улучшение` Подняты compileSdk и targetSdk до 37 (Android 17); поведение плагина не зависит от нового целевого уровня

# v1.0.3

###### 2026/09/13

* `Исправление` Информация о версии и ABI в центре плагинов соответствует установленному APK
* `Исправление` Размер закодированного изображения ограничен 64 MiB с поддержкой файловых дескрипторов и каналов
* `Исправление` Даты версий используют единый английский формат
* `Улучшение` Проверка версий, подписей и полного набора вариантов APK перед подготовкой файлов для загрузки
* `Улучшение` Изображения могут содержать до 16777216 пикселей; размер буферов необработанных изображений ограничен 64 MiB
* `Улучшение` Расширение набора нативных ABI и метаданных плагина до arm64-v8a, armeabi-v7a, x86 и x86_64 с согласованными универсальными и отдельными APK для каждой ABI

# v1.0.2

###### 2026/09/12

* `Исправление` Исправлен сбой движка при инициализации (SIGSEGV) на устройствах со страницами 16 КБ: встроенная `libc++_shared.so` теперь собрана NDK r28.2, и её сегмент RELRO больше не делит страницу с записываемыми данными (arm64-v8a, armeabi-v7a)
* `Исправление` Исправлен молчаливый пустой результат для крупных моделей распознавания после `OutOfMemoryError`: модели один раз копируются в приватное хранилище приложения и отображаются в память ONNX Runtime вместо чтения в кучу Java
* `Исправление` Сбои сборки при некоторых сочетаниях Gradle/AGP из-за некомпилируемых исходников Kotlin или повторных определений `WakeActivity`
* `Улучшение` Нативная библиотека OpenCV 4.8.0 синхронизирована с пересборкой NDK r28c (Clang 19.0.1) (донор: AutoJs6-Plugin-OpenCV); `libopencv_java4.so` для всех 4 ABI сохраняет выравнивание `PT_LOAD` 16 КБ и поставляется с манифестом provenance

##### Больше истории выпусков

* [CHANGELOG-ru.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-ru.md)

******

### Сборка

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Release-сборка:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

Параметры сборки берутся из `version.properties`; минимальный SDK app равен 26, целевой SDK равен 36.

******

### Структура Ресурсов

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` содержит локализованные описания плагина; `plugin_instruction.md` содержит инструкции, отображаемые хостом. README и CHANGELOG генерируются из JSON-источников с помощью `.python/generate_markdown.py`.

******

### Ссылки

******

- Документация AutoJs6: https://docs.autojs6.com
- Официальный проект PaddleOCR: https://github.com/PaddlePaddle/PaddleOCR
- Официальный проект PaddleX: https://github.com/PaddlePaddle/PaddleX


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/docs/16kb.md)
