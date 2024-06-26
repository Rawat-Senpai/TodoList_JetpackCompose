package com.example.todolistjetpackcompose.models

import android.os.Build
import android.provider.CalendarContract.Instances
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class TodoDataClass(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var title: String,
    var createdAt: Date
)

@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo(): List<TodoDataClass> {
    return listOf<TodoDataClass>(
        TodoDataClass(1, "First Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "second Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "third Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "4th  Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "5th  Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "First Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "First Todo ", Date.from(Instant.now())),
        TodoDataClass(1, "First Todo ", Date.from(Instant.now())),


        )
}
