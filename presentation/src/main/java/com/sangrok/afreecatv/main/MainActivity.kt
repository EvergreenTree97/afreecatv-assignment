package com.sangrok.afreecatv.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.sangrok.afreecatv.main.screen.MainScreen
import com.sangrok.afreecatv.theme.AfreecaTvTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AfreecaTvTheme {
                MainScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
