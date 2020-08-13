package io.github.turskyi.customspinner.util

import android.content.Context
import android.widget.Spinner
import io.github.turskyi.customspinner.R
import io.github.turskyi.customspinner.common.Constants.AE
import io.github.turskyi.customspinner.common.Constants.CN
import io.github.turskyi.customspinner.common.Constants.DE
import io.github.turskyi.customspinner.common.Constants.EN
import io.github.turskyi.customspinner.common.Constants.ES
import io.github.turskyi.customspinner.common.Constants.FR
import io.github.turskyi.customspinner.common.Constants.JP
import io.github.turskyi.customspinner.common.Constants.KR
import io.github.turskyi.customspinner.common.Constants.PT
import io.github.turskyi.customspinner.common.Constants.RU
import io.github.turskyi.customspinner.common.Constants.UA
import java.lang.reflect.Method

fun String.getLanguagePosition(context: Context) = when (this) {
    context.getString(R.string.language_en) -> EN
    context.getString(R.string.language_ru) -> RU
    context.getString(R.string.language_es) -> ES
    context.getString(R.string.language_de) -> DE
    context.getString(R.string.language_fr) -> FR
    context.getString(R.string.language_cn) -> CN
    context.getString(R.string.language_jp) -> JP
    context.getString(R.string.language_kr) -> KR
    context.getString(R.string.language_ae) -> AE
    context.getString(R.string.language_pt) -> PT
    context.getString(R.string.language_ua) -> UA
    else -> EN
}

fun Spinner?.hideSpinnerDropDown() {
    try {
        val method: Method = Spinner::class.java.getDeclaredMethod("onDetachedFromWindow")
        method.isAccessible = true
        method.invoke(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}