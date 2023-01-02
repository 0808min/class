import React, {useState} from 'react';
import {Dashboard} from "@mui/icons-material";
import List from "@mui/material/List";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import {useNavigate} from "react-router-dom";



function MenuComponent(props) {

    const menuArr = [
        {icon:<Dashboard/>, text:"Home", path:"/"},
        {icon:<Dashboard/>, text:"About", path: "/about"},
        {icon:<Dashboard/>, text:"Todo", path: "/todo"},
        {icon:<Dashboard/>, text:"회원가입"}
    ]

    const navigate = useNavigate();
    const movePage = (path) => {
        console.log("movePage: " + path)
        if (path) {
            navigate(path);
        }
    }

        return (
        <List>
            {menuArr.map((menu, index) => {

                return (
                <ListItemButton key={index}>
                    <ListItemIcon>{menu.icon}</ListItemIcon>
                    <ListItemText primary={menu.text} onClick={()=> movePage(menu.path)}/>
                </ListItemButton>
                )
            })}
        </List>
    );
}

export default MenuComponent;