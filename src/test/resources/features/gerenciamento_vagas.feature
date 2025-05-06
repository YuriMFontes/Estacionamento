Feature: Sistema de estacionamento

Scenario: Reservar uma vaga com sucesso
  Given o sistema está funcionando corretamente
  When o usuário tenta reservar uma vaga disponível
  Then a vaga será reservada com sucesso e o status será "reservada"

Scenario: Tentar reservar uma vaga já ocupada
  Given o sistema tem uma vaga ocupada
  When o usuário tenta reservar a vaga ocupada
  Then o sistema deve retornar uma mensagem de erro "Vaga já ocupada"

Scenario: Tentar reservar uma vaga quando o sistema está offline
  Given o sistema está offline
  When o usuário tenta reservar uma vaga
  Then o sistema deve retornar uma mensagem de erro "Sistema fora do ar"

