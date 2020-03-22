import React, { useState } from "react";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";

const Subscription = () => {
    const ownerId = "1";
    const [userId, setUserId] = useState("");

    const handleUserId = (event) => {
        setUserId(event.target.value);
    };

    const submit = () => {
        fetch(`${process.env.API_URL}/addsubscription`, {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                ownerid: ownerId,
                userid: userId,
            }),
        })
            .then((response) => response.json())
            .then((json) => {
                setUserId("");
                console.log(json);
            });
    };

    return (
        <Paper>
            <Box p={3}>
                <Box mb={2}>
                    <Typography variant="h6">
                        Подписаться на пользователя
                    </Typography>
                </Box>
                <Grid item xs={12}>
                    <Box mb={3}>
                        <TextField
                            id="outlined-basic"
                            label="ID пользователя"
                            variant="outlined"
                            required
                            fullWidth
                            onChange={handleUserId}
                        />
                    </Box>
                </Grid>
                <Grid
                    container
                    direction="row"
                    justify="flex-end"
                    alignItems="flex-start"
                >
                    <Button
                        variant="outlined"
                        color="primary"
                        onClick={submit}
                    >
                        Подписаться
                    </Button>
                </Grid>
            </Box>
        </Paper>
    );
};

export default Subscription;
