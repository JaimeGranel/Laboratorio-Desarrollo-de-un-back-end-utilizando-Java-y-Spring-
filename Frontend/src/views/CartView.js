import React from "react"
import Header from "../components/Header/Header";
import Footer from "../components/Footer/Footer";
import Cart from "../components/Cart/Cart";

function CartView() {
    return(
        <>
            <Header />
            <div className="container">
                <Cart />
            </div>
            <Footer />
        </>
    );
}

export default CartView;