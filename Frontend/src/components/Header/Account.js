import React from 'react';

function Account() {
    return (
        <div className="dropdown">
            <button
                className="btn account-btn btn-primary input-group-text"
                type="button"
                id="dropdownMenuButton"
                data-bs-toggle="dropdown"
                aria-expanded="false"
            >My account</button>
            <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <li className="account-dropdown-item">
                    <button className="account-btn-primary" type="button">Login</button>
                </li>
                <li className="account-dropdown-item">
                    <button className="account-btn-secondary" type="button">Register</button>
                </li>
                <li className="account-dropdown-item">
                    <button className="dropdown-item account-btn-last" type="button">My data</button>
                </li>
                <li className="account-dropdown-item">
                    <button className="dropdown-item account-btn-last" type="button">My orders</button>
                </li>
            </ul>
        </div>
    )
        ;
}

export default Account;