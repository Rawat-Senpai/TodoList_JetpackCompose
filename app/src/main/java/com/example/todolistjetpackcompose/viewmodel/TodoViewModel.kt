package com.example.todolistjetpackcompose.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistjetpackcompose.TodoManager
import com.example.todolistjetpackcompose.models.TodoDataClass

class TodoViewModel:ViewModel (){

    private var _todoList = MutableLiveData<List<TodoDataClass>>()
    val todoList :LiveData<List<TodoDataClass>> = _todoList

    fun getAllTodo()  {
        _todoList.value = TodoManager.getAllTodo().reversed()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun deleteTodo(id:Int){

        TodoManager.deleteTodo(id )
        getAllTodo()

    }


}