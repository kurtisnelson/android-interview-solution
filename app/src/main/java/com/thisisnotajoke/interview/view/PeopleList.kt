package com.thisisnotajoke.interview.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thisisnotajoke.interview.PeopleListViewModel
import com.thisisnotajoke.interview.model.PeopleState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleList(
    modifier: Modifier = Modifier,
    viewModel: PeopleListViewModel = viewModel(),
) {
    val response by viewModel.people.collectAsStateWithLifecycle()
    var isRefreshing by remember { mutableStateOf(false) }
    val onRefresh: () -> Unit = {
        isRefreshing = true
        viewModel.refresh {
            isRefreshing = false
        }
    }
    PullToRefreshBox(isRefreshing, onRefresh) {
        when (response) {
            is PeopleState.Loading -> {
                CircularProgressIndicator(modifier = modifier)
            }

            is PeopleState.Success -> {
                val success = response as PeopleState.Success
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(items = success.people.value, key = { it.uuid }) {
                        PersonRow(it, modifier = Modifier.animateItem())
                    }
                }
            }

            is PeopleState.Error -> {
                val error = response as PeopleState.Error
                Text("Error: {${error.error}")
            }
        }

    }
}
