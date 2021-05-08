import axios from 'axios'

const findAll=()=>{
    return axios.get("http://localhost:8080/users/findAll")
}

const signUp=(user)=>{
    
    return axios.post("http://localhost:8080/users/signup", user)
}

export default {findAll,signUp}
