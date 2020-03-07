@file:Suppress("unused")

package com.egoriku.motionlayoutandroidacademy

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.egoriku.motionlayoutandroidacademy.activity.MotionActivity
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import com.egoriku.motionlayoutandroidacademy.common.visible
import com.pandulapeter.beagle.Beagle
import com.pandulapeter.beagleCore.configuration.Trick
import com.pandulapeter.beagleCore.contracts.BeagleListItemContract

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Beagle.imprint(this)

        Beagle.learn(
            Trick.Header(title = getString(R.string.app_name)),
            Trick.Button(
                text = "Enable Coordinator",
                onButtonPressed = {
                    Beagle.currentActivity?.run {
                        findViewById<View>(R.id.appbarLayout)?.visible()
                    }
                }
            ),
            Trick.SimpleList(
                title = "Debug mode",
                isInitiallyExpanded = true,
                items = listOf(
                    DebugOptions(name = "NO_DEBUG", value = 0),
                    DebugOptions(name = "SHOW_PROGRESS", value = 1),
                    DebugOptions(name = "SHOW_PATH", value = 2),
                    DebugOptions(name = "SHOW_ALL", value = 3)
                ),
                onItemSelected = {
                    Beagle.currentActivity?.run {
                        findViewById<MotionLayout>(R.id.motionLayout)?.setDebugMode(it.value)

                        Beagle.dismiss()
                    }
                }
            ),
            Trick.SimpleList(
                title = "Basic animations",
                isInitiallyExpanded = true,
                items = listOf(
                    DebugOptions(name = "Clicks", value = R.layout.activity_basic_clicks),
                    DebugOptions(name = "Swipes", value = R.layout.activity_basic_swipes),
                    DebugOptions(name = "Transform", value = R.layout.activity_basic_transform),
                    DebugOptions(
                        name = "Key attributes",
                        value = R.layout.activity_basic_key_attributes
                    )
                ),
                onItemSelected = {
                    Beagle.currentActivity?.run {
                        startActivity(Intent(this, MotionActivity::class.java).apply {
                            putExtra(LAYOUT_ID, it.value)
                        })
                    }
                }
            )
        )
    }
}

data class DebugOptions(
    override val name: String,
    val value: Int
) : BeagleListItemContract