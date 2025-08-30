package com.example.savenotes.feature_note.presentation.notes

import com.example.savenotes.feature_note.domain.model.Note
import com.example.savenotes.feature_note.domain.util.NoteOrder
import com.example.savenotes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
