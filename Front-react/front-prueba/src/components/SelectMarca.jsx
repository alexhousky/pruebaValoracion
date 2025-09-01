import { useEffect, useState } from "react";
import axios from "axios";

export default function SelectMarca({ value, onChange, className }) {
    const [marcas, setMarcas] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/api/marcas")
        .then(res => setMarcas(res.data))
        .catch(err => console.error("Error cargando marcas:", err));
    }, []);

    return (
        <select value={value} onChange={onChange} className={className}>
        <option value="">Seleccione una marca</option>
        {marcas.map(marca => (
            <option key={marca.id} value={marca.id}>
            {marca.nombre}
            </option>
        ))}
        </select>
    );
}

