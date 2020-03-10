import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import Button from "../button/button";

const NavbarComponent = () => (
    <Navbar bg="light" expand="lg" className="navbar">
        <Link to="/">
            <Navbar.Brand
                className="navbar__logo"
            >
                SberTwitter
            </Navbar.Brand>
        </Link>
        <Navbar.Collapse>
            <Nav className="mr-auto navbar__nav">
                <Nav.Link>
                    <Link to="/">
                        Feed
                    </Link>
                </Nav.Link>
                <Nav.Link>
                    <Link to="/profile">
                        Profile
                    </Link>
                </Nav.Link>
            </Nav>
        </Navbar.Collapse>
        <Button>Logout</Button>
    </Navbar>
);

export default NavbarComponent;
