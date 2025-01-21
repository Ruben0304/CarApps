package ruben.hernandez.rentalcar.views.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.Player
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.common.BotonColor
import ruben.hernandez.rentalcar.views.poppinsFontFamily
import android.content.Context
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

val firstVideoUrl: Uri? = Uri.parse("https://wgfdmgsbsqflcgtecglw.supabase.co/storage/v1/object/public/memojis/doc_2025-01-06_02-17-13.mp4")
val secondVideoUrl: Uri? = Uri.parse("https://wgfdmgsbsqflcgtecglw.supabase.co/storage/v1/object/public/memojis/doc_2025-01-06_02-16-58.mp4")

@Composable
fun ConsultationsFragment(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = AppColors.backgroundGradient
                )
            )
    ) {

        if (firstVideoUrl != null) {
            if (secondVideoUrl != null) {
                AutoSwitchVideosPlayer(
                    context = LocalContext.current,
                    firstVideoUri = firstVideoUrl,
                    secondVideoUri = secondVideoUrl,
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 120.dp)
                )
            }
        }

        TextoInformativo(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.65f).padding(top = 190.dp)
        )

        BotonColor(
            texto = "Nueva consulta",
            modifier = Modifier
                .fillMaxHeight(0.12f)
                .fillMaxWidth(0.8f)
                .align(alignment = Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            forma = RoundedCornerShape(12.dp),
            color = AppColors.principal,
            tamanoTexto = 19.sp
        )

    }
}

@Composable
fun TextoInformativo(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            textAlign = TextAlign.Center,
            text = "Consultas publicas",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            color = AppColors.text,
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.12f),
            maxLines = 1
        )

        Spacer(modifier = Modifier.fillMaxHeight(0.08f))

        Text(
            textAlign = TextAlign.Center,
            text = "Echa un vistazo a los mecánicos y expertos en el sector automovilístico cerca de tu zona, agenda citas con ellos y elige el que prefieras",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.infoText,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.5f),
            maxLines = 4,
            lineHeight = 25.sp,
        )
    }
}


@OptIn(UnstableApi::class)
@Composable
fun AutoSwitchVideosPlayer(
    context: Context,
    modifier: Modifier = Modifier,
    firstVideoUri: Uri,
    secondVideoUri: Uri
) {
    var currentVideoIndex by remember { mutableIntStateOf(0) }

    // Configuración de los reproductores de video
    val playerOne = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(firstVideoUri))
            prepare()
            playWhenReady = true // Empieza como activo por defecto
        }
    }
    val playerTwo = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(secondVideoUri))
            prepare()
            playWhenReady = false // Pausado inicialmente
        }
    }

    // Efecto para alternar reproducción
    LaunchedEffect(currentVideoIndex) {
        val currentPlayer = if (currentVideoIndex == 0) playerOne else playerTwo
        currentPlayer.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                if (state == Player.STATE_ENDED) {
                    // Cambia al siguiente video cuando el actual termine
                    currentVideoIndex = (currentVideoIndex + 1) % 2
                    playerOne.playWhenReady = currentVideoIndex == 0
                    playerTwo.playWhenReady = currentVideoIndex == 1
                }
            }
        })
    }

    DisposableEffect(Unit) {
        onDispose {
            playerOne.release()
            playerTwo.release()
        }
    }

    // Diseño de los videos
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Primer video
        Box(
            modifier = Modifier
                .weight(1f)
                .height(150.dp) // Tamaño pequeño
        ) {
            AndroidView(
                factory = {
                    PlayerView(it).apply {
                        this.player = playerOne
                        this.useController = false
                        this.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Segundo video
        Box(
            modifier = Modifier
                .weight(1f)
                .height(150.dp) // Tamaño pequeño
        ) {
            AndroidView(
                factory = {
                    PlayerView(it).apply {
                        this.player = playerTwo // Usamos el segundo reproductor
                        this.useController = false
                        this.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }
    }
}

