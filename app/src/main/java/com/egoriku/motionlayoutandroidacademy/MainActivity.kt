package com.egoriku.motionlayoutandroidacademy

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
            startMotionActivity(R.layout.scene_5_final)
        }

        scene_6.setOnClickListener {
            startMotionActivity(R.layout.scene_6_final)
        }

        scene_7.setOnClickListener {
            startMotionActivity(R.layout.scene_7_final)
        }

        scene_8.setOnClickListener {
            startMotionActivity(R.layout.scene_8_final)
        }

        scene_9.setOnClickListener {
            startMotionActivity(R.layout.motion_in_progress)
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