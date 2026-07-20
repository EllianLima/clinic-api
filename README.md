# Clinic API

API REST para gerenciamento de clínica médica, desenvolvida com Spring Boot e JPA/Hibernate.

## 💡 Sobre o projeto

Desenvolvido como projeto próprio para consolidar os conhecimentos adquiridos no curso Java e Orientação a Objetos da DevSuperior. A aplicação gerencia médicos, pacientes, especialidades e consultas de uma clínica médica.

## 🛠️ Tecnologias

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven

## 📐 Modelo de domínio

- `Doctor` — médico com especialidade
- `Patient` — paciente
- `Specialty` — especialidade médica
- `Appointment` — consulta com status e tipo de pagamento

## 🔗 Relacionamentos

- `Doctor` → `Specialty`: ManyToOne
- `Doctor` → `Appointment`: OneToMany
- `Patient` → `Appointment`: OneToMany

## 📌 Enums

**Status da consulta:**
- `SCHEDULED` — Agendada
- `COMPLETED` — Concluída
- `CANCELLED` — Cancelada

**Tipo de pagamento:**
- `PRIVATE` — Particular
- `INSURANCE` — Plano de saúde

## ▶️ Como rodar

1. Clone o repositório
```bash
git clone https://github.com/EllianLima/clinic-api
```
2. Abra o projeto na sua IDE de preferência
3. Configure o banco de dados no `application.properties`
4. Execute a classe principal
