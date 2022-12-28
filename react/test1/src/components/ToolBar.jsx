import React from "react";

function ToolBar(props){

    const { isLogin, onClickLogin, onClickLogout } = props;

    return (
        <div style={{padding:10, borderBottom: '1px solid gray'}}>

            {isLogin && <h3>환영합니다.</h3>}

            {isLogin ? 
                <button onClick={onClickLogout}> 로그아웃 </button>
                :
                <button onClick={onClickLogin}> 로그인 </button>}

        </div>
    )


}

export default ToolBar