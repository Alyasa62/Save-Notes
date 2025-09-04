package com.example.savenotes.feature_note.presentation.util

import androidx.navigation.NavHostController

sealed class Screen(
    val route: String
) {

    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")

}