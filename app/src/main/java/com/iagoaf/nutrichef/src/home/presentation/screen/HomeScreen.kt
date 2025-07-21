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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagoaf.nutrichef.R
import com.iagoaf.nutrichef.core.ui.theme.appTypography
import com.iagoaf.nutrichef.core.ui.theme.primary
import com.iagoaf.nutrichef.core.ui.theme.secondary
import com.iagoaf.nutrichef.core.ui.theme.surface
import com.iagoaf.nutrichef.core.ui.theme.textPrimary
import com.iagoaf.nutrichef.core.ui.theme.textSecondary
import com.iagoaf.nutrichef.core.ui.theme.white

@Composable
fun HomeScreen(
    onClickSearch: () -> Unit,
    onClickLogout: () -> Unit,
) {
    Scaffold(
        containerColor = white
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
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
                            "Olá Marcos!",
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
                    items(4) {
                        Column(
                            modifier = Modifier.width(151.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(151.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(primary)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "A importância da tabela nutricional na alimentação consciente",
                                style = appTypography.subHeading,
                                color = textPrimary,
                                maxLines = 3,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "5 MIN",
                                style = appTypography.numberMd,
                                color = textSecondary,
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
                        items(4) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(primary)
                                )
                                Column {
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
                                        "15,13g proteínas, 18,40g carbo",
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


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        onClickLogout = {},
        onClickSearch = {}
    )
}