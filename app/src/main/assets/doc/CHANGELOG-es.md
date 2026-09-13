******

### Historial de Versiones

******

# v1.0.3

###### 2026/09/13

* `Corrección` La versión y las ABI del centro de complementos coinciden con el APK instalado
* `Corrección` La imagen codificada admite hasta 64 MiB mediante descriptores de archivo y tuberías
* `Corrección` Las fechas de versión mantienen un formato uniforme en inglés
* `Mejora` Validación de las versiones, firmas y variantes completas de los APK antes de crear los archivos de descarga
* `Mejora` Las imágenes admiten hasta 16777216 píxeles; los búferes de imagen sin procesar se limitan a 64 MiB

# v1.0.2

###### 2026/09/12

* `Corrección` Corregido el bloqueo del motor al inicializarse (SIGSEGV) en dispositivos con páginas de 16 KB: la `libc++_shared.so` incluida es ahora la compilación del NDK r28.2, cuyo segmento RELRO ya no comparte página con datos escribibles (arm64-v8a, armeabi-v7a)
* `Corrección` Corregido que los modelos de reconocimiento grandes devolvieran resultados vacíos en silencio tras un `OutOfMemoryError`: los modelos se copian una sola vez al almacenamiento privado de la app y ONNX Runtime los mapea en memoria en lugar de leerlos en el heap de Java
* `Corrección` Fallos de compilación con algunas combinaciones de Gradle/AGP por fuentes Kotlin no compiladas o definiciones duplicadas de `WakeActivity`
* `Mejora` Sincronizada la biblioteca nativa OpenCV 4.8.0 con la reconstrucción NDK r28c (Clang 19.0.1) (donante: AutoJs6-Plugin-OpenCV); `libopencv_java4.so` de las 4 ABI mantiene la alineación `PT_LOAD` de 16 KB e incluye un manifiesto de provenance

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
