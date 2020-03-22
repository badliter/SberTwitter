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
import Box from "@material-ui/core/Box";
import * as moment from "moment";

const Tweet = ({
    authorName, authorSurname, content, date,
}) => (
    <Box mb={3}>
        <Card>
            <CardHeader
                avatar={(
                    <Avatar aria-label="recipe">
                        {authorName[0]}
                    </Avatar>
                )}
                action={(
                    <IconButton aria-label="settings">
                        <MoreVertIcon />
                    </IconButton>
                )}
                titleTypographyProps={{ variant: "subtitle1" }}
                title={`${authorName} ${authorSurname}`}
                subheader={`${moment(date).format("LLL")}`}
            />
            <CardContent>
                <Typography variant="body2" color="textSecondary" component="p">
                    {content}
                </Typography>
            </CardContent>
            <CardActions disableSpacing>
                <IconButton aria-label="add to favorites">
                    <FavoriteIcon fontSize="small" />
                </IconButton>
                <IconButton aria-label="chat bubble">
                    <ChatBubbleIcon fontSize="small" />
                </IconButton>
            </CardActions>
        </Card>
    </Box>
);
export default Tweet;
