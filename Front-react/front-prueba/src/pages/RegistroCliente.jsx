import React, { useState } from 'react';
import { motion } from 'framer-motion';
import SelectTipoIdentificacion from '../components/SelectTipoIdentificacion';
import SelectPais from '../components/SelectPais';
import SelectDepartamento from '../components/SelectDepartamento';
import SelectCiudad from '../components/SelectCiudad';
import SelectMarca from '../components/SelectMarca';
import { registrarCliente } from '../services/api';

export default function RegistroCliente() {
  const [form, setForm] = useState({
    tipoIdentificacionId: '',
    numeroIdentificacion: '',
    nombres: '',
    apellidos: '',
    fechaNacimiento: '',
    direccion: '',
    paisId: '',
    departamentoId: '',
    ciudadId: '',
    marcaId: ''
  });

  const handleChange = (field, value) => {
    setForm(prev => ({ ...prev, [field]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await registrarCliente(form);
      alert('✅ Cliente registrado exitosamente');
      setForm({
        tipoIdentificacionId: '',
        numeroIdentificacion: '',
        nombres: '',
        apellidos: '',
        fechaNacimiento: '',
        direccion: '',
        paisId: '',
        departamentoId: '',
        ciudadId: '',
        marcaId: ''
      });
    } catch (error) {
      console.error(error);
      alert('❌ Error al registrar cliente');
    }
  };

  return (
    <div className="container">
      <motion.form
        className="form"
        onSubmit={handleSubmit}
        initial={{ opacity: 0, y: 20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.4 }}
      >
        <p className="title">Formulario de Fidelización GCO</p>

        <SelectTipoIdentificacion
          value={form.tipoIdentificacionId}
          onChange={(e) => handleChange('tipoIdentificacionId', e.target.value)}
          className="input"
        />

        <input
          placeholder="Número de Identificación"
          className="input"
          type="text"
          value={form.numeroIdentificacion}
          onChange={(e) => handleChange('numeroIdentificacion', e.target.value)}
        />

        <input
          placeholder="Nombres"
          className="input"
          type="text"
          value={form.nombres}
          onChange={(e) => handleChange('nombres', e.target.value)}
        />

        <input
          placeholder="Apellidos"
          className="input"
          type="text"
          value={form.apellidos}
          onChange={(e) => handleChange('apellidos', e.target.value)}
        />

        <input
          className="input"
          type="date"
          value={form.fechaNacimiento}
          onChange={(e) => handleChange('fechaNacimiento', e.target.value)}
        />

        <input
          placeholder="Dirección"
          className="input"
          type="text"
          value={form.direccion}
          onChange={(e) => handleChange('direccion', e.target.value)}
        />

        <SelectPais
          value={form.paisId}
          onChange={(e) => handleChange('paisId', e.target.value)}
          className="input"
        />

        <SelectDepartamento
          paisId={form.paisId}
          value={form.departamentoId}
          onChange={(e) => handleChange('departamentoId', e.target.value)}
          className="input"
        />

        <SelectCiudad
          departamentoId={form.departamentoId}
          value={form.ciudadId}
          onChange={(e) => handleChange('ciudadId', e.target.value)}
          className="input"
        />

        <SelectMarca
          value={form.marcaId}
          onChange={(e) => handleChange('marcaId', e.target.value)}
          className="input"
        />

        <button className="btn" type="submit">Registrar</button>
      </motion.form>
    </div>
  );
}
