import React from "react";
import { useState } from "react";

function LoginButton(props){
    return (
        <button onClick={props.onClick}>
            로그인
        </button>
    )
}

function LogoutButton(props){
    return (
        <button onClick={props.onClick}>
            로그아웃
        </button>
    )
}

function LoginControl(props){

    const [isLogin, setIsLogin] = useState(false)

    const handleLoginClick = () => {
        setIsLogin(true)
    }

    const handleLogoutClick = () => {
        setIsLogin(false);
    }


    let button;

    if(isLogin){
        button = <LogoutButton onClick={handleLogoutClick} />
    } else {
        button = <LoginButton onClick={handleLoginClick}/>
    }


    

    return (
        <>
        {button}
        </>
    )

}

export default LoginControl