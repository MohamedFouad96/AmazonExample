package sa.edu.twuaiq.amazon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val products = mutableListOf(
        ProductModel(
            R.drawable.product1,
            "Samsung core I7 11th gen - SSD 1TB -  RAM 8GB - nvidia video card",
            4.5f,
            3000.0,
            "Samsung core I7 11th gen - SSD 1TB -  RAM 8GB - nvidia video card"
        ),
        ProductModel(
            R.drawable.product2,
            "Acer Swift 3 Thin & Light Laptop | 14Octa-Core Processor | 8GB LPDDR4X | 512GB NVMe SSD",
            4.0f,
            2000.0,
            "Acer Swift 3 Thin & Light Lapt 7 5NVM SF314-43-R2YY"
        ),
        ProductModel(
            R.drawable.product3,
            "Acer Swift 3 Intel Evo Thin & Light Laptop,  Core i7-1165G7",
            3.0f,
            3000.0,
            "Acer Swift 3 Intel E65G7, InteVMe SSD, Wi-FBack-lit KB, SF314-59-75QC"
        ),
        ProductModel(
            R.drawable.product4,
            "Acer Aspire 5 Slim 15.6 4-Core Processor",
            3.0f,
            1500.0,
            "Acer Aspire 5Amazon Alexa, BunMode (12GB|512GB SSD, A515-46-R14K)"
        ),
        ProductModel(
            R.drawable.product5,
            "HP 15.6\" FHD Laptop for Business & Student, AM",
            3.0f,
            1500.0,
            "HP 15.6\" FHD Laptop for Business & Student, AMD Ryzen 3 3250U 4GB RAM"
        )
    )

    private lateinit var productRecyclerView: RecyclerView
    private lateinit var productRecyclerViewAdapter: ProductRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // views declaration from activity main
        val addProduct: FloatingActionButton = findViewById(R.id.add_floating_button)
        productRecyclerView = findViewById(R.id.products_recyclerview)
        productRecyclerViewAdapter = ProductRecyclerViewAdapter(this,products)

        // assign adapter to recyclerview
        productRecyclerView.adapter = productRecyclerViewAdapter

        addProduct.setOnClickListener {
            // start activity for result
            //Android Intent is the message that is passed between components such as activities
            val intent = Intent(this,AddProduct::class.java)

         /*  Starting another activity,
             whether one within your app or from another app,
             doesn't need to be a one-way operation.
             You can also start another activity and receive a result back. For example,
             your app can start a camera app and receive the captured photo as a result. Or,
             you might start the Contacts app in order for the user to select a contact and you'll receive the contact details as a result.*/
            startActivityForResult(intent,1)
        }

    }

    // this method called, When we start another activity from current activity to get the result for it
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK) {
            data?.let { intent ->
                products.add(
                    ProductModel(
                        intent.getIntExtra("product_image",0),
                        intent.getStringExtra("product_name")!!,
                        intent.getFloatExtra("product_rating",0.0f),
                        intent.getDoubleExtra("product_price",0.0),
                        intent.getStringExtra("product_description")!!
                    )
                )
            }

            // Notifies the attached observers that the underlying data has been changed and any View reflecting the data set should refresh itself.
            productRecyclerViewAdapter.notifyDataSetChanged()
        }
    }
}