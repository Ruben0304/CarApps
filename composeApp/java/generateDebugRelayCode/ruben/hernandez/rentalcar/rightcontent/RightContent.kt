package ruben.hernandez.rentalcar.rightcontent

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'right_content'.
 * Generated code; do not edit directly
 */
@Composable
fun RightContent(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(
        alpha = 0,
        red = 0,
        green = 0,
        blue = 0
    ),
    onClick: () -> Unit = {}
) {
    TopLevel(
        onClick = onClick,
        backgroundColor = backgroundColor,
        modifier = modifier
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

@Preview(widthDp = 28, heightDp = 28)
@Composable
private fun RightContentPreview() {
    MaterialTheme {
        RelayContainer {
            RightContent(
                backgroundColor = Color(
                    alpha = 0,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                onClick = {},
                modifier = Modifier.columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun SFSymbolArrowUp(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.right_content_sf_symbol_arrow_up),
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
fun TopLevel(
    onClick: () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = backgroundColor,
        mainAxisAlignment = MainAxisAlignment.End,
        crossAxisAlignment = CrossAxisAlignment.End,
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onClick).fillMaxHeight(1.0f)
    )
}
