import React from 'react';
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import Typography from "@mui/material/Typography";
import Toolbar from "@mui/material/Toolbar";

function CustomToolbar({title, handleDrawerOpen}) {
    return (
        <Toolbar>
            <IconButton
                size="large"
                color="inherit"
                aria-label="menu"
                onClick={handleDrawerOpen}
                edge="start"
                sx={{ mr: 2 }}
            >
                <MenuIcon />
            </IconButton>
            <Typography variant="h6" noWrap component="div">
                {title}
            </Typography>
        </Toolbar>
    );
}

export default CustomToolbar;