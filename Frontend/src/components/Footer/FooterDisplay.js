import React from 'react';

function FooterDisplay({ title, buttons }) {
    return (
        <div className="d-flex flex-column mb-5">
            <p className="footerdisplay-text fw-bold fs-6">
                {title}
            </p>
            {buttons.map((button, index) => (
                <button
                    key={index}
                    type="button"
                    className="footerdisplay-button btn mb-2"
                >
                    {button}
                </button>
            ))}
        </div>
    );
}

export default FooterDisplay;