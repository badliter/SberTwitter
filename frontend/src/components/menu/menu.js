import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import AccountCircle from "@material-ui/icons/AccountCircle";
import EmailIcon from "@material-ui/icons/Email";
import Grid from "@material-ui/core/Grid";
import {
    Link,
} from "react-router-dom";

const useStyles = makeStyles(() => ({
    root: {
        flexGrow: 1,
    },
    title: {
        flexGrow: 1,
    },
}));

const Menu = () => {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Grid
                    container
                    direction="row"
                    justify="center"
                    alignItems="center"
                >
                    <Grid item xs={11} md={8} lg={7} xl={6}>
                        <Toolbar>
                            <Typography variant="h6" className={classes.title}>
                                SberTwitter
                            </Typography>
                            <Link to="/" style={{ color: "white" }}>
                                <IconButton color="inherit">
                                    <EmailIcon />
                                </IconButton>
                            </Link>
                            <Link to="/profile" style={{ color: "white" }}>
                                <IconButton color="inherit">
                                    <AccountCircle />
                                </IconButton>
                            </Link>
                            <Button color="inherit">Выйти</Button>
                        </Toolbar>
                    </Grid>
                </Grid>
            </AppBar>
        </div>
    );
};

export default Menu;
