import React from "react";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import Avatar from "@material-ui/core/Avatar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import FavoriteIcon from "@material-ui/icons/Favorite";
import ChatBubbleIcon from "@material-ui/icons/ChatBubble";
import useStyles from "./tweet-style";


const Tweet = (props) => {
// const {
//     tweet_id,
//     user_id,
//     content,
//     timestamp,
// } = props.tweet;

    const classes = useStyles();

    return (
        <Card className={classes.root}>
            <CardHeader
                className={classes.header}
                avatar={(
                    <Avatar aria-label="recipe">
                        R
                    </Avatar>
                )}
                action={(
                    <IconButton aria-label="settings">
                        <MoreVertIcon />
                    </IconButton>
                )}
                titleTypographyProps={{ variant: "h5" }}
                title="Shrimp and Chorizo Paella"
                subheaderTypographyProps={{ variant: "13px" }}
                subheader="September 14, 2016"
            />
            <CardContent>
                <Typography variant="body2" color="textSecondary" component="p" className={classes.typography}>
                    This impressive paella is a perfect party dish and a fun meal to cook together with your
                    guests. Add 1 cup of frozen peas along with the mussels, if you like.
                </Typography>
            </CardContent>
            <CardActions disableSpacing>
                <IconButton aria-label="add to favorites">
                    <FavoriteIcon style={{ fontSize: 20 }} />
                </IconButton>
                <IconButton aria-label="chat bubble">
                    <ChatBubbleIcon style={{ fontSize: 20 }} />
                </IconButton>
            </CardActions>
        </Card>
    );
};

export default Tweet;
