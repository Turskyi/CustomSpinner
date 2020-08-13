package io.github.turskyi.customspinner.presentation.model.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.turskyi.customspinner.presentation.model.viewmodel.SettingsViewModelFactory
import io.github.turskyi.customspinner.R
import io.github.turskyi.customspinner.presentation.model.viewmodel.SettingsViewModel
import io.github.turskyi.customspinner.util.getLanguagePosition
import io.github.turskyi.customspinner.util.hideSpinnerDropDown
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var viewModel: SettingsViewModel
    private lateinit var languageWordAdapter: SpinnerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initObserver()
        initListener()
    }

    private fun initView() {
        viewModel = ViewModelProvider(this, SettingsViewModelFactory(this.application))
                .get(SettingsViewModel::class.java)
        initAdapter()
    }

    private fun initAdapter() {
        languageWordAdapter = SpinnerAdapter()
        spinnerWordLanguage.adapter = languageWordAdapter
    }

    private fun initObserver() {
        viewModel.languages.observe(this, Observer { languages ->
            languageWordAdapter.languages = languages
        })
    }

    private fun initListener() {
        languageWordAdapter.onItemClickListener = {
            viewModel.spinnerIsOpened = if (viewModel.spinnerIsOpened) {
                it.language?.getLanguagePosition(this)?.let { languagePosition ->
                    spinnerWordLanguage.setSelection(
                            languagePosition
                    )
                }
                spinnerWordLanguage.hideSpinnerDropDown()
                false
            } else {
                spinnerWordLanguage.performClick()
                true
            }
        }
    }
}