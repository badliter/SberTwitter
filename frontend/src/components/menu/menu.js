import React from "react";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import AccountCircle from "@material-ui/icons/AccountCircle";
import MailIcon from "@material-ui/icons/Mail";
import { Link } from "react-router-dom";

const Menu = () => (
    <div className="menu">
        <div className="wrapper menu__wrapper">
            <div className="menu__logo">
                <Link to="/" style={{ color: "inherit", textDecoration: "inherit" }}>
                    <Typography variant="h4" noWrap>
                        SberTwitter
                    </Typography>
                </Link>
            </div>
            <div className="menu__tabs">
                <Link to="/" style={{ color: "inherit", textDecoration: "inherit" }}>
                    <IconButton color="inherit">
                        <MailIcon style={{ fontSize: 25 }} />
                    </IconButton>
                </Link>
                <Link to="/profile" style={{ color: "inherit", textDecoration: "inherit" }}>
                    <IconButton
                        color="inherit"
                    >
                        <AccountCircle style={{ fontSize: 25 }} />
                    </IconButton>
                </Link>
            </div>
            <div className="menu__button">
                <Button variant="outlined">
                    Выйти
                </Button>
            </div>
        </div>
    </div>
);

export default Menu;
