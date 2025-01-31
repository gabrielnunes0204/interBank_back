InterBank Back

Projeto de Transferência Bancária Backend

🚀 Tecnologias Utilizadas

Java
Spring Boot
H2 Database

📌 Endpoints Disponíveis

🔹 GET /transferencias - Lista todas as transferências
Retorna um array contendo todas os agendamentos de transferências realizadas.

🔹 POST /transferencias - Cria um agendamento de transferência
Recebe um payload no formato JSON e realiza o agendamento da transferência.

Exemplo JSON Request
{
    "id": 1,
    "nomeUsuario": "João da Silva",
    "documentoUsuario": "123.456.789-00",
    "contaOrigem": 1001,
    "contaDestino": 2002,
    "valorTransferencia": 1500.00,
    "valorTaxa": 10.00,
    "dataHoraTransferencia": "2025-02-01T10:00:00",
    "dataHoraAgendamento": "2025-02-01T08:00:00"
}

Exemplo JSON Response
{
    "mensagem": "Transferência agendada com sucesso!",
    "valorTaxado": 10.00,
    "isSucesso": true
}

📌 Como executar o projeto

Clone o repositório:
- git clone https://github.com/seu-repositorio.git

Acesse a pasta do projeto:
- cd interBank_back

Execute a aplicação:
- mvn spring-boot:run

A aplicação estará disponível em: http://localhost:8080 🚀