import { useEffect, useState } from "react";
import axios from "axios";

export default function SelectTipoIdentificacion({ value, onChange, className }) {
  const [tipos, setTipos] = useState([]);

  useEffect(() => {
      axios.get("http://localhost:8080/api/tipos-identificacion")
      .then(res => setTipos(res.data))
      .catch(err => console.error("Error cargando tipos de identificación:", err));
  }, []);

  return (
    <select value={value} onChange={onChange} className={className}>
      <option value="">Seleccione tipo de identificación</option>
      {tipos.map(tipo => (
        <option key={tipo.id} value={tipo.id}>
          {tipo.nombre}
        </option>
      ))}
    </select>
  );
}

