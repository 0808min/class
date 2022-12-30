import React from 'react';
import styled from "styled-components";
import CommentListItem from "./CommentListItem";

const Wrapper = styled.div`
display: flex;
flex-direction: column;
align-items: flex-start
justify-content: center;
margin-bottom: 10px;

& > * {
:not(:last-child) {
margin-bottom: 16px;
}
}
`;

function CommentList({comments}) {
    return (
        <Wrapper>
            {comments.map(comment => {
                return(
                    <CommentListItem key={comment.id} comment={comment}/>
                )
            })}
        </Wrapper>
    );
}

export default CommentList;