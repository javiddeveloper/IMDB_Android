package ir.javid.developer.imdb.ui.dataBindingAdapter

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import ir.javid.developer.imdb.R
import ir.javid.developer.imdb.ui.widgets.CustomImageView

/**
 * Developed by javid
 */

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@BindingAdapter("imageUrl")
fun imageFromUrl(img: CustomImageView, url: String?) {
    Glide.with(img.context).load(url)
        .placeholder(img.context.getDrawable(R.drawable.ic_launcher_background))
        .into(img)
}

@BindingAdapter("isVisible")
fun visibleInvisible(view: View, isVisible: Boolean) {
    if (isVisible && view.visibility != View.VISIBLE) {
        view.visibility = View.VISIBLE
        YoYo.with(Techniques.FadeInDown).duration(500).playOn(view)
    } else if (!isVisible && view.visibility != View.INVISIBLE) {
        YoYo.with(Techniques.FadeOut).onEnd { view.visibility = View.INVISIBLE }.duration(500)
            .playOn(view)
    }

}