import React from "react";
import Typography from "@material-ui/core/Typography";
import TweetList from "../components/tweet/tweet-list";

const Feed = () => (
    <div className="page">
        <div className="page__header">
            <Typography variant="h4" noWrap>
                Лента новостей
            </Typography>
        </div>
        <div className="tweet__grid">
            <TweetList />
        </div>
    </div>
);

export default Feed;
