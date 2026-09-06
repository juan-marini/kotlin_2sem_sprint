package br.com.educamais.app.mock

import br.com.educamais.app.model.Conquista
import br.com.educamais.app.model.TipoConquista

val conquistas: List<Conquista> = listOf(
    Conquista(
        titulo = "Primeira trilha concluída",
        descricao = "Terminou o primeiro curso obrigatório: Boas Práticas de Fabricação.",
        tipo = TipoConquista.PROGRESSO,
        desbloqueada = true
    ),
    Conquista(
        titulo = "Ofensiva de 10 dias",
        descricao = "Acessou o EducaMais por 10 dias seguidos sem quebrar a sequência.",
        tipo = TipoConquista.OFENSIVA,
        desbloqueada = true
    ),
    Conquista(
        titulo = "Mediador de sala de estudo",
        descricao = "Ajudou colegas como mediador em uma Sala de Estudo.",
        tipo = TipoConquista.COLABORACAO,
        desbloqueada = false
    ),
    Conquista(
        titulo = "Nota máxima em compliance",
        descricao = "Acertou 100% dos quizzes do curso Compliance e Código de Conduta.",
        tipo = TipoConquista.EXCELENCIA,
        desbloqueada = true
    )
)
