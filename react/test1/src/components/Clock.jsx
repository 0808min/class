import React from "react";

function Clock(props) {
    return (
        <div>
            <h1>Clock</h1>
            <h3>현재 시간 : {new Date().toLocaleTimeString()}</h3>
        </div>
    )
}

export default Clock;