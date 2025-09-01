import { useEffect, useState } from "react";
import { getPaises } from "../services/api";

export default function SelectPais({ value, onChange, className }) {
    const [paises, setPaises] = useState([]);

    useEffect(() => {
        const cargarDatos = async () => {
        try {
            const data = await getPaises();
            setPaises(data);
        } catch (error) {
            console.error("Error al cargar países:", error);
        }
        };

        cargarDatos();
    }, []);

    return (
        <select value={value} onChange={onChange} className={className}>
        <option value="">Seleccione un país</option>
        {paises.map(pais => (
            <option key={pais.id} value={pais.id}>
            {pais.nombre}
            </option>
        ))}
        </select>
    );
}


