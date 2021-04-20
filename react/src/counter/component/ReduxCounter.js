import React from 'react'

const ReduxCounter=()=>{

    return (   
    <> < h1 > 카운터</h1> 
        <div>
         <div>
            <button aria-label="+" onClick={() => {}>
                +
            </button>
            <span>{count}</span>
            <button aria-label="-" onClick={() => {setCount(count-1)}}>
                -
            </button>
        </div>
      </div>

</>)
    
}

export default ReduxCounter