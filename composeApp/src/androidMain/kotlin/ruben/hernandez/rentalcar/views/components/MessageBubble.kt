//package ruben.hernandez.rentalcar.views.components
//
//
//import androidx.compose.foundation.layout.IntrinsicSize
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.requiredHeight
//import androidx.compose.foundation.layout.requiredWidth
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.DpOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.em
//import androidx.compose.ui.unit.sp
////import com.google.relay.compose.BorderAlignment
////import com.google.relay.compose.CrossAxisAlignment
////import com.google.relay.compose.MainAxisAlignment
////import com.google.relay.compose.RelayContainer
////import com.google.relay.compose.RelayContainerArrangement
////import com.google.relay.compose.RelayContainerScope
////import com.google.relay.compose.RelayText
////import com.google.relay.compose.RelayVector
//
///**
// * This composable was generated from the UI Package 'message_bubble'.
// * Generated code; do not edit directly
// */
//@Composable
//fun MessageBubble(
//    modifier: Modifier = Modifier,
//    messageContent: String = ""
//) {
//    TopLevel(modifier = modifier) {
//        MessageBubble {
//            MessageSendTime(modifier = Modifier.rowWeight(1.0f)) {
//                BubbleTail(modifier = Modifier.rowWeight(1.0f)) {
//                    BubbleTailSynth {
//                        Bubble(modifier = Modifier.columnWeight(1.0f)) {
//                            Message(messageContent = messageContent)
//                        }
//                    }
//                    Tail(
//                        modifier = Modifier.boxAlign(
//                            alignment = Alignment.BottomEnd,
//                            offset = DpOffset(
//                                x = 4.0.dp,
//                                y = -0.6775131225585938.dp
//                            )
//                        )
//                    ) {
//                        Vector()
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Preview(widthDp = 244, heightDp = 34)
//@Composable
//private fun MessageBubblePreview() {
//    MaterialTheme {
//        MessageBubble(messageContent = "I’d love to see you!")
//    }
//}
//
//@Composable
//fun Message(
//    messageContent: String,
//    modifier: Modifier = Modifier
//) {
//    RelayText(
//        content = messageContent,
//        fontSize = 17.0.sp,
//        fontFamily = sansSerifCollection,
//        color = Color(
//            alpha = 255,
//            red = 255,
//            green = 255,
//            blue = 255
//        ),
//        height = 1.2941175842285155.em,
//        letterSpacing = -0.40799999237060547.sp,
//        textAlign = TextAlign.Left,
//        modifier = modifier
//    )
//}
//
//@Composable
//fun Bubble(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        backgroundColor = Color(
//            alpha = 255,
//            red = 90,
//            green = 112,
//            blue = 168
//        ),
//        mainAxisAlignment = MainAxisAlignment.Start,
//        crossAxisAlignment = CrossAxisAlignment.Start,
//        arrangement = RelayContainerArrangement.Row,
//        padding = PaddingValues(
//            start = 12.0.dp,
//            top = 6.0.dp,
//            end = 12.0.dp,
//            bottom = 6.0.dp
//        ),
//        clipToParent = false,
//        radius = 18.0,
//        borderAlignment = BorderAlignment.Center,
//        content = content,
//        modifier = modifier.fillMaxHeight(1.0f)
//    )
//}
//
//@Composable
//fun BubbleTailSynth(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        mainAxisAlignment = MainAxisAlignment.End,
//        crossAxisAlignment = CrossAxisAlignment.End,
//        arrangement = RelayContainerArrangement.Row,
//        clipToParent = false,
//        content = content,
//        modifier = modifier.height(IntrinsicSize.Min).requiredWidth(244.0.dp).alpha(alpha = 100.0f)
//    )
//}
//
//@Composable
//fun Vector(modifier: Modifier = Modifier) {
//    RelayVector(
//        vector = painterResource(R.drawable.message_bubble_vector),
//        modifier = modifier.requiredWidth(16.417245864868164.dp).requiredHeight(20.322486877441406.dp)
//    )
//}
//
//@Composable
//fun Tail(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        mainAxisAlignment = MainAxisAlignment.Start,
//        crossAxisAlignment = CrossAxisAlignment.Start,
//        clipToParent = false,
//        content = content,
//        modifier = modifier.graphicsLayer(rotationZ = 180.0f).width(IntrinsicSize.Min)
//    )
//}
//
//@Composable
//fun BubbleTail(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        isStructured = false,
//        clipToParent = false,
//        content = content,
//        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(34.0.dp)
//    )
//}
//
//@Composable
//fun MessageSendTime(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        mainAxisAlignment = MainAxisAlignment.Start,
//        crossAxisAlignment = CrossAxisAlignment.Start,
//        itemSpacing = 12.0,
//        clipToParent = false,
//        content = content,
//        modifier = modifier.fillMaxWidth(1.0f)
//    )
//}
//
//@Composable
//fun MessageBubble(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        mainAxisAlignment = MainAxisAlignment.End,
//        crossAxisAlignment = CrossAxisAlignment.End,
//        itemSpacing = 8.0,
//        clipToParent = false,
//        content = content,
//        modifier = modifier.requiredWidth(244.0.dp)
//    )
//}
//
//@Composable
//fun TopLevel(
//    modifier: Modifier = Modifier,
//    content: @Composable RelayContainerScope.() -> Unit
//) {
//    RelayContainer(
//        mainAxisAlignment = MainAxisAlignment.Start,
//        crossAxisAlignment = CrossAxisAlignment.Start,
//        clipToParent = false,
//        content = content,
//        modifier = modifier.width(IntrinsicSize.Min)
//    )
//}
