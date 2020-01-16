package com.mpawluch.todolist.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val title: String
)