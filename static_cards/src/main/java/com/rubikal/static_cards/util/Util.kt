package com.rubikal.static_cards.util

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import com.rubikal.static_cards.static_cards.model.DiscoverCard
import com.rubikal.static_cards.R


fun openChromeCustomTab(card: DiscoverCard, context: Context){
    val url:String? = card.url
    val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
    builder.setToolbarColor(ContextCompat.getColor(context, R.color.abc_tint_spinner)).addDefaultShareMenuItem().setShowTitle(true)
    val customTabsIntent: CustomTabsIntent = builder.build()
    customTabsIntent.launchUrl(context, Uri.parse(url))
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}
fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{replace(frameId, fragment)}
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun convertDpToPixel(dp: Int, context: Context?): Int {
    val r = context?.resources
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r?.displayMetrics).toInt()
}

fun getScreenSize(activity: Activity): Point {
    val display = activity.windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size
}

