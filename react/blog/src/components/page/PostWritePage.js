import React, {useState} from 'react';
import styled from "styled-components";
import {useNavigate} from "react-router-dom";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";
import PageLayout from "./PageLayout";


function PostWritePage(props) {

    const navigate = useNavigate();

    const [title, setTitle] = useState();
    const [content, setContent] = useState();

    return (

        <PageLayout>
            <TextInput
                height={20}
                value={title}
                onChange={(event) => setTitle(event.target.value)}
            />
            <TextInput
                height={400}
                value={content}
                onChange={(event) => setContent(event.target.value)}
            />
            <Button title={'글 작성'} onClick={() => navigate("/")}/>
        </PageLayout>



    );
}

export default PostWritePage;