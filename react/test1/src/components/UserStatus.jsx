import React from "react";

function UserStatus(props){

    return (
        <div>
            현재 사용자는 <br/>
            {props.isLogin ? '로그인 ' : '비 로그인 '} 상태 입니다.
        </div>
    )
}

export default UserStatus;