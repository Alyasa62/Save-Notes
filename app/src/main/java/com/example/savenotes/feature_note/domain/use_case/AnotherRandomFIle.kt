package com.example.savenotes.feature_note.domain.use_case


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.Text

@Composable
fun RandomFile(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello from Random File",
            modifier = modifier
                .fillMaxWidth()
        )
    }

}