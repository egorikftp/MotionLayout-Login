package com.egoriku.motionlayoutandroidacademy.activity

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.egoriku.motionlayoutandroidacademy.R
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scene_1.setOnClickListener {
            startMotionActivity(R.layout.scene_1_final)
        }

        scene_1_todo.setOnClickListener {

        }

        scene_2.setOnClickListener {
            startMotionActivity(R.layout.scene_2_final)
        }

        scene_2_todo.setOnClickListener {

        }

        scene_3.setOnClickListener {
            startMotionActivity(R.layout.scene_3_final)
        }

        scene_3_todo.setOnClickListener {

        }

        scene_4.setOnClickListener {
            startMotionActivity(R.layout.scene_4_final)
        }

        scene_4_todo.setOnClickListener {

        }

        scene_5.setOnClickListener {
            startMotionActivity(R.layout.scene_5_final)
        }

        scene_5_todo.setOnClickListener {

        }

        scene_6.setOnClickListener {
            startMotionActivity(R.layout.scene_6_final)
        }

        scene_6_todo.setOnClickListener {

        }

        scene_7.setOnClickListener {
            startMotionActivity(R.layout.scene_7_final)
        }

        scene_7_todo.setOnClickListener {

        }

        scene_8.setOnClickListener {
            startMotionActivity(R.layout.scene_8_final)
        }

        scene_8_todo.setOnClickListener {

        }

        initCoordinatorWithMotion()
    }

    private fun startMotionActivity(@LayoutRes layoutId: Int) = startActivity(
        Intent(this, MotionActivity::class.java).apply {
            putExtra(LAYOUT_ID, layoutId)
        }
    )

    private fun initCoordinatorWithMotion() {
        val appBarLayout: AppBarLayout = findViewById(R.id.appbar_layout)
        val motionLayout: MotionLayout = findViewById(R.id.motion_layout)

        val listener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val scrollPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()

            motionLayout.progress = scrollPosition
        }

        appBarLayout.addOnOffsetChangedListener(listener)
    }
}