import React from "react";
import FancyBorder from "./FancyBorder";

function WelcomeMessage(props) {
    return(
        <FancyBorder color="red">
            <h1>안녕하세요</h1>
            <p>사이트에 방문해주셔서 감사합니다</p>
        </FancyBorder>
    )
}

export default WelcomeMessage