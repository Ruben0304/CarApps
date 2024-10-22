package ruben.hernandez.rentalcar.views.components.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
        shadowElevation = 8.dp,
        modifier = modifier,
        content = {
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 17.dp)
                    .height(7.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Puedes añadir un icono de búsqueda aquí si lo deseas
                 Icon(imageVector = Icons.Outlined.Search, contentDescription = "search", tint = Color.Gray,
                     modifier = Modifier.padding(top = 3.dp))

                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = AppColors.dark,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth().height(50.dp),
                    decorationBox = { innerTextField ->
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 2.dp).padding(start = 2.dp)) {
                            if (text.isEmpty()) {
                                Text(
                                    "Buscar",
                                    color = Color.Gray,
                                    fontSize = 19.sp,
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }

    )
}