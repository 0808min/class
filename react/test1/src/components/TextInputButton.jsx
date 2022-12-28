import React from "react";
import { useRef } from "react";

function TextInputButton(props){

    const inputEl = useRef(null);

    const onButtonClick = () => {
        // current 는 연결되어 있는 객체 input을 가리킨다!
        inputEl.current.focus();
        inputEl.current.value='new Message'
    }

    return (
        <div>
            <input ref={inputEl} type="text" />
            <button onClick={onButtonClick}>클릭!</button>
        </div>
    )

}

export default TextInputButton;