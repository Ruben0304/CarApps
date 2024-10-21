package ruben.hernandez.rentalcar.messagebubbleligth

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'message_bubble_ligth'.
 * Generated code; do not edit directly
 */
@Composable
fun MessageBubbleLigth(
    modifier: Modifier = Modifier,
    time: AnnotatedString = AnnotatedString(""),
    text: String = ""
) {
    TopLevel(modifier = modifier) {
        MessageBubble {
            MessageSendTime(modifier = Modifier.rowWeight(1.0f)) {
                Time(
                    time = time,
                    modifier = Modifier.rowWeight(1.0f)
                )
                BubbleTail {
                    BubbleTailSynth {
                        Bubble(modifier = Modifier.columnWeight(1.0f)) {
                            Message(text = text)
                        }
                    }
                    Tail(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.BottomStart,
                            offset = DpOffset(
                                x = -5.0.dp,
                                y = 0.32248687744140625.dp
                            )
                        )
                    ) {
                        Vector(
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 0.0000095367431640625.dp,
                                    y = 0.0.dp
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 372, heightDp = 59)
@Composable
private fun MessageBubbleLigthPreview() {
    MaterialTheme {
        MessageBubbleLigth(
            time = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(
                            alpha = 153,
                            red = 60,
                            green = 60,
                            blue = 67
                        ),
                        fontFamily = sansSerifCollection,
                        fontSize = 11.0.sp,
                        letterSpacing = 0.05999999865889549.sp,
                        fontWeight = FontWeight(400.0.toInt())
                    )
                ) {
                    append("Yesterday")
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        fontFamily = sansSerifCollection,
                        fontSize = 11.0.sp,
                        letterSpacing = 0.06599999964237213.sp,
                        fontWeight = FontWeight(400.0.toInt())
                    )
                ) {
                    append("9")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(
                            alpha = 153,
                            red = 60,
                            green = 60,
                            blue = 67
                        ),
                        fontFamily = sansSerifCollection,
                        fontSize = 11.0.sp,
                        letterSpacing = 0.06599999964237213.sp,
                        fontWeight = FontWeight(400.0.toInt())
                    )
                ) {
                    append(":41")
                }
            },
            text = "We should catch up soon!"
        )
    }
}

@Composable
fun Time(
    time: AnnotatedString,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = time,
        fontSize = 11.0.sp,
        fontFamily = sansSerifCollection,
        color = Color(
            alpha = 153,
            red = 60,
            green = 60,
            blue = 67
        ),
        height = 1.181818161010742.em,
        letterSpacing = 0.06599999964237213.sp,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun Message(
    text: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = text,
        fontSize = 17.0.sp,
        fontFamily = sansSerifCollection,
        height = 1.2941175842285155.em,
        letterSpacing = -0.40799999237060547.sp,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun Bubble(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 233,
            green = 233,
            blue = 235
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 12.0.dp,
            top = 6.0.dp,
            end = 12.0.dp,
            bottom = 6.0.dp
        ),
        clipToParent = false,
        radius = 18.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.fillMaxHeight(1.0f)
    )
}

@Composable
fun BubbleTailSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.End,
        crossAxisAlignment = CrossAxisAlignment.End,
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.height(IntrinsicSize.Min).alpha(alpha = 100.0f)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.message_bubble_ligth_vector),
        modifier = modifier.requiredWidth(16.417245864868164.dp).requiredHeight(20.322486877441406.dp)
    )
}

@Composable
fun Tail(
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
fun BubbleTail(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.width(IntrinsicSize.Min)
    )
}

@Composable
fun MessageSendTime(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 12.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun MessageBubble(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.End,
        crossAxisAlignment = CrossAxisAlignment.End,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(372.0.dp)
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
