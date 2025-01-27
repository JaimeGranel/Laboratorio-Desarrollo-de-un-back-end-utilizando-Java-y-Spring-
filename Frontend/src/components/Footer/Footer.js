import React from 'react';
import FooterDisplay from './FooterDisplay';

function Footer() {

    const buttons1 = ['Quienes somos', 'Trabaja con nosotros', 'Nuestras librerías'];
    const buttons2 = ['Pago seguro', 'Devoluciones', 'Gastos y formas de envío', 'Estado de tu pedido', 'Incidencias de pedidos'];
    const buttons3 = ['Vende con nosotros', 'Libros al por mayor', 'Afiliados'];
    const buttons4 = ['Condiciones de uso', 'Condiciones para vender', 'Política de protección de datos', 'Política de cookies', 'Configurar cookies'];

    return (
        <footer className="footer">
            <div className="footer-container container">
                <div className="row">
                    <div className="col-lg-3">
                        <FooterDisplay title={"Relatos de papel"} buttons={buttons1} />
                    </div>
                    <div className="col-lg-3">
                        <FooterDisplay title={"Ayuda"} buttons={buttons2} />
                    </div>
                    <div className="col-lg-3">
                        <FooterDisplay title={"Servicios"} buttons={buttons3} />
                    </div>
                    <div className="col-lg-3">
                        <FooterDisplay title={"Información legal"} buttons={buttons4} />
                    </div>
                </div>
            </div>
        </footer>
    );
}

export default Footer;