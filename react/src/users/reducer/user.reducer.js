import axios from 'axios'
import {createAsyncThunk, createSlice} from '@reduxjs/toolkit'
import {UserService} from 'users/index'


export const getUserList = createAsync("users/findAll",
async()=>{
    const response = await UserService.findAll()
    return response.data
})

export const getUserSignUp = createAsyncThunk(
    "users/signup",
    async (user) =>{
        const response = await UserService.signUp(user)
        return response.data
    })

const isRejectAction=action=>
     (action.type.endsWith('rejected'))


const userSlice = createSlice({
    name : 'users',
    initialState : [],
    reducers:{},
    extraReducers : (builder)=>{
        builder
        .addCase(getUserList.fulfilled, (state, {payload})=>{
            return [...payload]
        })
        .addCase(getUserSignUp.fulfilled,(state, {payload})=>{
            return[...payload]
        })
        .addMatcher(isRejectAction, ()=>{})
        .addDefaultCase((state, payload)=>{})
    },
})             



const {reducer}= userSlice
export default reducer

