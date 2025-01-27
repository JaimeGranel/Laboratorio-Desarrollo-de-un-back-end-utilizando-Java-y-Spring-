import React, {useContext} from 'react';
import { useProducts } from '../../contexts/ProductsContext';
import ProductCard from './ProductCard';
import { SearchContext } from "../../contexts/SearchContext";

function ProductsDisplay() {
    const { searchTerm } = useContext(SearchContext);
    const { products } = useProducts();

    // convierte product en un array para poder utilizar .filter
    const productsArray = Object.values(products);

    // filteredProducts recoge los products que coinciden con el filtro de búsqueda
    const filteredProducts = productsArray.filter(product => {
        // si hay algo escrito en la barra de búsqueda
        if (searchTerm) {
            return product.Name.toLowerCase().includes(searchTerm.toLowerCase());
        }
        else{
            return true
        }
    });
    console.log("filteredproducts: ", filteredProducts);

    return (
        <div className="productdisplay-container">
            <div className="row p-0 m-0">
                {filteredProducts.map((product, index) => (
                    // Para definir la cantidad de tarjetas por fila
                    <div className="col-lg-3 col-md-5 col-sm-7 p-0 m-0" key={index}>
                        <ProductCard
                            key={index}
                            Name={product.Name}
                            Image={product.Image}
                            Price={product.Price}
                            Author={product.Author}
                            Id={product.id}
                        />
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ProductsDisplay;