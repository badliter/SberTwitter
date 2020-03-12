import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";
import Menu from "./menu/menu";
import PrivateRoute from "../routes/private-route";
import TweetList from "./tweet/tweet-list";

const App = () => (
    <div className="container">
        <Menu />
        <div className="wrapper">
            <Switch>
                <Route path="/login">
                    <p>Login</p>
                </Route>
                <PrivateRoute exact path="/" isAuthenticated>
                    <div className="page page__feed">
                        <div className="tweet__grid">
                            <TweetList />
                        </div>
                    </div>
                </PrivateRoute>
                <PrivateRoute exact path="/profile" isAuthenticated>
                    <p>Profile</p>
                </PrivateRoute>
                <Route path="*">
                    <Redirect to="/" />
                </Route>
            </Switch>
        </div>
    </div>
);

export default App;
