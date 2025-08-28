package com.example.savenotes.feature_note.data.data_source.repository

import com.example.savenotes.feature_note.data.data_source.NoteDao
import com.example.savenotes.feature_note.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {
    override fun getNotes() = noteDao.getNotes()

    override suspend fun getNoteById(id: Int) = noteDao.getNoteById(id)

    override suspend fun insertNote(note: com.example.savenotes.feature_note.domain.model.Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: com.example.savenotes.feature_note.domain.model.Note) {
        noteDao.deleteNote(note)
    }
}