package com.egoriku.motionlayoutandroidacademy.activity.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egoriku.motionlayoutandroidacademy.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.step_10_todo.*

class CoordinatorActivityTodo : AppCompatActivity(R.layout.step_10_todo) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initCoordinatorWithMotion()
    }

    private fun initCoordinatorWithMotion() {
        val listener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val scrollPosition = -verticalOffset / appbarLayout.totalScrollRange.toFloat()

            //TODO set progress in Motion Layout
        }

        appbarLayout.addOnOffsetChangedListener(listener)

        /**
         * TODO handle clicks on Logo.
         *
         *  @see com.google.android.material.appbar.AppBarLayout.setExpanded
         */
    }
}