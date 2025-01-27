import React from 'react';
import { useParams } from "react-router-dom";
import { useProducts } from '../../contexts/ProductsContext';
import BtnAddToChart from "../Shared/BtnAddToChart";

function ProductDetail() {
    const { id } = useParams();
    const { products } = useProducts();

    const product = products[id] || "product not found.";
    console.log("id",id);
    console.log(products);
    return (
        <div className="row product-detail">
            <div className="col-lg-3 col-md-6">
                <img className="productdetail-image" src={product.Image} alt="product image" />
            </div>
            <div className="col-lg-6 col-md-12">
                <h1>{product.Name}</h1>
                <p>{product.Author}</p>
                <p>{product.Price}€</p>
                <p>{product.Description}</p>
                <BtnAddToChart product={product}/>
            </div>
        </div>
    );

}

export default ProductDetail;