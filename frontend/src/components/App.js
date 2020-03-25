import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Menu from "./menu/menu";
import PrivateRoute from "../routes/private-route";
import Feed from "../pages/feed";
import Profile from "../pages/profile";

const useStyles = makeStyles(() => ({
    root: {
        flexGrow: 1,
    },
}));

const App = () => {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <Grid container>
                <Grid item xs={12}>
                    <Menu />
                </Grid>
                <Grid
                    container
                    direction="row"
                    justify="center"
                    alignItems="center"
                >
                    <Grid item xs={11} md={8} lg={7} xl={6}>
                        <Switch>
                            <Route path="/login">
                                <p>Login</p>
                            </Route>
                            <PrivateRoute exact path="/" isAuthenticated>
                                <Feed />
                            </PrivateRoute>
                            <PrivateRoute exact path="/profile" isAuthenticated>
                                <Profile />
                            </PrivateRoute>
                            <Route path="*">
                                <Redirect to="/" />
                            </Route>
                        </Switch>
                    </Grid>
                </Grid>
            </Grid>
        </div>
    );
};

export default App;
