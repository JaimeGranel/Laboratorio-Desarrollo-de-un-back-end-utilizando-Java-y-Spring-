import { useNavigate } from 'react-router-dom';

function PaidView() {
    const navigate = useNavigate();

    const handleClick = function(){
        navigate('/home');
    }

    return (
        <div className="paid-container">
            <h1>El pago se ha realizado con éxito</h1>
            <button className="btn btn-info" onClick={handleClick}>Cerrar</button>
        </div>
    );
}

export default PaidView;