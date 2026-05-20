import { useEffect, useState } from "react";
import './App.css';
function App() {
  const [products, setProducts] = useState([]);

  const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

  useEffect(() => {
    fetch(`${API_BASE_URL}/api/products`)
        .then(res => res.json())
        .then(data => setProducts(data));
  }, []);

  return (
      <div className="product-grid">
          {products.map(p => (
              <div className="product-card" key={p.id}>
                  <img src={p.imageUrl} alt={p.name} className="product-image" />
                  <h3>{p.name}</h3>
                  <p className="price">£{p.price}</p>
                  <p>{p.description}</p>
              </div>
          ))}
      </div>

  );
}

export default App;
