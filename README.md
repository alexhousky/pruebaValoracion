# 🧾 Prueba de Valoración - Registro de Clientes GCO

Este proyecto es una aplicación web desarrollada como prueba técnica para el registro de clientes en el sistema de fidelización de GCO. Combina un frontend moderno en React con un backend robusto en Spring Boot, permitiendo una experiencia fluida y dinámica para el usuario.

---

## 🚀 Tecnologías utilizadas

### Frontend
- ⚛️ React + Vite
- 🎨 Tailwind CSS
- 🎞️ Framer Motion
- 📡 Axios

### Backend
- ☕ Spring Boot
- 🗃️ JPA / Hibernate
- 🧪 Maven

---

## 📦 Instalación

### 🔧 Requisitos previos
- Node.js y npm
- Java 17+
- Maven

### 🖥️ Frontend

bash
--cd front-react/front-prueba
--npm install
--npm run dev

###🧰 Backend
--cd back-spring/back-prueba
--./mvnw spring-boot:run

###🧩 Funcionalidades
Registro de cliente con campos dinámicos

--Selects dependientes: país → departamento → ciudad

--Validación visual y animaciones suaves

--Integración directa con endpoints REST

--Diseño elegante y responsivo

###📡 Endpoints principales

-- GET    /api/tipo-identificacion
-- GET    /api/paises
-- GET    /api/departamentos?paisId={id}
-- GET    /api/ciudades?departamentoId={id}
-- GET    /api/marcas
-- POST   /api/clientes

###📸 Vista previa


<img width="460" height="857" alt="img1" src="https://github.com/user-attachments/assets/16f0341a-bc6c-49b3-a05b-04f37d892b1b" />

<img width="454" height="847" alt="img2" src="https://github.com/user-attachments/assets/5ffe980c-d5c5-4ec3-be5b-e12d3e9f9e17" />
<img width="443" height="861" alt="img3" src="https://github.com/user-attachments/assets/279b65d3-6b56-40a2-88de-59e5de1d30d7" />

<img width="486" height="919" alt="img4" src="https://github.com/user-attachments/assets/c2c63ed4-66d3-4b9d-9eab-67dea4a4ad9e" />
