<<<<<<< HEAD
import React, { useReducer } from "react";
=======
<<<<<<< HEAD
import React, { useReducer } from "react";
import UserInfo from "./UserInfo";


function Comment(props){

    return (
=======
import React from "react";
>>>>>>> 1e9fd25b94552fca487cbbcf1a87c66d88c60563
import UserInfo from "./UserInfo";


<<<<<<< HEAD
function Comment(props){

    return (
=======
    return(
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
>>>>>>> 1e9fd25b94552fca487cbbcf1a87c66d88c60563
        <div className="comment">

            {/* 회원정보 */}
            <UserInfo user={props.user}/>
<<<<<<< HEAD

            {/* <div className="userInfo">
                <img className="userImg"
                    src="{props.user.imgUrl}"
                    alt="{props.user.userName}"
=======
<<<<<<< HEAD

            {/* <div className="userInfo">
                <img className="userImg"
                    src="{props.user.imgUrl}"
                    alt="{props.user.userName}"
=======
            {/* <div className="userInfo">
                <img className="userImg"
                src="{props.user.imgUrl}"
                alt="{props.user.userName}"
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
>>>>>>> 1e9fd25b94552fca487cbbcf1a87c66d88c60563
                />
                <div className="userInfoName">
                    {props.user.userName}
                </div>
            </div> */}

            {/* 댓글 내용 */}
            <div className="content">
                {props.content}
            </div>

            {/* 댓글 작성 시간 */}
            <div className="regdate">
                {props.replydate}
            </div>

        </div>
    )
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
>>>>>>> 1e9fd25b94552fca487cbbcf1a87c66d88c60563
}

export default Comment;