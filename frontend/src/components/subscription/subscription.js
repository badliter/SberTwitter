import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        padding: theme.spacing(2),
        textAlign: "center",
        color: theme.palette.text.secondary,
    },
}));

const Subscription = () => {
    const classes = useStyles();

    return (
        <div>
            <Paper>
                <Grid className={classes.root}>
                    <Box p={7}>
                        <Grid container>
                            <Box mb={2}>
                                <Typography variant="h5">
                                    Подписаться на пользователя
                                </Typography>
                            </Box>
                            <Grid
                                item
                                xs={12}
                            >
                                <Box mb={2}>
                                    <TextField
                                        id="outlined-basic"
                                        label="ID пользователя"
                                        variant="outlined"
                                        size="medium"
                                        required
                                        fullWidth
                                    />
                                </Box>
                            </Grid>
                            <Grid
                                container
                                xs={12}
                                direction="row"
                                justify="flex-end"
                                alignItems="flex-start"
                            >
                                <Button
                                    variant="outlined"
                                    color="primary"
                                    size="large"
                                >
                                    Подписаться
                                </Button>
                            </Grid>
                        </Grid>
                    </Box>
                </Grid>
            </Paper>
        </div>
    );
};

export default Subscription;
