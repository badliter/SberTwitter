import React from "react";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import Subscription from "../components/subscription/subscription";
import PageHeader from "./page-header";

const Profile = () => (
    <Grid
        container
        direction="row"
        justify="center"
        alignItems="center"
    >
        <PageHeader title="Профиль" />
        <Grid item xs={12} md={9} lg={8} xl={7}>
            <Box mr={3} ml={3}>
                <Subscription />
            </Box>
        </Grid>
    </Grid>
);


export default Profile;
