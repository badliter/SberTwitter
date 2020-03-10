import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";
import NavbarComponent from "./navbar/navbar";
import PrivateRoute from "../routes/private-route";

const App = () => (
    <div className="main">
        <NavbarComponent />
        <Switch>
            <Route path="/login">
                <p />
            </Route>
            <PrivateRoute exact path="/" isAuthenticated>
                <p />
            </PrivateRoute>
            <PrivateRoute exact path="/profile" isAuthenticated>
                <p />
            </PrivateRoute>
            <Route path="*">
                <Redirect to="/" />
            </Route>
        </Switch>
    </div>
);

export default App;
