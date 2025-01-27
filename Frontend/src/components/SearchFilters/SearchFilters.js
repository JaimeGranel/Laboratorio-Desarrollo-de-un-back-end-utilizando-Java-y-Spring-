import React, {useState} from "react"

function SearchFilters() {

    const [minValue, setMinValue] = useState(0);
    const [maxValue, setMaxValue] = useState(100);

    const handleMinChange = (e) => {
        const value = Math.min(Number(e.target.value), maxValue - 1);
        setMinValue(value);
    };

    const handleMaxChange = (e) => {
        const value = Math.max(Number(e.target.value), minValue + 1);
        setMaxValue(value);
    };

    return (
        <div className="searchfilters-container">
            <div className="searchfilters-keywords">
                <p className="searchfilters-title mb-2">Filtros</p>
                <div className="searchfilters-filter-buttons">
                    <button className="searchfilters-filter-button btn">Adultos</button>
                    <button className="searchfilters-filter-button btn">Juvenil</button>
                    <button className="searchfilters-filter-button btn">Infantil</button>
                </div>
            </div>
            <div className="searchfilters-price">
                <p className="searchfilters-title mb-3 mt-4">Precio</p>
                <input
                    type="range"
                    className="searchfilters-slider"
                    value={minValue}
                    onChange={handleMinChange}
                    min="0"
                    max="100"
                />
                <input
                    type="range"
                    className="searchfilters-slider"
                    value={maxValue}
                    onChange={handleMaxChange}
                    min="0"
                    max="100"
                />
                <div className="slider-track">
                    <div className="slider-range"
                        style={{
                            left: `${(minValue / 100) * 100}%`,
                            width: `${((maxValue - minValue) / 100) * 100}%`,
                        }}
                    ></div>
                </div>
            </div>
            <div className="price-values">
                <span>Min: {minValue}€</span>
                <span>Max: {maxValue}€</span>
            </div>
        </div>
    );
}

export default SearchFilters;