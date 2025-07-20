package com.iagoaf.nutrichef.src.auth.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagoaf.nutrichef.R
import com.iagoaf.nutrichef.core.components.CTextField
import com.iagoaf.nutrichef.core.ui.theme.appTypography
import com.iagoaf.nutrichef.core.ui.theme.background
import com.iagoaf.nutrichef.core.ui.theme.border
import com.iagoaf.nutrichef.core.ui.theme.primary
import com.iagoaf.nutrichef.core.ui.theme.textCta
import com.iagoaf.nutrichef.core.ui.theme.textPrimary
import com.iagoaf.nutrichef.core.ui.theme.textSecondary
import com.iagoaf.nutrichef.core.ui.theme.white

@Composable
fun LoginScreen(
    onLogin: (String, String) -> Unit,
    onClickCreateAccount: () -> Unit
) {
    val isObscure = remember { mutableStateOf(false) }

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }


    fun btnEnabled(): Boolean {
        return email.value.isNotEmpty() && password.value.isNotEmpty()
    }

    Scaffold(
        containerColor = background,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_chef),
                            contentDescription = "Chef Icon",
                            colorFilter = ColorFilter.tint(white)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "NutriChef",
                        style = appTypography.heading1,
                        color = primary,
                        textAlign = TextAlign.Center,
                    )
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp
                        )
                    )
                    .background(white)
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = 32.dp,
                        vertical = 40.dp
                    )
                ) {
                    Text(
                        "Entrar",
                        style = appTypography.heading2,
                        color = textPrimary,
                    )
                    Text(
                        "Acesse suas receitas saudáveis favoritas",
                        style = appTypography.numberSm,
                        color = textSecondary,
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        "E-mail",
                        style = appTypography.numberSm,
                        color = textPrimary,
                    )
                    CTextField(
                        value = email.value,
                        onValueChange = {
                            email.value = it
                        },
                        placeHolder = "seu@mail.com"
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "Senha",
                        style = appTypography.numberSm,
                        color = textPrimary,
                    )
                    CTextField(
                        value = password.value,
                        onValueChange = {
                            password.value = it
                        },
                        placeHolder = "Sua senha de acesso",
                        visualTransformation = if (isObscure.value) PasswordVisualTransformation() else VisualTransformation.None,
                        suffix = {
                            Image(
                                painter = painterResource(
                                    if (isObscure.value) {
                                        R.drawable.ic_eye
                                    } else {
                                        R.drawable.ic_eye_closed
                                    }
                                ),
                                contentDescription = "Visibility Icon",
                                modifier = Modifier.clickable {
                                    isObscure.value = !isObscure.value
                                }
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                            onLogin(email.value, password.value)
                        },
                        enabled = btnEnabled(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primary
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(
                            vertical = 16.dp
                        )
                    ) {
                        Text(
                            "Acessar",
                            style = appTypography.numberMd,
                            color = textCta
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    HorizontalDivider(
                        color = border,
                        modifier = Modifier.padding(
                            vertical = 24.dp
                        )
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = textPrimary,
                                    fontSize = appTypography.numberSm.fontSize, // agora correto
                                    fontWeight = appTypography.numberSm.fontWeight
                                )
                            ) {
                                append("Não tem uma conta? ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = primary,
                                    fontSize = appTypography.numberSm.fontSize,
                                    fontWeight = appTypography.numberSm.fontWeight,
                                    textDecoration = TextDecoration.Underline
                                )
                            ) {
                                append("Criar conta")
                            }
                        },
                        style = appTypography.numberSm,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        onLogin = { _, _ -> },
        onClickCreateAccount = {}
    )
}