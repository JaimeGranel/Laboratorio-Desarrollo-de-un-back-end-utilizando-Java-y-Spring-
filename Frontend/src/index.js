import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import './index.css';
import './styles/main.css'
import './styles/Header/BtnCartStyle.css'
import './styles/Header/NavBarStyle.css'
import './styles/Header/SearchBarStyle.css'
import './styles/Header/AccountStyle.css'
import './styles/Footer/FooterDisplayStyle.css';
import './styles/Footer/Footer.css';
import './styles/ProductDisplay/ProductCardStyle.css';
import './styles/Views/SearchViewStyle.css';
import './styles/SearchFilters/SearchFiltersStyle.css';
import './styles/ProductDetail/ProductDeatailStyle.css'
import './styles/Cart/CartProductStyle.css'
import './styles/Cart/CartStyle.css'
import reportWebVitals from './reportWebVitals';
import App from './App';
import {BrowserRouter} from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <BrowserRouter>
          <App />
      </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
