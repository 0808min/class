import React, {useEffect, useState} from 'react';
import {getTodo, putTodo} from "../../apis/todoAPI";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import {Button, Checkbox, FormControlLabel, Stack, TextField} from "@mui/material";

function TodoModifyComponent({id,setResult, moveToList, moveToBack}) {

    const [todo, setTodo] = useState({})

    useEffect(() => {
        getTodo().then(result => {
            setTodo(result)
        })
    }, [])

    const changeTodo = (e) => {
        todo[e.target.name] = e.target.value

        setTodo({...todo})
    }

    const changeTodoComplete = (e) => {
        todo['complete'] = e.target.checked
        setTodo({...todo})
    }

    const clickModify = async () => {
        const result = await putTodo(todo)
        setResult('수정되었습니다.')
    }

    return (
        <>
            <Typography variant={'h4'} sx={{p:3}}>Todo Modify Page</Typography>

            <Box sx={{p:1}}>
                <TextField variant="outlined"
                           fullWidth
                           name={'id'}
                           label={'ID'}
                           value={String(todo.id)}
                ></TextField>
            </Box>

            <Box sx={{p:1}}>
                <TextField variant="outlined"
                           fullWidth
                           name={'title'}
                           label={'title'}
                           value={String(todo.title)}
                           onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>

            <Box sx={{p:1}}>
                <TextField variant="outlined"
                           fullWidth
                           name={'writer'}
                           label={'writer'}
                           value={String(todo.writer)}
                           onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>

            <Box sx={{p:1}}>
                <FormControlLabel control={<Checkbox checked={Boolean(todo.complete)}/>}
                                  onChange={(e) => changeTodoComplete(e)}
                                  label='Complete'/>
            </Box>

            <Box sx={{p:1}} display={"flex"} justifyContent={"right"}>
                <Stack spacing={{p:2}} direction="row">
                    <Button variant={"contained"} onClick={() => clickModify()}>수정</Button>
                    <Button variant={"contained"} onClick={() => moveToBack()}>취소(이전)</Button>
                    <Button variant={"contained"} onClick={() => moveToList()}>LIST</Button>
                </Stack>
            </Box>
        </>
    );
}

export default TodoModifyComponent;