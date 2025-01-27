import React from 'react';
import Header from "../components/Header/Header";
import Footer from "../components/Footer/Footer";
import ProductCard from "../components/ProductsDisplay/ProductsDisplay";
import SearchFilters from "../components/SearchFilters/SearchFilters";

function SearchView() {
    return (
        <>
            <Header/>
            <div className="searchView-container">
                <div className="row">
                    <div className="col-lg-3 col-md-5 col-sm-12">
                        <SearchFilters />
                    </div>
                    <div className="col-lg-9 col-md-7 col-sm-12">
                        <ProductCard />
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    );
}

export default SearchView;