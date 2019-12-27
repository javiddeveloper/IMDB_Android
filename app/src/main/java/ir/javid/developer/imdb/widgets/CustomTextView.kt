package ir.javid.developer.imdb.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import ir.javid.developer.imdb.R

/**
 * Developed by javid
 */
class CustomTextView : AppCompatTextView {
    companion object {
        const val FONT_NAME: String = "Shabnam"
        const val BOLD: Int = 2
        const val LIGHT: Int = 1
        const val NORMAL: Int = 0
        lateinit var face: Typeface
    }

    constructor(context: Context?) : super(context) {
        initView(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
    }


    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val customView: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val type: Int = customView.getInteger(R.styleable.CustomView_fontType, 0)
        typeFont(type)
    }


    private fun typeFont(type: Int) {
        when (type) {
            BOLD -> {
                face = Typeface.createFromAsset(context.assets, "font/$FONT_NAME-Bold.ttf")
                typeface = face
            }
            LIGHT -> {
                face = Typeface.createFromAsset(context.assets, "font/$FONT_NAME-Light.ttf")
                typeface = face
            }
            NORMAL -> {
                face = Typeface.createFromAsset(context.assets, "font/$FONT_NAME.ttf")
                typeface = face
            }
            else -> {
                face = Typeface.createFromAsset(context.assets, "font/$FONT_NAME.ttf")
                typeface = face
            }
        }
    }
}
