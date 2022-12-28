import React from "react";
import { useContext } from "react";
import ThemeContext from "./components/ThemeContext";

function MainContent(props) {
    
    // const color = props.color
    const {theme, toggleTheme} = useContext(ThemeContext)

    // 테마에 따라 배경을 흰색 또는 검정색
    return(
        <div style={{
            width: "100vw",
            height: "100vh",
            padding: "1.5rem",
            backgroundColor: theme == 'light' ? "white" : "black",
            color: theme == 'light' ? "black" : "white"
            }}>
            <p>안녕하세요 테마변경이 가능한 웹 사이트입니다.</p>
            <button onClick={toggleTheme}>테마 변경</button>
        </div>
    )
}

export default MainContent