import React from "react";
import { useState } from "react";

function Reservation(props) {

    const [haveBreakfast, setHavBreakfast] = useState(false)
    const [guestOfNum, setGuestOfNum] = useState(1)
   
    const handleSubmit = (event) => {
        event.preventDefault()
        alert(`조식여부 : ${haveBreakfast}, 방문객 수 : ${guestOfNum} 명`)
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                조식 여부 :
                <input type="checkbox" checked={haveBreakfast} 
                onChange={(event) => {setHavBreakfast(event.target.checked)}}/>
            </label>
            <br></br>
            <label>
                방문객 수 :
                <input type="text" value={guestOfNum}
                onChange={(event) => {setGuestOfNum(event.target.value)}}/>
            </label>
            <button type="submit">제출</button>
        </form>
    )

}

export default Reservation