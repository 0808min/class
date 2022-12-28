import React from "react";
import { useState } from "react";

function SignUp(props) {


    const [name, setName] = useState('')
    const [gender, setGender] = useState('')

 
    const handleChange = (event) => {
        setGender(event.target.value)
    }


    return(
        <form onSubmit={(event) => {
            event.preventDefault()
            
        }}>
            <label>
                이름 :
                <input type="text" value={name} onChange={handleChange}/>
            </label>
            <br></br>
            <label>
                성별 :
                <select value={gender} onChange={handleChange}>
                <option value="남자">남자</option>
                <option value="여자">여자</option>
                </select>
            </label>
            <br></br>
            <button type="submit">제출</button>
        </form>

    )

}

export default SignUp