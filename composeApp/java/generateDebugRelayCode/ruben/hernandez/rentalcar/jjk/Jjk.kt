package ruben.hernandez.rentalcar.jjk

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'jjk'.
 * Generated code; do not edit directly
 */
@Composable
fun Jjk(
    modifier: Modifier = Modifier,
    onImageCarouselSliderTapped: () -> Unit = {},
    onMiniSliderTapped: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        Rectangle6(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = -24.0.dp,
                    y = -24.0.dp
                )
            ).rowWeight(1.0f).columnWeight(1.0f)
        )
        ImageCarousel(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            ImageCarouselSlider(
                onImageCarouselSliderTapped = onImageCarouselSliderTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 440.4230041503906.dp,
                        y = 40.0.dp
                    )
                )
            ) {
                ImageCard {
                    Image(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Img1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
                ImageCard1 {
                    Image1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Img2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
                ImageCard2 {
                    Image2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Img3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
                ImageCard3 {
                    Image3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Img4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
                ImageCard4 {
                    Image4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Img5(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
                ImageCard5 {
                    Image5(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Img6(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
            }
            MiniSlider(
                onMiniSliderTapped = onMiniSliderTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.423004150390625.dp,
                        y = 320.0.dp
                    )
                )
            ) {
                Dot {
                    Rectangle8(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                Dot1 {
                    Rectangle9(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                Dot2 {
                    Rectangle10(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                Dot3 {
                    Rectangle11(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                Dot4 {
                    Rectangle12(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                Dot5 {
                    Rectangle13(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
            }
        }
    }
}

@Preview(widthDp = 455, heightDp = 393)
@Composable
private fun JjkPreview() {
    MaterialTheme {
        RelayContainer {
            Jjk(
                onImageCarouselSliderTapped = {},
                onMiniSliderTapped = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Rectangle6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_6),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f).relayDropShadow(
            color = Color(
                alpha = 38,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 40.0.dp,
            blur = 30.0.dp,
            offsetX = 6.0.dp,
            offsetY = 6.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun Img1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.jjk_img_1),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
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
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(192.0.dp).requiredHeight(256.0.dp)
    )
}

@Composable
fun Img2(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.jjk_img_2),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Image1(
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
fun ImageCard1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(144.0.dp).requiredHeight(192.0.dp)
    )
}

@Composable
fun Img3(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.jjk_img_3),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Image2(
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
fun ImageCard2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(144.0.dp).requiredHeight(192.0.dp)
    )
}

@Composable
fun Img4(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.jjk_img_4),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Image3(
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
fun ImageCard3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(144.0.dp).requiredHeight(192.0.dp)
    )
}

@Composable
fun Img5(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.jjk_img_5),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Image4(
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
fun ImageCard4(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(144.0.dp).requiredHeight(192.0.dp)
    )
}

@Composable
fun Img6(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.jjk_img_6),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Image5(
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
fun ImageCard5(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(144.0.dp).requiredHeight(192.0.dp)
    )
}

@Composable
fun ImageCarouselSlider(
    onImageCarouselSliderTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 32.0,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onImageCarouselSliderTapped).height(IntrinsicSize.Min)
    )
}

@Composable
fun Rectangle8(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_8),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Dot(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        radius = 33.0,
        content = content,
        modifier = modifier.requiredWidth(24.0.dp).requiredHeight(8.0.dp)
    )
}

@Composable
fun Rectangle9(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_9),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Dot1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        radius = 33.0,
        content = content,
        modifier = modifier.requiredWidth(8.0.dp).requiredHeight(8.0.dp)
    )
}

@Composable
fun Rectangle10(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_10),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Dot2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        radius = 33.0,
        content = content,
        modifier = modifier.requiredWidth(8.0.dp).requiredHeight(8.0.dp)
    )
}

@Composable
fun Rectangle11(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_11),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Dot3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        radius = 33.0,
        content = content,
        modifier = modifier.requiredWidth(8.0.dp).requiredHeight(8.0.dp)
    )
}

@Composable
fun Rectangle12(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_12),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Dot4(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        radius = 33.0,
        content = content,
        modifier = modifier.requiredWidth(8.0.dp).requiredHeight(8.0.dp)
    )
}

@Composable
fun Rectangle13(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.jjk_rectangle_13),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Dot5(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        radius = 33.0,
        content = content,
        modifier = modifier.requiredWidth(8.0.dp).requiredHeight(8.0.dp)
    )
}

@Composable
fun MiniSlider(
    onMiniSliderTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 4.0,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onMiniSliderTapped).height(IntrinsicSize.Min)
    )
}

@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        isStructured = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 23.0.dp,
                top = 25.0.dp,
                end = 22.84600830078125.dp,
                bottom = 25.289093017578125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
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
