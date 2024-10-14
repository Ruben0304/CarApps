package ruben.hernandez.rentalcar.chatinput

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.EmptyPainter
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'chat_input'.
 * Generated code; do not edit directly
 */
@Composable
fun ChatInput(
    modifier: Modifier = Modifier,
    leftIcon: Painter = EmptyPainter(),
    buttonColor: Color = Color(
        alpha = 0,
        red = 0,
        green = 0,
        blue = 0
    ),
    onLeftClick: () -> Unit = {},
    onButtonClick: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        Actions {
            Camera(
                onLeftClick = onLeftClick,
                leftIcon = leftIcon
            )
        }
        _MessagesSendField(modifier = Modifier.rowWeight(1.0f)) {
            LeftContent(modifier = Modifier.rowWeight(1.0f)) {}
            RightContent(
                onButtonClick = onButtonClick,
                buttonColor = buttonColor,
                modifier = Modifier.columnWeight(1.0f)
            ) {
                _MessagesSendIcon1 {
                    SFSymbolArrowUp(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 382, heightDp = 64)
@Composable
private fun ChatInputPreview() {
    MaterialTheme {
        RelayContainer {
            ChatInput(
                leftIcon = painterResource(R.drawable.chat_input_camera),
                onLeftClick = {},
                buttonColor = Color(
                    alpha = 0,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                onButtonClick = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Camera(
    onLeftClick: () -> Unit,
    leftIcon: Painter,
    modifier: Modifier = Modifier
) {
    RelayImage(
        image = leftIcon,
        contentScale = ContentScale.Crop,
        modifier = modifier.tappable(onTap = onLeftClick).requiredWidth(38.66666793823242.dp).requiredHeight(28.66666603088379.dp)
    )
}

@Composable
fun Actions(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 16.0,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min)
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
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min).fillMaxWidth(1.0f)
    )
}

@Composable
fun SFSymbolArrowUp(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.chat_input_sf_symbol_arrow_up),
        modifier = modifier.requiredWidth(12.0.dp).requiredHeight(14.0.dp)
    )
}

@Composable
fun _MessagesSendIcon1(
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
        isStructured = false,
        clipToParent = false,
        radius = 100.0,
        content = content,
        modifier = modifier.requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun RightContent(
    onButtonClick: () -> Unit,
    buttonColor: Color,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = buttonColor,
        mainAxisAlignment = MainAxisAlignment.End,
        crossAxisAlignment = CrossAxisAlignment.End,
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onButtonClick).fillMaxHeight(1.0f)
    )
}

@Composable
fun _MessagesSendField(
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
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 12.0.dp,
            top = 4.0.dp,
            end = 4.0.dp,
            bottom = 4.0.dp
        ),
        itemSpacing = 4.0,
        clipToParent = false,
        radius = 18.0,
        strokeWidth = 1.0,
        borderAlignment = BorderAlignment.Center,
        strokeColor = Color(
            alpha = 91,
            red = 60,
            green = 60,
            blue = 67
        ),
        content = content,
        modifier = modifier.height(IntrinsicSize.Min).fillMaxWidth(1.0f)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 4.0.dp,
            end = 2.0.dp,
            bottom = 4.0.dp
        ),
        itemSpacing = 12.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
