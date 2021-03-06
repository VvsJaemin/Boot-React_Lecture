import {
  combineReducers,
  configureStore,
  getDefaultMiddleware,
} from "@reduxjs/toolkit";
import logger from "redux-logger";
import counterSlice from 'counter/reducer/counter.slice'
import todos from 'todos/reducer/todo.reducer'
import users from 'users/reducer/user.reducer'

const rootReducer = combineReducers({counterSlice, todos, users})
export default configureStore({
  reducer : rootReducer,
  middleware: [...getDefaultMiddleware(), logger]
});