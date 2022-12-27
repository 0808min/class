import React from "react";

function Button(props){
    return (
        <button className={`bg-${props.color}`}>
            <b>
                {props.children}
            </b>
        </button>
    )
}

function ConfirmDialog(props) {
    return (
        <div>
            <p>내용을 확인하셨다면 확인 버튼을 눌러주세요.</p>
            <Button color="Green">확인</Button>
        </div>
    )
}

export default ConfirmDialog;