import React from 'react';
import SearchBar from './SearchBar';
import BtnCart from './BtnCart';
import Account from './Account';
import BtnMainPage from "./BtnMainPage";

function NavBar() {
    return (
        <nav className="navbar">
            <div className="container">
                <BtnMainPage />
                <SearchBar />
                <Account />
                <BtnCart />
            </div>
        </nav>
    );
}

export default NavBar;