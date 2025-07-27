package com.iagoaf.nutrichef.src.plateDetail.presentation.screen

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
import com.iagoaf.nutrichef.core.ui.theme.surfaceElement
import com.iagoaf.nutrichef.core.ui.theme.textCta
import com.iagoaf.nutrichef.core.ui.theme.textPrimary
import com.iagoaf.nutrichef.src.home.domain.model.Details
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.domain.model.MoreDetails
import com.iagoaf.nutrichef.src.plateDetail.presentation.state.PlateDetailState

@Composable
fun PlateDetailScreen(
    state: PlateDetailState,
    dish: DishModel,
    onBack: () -> Unit,
    onClickShowDetails: (PlateDetailState) -> Unit,
    getProteinBars: () -> Int = { 0 },
    getCarbohydrateBars: () -> Int = { 0 },
    getSugarBars: () -> Int = { 0 },
    getFatBars: () -> Int = { 0 },
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
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(textPrimary),
                    modifier = Modifier.clickable {
                        onBack()
                    }
                )
                Image(
                    painter = painterResource(R.drawable.ic_favorite_off),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(textPrimary)
                )
            }
//            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(surface)
                    .padding(horizontal = 32.dp)
            ) {
                when (state) {
                    PlateDetailState.MoreDetails -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Energia",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.energy.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Proteinas",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.proteins.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Carboidratos",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.carbohydrates.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Gorduras Totais",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.totalFat.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Colesterol",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.totalFat.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Sódio",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.totalFat.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Potássio",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.totalFat.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Cálcio",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.calcium.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Ferro",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.iron.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Magnésio",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.magnesium.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Vitamina C",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.vitaminC.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Vitamina D",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.vitaminD.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Vitamina B6",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        dish.moreDetails.vitaminB6.toString(),
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Button(
                                onClick = {
                                    onClickShowDetails(PlateDetailState.SimpleDetails)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = primary),
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                contentPadding = PaddingValues(vertical = 12.dp)
                            ) {
                                Text(
                                    "Voltar",
                                    style = appTypography.numberMd,
                                    color = textCta
                                )
                            }
                        }
                    }

                    PlateDetailState.SimpleDetails -> {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                dish.name,
                                style = appTypography.heading1,
                                color = textPrimary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(vertical = 8.dp)
                            )
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
                                        dish.calories,
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
                                        dish.portionTotal,
                                        style = appTypography.numberMd,
                                        color = textPrimary
                                    )
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
                                        "Proteinas",
                                        style = appTypography.heading3,
                                        color = textPrimary
                                    )
                                    Text(
                                        "${dish.details.proteins} kcal",
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    val filledBars = getProteinBars()
                                    items(6) { index ->
                                        Box(
                                            modifier = Modifier
                                                .height(8.dp)
                                                .width(42.dp)
                                                .clip(RoundedCornerShape(80.dp))
                                                .background(
                                                    if (index < filledBars) primary
                                                    else surfaceElement
                                                )
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
                                        "${dish.details.carbohydrates} kcal",
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    val filledBars = getCarbohydrateBars()
                                    items(6) { index ->
                                        Box(
                                            modifier = Modifier
                                                .height(8.dp)
                                                .width(42.dp)
                                                .clip(RoundedCornerShape(80.dp))
                                                .background(
                                                    if (index < filledBars) primary
                                                    else surfaceElement
                                                )
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
                                        "${dish.details.sugar} kcal",
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    val filledBars = getSugarBars()
                                    items(6) { index ->
                                        Box(
                                            modifier = Modifier
                                                .height(8.dp)
                                                .width(42.dp)
                                                .clip(RoundedCornerShape(80.dp))
                                                .background(
                                                    if (index < filledBars) primary
                                                    else surfaceElement
                                                )
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
                                        "${dish.details.fats} kcal",
                                        style = appTypography.numberSm,
                                        color = textPrimary
                                    )
                                }
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    val filledBars = getFatBars()
                                    items(6) { index ->
                                        Box(
                                            modifier = Modifier
                                                .height(8.dp)
                                                .width(42.dp)
                                                .clip(RoundedCornerShape(80.dp))
                                                .background(
                                                    if (index < filledBars) primary
                                                    else surfaceElement
                                                )
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Button(
                                onClick = {
                                    onClickShowDetails(PlateDetailState.MoreDetails)
                                },
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
    }
}

@Preview
@Composable
private fun PlateDetailPreview() {
    PlateDetailScreen(
        state = PlateDetailState.SimpleDetails,
        onBack = {},
        onClickShowDetails = {},
        dish = DishModel(
            photoUrl = "https://example.com/images/sushi.jpg",
            name = "Combo Sushi",
            category = "principal",
            description = "Seleção de sushis variados, incluindo nigiri e sashimi.",
            calories = "280 kcal",
            energy = 280,
            portionTotal = "220g",
            typeDish = "Principal",
            details = Details(12, 38, 8, 6),
            moreDetails = MoreDetails(280, 12, 38, 6, 35, 600, 300, 40, 2, 20, 8, 0, 0.2)
        ),
    )
}

@Preview
@Composable
private fun PlateDetailPreview2() {
    PlateDetailScreen(
        state = PlateDetailState.MoreDetails,
        onBack = {},
        onClickShowDetails = {},
        dish = DishModel(
            photoUrl = "https://example.com/images/sushi.jpg",
            name = "Combo Sushi",
            category = "principal",
            description = "Seleção de sushis variados, incluindo nigiri e sashimi.",
            calories = "280 kcal",
            energy = 280,
            portionTotal = "220g",
            typeDish = "Principal",
            details = Details(12, 38, 8, 6),
            moreDetails = MoreDetails(280, 12, 38, 6, 35, 600, 300, 40, 2, 20, 8, 0, 0.2)
        ),
    )
}