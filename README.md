# Projeto_refatorando_projeto_tqi
Refatorando projeto criado para o processo seletivo da TQI

sudo docker run --name container-teste-api-emprestimo -p 27017:27017 -d mongo


Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades. 
i. Cadastro de clientes O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha. 
ii. Login A autenticação será realizada por e-mail e senha. 
iii. Solicitação de empréstimo: (DTO) Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas. O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual. 
iv. Acompanhamento das solicitações de empréstimo: O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
    (DTO)Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    (DTO)No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.