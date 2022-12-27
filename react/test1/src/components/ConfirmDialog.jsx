import React from "react";

<<<<<<< HEAD
function Button(props){
=======
function Button(props) {
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
    return (
        <button className={`bg-${props.color}`}>
            <b>
                {props.children}
            </b>
        </button>
    )
}

<<<<<<< HEAD
function ConfirmDialog(props) {
    return (
        <div>
            <p>내용을 확인하셨다면 확인 버튼을 눌러주세요.</p>
            <Button color="Green">확인</Button>
=======

function ConfirmDialog(props) {
    return (
        <div>
            <p>내용을 확인하셨다면 확인 버튼을 눌러주세요</p>
            <button color="Green">확인</button>
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
        </div>
    )
}

<<<<<<< HEAD
export default ConfirmDialog;
=======
export default ConfirmDialog
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
