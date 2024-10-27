package ruben.hernandez.rentalcar.views.components.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun searchPreview() {
    SearchInput()

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchInput(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    Surface(
        color = Color.White,
        shape = CircleShape,
        shadowElevation = 12.dp,
        modifier = modifier,
        content = {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {

                Row(modifier = Modifier.align(Alignment.CenterStart)) {
                    BasicTextField(
                        value = text,
                        onValueChange = { text = it },
                        textStyle = androidx.compose.ui.text.TextStyle(
                            color = AppColors.dark,
                            fontSize = 16.sp,

                            ),

                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()

                            ) {
                                if (text.isEmpty()) {
                                    Text(
                                        "Buscar",
                                        color = Color.Gray,
                                        fontSize = 16.sp,
                                        modifier = Modifier.align(Alignment.CenterStart),
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )

                }

            }

        }

    )
}