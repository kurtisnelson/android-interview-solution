package com.thisisnotajoke.interview.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import com.thisisnotajoke.interview.model.Person

@Composable
fun PersonRow(person: Person, modifier: Modifier = Modifier) {
    Row {
        AsyncImage(model = person.photo_url_small, contentDescription = person.fullName)
        Column {
            Text(person.fullName, modifier = modifier)
            Text(person.team, modifier = modifier)
        }
    }
}