package br.com.educamais.app.mock

import br.com.educamais.app.model.AlertaEvasao
import br.com.educamais.app.model.RiscoEvasao

val alertasEvasao: List<AlertaEvasao> = listOf(
    AlertaEvasao(
        titulo = "Risco de abandono em Segurança do Trabalho",
        descricao = "Você não acessa o curso há 9 dias e o prazo termina em poucos dias. " +
            "Colaboradores com esse padrão de acesso têm alta chance de não concluir o " +
            "treinamento obrigatório.",
        cursoRelacionado = "Segurança do Trabalho em Ambiente Fabril",
        acaoSugerida = "Entrar na sala de estudo de hoje às 19h00 para tirar dúvidas com " +
            "a mediadora antes de retomar o curso.",
        nivel = RiscoEvasao.ALTO,
        probabilidade = 78
    ),
    AlertaEvasao(
        titulo = "Ritmo abaixo do esperado em Validação de Processos",
        descricao = "Seu ritmo de estudo caiu nas últimas duas semanas em comparação com " +
            "colegas da mesma área que já concluíram o módulo de fundamentos.",
        cursoRelacionado = "Validação de Processos Produtivos",
        acaoSugerida = "Reservar 20 minutos hoje para concluir a aula 'Estudo de caso: " +
            "validação de processo de envase'.",
        nivel = RiscoEvasao.MEDIO,
        probabilidade = 42
    )
)
