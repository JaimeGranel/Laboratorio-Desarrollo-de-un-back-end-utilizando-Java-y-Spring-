import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function LandingView() {
    const navigate = useNavigate();

    useEffect(() => {
        const timeout = setTimeout(() => {
            navigate('/home');
        }, 5000);

        return () => clearTimeout(timeout);
    }, [navigate]);

    return (
        <div className="landing-container m-5">
            <h1>Bienvenido a Nuestra Página</h1>
            <p className="">Serás redirigido automáticamente en 5 segundos...</p>
        </div>
    );
}

export default LandingView;