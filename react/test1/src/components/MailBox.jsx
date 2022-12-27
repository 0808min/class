import React from "react";

function MailBox(props) {

    /* 
        {unReadMessage : [{},{},{},{},{},{},{}] } 
    */

    // props.unReadMessage => []

    const unReadMessage = props.unReadMessage;

    return (
        <div>
            <h1> Mail Box </h1>

            { unReadMessage.length > 0 && 
            <h3> 현재 {unReadMessage.length} 개의 읽지 않은 메시지가 있습니다.</h3>}

        </div>
    )
    
}

export default MailBox;