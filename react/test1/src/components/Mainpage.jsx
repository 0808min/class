import React from "react";
import { useState } from "react";
import ToolBar from "./ToolBar";

function MainPage(props){

    const [isLogin, setIsLogin] = useState(false)

    const onClickLogin = () => {
        setIsLogin(true)
    }

    const onClickLogout = () => {
        setIsLogin(false)
    }

    return (

        <div>
            <ToolBar
                isLogin={isLogin}
                onClickLogin={onClickLogin}
                onClickLogout={onClickLogout}
            />

            <h3>안녕하세요. 메인 인덱스 페이지 입니다.</h3>

        </div>

    )

}

export default MainPage