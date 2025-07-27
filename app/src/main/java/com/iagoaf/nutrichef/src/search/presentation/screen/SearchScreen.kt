package com.iagoaf.nutrichef.src.search.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagoaf.nutrichef.R
import com.iagoaf.nutrichef.core.components.CTextField
import com.iagoaf.nutrichef.core.ui.theme.appTypography
import com.iagoaf.nutrichef.core.ui.theme.background
import com.iagoaf.nutrichef.core.ui.theme.primary
import com.iagoaf.nutrichef.core.ui.theme.surface
import com.iagoaf.nutrichef.core.ui.theme.textPrimary
import com.iagoaf.nutrichef.core.ui.theme.textSecondary

@Composable
fun SearchScreen(
    onClickReceipt: () -> Unit,
) {

    val searchValue = remember { mutableStateOf("") }

    Scaffold(
        containerColor = background,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 24.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(textPrimary)
                )
                Text(
                    "Buscar receitas",
                    style = appTypography.heading2,
                    color = textPrimary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(surface)
                    .padding(horizontal = 24.dp)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CTextField(
                            value = searchValue.value,
                            onValueChange = { searchValue.value = it },
                            placeHolder = "Buscar receitas",
                            modifier = Modifier
                                .weight(1f)
                        )
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = primary)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(6) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(14.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onClickReceipt()
                                    }
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(primary),
                                )
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            "Salada variada",
                                            style = appTypography.heading2,
                                            color = textPrimary,
                                        )
                                        Text(
                                            "221,15 kcal",
                                            style = appTypography.numberMd,
                                            color = textPrimary,
                                        )
                                    }
                                    Text(
                                        "15,13g proteínas,  18,40g carbo",
                                        style = appTypography.numberSm,
                                        color = textSecondary
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen(
        onClickReceipt = {}
    )
}