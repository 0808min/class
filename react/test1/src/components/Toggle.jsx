import React from "react";
import { useState } from "react";

function Toggle(props){

    const [isToggleOn, setIsToggleOn] = useState(true)

    function handleClick1(){
        setIsToggleOn(isToggleOn => !isToggleOn)
    }

    const handleClick2 = () => {
        setIsToggleOn(isToggleOn => !isToggleOn)
    }

    return (
        <button onClick={handleClick2}>
            {isToggleOn ? '켜짐' : '꺼짐'}
        </button>
    )

}

export default Toggle;