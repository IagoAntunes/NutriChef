package com.iagoaf.nutrichef.src.plateDetail.presentation.state

sealed class PlateDetailState {
    object SimpleDetails : PlateDetailState()
    object MoreDetails : PlateDetailState()
}