package com.thisisnotajoke.interview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.thisisnotajoke.interview.repository.MobileInterviewRepository
import com.thisisnotajoke.interview.ui.theme.InterviewTheme
import com.thisisnotajoke.interview.view.PeopleList
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var service: MobileInterviewRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterviewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PeopleList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}