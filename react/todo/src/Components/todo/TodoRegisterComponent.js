import React, {useState} from 'react';
import Typography from "@mui/material/Typography";
import {Button, TextField} from "@mui/material";
import Box from "@mui/material/Box";
import {postTodo} from "../../apis/todoAPI";

function TodoRegisterComponent({setResult}) {

    const [todo, setTodo] = useState({title:'', writer:'', complete:false})

    const changeTodo = (e) => {

        const attr = e.target.name
        const value = e.target.value

        todo[attr] = value;

        setTodo({...todo})
    }

    const clickRegister = async () => {
        const result = await postTodo(todo)
        console.log(result)

        setResult(result)

    }

    return (
        <>
            <Typography variant={'h4'} sx={{p:3}}>Todo Register Page</Typography>

            <Box sx={{p:1}}>
                <TextField variant="outlined"
                   fullWidth
                   name={'title'}
                   label={'title'}
                   onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>

            <Box sx={{p:1}}>
                <TextField variant="outlined"
                   fullWidth
                   name={'writer'}
                   label={'writer'}
                           onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>

            <Box sx={{p:1}} display={"flex"} justifyContent={"right"}>
                <Button variant={"contained"} onClick={clickRegister}>등록</Button>
            </Box>
        </>
    );
}

export default TodoRegisterComponent;