import React from "react";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import TweetList from "../components/tweet/tweet-list";
import PageHeader from "./page-header";

const Feed = () => (
    <Grid
        container
        direction="row"
        justify="center"
        alignItems="center"
    >
        <PageHeader title="Лента новостей" />
        <Grid item xs={12} md={9} lg={8} xl={7}>
            <Box mr={3} ml={3}>
                <TweetList />
            </Box>
        </Grid>
    </Grid>
);

export default Feed;
