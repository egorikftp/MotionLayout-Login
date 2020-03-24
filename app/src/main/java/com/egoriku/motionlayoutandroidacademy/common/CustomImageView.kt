package com.egoriku.motionlayoutandroidacademy.common

import android.content.Context
import android.util.AttributeSet
import android.view.animation.ScaleAnimation
import androidx.appcompat.widget.AppCompatImageView
import androidx.interpolator.view.animation.FastOutLinearInInterpolator

class CustomImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    fun hide() = animateView(isExpand = false)

    fun show() = animateView(isExpand = true)

    private fun animateView(isExpand: Boolean) {
        if (animation?.hasEnded() == false) {
            return
        }

        if (isExpand) {
            ScaleAnimation(
                0.0f, 1.0f, 0.0f, 1.0f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f
            )
        } else {
            ScaleAnimation(
                1.0f, 0.0f, 1.0f, 0.0f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f
            )
        }.run {
            fillAfter = true
            duration = 200
            interpolator = FastOutLinearInInterpolator()

            startAnimation(this)
        }
    }
}