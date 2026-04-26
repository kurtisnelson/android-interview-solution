package com.thisisnotajoke.interview.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thisisnotajoke.interview.ui.theme.InterviewTheme

@Composable
fun App() {
        InterviewTheme {
            Box(Modifier.safeDrawingPadding()) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PeopleList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
}