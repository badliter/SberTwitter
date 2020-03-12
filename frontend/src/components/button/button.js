import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";

const useStyles = makeStyles((theme) => ({
    root: {
        "& > *": {
            margin: theme.spacing(1),
        },
    },
    button: {
        fontSize: "1.3rem",
    },
}));

const OutlinedButton = ({ content }) => {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <Button
                className={classes.button}
                variant="outlined"
                color="primary"
            >
                {content}
            </Button>
        </div>
    );
};

export default OutlinedButton;
