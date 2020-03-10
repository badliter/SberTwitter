import React from "react";
import { Button as BootstrapButton } from "react-bootstrap";

const Button = ({ variant, className, children }) => {
    const style = ["button"];
    style.push(className);

    return (
        <BootstrapButton variant={variant} className={style.join(" ")}>
            { children }
        </BootstrapButton>
    );
};

export default Button;
