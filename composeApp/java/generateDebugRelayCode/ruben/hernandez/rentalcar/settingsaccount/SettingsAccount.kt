package ruben.hernandez.rentalcar.settingsaccount

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.EmptyPainter
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'settings_account'.
 * Generated code; do not edit directly
 */
@Composable
fun SettingsAccount(
    modifier: Modifier = Modifier,
    icono: Painter = EmptyPainter(),
    nombre: String = "",
    abajo: String = ""
) {
    TopLevel(modifier = modifier) {
        _SettingsAccount {
            IconContent(modifier = Modifier.rowWeight(1.0f)) {
                AccountPhoto(icono = icono)
                Content(modifier = Modifier.rowWeight(1.0f)) {
                    LeftContent(modifier = Modifier.rowWeight(1.0f)) {
                        Name(
                            nombre = nombre,
                            modifier = Modifier.rowWeight(1.0f)
                        )
                        AppleIDICloudMediaPurchases(
                            abajo = abajo,
                            modifier = Modifier.rowWeight(1.0f)
                        )
                    }
                    RightContent(modifier = Modifier.columnWeight(1.0f)) {
                        SFSymbolChevronRight()
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 358, heightDp = 77)
@Composable
private fun SettingsAccountPreview() {
    MaterialTheme {
        SettingsAccount(
            icono = painterResource(R.drawable.settings_account_account_photo),
            nombre = "First Last",
            abajo = "Apple ID, iCloud, Media, & Purchases"
        )
    }
}

@Composable
fun AccountPhoto(
    icono: Painter,
    modifier: Modifier = Modifier
) {
    RelayImage(
        image = icono,
        radius = 100.0,
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(60.0.dp).requiredHeight(60.0.dp)
    )
}

@Composable
fun Name(
    nombre: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = nombre,
        fontSize = 22.0.sp,
        fontFamily = sFProDisplay,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.272727279663086.em,
        letterSpacing = 0.3499999940395355.sp,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun AppleIDICloudMediaPurchases(
    abajo: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = abajo,
        fontSize = 13.0.sp,
        fontFamily = sFProText,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.3846153259277343.em,
        letterSpacing = -0.07800000160932541.sp,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun LeftContent(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 8.0.dp,
            end = 16.0.dp,
            bottom = 9.0.dp
        ),
        itemSpacing = 2.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun SFSymbolChevronRight(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.settings_account_sf_symbol_chevron_right),
        modifier = modifier.requiredWidth(7.164339065551758.dp).requiredHeight(12.29638671875.dp)
    )
}

@Composable
fun RightContent(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 0.0.dp,
            end = 16.0.dp,
            bottom = 0.0.dp
        ),
        itemSpacing = 12.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxHeight(1.0f)
    )
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min).fillMaxWidth(1.0f)
    )
}

@Composable
fun IconContent(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 6.0.dp,
            end = 0.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 13.0,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min).fillMaxWidth(1.0f)
    )
}

@Composable
fun _SettingsAccount(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 28,
            green = 28,
            blue = 30
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 16.0.dp,
            top = 0.0.dp,
            end = 0.0.dp,
            bottom = 0.0.dp
        ),
        radius = 14.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.requiredWidth(358.0.dp)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        clipToParent = false,
        content = content,
        modifier = modifier.width(IntrinsicSize.Min)
    )
}
