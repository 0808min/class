import React from "react";


function UserGreeting(props){
    return (
        <h1> 다시 오셨군요 !</h1>
    )
}

function GuestGreeting(props){
    return <h1> 회원가입을 해주세요!</h1>;
}

function Greeting(props){

    const isLogin = props.isLogin
    
    /* if(isLogin){
        return <UserGreeting/>
    }

    return <GuestGreeting/> */

    return (
        <div>
            { isLogin ? <UserGreeting/> : <GuestGreeting/>}
        </div>
    )

}

export default Greeting
