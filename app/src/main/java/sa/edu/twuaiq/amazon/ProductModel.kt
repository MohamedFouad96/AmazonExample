package sa.edu.twuaiq.amazon

import androidx.annotation.DrawableRes

data class ProductModel(
    @DrawableRes val productImage: Int,
    val productName: String,
    val productRate: Float,
    val productPrice: Double,
    val productDescription: String
)
