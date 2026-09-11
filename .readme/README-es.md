<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Complemento Paddle OCR PP-OCRv6 para OCR local</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Idiomas (Languages)

******

El README.md actual admite los siguientes idiomas:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-fr.md)
- Español [es] # actual
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ar.md)

******

### Introducción

******

El complemento AutoJs6 Paddle OCR PP-OCRv6 proporciona deteccion y reconocimiento de texto local para AutoJs6 con Paddle OCR PP-OCRv6. Crea APK separados para los perfiles de modelo Tiny, Small y Medium.

******

### Funciones

******

- Proporciona el servicio de complemento OCR compartido con los ID de complemento `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, motor `paddle-ocr` y variante `v6`.
- Expone la interfaz OCR AIDL mediante `org.autojs.plugin.PADDLE_OCR` y funciona con el flujo de descubrimiento de complementos OCR del host AutoJs6.
- Admite `recognizeText` para listas de lineas de texto y `detect` para texto, confianza, limites de linea, coordenadas cuadrilateras y metadatos de tiempo.
- Admite entrada de imagen codificada y entrada de bufer de imagen `ARGB_8888` sin procesar.
- `small` es el valor predeterminado recomendado para Android, `tiny` apunta a dispositivos de gama baja y OCR local mas rapido, y `medium` apunta a OCR de mayor precision.
- Proporciona `scripts/prepare_ppocrv6_assets.py` para preparar activos de modelo PP-OCRv6 y colocar cada perfil en su propio directorio de assets de flavor.
- Los metadatos del complemento, las instrucciones de uso, el README y el CHANGELOG estan localizados en español, frances, ruso, arabe, japones, coreano, ingles, chino simplificado, chino tradicional de Hong Kong y chino tradicional de Taiwan.
- Basado en `com.microsoft.onnxruntime:onnxruntime-android` y OpenCV 4.8.0.

******

### Perfiles de Modelo

******

```text
tiny: dispositivos de gama baja y OCR local mas rapido
small: valor predeterminado recomendado para Android
medium: OCR de alta precision con activos de modelo mas grandes
```

Cada perfil se empaqueta como un product flavor independiente para que el APK solo contenga los activos del modelo seleccionado

******

### Interfaz del Complemento

******

El host puede descubrir e invocar el complemento con la siguiente identidad:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText` devuelve una lista de cadenas; `detect` devuelve objetos de resultado OCR que contienen `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs` y `coldLoadTimeMs`.

******

### Activos de Modelo

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

El script descarga activos ONNX oficiales de PP-OCRv6, o convierte archivos de modelo estatico Paddle locales cuando se proporciona `--source-dir`. De forma predeterminada, los activos se escriben en `app/src/<profile>/assets`.

******

### Historial de Versiones

******

# v1.0.1

###### 2026/09/11

* `Mejora` Verificación de compilación de la alineación de páginas de 16 KB en bibliotecas nativas de 64 bits, con controles del contrato manifest e informes JSON

# v1.0.0

###### 2026/09/01

* `Función` Se agrego el servicio de complemento Paddle OCR PP-OCRv6 con ID de complemento `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small` y `paddle-ocr-pp-ocrv6-medium`, motor `paddle-ocr` y variante `v6`
* `Función` Se agrego descubrimiento e invocacion desde el host mediante la accion OCR AIDL compartida `org.autojs.plugin.PADDLE_OCR`
* `Función` Se agregaron las interfaces `recognizeText` y `detect`, que devuelven texto reconocido, valores de confianza, limites de linea, coordenadas cuadrilateras y tiempos de deteccion/reconocimiento
* `Función` Se agregaron los perfiles de modelo Tiny, Small y Medium, con `small` como valor predeterminado recomendado para Android
* `Función` Se agrego soporte para entrada de imagen codificada y entrada de bufer de imagen `ARGB_8888` sin procesar
* `Función` Se agrego el script de preparacion de activos de modelo PP-OCRv6, con descargas ONNX oficiales y conversion de modelos estaticos Paddle locales mediante `--source-dir`
* `Función` Se agregaron metadatos e instrucciones de uso localizados para espanol, frances, ruso, arabe, japones, coreano, ingles, chino simplificado, chino tradicional de Hong Kong y chino tradicional de Taiwan
* `Función` Se agregaron fuentes JSON y el flujo de generacion `.python/generate_markdown.py` para README y CHANGELOG
* `Función` Se agregaron compilaciones APK divididas por ABI para `arm64-v8a`, `armeabi-v7a` y un APK `universal`
* `Función` Los nombres de los APK de release incluyen version, flavor, variante ABI y resumen CRC32 opcional desde la tarea de archivo de release
* `Corrección` El complemento no se podía activar desde el centro de complementos después de instalarlo en algunos sistemas
* `Mejora` Unificar el diseño del README y la gestión de versiones de la plataforma Gradle

##### Para ver mas historial de versiones

* [CHANGELOG-es.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-es.md)

******

### Compilación

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Compilación Release:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

Los parametros de compilacion provienen de `version.properties`; el SDK minimo de la app es 26 y el SDK de destino es 36.

******

### Estructura de Recursos

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` contiene descripciones localizadas del complemento; `plugin_instruction.md` contiene las instrucciones de uso que muestra el host. README y CHANGELOG se generan desde fuentes JSON mediante `.python/generate_markdown.py`.

******

### Enlaces

******

- Documentación de AutoJs6: https://docs.autojs6.com
- Proyecto oficial PaddleOCR: https://github.com/PaddlePaddle/PaddleOCR
- Proyecto oficial PaddleX: https://github.com/PaddlePaddle/PaddleX


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/docs/16kb.md)
