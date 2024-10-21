package ruben.hernandez.rentalcar.basicdialogo

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'basic_dialogo'.
 * Generated code; do not edit directly
 */
@Composable
fun BasicDialogo(
    modifier: Modifier = Modifier,
    title: String = "",
    supportingText: String = "",
    labelTextSecondaryButton: String = "",
    labelTextPrimmaryButton: String = "",
    onClickSecondaryButton: () -> Unit = {},
    onClickPrimaryButton: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        BasicDialog {
            TextContent(modifier = Modifier.rowWeight(1.0f)) {
                TitleDescription(modifier = Modifier.rowWeight(1.0f)) {
                    Headline(
                        title = title,
                        modifier = Modifier.rowWeight(1.0f)
                    )
                    SupportingText(
                        supportingText = supportingText,
                        modifier = Modifier.rowWeight(1.0f)
                    )
                }
            }
            Divider(modifier = Modifier.rowWeight(1.0f)) {
                HorizontalFullWidth(modifier = Modifier.rowWeight(1.0f)) {
                    Divider(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = -1.0.dp
                            )
                        ).rowWeight(1.0f)
                    )
                }
            }
            Actions(modifier = Modifier.rowWeight(1.0f)) {
                Actions1 {
                    SecondaryButton(onClickSecondaryButton = onClickSecondaryButton) {
                        StateLayer(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            LabelText(labelTextSecondaryButton = labelTextSecondaryButton)
                        }
                    }
                    PrimaryButton(onClickPrimaryButton = onClickPrimaryButton) {
                        StateLayer1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            LabelText1(labelTextPrimmaryButton = labelTextPrimmaryButton)
                        }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 312, heightDp = 257)
@Composable
private fun BasicDialogoPreview() {
    MaterialTheme {
        BasicDialogo(
            title = "Basic dialog title",
            supportingText = "A dialog is a type of modal window that appears in front of app content to provide critical information, or prompt for a decision to be made.",
            onClickSecondaryButton = {},
            onClickPrimaryButton = {},
            labelTextSecondaryButton = "Action 2",
            labelTextPrimmaryButton = "Action 1"
        )
    }
}

@Composable
fun Headline(
    title: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = title,
        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
        fontFamily = MaterialTheme.typography.headlineSmall.fontFamily,
        color = MaterialTheme.colorScheme.onSurface,
        height = MaterialTheme.typography.headlineSmall.lineHeight,
        letterSpacing = MaterialTheme.typography.headlineSmall.letterSpacing,
        textAlign = TextAlign.Left,
        fontWeight = MaterialTheme.typography.headlineSmall.fontWeight,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun SupportingText(
    supportingText: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = supportingText,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        height = MaterialTheme.typography.bodyMedium.lineHeight,
        letterSpacing = MaterialTheme.typography.bodyMedium.letterSpacing,
        textAlign = TextAlign.Left,
        fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun TitleDescription(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 24.0.dp,
            top = 24.0.dp,
            end = 24.0.dp,
            bottom = 0.0.dp
        ),
        itemSpacing = 16.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TextContent(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun Divider(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.basic_dialogo_divider),
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(0.0.dp)
    )
}

@Composable
fun HorizontalFullWidth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        crossAxisAlignment = CrossAxisAlignment.Start,
        clipToParent = false,
        content = content,
        modifier = modifier.graphicsLayer(rotationZ = 0.0f).fillMaxWidth(1.0f)
    )
}

@Composable
fun Divider(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 16.0.dp,
            end = 0.0.dp,
            bottom = 0.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun LabelText(
    labelTextSecondaryButton: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = labelTextSecondaryButton,
        fontSize = MaterialTheme.typography.labelLarge.fontSize,
        fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
        color = MaterialTheme.colorScheme.primary,
        height = MaterialTheme.typography.labelLarge.lineHeight,
        letterSpacing = MaterialTheme.typography.labelLarge.letterSpacing,
        fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun StateLayer(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 12.0.dp,
            top = 10.0.dp,
            end = 12.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun SecondaryButton(
    onClickSecondaryButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        itemSpacing = 8.0,
        radius = 100.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.tappable(onTap = onClickSecondaryButton).width(IntrinsicSize.Min).requiredHeight(40.0.dp)
    )
}

@Composable
fun LabelText1(
    labelTextPrimmaryButton: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = labelTextPrimmaryButton,
        fontSize = MaterialTheme.typography.labelLarge.fontSize,
        fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
        color = MaterialTheme.colorScheme.primary,
        height = MaterialTheme.typography.labelLarge.lineHeight,
        letterSpacing = MaterialTheme.typography.labelLarge.letterSpacing,
        fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun StateLayer1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 12.0.dp,
            top = 10.0.dp,
            end = 12.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun PrimaryButton(
    onClickPrimaryButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        itemSpacing = 8.0,
        radius = 100.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.tappable(onTap = onClickPrimaryButton).width(IntrinsicSize.Min).requiredHeight(40.0.dp)
    )
}

@Composable
fun Actions1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 8.0.dp,
            top = 24.0.dp,
            end = 24.0.dp,
            bottom = 24.0.dp
        ),
        itemSpacing = 8.0,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min)
    )
}

@Composable
fun Actions(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.End,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun BasicDialog(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 236,
            green = 230,
            blue = 240
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.End,
        radius = 28.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.requiredWidth(312.0.dp)
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
