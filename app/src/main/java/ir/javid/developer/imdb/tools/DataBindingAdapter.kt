package ir.javid.developer.imdb.tools

import android.view.View
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import ir.javid.developer.imdb.ui.widgets.CustomImageView

/**
 * Developed by javid
 */

@BindingAdapter("imageUrl")
fun imageFromUrl(img: CustomImageView, url: String?) {
    Glide.with(img.context).load(url)
//            .centerCrop()
//            .placeholder()
        .into(img)
}

@BindingAdapter("isVisible")
fun visibleInvisible(view: View, isVisible: Boolean) {
    if (isVisible && view.visibility != View.VISIBLE) {
        view.visibility = View.VISIBLE
        YoYo.with(Techniques.FadeIn).duration(500).playOn(view)
    } else if (!isVisible && view.visibility != View.INVISIBLE) {

        YoYo.with(Techniques.FadeOut).onEnd { view.visibility = View.INVISIBLE }.duration(1000)
            .playOn(view)
    }

}