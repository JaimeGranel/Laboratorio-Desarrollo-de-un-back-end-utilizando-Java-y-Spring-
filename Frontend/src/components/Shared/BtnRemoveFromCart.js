import React from "react";
import { useCart } from "../../contexts/CartContext"

function BtnRemoveFromCart({ product }) {

    const { removeFromCart } = useCart();

    return(
        <button onClick={() => removeFromCart(product)} className="btn btn-addtochart">
            Remove from cart
        </button>
    )
}

export default BtnRemoveFromCart;