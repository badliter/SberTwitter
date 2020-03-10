import React from "react";
import { Route, Redirect } from "react-router-dom";

const PrivateRoute = ({ children, isAuthenticated, ...rest }) => (
    <Route
        {...rest}
        render={({ location }) => (isAuthenticated ? (
            children
        ) : (
            <Redirect
                to={{
                    pathname: "/login",
                    state: { from: location },
                }}
            />
        ))}
    />
);

export default PrivateRoute;
