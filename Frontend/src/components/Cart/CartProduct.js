import React from "react"
import BtnRemoveFromCart from "../Shared/BtnRemoveFromCart";

function CartProduct({Id, Description, Name, Image, Price, Author, Quantity, product}) {

    return (
        <div className="cartproduct-container row">
            <div className="col-lg-3 col-md-6">
                <img className="cartproduct-image" src={Image} alt="product image"/>
            </div>
            <div className="col-lg-9 col-md-12">
                <div className="row">
                    <div className="col-lg-10">
                        <h3 className="mt-2">{Name}</h3>
                        <p>{Author}</p>
                        <p>Cantidad: {Quantity}</p>
                        <BtnRemoveFromCart product={product}/>
                    </div>
                    <div className="col-lg-2">
                        <p className="productdetail-price text-end">{Price}€</p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CartProduct;