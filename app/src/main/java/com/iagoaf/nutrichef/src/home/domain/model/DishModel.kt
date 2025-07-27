package com.iagoaf.nutrichef.src.home.domain.model

data class DishModel(
    val photoUrl: String = "",
    val name: String = "",
    val category: String = "",
    val description: String = "",
    val calories: String = "",
    val energy: Int = 0,
    val portionTotal: String = "",
    val typeDish: String = "",
    val details: Details = Details(),
    val moreDetails: MoreDetails = MoreDetails()
)

data class Details(
    val proteins: Int = 0,
    val carbohydrates: Int = 0,
    val sugar: Int = 0,
    val fats: Int = 0
)

data class MoreDetails(
    val energy: Int = 0,
    val proteins: Int = 0,
    val carbohydrates: Int = 0,
    val totalFat: Int = 0,
    val cholesterol: Int = 0,
    val sodium: Int = 0,
    val potassium: Int = 0,
    val calcium: Int = 0,
    val iron: Int = 0,
    val magnesium: Int = 0,
    val vitaminC: Int = 0,
    val vitaminD: Int = 0,
    val vitaminB6: Double = 0.0
)
