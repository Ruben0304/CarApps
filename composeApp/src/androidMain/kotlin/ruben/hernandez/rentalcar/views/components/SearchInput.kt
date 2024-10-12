package ruben.hernandez.rentalcar.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchInput(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    Surface(
        color = Color.White,
        shape = CircleShape,
        shadowElevation = 8.dp,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Puedes añadir un icono de búsqueda aquí si lo deseas
            // Icon(imageVector = Icons.Outlined.Search, contentDescription = "search", tint = Color.Gray)

            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = androidx.compose.ui.text.TextStyle(color = AppColors.dark, fontSize = 19.sp),
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 1.dp),
                decorationBox = { innerTextField ->
                    Box {
                        if (text.isEmpty()) {
                            Text(
                                "Buscar...",
                                color = Color.Gray,
                                fontSize = 19.sp
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}