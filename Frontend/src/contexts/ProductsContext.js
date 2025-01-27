import React, { createContext, useContext, useState } from 'react';

const ProductContext = createContext();

export const ProductProvider = ({ children }) => {
    const [products, setProducts] = useState({
        1: { id: 1,
            Name: "Las 48 leyes del poder",
            Description: "Hay quienes juegan con el poder y lo pierden todo por un error fatídico. Algunos van demasiado lejos, otros se quedan cortos. Entretanto, hay quienes se mueven de manera adecuada y consiguen hacerse con el poder con una destreza sobrehumana. Para los que quieren el poder, vigilan el poder, o quieren armarse contra el poder.\n" +
                "Cómo llegar a lo más alto y quedarse allí...",
            Author: "Robert Greene",
            Image: "https://m.media-amazon.com/images/I/61tHXwnTDiL._AC_UF350,350_QL50_.jpg",
            Price: 10 },
        2: { id: 2,
            Name: "Don Quijote",
            Description: "Don Quijote de la Mancha inauguró una nueva forma de novelar y de representar la realidad humana. De la vieja comicidad, basada en la distrancia y la falta de simpatía con los personajes, Cervantes dio el decisivo paso hacia el humor, que funde lo hilarante con la comprensión y la ternura. Esta edición pone al alcance del lector un texto limpio y rigurosamente fiel a las primeras ediciones, anotado con generosidad para facilitar al lector la cabal comprensión de cada uno de sus pasajes, y precedido de un estudio que analiza con detalle la creación, estructura y sentido de la primera novela moderna.",
            Author: "Cervantes",
            Image: "https://pictures.abebooks.com/isbn/9788471664570-es.jpg",
            Price: 12.90 },
        3: { id: 3,
            Name: "Homo Deus",
            Description: "Yuval Noah Harari, autor deSapiens, un fenómeno internacional unánimemente aclamado por la crítica, regresa con una secuela igualmente original, convincente y provocadora, centrando su atención en el futuro de la humanidad y en nuestra obsesión por convertirnos en dioses.",
            Author: "Yuval Noah Harari",
            Image: "https://traficantes.net/sites/default/files/book_covers//9788466362689.gif",
            Price: 10 },
        4: { id: 4,
            Name: "Sapiens",
            Description: "Bestseller internacional con más de 23 millones de ejemplares vendidos. Traducido a 65 idiomas. Número 1 en la lista de The New York Times. Recomendado por Barack Obama, Bill Gates y Mark Zuckerberg.\n" +
                "\n" +
                "De la mano de uno de los historiadores más interesantes de la actualidad, he aquí la fascinante interpretación de Yuval Noah Harari sobre la historia de la humanidad. Bestseller nacional e internacional, este libro explora las formas en que la biología y la historia nos han definido y han mejorado nuestra comprensión de lo que significa ser \"humano\".",
            Author: "Yuval Noah Harari",
            Image: "https://m.media-amazon.com/images/I/716E6dQ4BXL._AC_UF894,1000_QL80_.jpg",
            Price: 10 },
        5: { id: 5,
            Name: "Hábitos atómicos",
            Description: "A menudo pensamos que para cambiar de vida tenemos que pensar en hacer cambios grandes. Nada más lejos de la realidad. Según el reconocido experto en hábitos James Clear, el cambio real proviene del resultado de cientos de pequeñas decisiones: hacer dos flexiones al día, levantarse cinco minutos antes o hacer una corta llamada telefónica.",
            Author: "James Clear",
            Image: "https://d1fa9n6k2ql7on.cloudfront.net/KFFQT96YQL2J4NM1664836845.jpg",
            Price: 10},
        6: { id: 6,
            Name: "Las meditaciones de Marco Aurelio",
            Description: "La sabiduría eterna de Meditaciones de Marco Aurelio.\n" +
                "Es increíble cómo estas enseñanzas pueden abarcar siglos y más siglos y, sin embargo, seguir siendo de inmensa relevancia para nuestras vidas hoy en día.",
            Author: "Marco Aurelio",
            Image: "https://m.media-amazon.com/images/I/61iMxtIaXqL._AC_UF894,1000_QL80_.jpg",
            Price: 10 },
        7: {id: 7, Name: "La psicología del dinero",
            Description: "asdfgh",
            Author: "Morgan Housel",
            Image: "https://ellector.com.pa/cdn/shop/files/9789584299680.jpg?v=1701266620",
            Price: 10 },
        8: {id: 8, Name: "Can't hurt me",
            Description: "asdfgh",
            Author: "David Goggins",
            Image: "https://cdn.achology.com/wp-content/uploads/20230724180241/Cant-Hurt-Me_-Master-Your-Mind-and-Defy-the-Odds_-by-David-Goggins.png",
            Price: 10 },
        9: {id: 9, Name: "21 lecciones para el siglo 21",
            Description: "asdfgh",
            Author: "Yuval Noah Harari",
            Image: "https://m.media-amazon.com/images/I/61YbVoSdhnL._AC_UF1000,1000_QL80_.jpg",
            Price: 10 },
    });

    return (
        <ProductContext.Provider value={{ products, setProducts }}>
            {children}
        </ProductContext.Provider>
    );
};

export const useProducts = () => {
    return useContext(ProductContext);
};