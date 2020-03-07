package com.egoriku.motionlayoutandroidacademy.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.egoriku.motionlayoutandroidacademy.R
import com.egoriku.motionlayoutandroidacademy.activity.todo.CoordinatorActivityTodo
import com.egoriku.motionlayoutandroidacademy.activity.todo.MotionActivityTodo
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import com.google.android.material.appbar.AppBarLayout
import com.pandulapeter.beagle.Beagle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var isAppBarExpanded = true

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
            startMotionActivity(R.layout.step_3)
        }

        step_3_todo.setOnClickListener {
            startMotionActivity(R.layout.step_3_todo)
        }

        step_4.setOnClickListener {
            startMotionActivity(R.layout.step_4)
        }

        step_4_todo.setOnClickListener {
            startMotionActivity(R.layout.step_4_todo)
        }

        step_5.setOnClickListener {
            startMotionActivity(R.layout.step_5)
        }

        step_5_todo.setOnClickListener {
            startMotionActivity(R.layout.step_5_todo)
        }

        step_6.setOnClickListener {
            startMotionActivity(R.layout.step_6)
        }

        step_6_todo.setOnClickListener {
            startMotionActivity(R.layout.step_6_todo)
        }

        step_7.setOnClickListener {
            startMotionActivity(R.layout.step_7)
        }

        step_7_todo.setOnClickListener {
            startMotionActivity(R.layout.step_7_todo)
        }

        step_8.setOnClickListener {
            startMotionActivity(R.layout.step_8)
        }

        step_8_todo.setOnClickListener {
            startMotionActivity(R.layout.step_8_todo)
        }

        step_9.setOnClickListener {
            startMotionActivity(R.layout.step_9)
        }

        step_9_todo.setOnClickListener {
            startActivity(Intent(this, MotionActivityTodo::class.java))
        }

        step_10_todo.setOnClickListener {
            startActivity(Intent(this, CoordinatorActivityTodo::class.java))
        }

        initCoordinatorWithMotion()
    }

    private fun startMotionActivity(@LayoutRes layoutId: Int) = startActivity(
        Intent(this, MotionActivity::class.java).apply {
            putExtra(LAYOUT_ID, layoutId)
        }
    )

    private fun initCoordinatorWithMotion() {
        val listener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val scrollPosition = -verticalOffset / appbarLayout.totalScrollRange.toFloat()
            isAppBarExpanded = verticalOffset == 0

            motionLayout.progress = scrollPosition
        }

        appbarLayout.addOnOffsetChangedListener(listener)

        appLogo.setOnClickListener {
            appbarLayout.setExpanded(!isAppBarExpanded)
        }
    }
}