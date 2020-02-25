package com.egoriku.motionlayoutandroidacademy

import android.app.Application
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
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
                        findViewById<MotionLayout>(R.id.motion_layout)?.setDebugMode(it.value)

                        Beagle.dismiss(this)
                    }
                }
            ),
            Trick.Button(
                text = "Enable Coordinator",
                onButtonPressed = {
                    Beagle.currentActivity?.run {
                        findViewById<View>(R.id.appbar_layout).visible()
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