package com.egoriku.motionlayoutandroidacademy.common

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

fun View.visible() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, duration).show()