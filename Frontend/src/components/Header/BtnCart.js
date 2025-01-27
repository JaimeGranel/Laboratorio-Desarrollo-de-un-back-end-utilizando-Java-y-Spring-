import React from 'react';
import {useNavigate} from "react-router-dom";

function BtnCart() {

    const navigate = useNavigate();
    const handleClick = () => {
        navigate(`/cart`);
    };

    return (
        <button className="btn btn-primary" onClick={handleClick}>
            carrito
        </button>
    );
}

export default BtnCart;