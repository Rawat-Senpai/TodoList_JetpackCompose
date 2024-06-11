package com.example.todolistjetpackcompose.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolistjetpackcompose.models.TodoDataClass

@Dao
interface TodoDao {


    @Query("SELECT * FROM TODODATACLASS")
    fun getALlTodo(): LiveData<List<TodoDataClass>>


    @Insert
    fun addTodo(todo:TodoDataClass)

    @Query("Delete From TodoDataClass where id =:id ")
     fun deleteTodo(id:Int)

}