package com.iagoaf.nutrichef.core.utils

import com.iagoaf.nutrichef.src.home.domain.model.Details
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.domain.model.MoreDetails

object DishSamples {
    val dishes = listOf(
        DishModel(
            photoUrl = "https://canaldareceita.com.br/wp-content/uploads/2024/08/LASANHA-DE-FRANGO-COM-QUEIJO.png",
            name = "Lasanha de Frango",
            category = "principal",
            description = "Uma lasanha cremosa recheada com frango desfiado e molho branco.",
            calories = "350 kcal",
            energy = 350,
            portionTotal = "250g",
            typeDish = "Principal",
            details = Details(20, 45, 5, 10),
            moreDetails = MoreDetails(350, 20, 45, 10, 50, 500, 400, 100, 2, 40, 15, 2, 0.5)
        ),
        DishModel(
            photoUrl = "https://example.com/images/salada.jpg",
            name = "Salada Mediterrânea",
            category = "principal",
            description = "Salada fresca com tomate, pepino, azeitonas e queijo feta.",
            calories = "180 kcal",
            energy = 180,
            portionTotal = "150g",
            typeDish = "Entrada",
            details = Details(5, 20, 3, 8),
            moreDetails = MoreDetails(180, 5, 20, 8, 0, 250, 300, 60, 1, 20, 25, 0, 0.2)
        ),
        DishModel(
            photoUrl = "https://example.com/images/smoothie.jpg",
            name = "Smoothie de Morango",
            category = "principal",
            description = "Bebida gelada de morango, iogurte natural e mel.",
            calories = "220 kcal",
            energy = 220,
            portionTotal = "300ml",
            typeDish = "Bebida",
            details = Details(6, 35, 25, 4),
            moreDetails = MoreDetails(220, 6, 35, 4, 5, 150, 350, 120, 0, 30, 60, 0, 0.4)
        ),
        DishModel(
            photoUrl = "https://example.com/images/sopa.jpg",
            name = "Sopa de Legumes",
            category = "principal",
            description = "Sopa nutritiva com legumes frescos e temperos leves.",
            calories = "120 kcal",
            energy = 120,
            portionTotal = "200ml",
            typeDish = "Entrada",
            details = Details(3, 18, 4, 2),
            moreDetails = MoreDetails(120, 3, 18, 2, 0, 200, 250, 40, 1, 15, 20, 0, 0.1)
        ),
        DishModel(
            photoUrl = "https://example.com/images/omelete.jpg",
            name = "Omelete de Queijo",
            category = "principal",
            description = "Omelete fofinha recheada com queijo mussarela e ervas finas.",
            calories = "250 kcal",
            energy = 250,
            portionTotal = "180g",
            typeDish = "Principal",
            details = Details(15, 2, 1, 20),
            moreDetails = MoreDetails(250, 15, 2, 20, 200, 400, 300, 150, 2, 30, 0, 2, 0.5)
        ),
        DishModel(
            photoUrl = "https://example.com/images/panqueca.jpg",
            name = "Panqueca Integral",
            category = "principal",
            description = "Panqueca leve feita com farinha integral, banana e mel.",
            calories = "200 kcal",
            energy = 200,
            portionTotal = "100g",
            typeDish = "Café da manhã",
            details = Details(8, 30, 5, 5),
            moreDetails = MoreDetails(200, 8, 30, 5, 30, 250, 200, 60, 1, 25, 10, 0, 0.3)
        ),
        DishModel(
            photoUrl = "https://example.com/images/frango_grelhado.jpg",
            name = "Frango Grelhado",
            category = "principal",
            description = "Peito de frango grelhado temperado com limão e ervas.",
            calories = "300 kcal",
            energy = 300,
            portionTotal = "200g",
            typeDish = "Principal",
            details = Details(28, 0, 0, 8),
            moreDetails = MoreDetails(300, 28, 0, 8, 90, 350, 400, 20, 1, 35, 0, 0, 0.6)
        ),
        DishModel(
            photoUrl = "https://example.com/images/brownie.jpg",
            name = "Brownie de Chocolate",
            category = "principal",
            description = "Sobremesa deliciosa com chocolate meio amargo e nozes.",
            calories = "400 kcal",
            energy = 400,
            portionTotal = "120g",
            typeDish = "Sobremesa",
            details = Details(5, 50, 35, 20),
            moreDetails = MoreDetails(400, 5, 50, 20, 40, 180, 200, 80, 2, 25, 5, 0, 0.1)
        ),
        DishModel(
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
        DishModel(
            photoUrl = "https://example.com/images/espaguete.jpg",
            name = "Espaguete ao Sugo",
            category = "principal",
            description = "Massa italiana com molho de tomate fresco e manjericão.",
            calories = "320 kcal",
            energy = 320,
            portionTotal = "250g",
            typeDish = "Principal",
            details = Details(10, 60, 10, 5),
            moreDetails = MoreDetails(320, 10, 60, 5, 0, 300, 250, 50, 1, 30, 12, 0, 0.3)
        )
    )
}
