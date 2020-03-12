import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";
import Menu from "./menu/menu";
import PrivateRoute from "../routes/private-route";
import Feed from "../pages/feed";
import Profile from "../pages/profile";

const App = () => (
    <div className="container">
        <Menu />
        <div className="wrapper">
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
        </div>
    </div>
);

export default App;
