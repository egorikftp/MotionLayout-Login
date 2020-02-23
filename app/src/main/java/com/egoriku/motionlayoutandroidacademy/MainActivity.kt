package com.egoriku.motionlayoutandroidacademy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scene_0.setOnClickListener {
            startMotionActivity(R.layout.scene_0_final)
        }

        scene_1.setOnClickListener {
            startMotionActivity(R.layout.scene_1_final)
        }

        scene_2.setOnClickListener {
            startMotionActivity(R.layout.scene_2_final)
        }

        scene_3.setOnClickListener {
            startMotionActivity(R.layout.scene_3_final)
        }

        scene_4.setOnClickListener {
            startMotionActivity(R.layout.scene_4_final)
        }

        scene_5.setOnClickListener {
            startMotionActivity(R.layout.motion_in_progress)
        }

        Handler().post {
            //scene_4.performClick()
        }
    }

    private fun startMotionActivity(@LayoutRes layoutId: Int) {
        startActivity(
            Intent(this, MotionActivity::class.java).apply {
                putExtra(LAYOUT_ID, layoutId)
            }
        )
    }
}


