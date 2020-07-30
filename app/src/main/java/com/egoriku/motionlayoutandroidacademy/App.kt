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
                    DebugOptions(name = "Click", value = R.layout.activity_basic_click),
                    DebugOptions(name = "Transform", value = R.layout.activity_basic_transform),
                    DebugOptions(name = "Custom Attribute", value = R.layout.activity_basic_custom_attribute),
                    DebugOptions(name = "Swipe", value = R.layout.activity_basic_swipe),
                    DebugOptions(name = "ImageFilterView", value = R.layout.activity_basic_imagefilter),
                    DebugOptions(name = "ImageFilterView Saturation", value = R.layout.activity_basic_imagefilter_saturation),
                    DebugOptions(name = "PropertySet", value = R.layout.activity_basic_property_set),
                    DebugOptions(name = "KeyPosition", value = R.layout.activity_basic_keyposition),
                    DebugOptions(name = "KeyAttribute", value = R.layout.activity_basic_keyattribute),
                    DebugOptions(name = "Motion", value = R.layout.activity_basic_motion),
                    DebugOptions(name = "KeyCycle", value = R.layout.activity_basic_key_cycle),
                    DebugOptions(name = "KeyTimeCycle", value = R.layout.activity_basic_key_time_cycle),
                    DebugOptions(name = "KeyTrigger", value = R.layout.activity_basic_key_trigger)
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