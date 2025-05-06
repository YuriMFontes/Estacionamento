Feature: Teste de API de vagas

  Scenario: Criar uma nova vaga com sucesso
    Given a API de vagas está disponível
    When eu envio uma requisição POST para "/vagas" com os dados válidos
    Then o status code da resposta deve ser 201
    And o corpo da resposta deve conter o campo "numero"
