import React, { useState, useEffect } from "react";
import { v4 as uuidv4 } from "uuid";
import Tweet from "./tweet";

const TweetList = () => {
    const [tweetList, setTweetList] = useState([]);
    const ownerId = "1";

    useEffect(() => {
        fetch(`${process.env.API_URL}/getAllTwitts/${ownerId}`)
            .then((response) => response.json())
            .then((json) => setTweetList(json.tweets));
    }, []);

    return (
        <>
            {tweetList.map((tweet) => (
                <Tweet
                    key={uuidv4()}
                    authorName={tweet.authorName}
                    authorSurname={tweet.authorSurname}
                    content={tweet.content}
                    date={tweet.date}
                />
            ))}
        </>
    );
};

export default TweetList;
