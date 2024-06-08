package com.example.todolistjetpackcompose

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.todolistjetpackcompose.models.TodoDataClass
import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf<TodoDataClass>()

    fun getAllTodo() : List<TodoDataClass>{

        return todoList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){

        todoList.add(TodoDataClass(System.currentTimeMillis().toInt(),title.toString(), Date.from(
            Instant.now())))
    }

    fun deleteTodo(id:Int){
        todoList.removeIf{
            it.id==id
        }
    }


}