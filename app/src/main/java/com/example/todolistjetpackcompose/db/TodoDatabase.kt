package com.example.todolistjetpackcompose.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todolistjetpackcompose.models.TodoDataClass

@Database(entities = [TodoDataClass::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase:RoomDatabase() {

    companion object{
        const val NAME ="Todo_DB"


    }

    abstract  fun getTodoDao():TodoDao


}