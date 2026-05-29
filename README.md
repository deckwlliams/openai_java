**# 🤖 OpenAI Java - Análise Inteligente de E-commerce

Projeto desenvolvido em **Java** utilizando a **API da OpenAI** para realizar análises inteligentes em dados de clientes e avaliações de produtos de e-commerce.

O objetivo deste projeto é demonstrar a integração entre aplicações Java e Inteligência Artificial, aplicando conceitos de análise de sentimentos, identificação de perfil de compra e processamento de texto.

---

## 📋 Funcionalidades

### 🔍 Análise de Sentimentos
Analisa avaliações de clientes e identifica se o sentimento é:

- Positivo 😊
- Neutro 😐
- Negativo 😞

### 🛒 Identificação de Perfil de Compra
Utiliza IA para analisar o histórico de compras e identificar padrões de comportamento dos clientes.

Exemplos:

- Cliente Econômico
- Cliente Impulsivo
- Cliente Premium
- Cliente Frequente

### 🧮 Contagem de Tokens
Calcula a quantidade de tokens utilizados em textos enviados para modelos de IA.

### 📂 Leitura de Arquivos
Permite a leitura de arquivos contendo avaliações ou dados de clientes para análise automatizada.

---

## 🛠️ Tecnologias Utilizadas

- Java 26
- Maven
- OpenAI API
- JTokkit
- IntelliJ IDEA

---

## 📁 Estrutura do Projeto

```text
openai_java/
│
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── github/
│                   └── derick/
│                       ├── ecommerce/
│                       │   ├── AnaliseDeSentimentos.java
│                       │   ├── IdentificadorDePerfil.java
│                       │   └── ContadorDeTokens.java
│                       │
│                       └── Main.java
│
├── pom.xml
└── README.md
```

---

## ⚙️ Configuração

### 1. Clonar o Repositório

```bash
git clone https://github.com/deckwlliams/openai_java.git
cd openai_java
```

### 2. Configurar a Chave da API

#### Windows (CMD)

```cmd
set OPENAI_API_KEY=sua_chave_aqui
```

#### Windows (PowerShell)

```powershell
$env:OPENAI_API_KEY="sua_chave_aqui"
```

#### Linux / macOS

```bash
export OPENAI_API_KEY="sua_chave_aqui"
```

### 3. Instalar Dependências

```bash
mvn clean install
```

### 4. Executar o Projeto

```bash
mvn exec:java
```

Ou execute diretamente pelo IntelliJ IDEA.

---

## 💡 Exemplo de Uso

### Entrada

```text
"O produto chegou antes do prazo e superou minhas expectativas."
```

### Saída

```text
Sentimento: POSITIVO
```

---

## 🎯 Objetivo Educacional

Este projeto foi desenvolvido com o propósito de estudar:

- Integração de APIs de Inteligência Artificial
- Processamento de Texto
- Engenharia de Prompt
- Consumo de APIs REST em Java
- Manipulação de Arquivos
- Boas Práticas de Desenvolvimento Java

---

## 🚀 Próximas Melhorias

- [ ] Interface Web com Spring Boot
- [ ] Dashboard de Análises
- [ ] Banco de Dados PostgreSQL
- [ ] Histórico de Análises
- [ ] Upload de Arquivos CSV
- [ ] API REST
- [ ] Docker
- [ ] Deploy na AWS

---

## 👨‍💻 Autor

**Derick Williams**

Estudante de Análise e Desenvolvimento de Sistemas (FIAP), Técnico em Informática e entusiasta de Desenvolvimento Backend, Inteligência Artificial e Análise de Dados.

### Contato

GitHub:
https://github.com/deckwlliams

LinkedIn:
https://www.linkedin.com/in/derick-williams-217154256

---

## ⭐ Contribuição

Sinta-se à vontade para abrir Issues ou Pull Requests com sugestões de melhorias.

---

## 📄 Licença

Este projeto está disponível para fins educacionais e de aprendizado.**
