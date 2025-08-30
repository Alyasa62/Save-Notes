package com.example.savenotes.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: com.example.savenotes.feature_note.domain.use_case.NoteUseCases

): ViewModel() {

    private val _state = androidx.compose.runtime.mutableStateOf(NotesState())
    val state: androidx.compose.runtime.State<NotesState> = _state

    private var RecentlyDeletedNote: com.example.savenotes.feature_note.domain.model.Note? = null
    private var getNotesJob: kotlinx.coroutines.Job? = null
    init {
        getNotes(com.example.savenotes.feature_note.domain.util.NoteOrder.Date(com.example.savenotes.feature_note.domain.util.OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    RecentlyDeletedNote = event.note
                }

            }
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(RecentlyDeletedNote ?: return@launch)
                    RecentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                  isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: com.example.savenotes.feature_note.domain.util.NoteOrder) {
        getNotesJob?.cancel()
        _state.value = state.value.copy(isLoading = true)
        getNotesJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder,
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)

        }
    }
