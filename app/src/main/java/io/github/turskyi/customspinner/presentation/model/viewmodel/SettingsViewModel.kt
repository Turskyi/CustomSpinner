package io.github.turskyi.customspinner.presentation.model.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.turskyi.customspinner.data.LanguagesRepository
import io.github.turskyi.customspinner.presentation.model.Language

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val languagesRepository: LanguagesRepository = LanguagesRepository(application)
    var spinnerIsOpened = false

    private val _languages =
        MutableLiveData<List<Language>>().apply {
            value = languagesRepository.allLanguages
        }
    val languages: LiveData<List<Language>> = _languages
}