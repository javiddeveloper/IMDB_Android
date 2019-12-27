package ir.javid.developer.imdb.tools

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Developed by javid
 */
class DataBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun setImageFromUrl(img: ImageView, url: String) {
            Glide.with(img.context).load(url)
//            .centerCrop()
//            .placeholder()
                .into(img)
        }
    }
}