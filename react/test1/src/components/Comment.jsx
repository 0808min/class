<<<<<<< HEAD
import React, { useReducer } from "react";
import UserInfo from "./UserInfo";


function Comment(props){

    return (
=======
import React from "react";
import UserInfo from "./UserInfo";

function Comment(props) {

    return(
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
        <div className="comment">

            {/* 회원정보 */}
            <UserInfo user={props.user}/>
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
>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
}

export default Comment;