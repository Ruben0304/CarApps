package ruben.hernandez.rentalcar.components.util

// Función para crear un archivo temporal donde guardar la imagen capturada por la cámara
//fun createImageFile(context: Context): Uri {
//    // Crear un archivo temporal único para la imagen
//    val timeStamp = System.currentTimeMillis().toString()
//    val fileName = "JPEG_${timeStamp}_"
//    val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//    val imageFile = File.createTempFile(fileName, ".jpg", storageDir)
//
//    // Devolver la Uri del archivo usando FileProvider
//    return FileProvider.getUriForFile(
//        context,
//        "${context.packageName}.provider",
//        imageFile
//    )
//}