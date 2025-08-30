package com.example.savenotes.feature_note.domain.use_case

import com.example.savenotes.feature_note.domain.model.InvalidNoteException
import com.example.savenotes.feature_note.domain.model.Note
import com.example.savenotes.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank() || note.content.isBlank()) {
            throw InvalidNoteException("The note title or content can't be empty.")
        }
        repository.insertNote(note)
    }
}