import React from "react";
import TweetList from "./tweet/tweet-list";

const App = () => (
    <div className="app">
        <div className="app__wrapper">
            <h1 className="app__header">SberTwitter</h1>
            <TweetList />
        </div>
    </div>
);

export default App;
