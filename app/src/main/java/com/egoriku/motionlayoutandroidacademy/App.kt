package com.egoriku.motionlayoutandroidacademy

import android.app.Application
import androidx.constraintlayout.motion.widget.MotionLayout
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
                    Beagle.currentActivity?.let { activity ->
                        activity.findViewById<MotionLayout>(R.id.motionLayout)
                            ?.setDebugMode(it.value)
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