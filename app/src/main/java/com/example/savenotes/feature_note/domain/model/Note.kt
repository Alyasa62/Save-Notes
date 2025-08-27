package com.example.savenotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.savenotes.ui.theme.BabyBlue
import com.example.savenotes.ui.theme.LightGreen
import com.example.savenotes.ui.theme.RedOrange
import com.example.savenotes.ui.theme.RedPink
import com.example.savenotes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
)
{
    companion object {
        val noteColor = listOf(
            RedOrange, LightGreen, Violet, BabyBlue, RedPink
        )
    }
}
