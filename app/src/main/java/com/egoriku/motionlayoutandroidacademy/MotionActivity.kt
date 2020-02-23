package com.egoriku.motionlayoutandroidacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egoriku.motionlayoutandroidacademy.common.BundleDelegate
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import kotlinx.android.synthetic.main.scene_0_final.*

class MotionActivity : AppCompatActivity() {

    private val Bundle.layoutId: Int by BundleDelegate.Int(
        LAYOUT_ID
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = intent.extras?.layoutId ?: throw Exception("Where is layout??")

        setContentView(layoutId)

        motionLayout?.setDebugMode(2)
    }
}
