******

### Historial de Versiones

******

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
