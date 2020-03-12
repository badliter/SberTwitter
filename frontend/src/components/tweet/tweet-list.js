import React, { useState, useEffect } from "react";
import { v4 as uuidv4 } from "uuid";
import Tweet from "./tweet";

const TweetList = () => {
    const [tweetList, setTweetList] = useState([]);

    useEffect(() => {
        fetch(`${process.env.API_URL}/getAllTwitts`)
            .then((response) => response.json())
            .then((json) => setTweetList(json.tweets));
    }, []);

    return (
        <React.Fragment>
            {tweetList.map((tweet) => (
                <Tweet
                    key={uuidv4()}
                    tweet={tweet}
                />
            ))}
        </React.Fragment>
    );
};

export default TweetList;
