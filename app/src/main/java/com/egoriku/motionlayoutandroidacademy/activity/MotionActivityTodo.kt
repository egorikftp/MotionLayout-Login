package com.egoriku.motionlayoutandroidacademy.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egoriku.motionlayoutandroidacademy.R
import com.egoriku.motionlayoutandroidacademy.common.BundleDelegate
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID

class MotionActivityTodo : AppCompatActivity() {

    private val Bundle.layoutId: Int by BundleDelegate.Int(LAYOUT_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = intent.extras?.layoutId ?: throw Exception("Where is layout??")

        setContentView(layoutId)

        if (layoutId == R.layout.step_9) {
            //TODO add TransitionAdapter and change selected state on 50% of animation
        }
    }
}
