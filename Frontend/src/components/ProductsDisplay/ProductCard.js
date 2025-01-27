import React from 'react';
import { useNavigate } from "react-router-dom";



function ProductCard({Id, Name, Image, Price, Author}) {

    const navigate = useNavigate();
    const handleClick = () => {
        navigate(`/product/${Id}`);
    };

    return (
        <div className="productcard-container" onClick={ handleClick }>
                <div className="productcard-image-container">
                    <img className="productcard-image" src={Image} alt={"product image"}/>
                </div>
                <h5 className="productcard-name mb-0">{Name}</h5>
                <p className="productcard-author">{Author}</p>
                <p>{Price}€</p>
        </div>
    );
}

export default ProductCard;