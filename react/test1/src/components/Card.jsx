import React from "react";

function Card({title, backgroundColor, children}) {
    // const {title, backgroundColor, children} = props
    return (
        <div style={{
            margin:10,
            padding:10,
            borderRadius:5,
            boxShadow: "0px 0px 5px gray",
            backgroundColor: backgroundColor || "white"
        }}>
            {title && <h1>{title}</h1>}
            {children}

        </div>
    )
}

export default Card