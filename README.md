# 🛒 Feirinha - Lista de Compras

Aplicação desenvolvida em **Java com Spring Boot** para gerenciar uma lista de compras simples, com operações de **criação, leitura, atualização e exclusão de itens (CRUD)**.  
Os dados são armazenados em um banco de dados **PostgreSQL**.

---

## 🚀 Funcionalidades

- **POST /items** → Cadastra um novo item  
- **GET /items** → Lista todos os itens  
- **GET /items/{id}** → Busca um item pelo ID  
- **PUT /items/{id}** → Atualiza um item existente  
- **DELETE /items/{id}** → Remove um item pelo ID  

---

## ⚙️ Tecnologias utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  

---

## 🧠 Validações

- `name` não pode ser vazio ou repetido  
- `quantity` deve ser maior que 0  
- Retornos HTTP adequados: **400**, **404**, **409**, **201**, **200**, **204**

