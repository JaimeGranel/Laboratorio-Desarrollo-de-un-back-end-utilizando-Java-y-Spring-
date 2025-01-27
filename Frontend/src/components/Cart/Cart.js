import React from "react";
import {useCart} from "../../contexts/CartContext";
import CartProduct from "./CartProduct";
import {useNavigate} from "react-router-dom";

function Cart() {

    const { cart } = useCart();
    const { cleanCart } = useCart();

    const navigate = useNavigate();
    const handleClick = () => {
        cleanCart();
        navigate("/paid");
    };

    if (cart.length === 0) {
        return <div className="empty-cart">El carrito está vacío.</div>;
    }

    const totalAmmount = cart.reduce((sum, product) => sum + Number(product.Price)*product.quantity, 0);

    const totalProducts = cart.reduce((sum, product) => sum + product.quantity, 0);

    return(
        <div className="row">
            <div className="col-lg-9 col-sm-6">
                <div className="cart-header mt-4">
                    <div className="row cart-row2">
                        <h2>Cesta</h2>
                    </div>
                    <div className="row cart-row2">
                        <p className="text-end cart-header-pricetext">Precio</p>
                    </div>
                </div>
                {cart.map((product, index) => (
                    <CartProduct
                        product={product}
                        key={index}
                        Name={product.Name}
                        Image={product.Image}
                        Price={product.Price}
                        Author={product.Author}
                        Description={product.Description}
                        Quantity={product.quantity}
                        Id={product.Id}
                    />
                ))}
                <div className="cart mb-5">
                    <p className="cart-totalprice text-end">precio total: {totalAmmount}€</p>
                </div>
            </div>
            <div className="col-lg-3 col-sm-6">
                <div className="cart-data">
                    <p>Productos en el carrito: {totalProducts}</p>
                    <p>Precio total: {totalAmmount}€</p>
                    <button className="btn" onClick={handleClick}>Pagar</button>
                </div>
            </div>
        </div>
    );

}

export default Cart;