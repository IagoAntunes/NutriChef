package com.iagoaf.nutrichef.src.plateDetail.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagoaf.nutrichef.R
import com.iagoaf.nutrichef.core.ui.theme.appTypography
import com.iagoaf.nutrichef.core.ui.theme.background
import com.iagoaf.nutrichef.core.ui.theme.primary
import com.iagoaf.nutrichef.core.ui.theme.surface
import com.iagoaf.nutrichef.core.ui.theme.textCta
import com.iagoaf.nutrichef.core.ui.theme.textPrimary

@Composable
fun PlateDetailScreen(
    onClickShowDetails: () -> Unit,
) {
    Scaffold(
        containerColor = background,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(textPrimary)
                )
                Image(
                    painter = painterResource(R.drawable.ic_favorite_off),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(textPrimary)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(surface)
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    "Salada variada",
                    style = appTypography.heading1,
                    color = textPrimary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Energia",
                            style = appTypography.heading3,
                            color = textPrimary
                        )
                        Text(
                            "221,15 kcal",
                            style = appTypography.numberMd,
                            color = textPrimary
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Porção total",
                            style = appTypography.heading3,
                            color = textPrimary
                        )
                        Text(
                            "240 g",
                            style = appTypography.numberMd,
                            color = textPrimary
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Proteinas",
                                style = appTypography.heading3,
                                color = textPrimary
                            )
                            Text(
                                "15,13 g",
                                style = appTypography.numberSm,
                                color = textPrimary
                            )
                        }
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(6) {
                                Box(
                                    modifier = Modifier
                                        .height(8.dp)
                                        .width(42.dp)
                                        .clip(RoundedCornerShape(80.dp))
                                        .background(primary)
                                )
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Carboidratos",
                                style = appTypography.heading3,
                                color = textPrimary
                            )
                            Text(
                                "18,40 g",
                                style = appTypography.numberSm,
                                color = textPrimary
                            )
                        }
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(6) {
                                Box(
                                    modifier = Modifier
                                        .height(8.dp)
                                        .width(42.dp)
                                        .clip(RoundedCornerShape(80.dp))
                                        .background(primary)
                                )
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Açucar",
                                style = appTypography.heading3,
                                color = textPrimary
                            )
                            Text(
                                "4,88 g",
                                style = appTypography.numberSm,
                                color = textPrimary
                            )
                        }
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(6) {
                                Box(
                                    modifier = Modifier
                                        .height(8.dp)
                                        .width(42.dp)
                                        .clip(RoundedCornerShape(80.dp))
                                        .background(primary)
                                )
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Gorduras",
                                style = appTypography.heading3,
                                color = textPrimary
                            )
                            Text(
                                "5,18 g",
                                style = appTypography.numberSm,
                                color = textPrimary
                            )
                        }
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(6) {
                                Box(
                                    modifier = Modifier
                                        .height(8.dp)
                                        .width(42.dp)
                                        .clip(RoundedCornerShape(80.dp))
                                        .background(primary)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = onClickShowDetails,
                        colors = ButtonDefaults.buttonColors(containerColor = primary),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(vertical = 12.dp)
                    ) {
                        Text(
                            "Mais detalhes",
                            style = appTypography.numberMd,
                            color = textCta
                        )
                    }
                }
            }
        }

    }
}

@Preview
@Composable
private fun PlateDetailPreview() {
    PlateDetailScreen(
        onClickShowDetails = {}
    )
}