import React from "react";
import ReactDOM from "react-dom";
import { HashRouter } from "react-router-dom";
import "./scss/index.scss";
import App from "./components/App";
// import makeServer from "./api/server";
//
// if (process.env.NODE_ENV === "development") {
//     makeServer();
// }

ReactDOM.render(
    <HashRouter>
        <App />
    </HashRouter>,
    document.getElementById("root"),
);
