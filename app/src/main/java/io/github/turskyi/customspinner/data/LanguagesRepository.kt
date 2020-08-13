package io.github.turskyi.customspinner.data

import android.app.Application
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
import io.github.turskyi.customspinner.presentation.model.Language

class LanguagesRepository(private val application: Application) {
    val allLanguages: List<Language>

    init {
        allLanguages = generateLanguages()
    }

    private fun generateLanguages(): List<Language> {
        val list = mutableListOf<Language>()
        for (i in EN..UA) {
            val language = when (i) {
                EN -> application.resources.getString(R.string.language_en)
                RU -> application.resources.getString(R.string.language_ru)
                ES -> application.resources.getString(R.string.language_es)
                DE -> application.resources.getString(R.string.language_de)
                FR -> application.resources.getString(R.string.language_fr)
                CN -> application.resources.getString(R.string.language_cn)
                JP -> application.resources.getString(R.string.language_jp)
                KR -> application.resources.getString(R.string.language_kr)
                AE -> application.resources.getString(R.string.language_ae)
                PT -> application.resources.getString(R.string.language_pt)
                UA -> application.resources.getString(R.string.language_ua)
                else -> application.resources.getString(R.string.language_en)
            }
            list.add(
                Language(
                    language
                )
            )
        }
        return list
    }
}