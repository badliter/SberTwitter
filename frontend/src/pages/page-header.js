import React from "react";
import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";

const PageHeader = ({ title }) => (
    <Grid item xs={12} md={9} lg={8} xl={7}>
        <Box m={3}>
            <Typography variant="h5" noWrap>
                {title}
            </Typography>
        </Box>
    </Grid>
);

export default PageHeader;
