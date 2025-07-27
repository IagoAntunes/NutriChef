package com.iagoaf.nutrichef.core.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagoaf.nutrichef.core.ui.theme.border
import com.iagoaf.nutrichef.core.ui.theme.textSecondary
import com.iagoaf.nutrichef.core.ui.theme.white

@Composable
fun CTextField(
    value: String,
    placeHolder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    suffix: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.border(
            width = 1.dp,
            color = border,
            shape = RoundedCornerShape(8.dp)
        )
    ) {
        TextField(
            value = value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = white,
                focusedContainerColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    text = placeHolder,
                    color = textSecondary
                )
            },
            visualTransformation = visualTransformation,
            suffix = suffix
        )
    }
}


@Preview
@Composable
private fun CTextFieldPreview() {
    CTextField(
        value = "",
        placeHolder = "Seu@mail.com",

        )
}