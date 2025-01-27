import React from "react";
import Header from "../components/Header/Header";
import Footer from "../components/Footer/Footer";
import ProductDetail from "../components/ProductDetail/ProductDetail";

function ProductDetailView() {
    return(
        <>
            <Header />
            <div className="container">
                <ProductDetail/>
            </div>
            <Footer />
        </>
    )
}

export default ProductDetailView;