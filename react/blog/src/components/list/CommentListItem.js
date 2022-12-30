import React from 'react';
import styled from "styled-components";

const Wrapper = styled.div`
width: calc(100% - 32px);
padding: 8px 16px;
display: flex;
flex-direction: column;
align-items: flex-start;
border: 1px solid gray;
border-radius: 8px;
cursor: pointer;
background: white;
:hover {background: lightgray;} 
`;

const TitleText = styled.p`
font-size: 16px;
white-space: pre-wrap;
`;

function CommentListItem({comment}) {
    return (
        <Wrapper>
            <TitleText>{comment.content}</TitleText>
        </Wrapper>
    );
}

export default CommentListItem;