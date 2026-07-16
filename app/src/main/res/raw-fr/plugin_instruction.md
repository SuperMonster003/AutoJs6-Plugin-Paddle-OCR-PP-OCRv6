Paddle OCR PP-OCRv6 fournit la detection et la reconnaissance de texte locales via l'interface de plugin OCR partagee d'AutoJs6.

Identite du plugin:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` renvoie les lignes de texte reconnues. `detect` renvoie le texte, la confiance, les limites de ligne, les coordonnees quadrilaterales et les metadonnees de temps.

Le plugin accepte les images encodees et les tampons d'image bruts `ARGB_8888`. Utilisez `small` comme profil Android recommande par defaut, `tiny` pour les appareils bas de gamme et l'OCR local le plus rapide, et `medium` pour un OCR plus precis avec des assets de modele plus grands.
