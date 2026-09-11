******

### Historique des Versions

******

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
