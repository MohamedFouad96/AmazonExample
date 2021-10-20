package sa.edu.twuaiq.amazon

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/***
Once you've determined your layout, you need to implement your Adapter and ViewHolder.
These two classes work together to define how your data is displayed.
The ViewHolder is a wrapper around a View that contains the layout for an individual item in the list.
The Adapter creates ViewHolder objects as needed, and also sets the data for those views.
The process of associating views to their data is called binding.

When you define your adapter, you need to override three key methods:
onCreateViewHolder()
onBindViewHolder()
getItemCount()
 **/
class ProductRecyclerViewAdapter(
    val context: Context,
    val productList: MutableList<ProductModel>):
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>() {





    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImageView:ImageView = view.findViewById(R.id.product_img)
        val productNameTextView: TextView = view.findViewById(R.id.product_name_text)
        val productRatingBar: RatingBar = view.findViewById(R.id.rating)
        val productPriceTextView: TextView = view.findViewById(R.id.product_price)
        val productDescriptionTextView: TextView = view.findViewById(R.id.product_description)
    }


    /**
     * onCreateViewHolder(): RecyclerView calls this method whenever it needs to create a new ViewHolder.
    The method creates and initializes the ViewHolder and its associated View,
    but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
     */


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val product_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return ProductViewHolder(product_layout)
    }

    /**
     * onBindViewHolder(): RecyclerView calls this method to associate a ViewHolder with data.
    The method fetches the appropriate data and uses the data to fill in the view holder's layout.
    For example, if the RecyclerView displays a list of names,
    the method might find the appropriate name in the list and fill in the view holder's TextView widget.
     */

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.productNameTextView.text = product.productName
        holder.productImageView.setImageResource(product.productImage)
        holder.productRatingBar.rating = product.productRate
        holder.productPriceTextView.text = "${product.productPrice} SAR"
        holder.productDescriptionTextView.text = product.productDescription

        holder.itemView.setOnClickListener {

            //Android Intent is the message that is passed between components such as activities
            val intent = Intent(context,ProductDetails::class.java)
            intent.putExtra("product_name",product.productName)
            intent.putExtra("product_price",product.productPrice)
            intent.putExtra("product_image",product.productImage)

            context.startActivity(intent)
        }

    }

    /**
     * getItemCount(): RecyclerView calls this method to get the size of the data set.
    For example, in an address book app, this might be the total number of addresses.
    RecyclerView uses this to determine when there are no more items that can be displayed.
     */

    override fun getItemCount(): Int {
        return productList.size
    }
}

