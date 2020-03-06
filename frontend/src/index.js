import React from "react";
import ReactDOM from "react-dom";
import "./scss/index.scss";
import App from "./components/App";
import makeServer from "./api/server";

if (process.env.NODE_ENV === "development") {
    makeServer();
}

ReactDOM.render(<App />, document.getElementById("root"));
