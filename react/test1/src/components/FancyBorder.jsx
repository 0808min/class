import React from "react";

function FancyBorder(props) {

    return (
        <div className={'border-' + props.color}>
            {props.children}
        </div>
    )

}

export default FancyBorder