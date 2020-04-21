package com.egoriku.motionlayoutandroidacademy.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.egoriku.motionlayoutandroidacademy.R
import com.egoriku.motionlayoutandroidacademy.common.BundleDelegate
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import com.egoriku.motionlayoutandroidacademy.common.toast
import kotlinx.android.synthetic.main.step_9.*

class MotionActivity : AppCompatActivity() {

    private val Bundle.layoutId: Int by BundleDelegate.Int(LAYOUT_ID)

    private var completedId: Int = R.id.start

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = intent.extras?.layoutId ?: throw Exception("Where is layout??")

        setContentView(layoutId)

        if (layoutId == R.layout.step_9) {
            login_text.setOnClickListener {
                when (completedId) {
                    R.id.start -> toast("Perform Login")
                    else -> motionLayout.transitionToStart()
                }
            }

            sign_up_text.setOnClickListener {
                when (completedId) {
                    R.id.end -> toast("Perform Sign Up")
                    else -> motionLayout.transitionToEnd()
                }
            }

            motionLayout.setTransitionListener(object : TransitionAdapter() {

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                    completedId = currentId
                }
            })
        }
    }
}
