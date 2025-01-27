import {Routes, Route} from "react-router-dom";
import {CartProvider} from "./contexts/CartContext";
import SearchView from "./views/SearchView";
import ProductDetailView from "./views/ProductDetailView";
import CartView from "./views/CartView";
import LandingView from "./views/LandingView";
import {SearchProvider} from "./contexts/SearchContext";
import {ProductProvider} from "./contexts/ProductsContext";
import PaidView from "./views/PaidView";


function App() {
  return (
      <div className="App">
          <ProductProvider>
              <CartProvider>
                  <SearchProvider>
                      <Routes>
                          <Route path="/" element={<LandingView />} />
                          <Route path="/home" element={<SearchView />} />
                          <Route path="/product/:id" element={<ProductDetailView />} />
                          <Route path="/cart" element={<CartView />} />
                          <Route path="/paid" element={<PaidView />} />
                      </Routes>
                  </SearchProvider>
              </CartProvider>
          </ProductProvider>
      </div>
  );
}

export default App;
