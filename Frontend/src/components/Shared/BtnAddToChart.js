import React from "react";
import { useCart } from "../../contexts/CartContext"

function BtnAddToChart({ product}) {

    const { addToCart } = useCart();

    return(
        <button onClick={() => addToCart(product)} className="btn btn-addtochart">
            Add to cart
        </button>
    )
}

export default BtnAddToChart;