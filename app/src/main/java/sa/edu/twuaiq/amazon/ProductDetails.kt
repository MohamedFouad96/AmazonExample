package sa.edu.twuaiq.amazon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        // views declaration from activity product details
        val productNameTextView: TextView = findViewById(R.id.product_name)
        val productPriceTextView: TextView = findViewById(R.id.product_price)
        val productImageView: ImageView = findViewById(R.id.product_img)

        // get data from main activity by intent
        // the normal way to pass data from activity to another
        val productName = intent.getStringExtra("product_name")
        val productPrice = intent.getDoubleExtra("product_price" , 0.0)
        val productImage = intent.getIntExtra("product_image",0)

        // assignment intent data to views
        productNameTextView.text = productName
        productPriceTextView.text = "$productPrice SAR"
        productImageView.setImageResource(productImage)
    }
}