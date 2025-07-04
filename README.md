# 📋 Desafio first decision - Sistema de Cadastro de Usuários

Uma aplicação Spring Boot para gerenciamento de usuários. Permite operações CRUD (criar, listar, atualizar e excluir) por meio de uma API REST.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Postgres
- Maven
- Lombok

---

## ⚙️ Funcionalidades

- 📌 Cadastro de novos usuários
- 🔍 Listagem de usuários
- 📝 Atualização de dados
- ❌ Exclusão de registros

---

## 🔧 Como Executar Localmente

### 1. Clone o repositório:

```bash
git clone https://github.com/HelenoNeto/first-decision-angularJava-back.git
cd first-decision-angularJava-back
```

### 2. Compile e execute a aplicação:

#### Com Maven:

```bash
./mvnw spring-boot:run
```

#### Com Docker:

```bash
docker build -t spring-app .
docker run -d -p 8080:80 spring-app
```

### 3. Acesse:

- API: `http://localhost:8080`

---

## 🛠️ Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com.firstDecision.cadUsuario.Usuario
│   │       ├── controller
│   │       ├── model
│   │       ├── dto
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   └── resources
│       ├── application.properties
```

---

## 📚 Exemplos de Requisições

### 🔸 POST `/v1/usuarios`

Cria um novo usuário.

```json
{
  "nome": "Usuário teste",
  "email": "teste@email.com",
  "senha": "123456"
}
```

---

### 🔸 GET `/v1/usuarios`

Lista todos os usuários.

---

### 🔸 PUT `/v1/usuarios/{id}`

Atualiza informações do usuário.

```json
{
  "nome": "Usuário teste Modificado",
  "email": "novo@email.com"
}
```

---

### 🔸 DELETE `/v1/usuarios/{id}`

Remove um usuário específico.

---

## ✅ Requisitos

- Java 17+
- Maven instalado
- IDE de sua preferência (IntelliJ, VS Code, Eclipse)
ou 
Docker (Utilizando Dockerfile)

---

Desenvolvido por Heleno Neto