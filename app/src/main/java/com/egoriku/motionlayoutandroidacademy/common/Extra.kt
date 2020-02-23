package com.egoriku.motionlayoutandroidacademy.common

import android.os.Bundle
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

const val LAYOUT_ID = "layout_id"

sealed class BundleDelegate<T>(protected val key: String) : ReadWriteProperty<Bundle, T> {

    class Int(key: String) : BundleDelegate<kotlin.Int>(key) {

        override fun getValue(thisRef: Bundle, property: KProperty<*>) = thisRef.getInt(key)

        override fun setValue(thisRef: Bundle, property: KProperty<*>, value: kotlin.Int) =
            thisRef.putInt(key, value)
    }
}