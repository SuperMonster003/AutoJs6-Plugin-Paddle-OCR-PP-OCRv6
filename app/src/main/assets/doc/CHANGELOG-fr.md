******

### Historique des Versions

******

# v1.0.3

###### 2026/09/13

* `Correctif` Les informations de version et d'ABI du centre des plugins correspondent à l'APK installé
* `Correctif` Les images encodées sont limitées à 64 MiB avec prise en charge des fichiers et des tubes
* `Correctif` Les dates de version utilisent un format anglais uniforme
* `Amélioration` Validation des versions, signatures et variantes complètes des APK avant la création des fichiers à télécharger
* `Amélioration` Les images peuvent contenir jusqu'à 16777216 pixels; les tampons bruts sont limités à 64 MiB

# v1.0.2

###### 2026/09/12

* `Correctif` Correction du plantage du moteur à l'initialisation (SIGSEGV) sur les appareils à pages de 16 Ko : la `libc++_shared.so` embarquée est désormais la version compilée avec le NDK r28.2, dont le segment RELRO ne partage plus de page avec des données inscriptibles (arm64-v8a, armeabi-v7a)
* `Correctif` Correction des modèles de reconnaissance volumineux renvoyant silencieusement un résultat vide après un `OutOfMemoryError` : les modèles sont copiés une seule fois dans le stockage privé de l'application et mappés en mémoire par ONNX Runtime au lieu d'être lus dans le tas Java
* `Correctif` Échecs de compilation avec certaines combinaisons Gradle/AGP dus aux sources Kotlin non compilées ou aux définitions en double de `WakeActivity`
* `Amélioration` Bibliothèque native OpenCV 4.8.0 synchronisée avec la recompilation NDK r28c (Clang 19.0.1) (donneur : AutoJs6-Plugin-OpenCV) ; `libopencv_java4.so` des 4 ABI conserve l'alignement `PT_LOAD` de 16 Ko et embarque un manifeste de provenance

# v1.0.1

###### 2026/09/11

* `Amélioration` Vérification à la compilation de l'alignement des pages de 16 KB des bibliothèques natives 64 bits, avec contrôle du contrat manifest et rapports JSON

# v1.0.0

###### 2026/09/01

* `Fonctionnalité` Ajout du service de plugin Paddle OCR PP-OCRv6 avec les ID de plugin `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small` et `paddle-ocr-pp-ocrv6-medium`, le moteur `paddle-ocr` et la variante `v6`
* `Fonctionnalité` Ajout de la decouverte et de l'appel par l'hote via l'action OCR AIDL partagee `org.autojs.plugin.PADDLE_OCR`
* `Fonctionnalité` Ajout des interfaces `recognizeText` et `detect`, qui renvoient le texte reconnu, les valeurs de confiance, les limites de ligne, les coordonnees quadrilaterales et les temps de detection/reconnaissance
* `Fonctionnalité` Ajout des profils de modele Tiny, Small et Medium, avec `small` comme profil Android recommande par defaut
* `Fonctionnalité` Ajout de la prise en charge des images encodees et des tampons d'image bruts `ARGB_8888`
* `Fonctionnalité` Ajout du script de preparation des assets de modele PP-OCRv6, avec telechargements ONNX officiels et conversion de modeles statiques Paddle locaux via `--source-dir`
* `Fonctionnalité` Ajout des metadonnees de plugin et des instructions localisees en espagnol, francais, russe, arabe, japonais, coreen, anglais, chinois simplifie, chinois traditionnel de Hong Kong et chinois traditionnel de Taiwan
* `Fonctionnalité` Ajout des sources JSON et du flux de generation `.python/generate_markdown.py` pour README et CHANGELOG
* `Fonctionnalité` Ajout de builds APK divises par ABI pour `arm64-v8a`, `armeabi-v7a` et un APK `universal`
* `Fonctionnalité` Les noms des APK de release incluent la version, le flavor, la variante ABI et le resume CRC32 optionnel de la tache d'archivage release
* `Correctif` Le plugin ne pouvait pas être activé depuis le centre de plugins après son installation sur certains systèmes
* `Amélioration` Uniformiser la mise en page du README et la gestion des versions de la plateforme Gradle
