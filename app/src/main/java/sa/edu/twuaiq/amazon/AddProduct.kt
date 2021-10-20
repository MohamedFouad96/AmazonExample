package sa.edu.twuaiq.amazon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import kotlin.random.Random

class AddProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        val productNameEditText: EditText = findViewById(R.id.product_name_edittext)
        val productPriceEditText: EditText = findViewById(R.id.product_price_edittext)
        val productDescriptionEditText: EditText = findViewById(R.id.product_description_edittext)
        val productRatingBar: RatingBar = findViewById(R.id.product_rating)
        val addProductButton: Button = findViewById(R.id.add_button)

        val productImages = listOf(
            R.drawable.product1,
            R.drawable.product2,
            R.drawable.product3,
            R.drawable.product4,
            R.drawable.product5)

        addProductButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("product_name",productNameEditText.text.toString())
            intent.putExtra("product_price",productPriceEditText.text.toString().toDouble())
            intent.putExtra("product_description", productDescriptionEditText.text.toString())
            intent.putExtra("product_rating", productRatingBar.rating)
            intent.putExtra("product_image",productImages[Random.nextInt(0,productImages.size)])
            setResult(RESULT_OK,intent)
            finish()
        }


    }
}