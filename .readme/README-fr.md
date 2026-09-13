<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin Paddle OCR PP-OCRv6 pour OCR local</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Langues (Languages)

******

Le README.md actuel prend en charge les langues suivantes:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- Français [fr] # actuel
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ar.md)

******

### Introduction

******

Le plugin AutoJs6 Paddle OCR PP-OCRv6 fournit a AutoJs6 une detection et une reconnaissance de texte locales avec Paddle OCR PP-OCRv6. Il construit des APK separes pour les profils de modele Tiny, Small et Medium.

******

### Fonctions

******

- Fournit le service de plugin OCR partage avec les ID de plugin `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, le moteur `paddle-ocr` et la variante `v6`.
- Expose l'interface OCR AIDL via `org.autojs.plugin.PADDLE_OCR` et fonctionne avec le flux de decouverte des plugins OCR de l'hote AutoJs6.
- Prend en charge `recognizeText` pour les listes de lignes de texte et `detect` pour le texte, la confiance, les limites de ligne, les coordonnees quadrilaterales et les metadonnees de temps.
- Prend en charge les images encodees et les tampons d'image bruts `ARGB_8888`.
- `small` est le profil Android recommande par defaut, `tiny` vise les appareils bas de gamme et l'OCR local le plus rapide, et `medium` vise un OCR plus precis.
- Fournit `scripts/prepare_ppocrv6_assets.py` pour preparer les assets de modele PP-OCRv6 et placer chaque profil dans son propre repertoire d'assets de flavor.
- Les metadonnees du plugin, les instructions d'utilisation, le README et le CHANGELOG sont localises en espagnol, francais, russe, arabe, japonais, coreen, anglais, chinois simplifie, chinois traditionnel de Hong Kong et chinois traditionnel de Taiwan.
- Base sur `com.microsoft.onnxruntime:onnxruntime-android` et OpenCV 4.8.0.
- Les images peuvent contenir jusqu'à 16777216 pixels; les tampons bruts sont limités à 64 MiB
- Les images encodées sont limitées à 64 MiB avec prise en charge des fichiers et des tubes

******

### Profils de Modele

******

```text
tiny: appareils bas de gamme et OCR local le plus rapide
small: profil Android recommande par defaut
medium: OCR haute precision avec assets de modele plus grands
```

Chaque profil est empaquete comme un product flavor separe afin que l'APK ne contienne que les assets du modele selectionne

******

### Interface du Plugin

******

L'hote peut decouvrir et appeler le plugin avec l'identite suivante:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText` renvoie une liste de chaines; `detect` renvoie des objets de resultat OCR contenant `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs` et `coldLoadTimeMs`.

******

### Assets de Modele

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

Le script telecharge les assets ONNX officiels de PP-OCRv6, ou convertit des archives de modeles statiques Paddle locales lorsque `--source-dir` est fourni. Par defaut, les assets sont ecrits dans `app/src/<profile>/assets`.

******

### Historique des Versions

******

# v1.0.3

###### 2026/09/13

* `Correctif` Les informations de version et d'ABI du centre des plugins correspondent à l'APK installé
* `Correctif` Les images encodées sont limitées à 64 MiB avec prise en charge des fichiers et des tubes
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

##### Pour plus d'historique des versions

* [CHANGELOG-fr.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-fr.md)

******

### Compilation

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Compilation Release:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

Les parametres de compilation proviennent de `version.properties`; le SDK minimal de l'app est 26 et le SDK cible est 36.

******

### Structure des Ressources

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` contient les descriptions localisees du plugin; `plugin_instruction.md` contient les instructions d'utilisation affichees par l'hote. README et CHANGELOG sont generes depuis des sources JSON par `.python/generate_markdown.py`.

******

### Liens

******

- Documentation AutoJs6: https://docs.autojs6.com
- Projet officiel PaddleOCR: https://github.com/PaddlePaddle/PaddleOCR
- Projet officiel PaddleX: https://github.com/PaddlePaddle/PaddleX


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/docs/16kb.md)
