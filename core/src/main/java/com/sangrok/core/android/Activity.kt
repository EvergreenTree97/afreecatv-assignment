package com.sangrok.core.android

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.startActivityWithAnimation(
    intentBuilder: Intent.() -> Intent = { this },
    withFinish: Boolean = false,
) {
    startActivity(intentBuilder(Intent(this, T::class.java)))
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    if (withFinish) finish()
}

fun Activity.finishWithAnimation() {
    finish()
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}