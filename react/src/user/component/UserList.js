import React, {useEffect, useState, useCallback} from 'react'
import axios from 'axios'

const UserList = () => {

    const [users, setUsers] = useState([])

    useEffect(()=>{
        axios.get('/data/users.json')
        .then(res =>{
            setUsers(res.data)
        })
        .catch(err =>{
            console.log(err.message)
        })
    }, [])

    return (
        <>    <h1>사용자 목록</h1>
         <table>
            <tr>
                <td>No</td>
                <td>아이디</td>
                <td>이름</td>
                <td>이메일</td>
                <td>회원여부</td>
            </tr>
   
            {
                users.map((user, userId) => {
                    return (
                        <tr key={userId}>
                            <td>{userId+1}</td>
                            <td>{user.username}</td>
                            <td>{user.email}</td>
                            <td>{user.name}</td>
                            <td>{user.roles}</td>
                        </tr>
                    )
                })
            }
    </table><br/>
</>
    )
}

export default UserList