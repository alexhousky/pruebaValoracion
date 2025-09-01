import { useState, useEffect } from "react";
import axios from "axios";

export default function SelectCiudad({ departamentoId, value, onChange, className }) {
    const [ciudades, setCiudades] = useState([]);

    useEffect(() => {
        if (departamentoId) {
        axios.get(`http://localhost:8080/api/ciudades?departamentoId=${departamentoId}`)
            .then(res => setCiudades(res.data))
            .catch(err => console.error("Error cargando ciudades:", err));
        } else {
        setCiudades([]);
        }
    }, [departamentoId]);

    return (
        <select value={value} onChange={onChange} className={className}>
        <option value="">Seleccione una ciudad</option>
        {ciudades.map(ciudad => (
            <option key={ciudad.id} value={ciudad.id}>
            {ciudad.nombre}
            </option>
        ))}
        </select>
    );
}