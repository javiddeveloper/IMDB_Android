package ir.javid.developer.imdb.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import ir.javid.developer.imdb.R
import jp.wasabeef.glide.transformations.BlurTransformation

/**
 * Developed by javid
 */
class CustomImageView : ImageView {
    companion object {
        const val BLUR: Int = 0
        const val NORMAL: Int = 1
    }

    constructor(context: Context?) : super(context) {
        initView(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val customView: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val type: Int = customView.getInteger(R.styleable.CustomView_imageMode, 1)
    }

    fun imageControl(type: Int,url :String) {
        when (type) {
            BLUR -> {
                Glide.with(context)
                    .load(url)
                    .apply(bitmapTransform(BlurTransformation(25, 3)))
                    .into(this)
            }
            NORMAL -> {
                Glide.with(context)
                    .load(url)
                    .into(this)
            }
        }
    }


}
