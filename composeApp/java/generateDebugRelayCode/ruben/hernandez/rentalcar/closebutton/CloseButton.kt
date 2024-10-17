package ruben.hernandez.rentalcar.closebutton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'close_button'.
 * Generated code; do not edit directly
 */
@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onCloseButtonTapped: () -> Unit = {}
) {
    TopLevel(
        onCloseButtonTapped = onCloseButtonTapped,
        modifier = modifier
    ) {
        Close(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            Background(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            SFSymbolXmark(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Preview(widthDp = 30, heightDp = 30)
@Composable
private fun CloseButtonPreview() {
    MaterialTheme {
        RelayContainer {
            CloseButton(
                onCloseButtonTapped = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.close_button_background),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun SFSymbolXmark(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.close_button_sf_symbol_xmark),
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
fun TopLevel(
    onCloseButtonTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onCloseButtonTapped).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
