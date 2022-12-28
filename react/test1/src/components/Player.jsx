import React from "react";

function Player(props){

    const name = props.playerName
    const number = props.playerNumber

    return (
        <ul>
            <li>선수 이름 : {name} </li>
            <li>선수 번호 : {number} </li>
        </ul>
    )

}

export default Player;