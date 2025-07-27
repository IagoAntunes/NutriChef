package com.iagoaf.nutrichef.src.home.presentation.screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.iagoaf.nutrichef.R
import com.iagoaf.nutrichef.core.ui.theme.appTypography
import com.iagoaf.nutrichef.core.ui.theme.primary
import com.iagoaf.nutrichef.core.ui.theme.secondary
import com.iagoaf.nutrichef.core.ui.theme.surface
import com.iagoaf.nutrichef.core.ui.theme.textPrimary
import com.iagoaf.nutrichef.core.ui.theme.textSecondary
import com.iagoaf.nutrichef.core.ui.theme.white
import com.iagoaf.nutrichef.core.utils.DishSamples
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.presentation.state.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onClickSearch: () -> Unit,
    onClickLogout: () -> Unit,
    onClickDish: (DishModel) -> Unit,
) {
    Scaffold(
        containerColor = white
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when (state) {
                is HomeState.Idle -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(primary)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_chef),
                                    contentDescription = "User Profile",
                                    colorFilter = ColorFilter.tint(white),
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    "Olá ${state.name}!",
                                    style = appTypography.heading3,
                                    color = textPrimary,
                                )
                                Text(
                                    "Boas vindas de volta!",
                                    style = appTypography.subHeading,
                                    color = textSecondary,
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_search),
                                colorFilter = ColorFilter.tint(primary),
                                contentDescription = "Search Icon",
                                modifier = Modifier.clickable(onClick = onClickSearch)
                            )
                            Image(
                                painter = painterResource(R.drawable.ic_logout),
                                colorFilter = ColorFilter.tint(secondary),
                                contentDescription = "Logout Icon",
                                modifier = Modifier.clickable(onClick = onClickLogout)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Column {
                        Text(
                            "Saúde em foco",
                            style = appTypography.heading2,
                            color = textPrimary,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(start = 20.dp)
                        ) {
                            items(state.headDishes) { dish ->
                                Column(
                                    modifier = Modifier
                                        .width(151.dp)
                                        .clickable {
                                            onClickDish(dish)
                                        }
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(151.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                    ) {
                                        AsyncImage(
                                            model = dish.photoUrl,
                                            contentScale = ContentScale.Crop,
                                            contentDescription = "Dish Image",
                                            placeholder = painterResource(R.drawable.ic_launcher_background),
                                            error = painterResource(R.drawable.ic_favorite_on),
                                            modifier = Modifier.fillMaxSize(),
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        dish.description,
                                        style = appTypography.subHeading,
                                        color = textPrimary,
                                        maxLines = 3,
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .background(surface)
                                .padding(horizontal = 20.dp)
                        ) {
                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                "Tabela nutricional ",
                                style = appTypography.heading2,
                                color = textPrimary
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(state.subDishes) { dish ->
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.clickable {
                                            onClickDish(dish)
                                        }
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(60.dp)
                                                .clip(RoundedCornerShape(16.dp))
                                        ) {
                                            AsyncImage(
                                                model = dish.photoUrl,
                                                contentScale = ContentScale.Crop,
                                                contentDescription = "Dish Image",
                                                placeholder = painterResource(R.drawable.ic_launcher_background),
                                                error = painterResource(R.drawable.ic_favorite_on),
                                                modifier = Modifier.fillMaxSize(),
                                            )
                                        }
                                        Column {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    dish.name,
                                                    style = appTypography.heading2,
                                                    color = textPrimary,
                                                )
                                                Text(
                                                    dish.calories,
                                                    style = appTypography.numberMd,
                                                    color = textPrimary,
                                                )
                                            }
                                            Text(
                                                "${dish.details.proteins}g proteina - ${dish.details.carbohydrates}g carboidratos",
                                                style = appTypography.numberSm,
                                                color = textSecondary,
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
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState.Idle("", headDishes = DishSamples.dishes, subDishes = DishSamples.dishes),
        onClickLogout = {},
        onClickSearch = {},
        onClickDish = {}
    )
}