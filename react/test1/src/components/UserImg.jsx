import React from "react";

function UserImg(props) {
    return (
        <img className="userImg"
            src={props.user.imgUrl}
            alt={props.user.userName}
            width="200"
        />
    )
}

export default UserImg;