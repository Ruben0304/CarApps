package ruben.hernandez.rentalcar.appclip

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'app_clip'.
 * Generated code; do not edit directly
 */
@Composable
fun AppClip(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        AppClip(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            Image {
                Image1(modifier = Modifier.rowWeight(1.0f))
                CloseButton(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopEnd,
                        offset = DpOffset(
                            x = -24.0.dp,
                            y = 24.0.dp
                        )
                    )
                ) {
                    Close(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Background(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        SFSymbolXmark(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
            }
            NameDescOpenButton(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 24.0.dp,
                        y = 261.0.dp
                    )
                )
            ) {
                NameDesc(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 1.0.dp
                        )
                    ).rowWeight(1.0f)
                ) {
                    ClipName(modifier = Modifier.rowWeight(1.0f))
                    HereSAPlaceForTheAppClipSDescription(modifier = Modifier.rowWeight(1.0f))
                }
                Button(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopEnd,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.0.dp
                        )
                    )
                ) {
                    Label()
                }
                Separator(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.BottomStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = -51.5.dp
                        )
                    ).rowWeight(1.0f)
                )
                PoweredBy(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.BottomStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.0.dp
                        )
                    )
                ) {
                    _AppClipIcon {
                        Icon(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                    PoweredBy1 {
                        PoweredBy()
                        AppName()
                    }
                }
                AppStore(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.BottomEnd,
                        offset = DpOffset(
                            x = -0.17493438720703125.dp,
                            y = -7.0.dp
                        )
                    )
                ) {
                    AppStore1()
                    SFIconChevronForward()
                }
            }
        }
    }
}

@Preview(widthDp = 358, heightDp = 410)
@Composable
private fun AppClipPreview() {
    MaterialTheme {
        RelayContainer {
            AppClip(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun Image1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.app_clip_image),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(236.0.dp)
    )
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.app_clip_background),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun SFSymbolXmark(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.app_clip_sf_symbol_xmark),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 10.0.dp,
                top = 10.0.dp,
                end = 9.6295166015625.dp,
                bottom = 9.629505157470703.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Close(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(30.0.dp).requiredHeight(30.0.dp)
    )
}

@Composable
fun Image(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(358.0.dp).requiredHeight(236.0.dp)
    )
}

@Composable
fun ClipName(modifier: Modifier = Modifier) {
    RelayText(
        content = "Clip Name",
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
        fontWeight = FontWeight(700.0.toInt()),
        overflow = TextOverflow.Ellipsis,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun HereSAPlaceForTheAppClipSDescription(modifier: Modifier = Modifier) {
    RelayText(
        content = "Here’s a place for the App Clip’s description...",
        fontSize = 12.0.sp,
        fontFamily = sFProText,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.3333332824707032.em,
        textAlign = TextAlign.Left,
        overflow = TextOverflow.Ellipsis,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun NameDesc(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 4.0,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 132.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f)
    )
}

@Composable
fun Label(modifier: Modifier = Modifier) {
    RelayText(
        content = "Open",
        fontSize = 17.0.sp,
        fontFamily = sFProText,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2941175842285155.em,
        letterSpacing = -0.40799999237060547.sp,
        fontWeight = FontWeight(600.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 0,
            green = 122,
            blue = 255
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 27.0.dp,
            top = 14.0.dp,
            end = 27.0.dp,
            bottom = 14.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        radius = 100.0,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min)
    )
}

@Composable
fun Separator(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.app_clip_separator),
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(0.5.dp)
    )
}

@Composable
fun Icon(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.app_clip_icon),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun _AppClipIcon(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 6.066666603088379,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun PoweredBy(modifier: Modifier = Modifier) {
    RelayText(
        content = "Powered by",
        fontSize = 11.0.sp,
        fontFamily = sFProText,
        color = Color(
            alpha = 153,
            red = 235,
            green = 235,
            blue = 245
        ),
        height = 1.181818161010742.em,
        letterSpacing = 0.05999999865889549.sp,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun AppName(modifier: Modifier = Modifier) {
    RelayText(
        content = "App Name",
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
        fontWeight = FontWeight(600.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun PoweredBy1(
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

@Composable
fun PoweredBy(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min)
    )
}

@Composable
fun AppStore1(modifier: Modifier = Modifier) {
    RelayText(
        content = "App Store",
        fontSize = 12.0.sp,
        fontFamily = sFProText,
        color = Color(
            alpha = 153,
            red = 235,
            green = 235,
            blue = 245
        ),
        height = 1.3333332824707032.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun SFIconChevronForward(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.app_clip_sf_icon_chevron_forward),
        modifier = modifier.requiredWidth(4.8251953125.dp).requiredHeight(8.0859375.dp)
    )
}

@Composable
fun AppStore(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 5.0,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min)
    )
}

@Composable
fun NameDescOpenButton(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(310.0.dp).requiredHeight(133.0.dp)
    )
}

@Composable
fun AppClip(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 191,
            red = 30,
            green = 30,
            blue = 30
        ),
        isStructured = false,
        radius = 34.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
