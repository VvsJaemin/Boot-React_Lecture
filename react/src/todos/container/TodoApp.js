import React from 'react'
import 'todos/style/TodoStyle.css'
import { useSelector } from 'react-redux'
import {AddTodo, Todos, CompletedTodos} from "todos/index"
import {addTodo} from 'todos/reducer/todo.reducer'

const TodoApp =()=>{

    const todos = useSelector(state=>(state.todoReducer))

    return(<div className="container todo">
        <AddTodo addTodo={addTodo}/>
        <Todos todos={todos}/>
        <CompletedTodos/>
    </div>)

}

export default TodoApp
