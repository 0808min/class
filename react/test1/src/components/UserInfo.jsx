import React from "react";
import UserImg from "./UserImg";

function UserInfo(props) {
<<<<<<< HEAD
    return (
        <div className="userInfo">
            <UserImg user={props.user}/>
            <div className="userInfoName">
                {props.userName}
            </div>
        </div>
    )
}

export default UserInfo;
=======
    return(
        <div className="userInfo">
            <UserImg user={props.user}/>
        <div className="userInfoName">
            {props.userName}
        </div>
    </div>
    )
}

export default UserInfo
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
