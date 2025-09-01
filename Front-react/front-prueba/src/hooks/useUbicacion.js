import { useState, useEffect } from 'react';
import { getPaises, getDepartamentosPorPais, getCiudadesPorDepartamento } from '../assets/services/api';

export function useUbicacion() {
    const [paises, setPaises] = useState([]);
    const [departamentos, setDepartamentos] = useState([]);
    const [ciudades, setCiudades] = useState([]);

    const [paisSeleccionado, setPaisSeleccionado] = useState(null);
    const [departamentoSeleccionado, setDepartamentoSeleccionado] = useState(null);

    useEffect(() => {
    getPaises().then(res => setPaises(res.data));
    }, []);

    useEffect(() => {
        if (paisSeleccionado) {
            getDepartamentosPorPais(paisSeleccionado).then(res => setDepartamentos(res.data));
        }
    }, [paisSeleccionado]);

    useEffect(() => {
        if (departamentoSeleccionado) {
        getCiudadesPorDepartamento(departamentoSeleccionado).then(res => setCiudades(res.data));
        }
    }, [departamentoSeleccionado]);

    return {
        paises,
        departamentos,
        ciudades,
        setPaisSeleccionado,
        setDepartamentoSeleccionado,
    };
}
