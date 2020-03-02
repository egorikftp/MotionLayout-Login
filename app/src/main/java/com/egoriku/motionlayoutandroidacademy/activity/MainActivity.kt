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

        step_1.setOnClickListener {
            startMotionActivity(R.layout.step_1)
        }

        step_1_todo.setOnClickListener {
            startMotionActivity(R.layout.step_1_todo)
        }

        step_2.setOnClickListener {
            startMotionActivity(R.layout.step_2)
        }

        step_2_todo.setOnClickListener {
            startMotionActivity(R.layout.step_2_todo)
        }

        step_3.setOnClickListener {
            startMotionActivity(R.layout.scene_3)
        }

        step_3_todo.setOnClickListener {

        }

        step_4.setOnClickListener {
            startMotionActivity(R.layout.scene_4)
        }

        step_4_todo.setOnClickListener {

        }

        step_5.setOnClickListener {
            startMotionActivity(R.layout.scene_5_final)
        }

        step_5_todo.setOnClickListener {

        }

        step_6.setOnClickListener {
            startMotionActivity(R.layout.scene_6_final)
        }

        step_6_todo.setOnClickListener {

        }

        step_7.setOnClickListener {
            startMotionActivity(R.layout.scene_7_final)
        }

        step_7_todo.setOnClickListener {

        }

        step_8.setOnClickListener {
            startMotionActivity(R.layout.scene_8_final)
        }

        step_8_todo.setOnClickListener {

        }

        step_9.setOnClickListener {
            startMotionActivity(R.layout.scene_9_final)
        }

        step_9_todo.setOnClickListener {

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