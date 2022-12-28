import React, { useReducer } from "react";
import UserInfo from "./UserInfo";


function Comment(props){

    return (
        <div className="comment">

            {/* 회원정보 */}
            <UserInfo user={props.user}/>

            {/* <div className="userInfo">
                <img className="userImg"
                    src="{props.user.imgUrl}"
                    alt="{props.user.userName}"
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

}

export default Comment;