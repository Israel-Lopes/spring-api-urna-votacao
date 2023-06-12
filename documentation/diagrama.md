---
title: API de Votação
---

classDiagram
class AssociadoEntity {
- id: Long
- cpf: String
}
class FormularioDeVotoEntity {
- id: Long
- votos: List<Boolean>
- idAssociadosQueVotaram: List<Long>
}
class PautaEntity {
- id: Long
- titulo: String
- descricao: String
}
class SessaoEntity {
- id: Long
- tempoDaVotacao: LocalTime
- votacaoEmAndamento: Boolean
- inicioDaContagem: LocalDateTime
- fimDaContagem: LocalDateTime
- formulario: FormularioDeVotoEntity
- pauta: PautaEntity
}
class ValidaCPFClient {
<<Interface>>
+ getValidaCPF(cpf: String): String
}
class ValidaCPF {
- status: String
}

AssociadoEntity "1" --> "*" FormularioDeVotoEntity
FormularioDeVotoEntity "1" --> "1" PautaEntity
SessaoEntity "1" --> "1" FormularioDeVotoEntity
SessaoEntity "1" --> "1" PautaEntity
ValidaCPFClient --> ValidaCPF