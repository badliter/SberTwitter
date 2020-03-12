import React from "react";
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Paper";
import Subscription from "../components/subscription/subscription";

const Profile = () => (
    <div className="page">
        <div className="page__header">
            <Typography variant="h4">
                Профиль пользователя
            </Typography>
        </div>
        <Paper />
        <Subscription />
    </div>
);


export default Profile;
