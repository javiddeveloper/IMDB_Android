package ir.javid.developer.imdb.tools

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import ir.javid.developer.imdb.ui.widgets.CustomImageView

/**
 * Developed by javid
 */
//class DataBindingAdapter {
//    companion object {
//        @JvmStatic
        @BindingAdapter("imageUrl")
        fun imageFromUrl(img: CustomImageView, url: String?) {
            Glide.with(img.context).load(url)
//            .centerCrop()
//            .placeholder()
                .into(img)
        }
//    }
//}