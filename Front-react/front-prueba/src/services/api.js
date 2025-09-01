import axios from 'axios';

const API_BASE = 'http://localhost:8080/api';

export const getTiposIdentificacion = () =>
    axios.get(`${API_BASE}/tipos-identificacion`);

// Países
export const getPaises = async () => {
    const response = await axios.get(`${API_BASE}/paises`);
    return response.data;
};

// Departamentos por país
export const getDepartamentos = async (paisId) => {
    const response = await axios.get(`${API_BASE}/departamentos?paisId=${paisId}`);
    return response.data;
};

// Ciudades por departamento
export const getCiudades = async (departamentoId) => {
    const response = await axios.get(`${API_BASE}/ciudades?departamentoId=${departamentoId}`);
    return response.data;
};

// Marcas
export const getMarcas = async () => {
    const response = await axios.get(`${API_BASE}/marca`);
    return response.data;
};

// Registro de cliente
export const registrarCliente = async (clienteData) => {
    const response = await axios.post(`${API_BASE}/clientes`, clienteData);
    return response.data;
};





