import { useState, useEffect } from "react";
import axios from "axios";

export default function SelectDepartamento({ paisId, value, onChange, className }) {
    const [departamentos, setDepartamentos] = useState([]);

    useEffect(() => {
        if (paisId) {
        axios.get(`http://localhost:8080/api/departamentos?paisId=${paisId}`)
            .then(res => setDepartamentos(res.data))
            .catch(err => console.error("Error cargando departamentos", err));
        } else {
        setDepartamentos([]);
        }
    }, [paisId]);

    return (
        <select value={value} onChange={onChange} className={className}>
        <option value="">Seleccione un departamento</option>
        {departamentos.map(dep => (
            <option key={dep.id} value={dep.id}>{dep.nombre}</option>
        ))}
        </select>
    );
}


