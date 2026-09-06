package br.com.educamais.app.mock

import br.com.educamais.app.model.SalaEstudo

val salasEstudo: List<SalaEstudo> = listOf(
    SalaEstudo(
        id = "sala-bpf",
        titulo = "Tira-dúvidas: BPF na rotina do chão de fábrica",
        cursoRelacionado = "Boas Práticas de Fabricação (BPF)",
        mediador = "Fernanda Ristow",
        horario = "Hoje, 19h00",
        descricao = "Sessão prática para tirar dúvidas sobre contaminação cruzada e " +
            "registros de lote antes da avaliação do módulo.",
        participantes = 18,
        capacidade = 20,
        aoVivo = true
    ),
    SalaEstudo(
        id = "sala-farmaco",
        titulo = "Como notificar um evento adverso passo a passo",
        cursoRelacionado = "Farmacovigilância na Prática",
        mediador = "Dr. Ricardo Bonfim",
        horario = "Amanhã, 18h00",
        descricao = "Mediador experiente mostra o fluxo completo de notificação no " +
            "sistema VigiMed com casos reais anonimizados.",
        participantes = 12,
        capacidade = 25,
        aoVivo = false
    ),
    SalaEstudo(
        id = "sala-lgpd",
        titulo = "LGPD na prática: dúvidas do dia a dia",
        cursoRelacionado = "LGPD Aplicada à Indústria Farmacêutica",
        mediador = "Camila Nogueira",
        horario = "Quinta, 19h30",
        descricao = "Discussão de casos comuns de tratamento de dados sensíveis de " +
            "pacientes e colaboradores.",
        participantes = 25,
        capacidade = 25,
        aoVivo = false
    ),
    SalaEstudo(
        id = "sala-validacao",
        titulo = "Protocolos de validação: perguntas frequentes",
        cursoRelacionado = "Validação de Processos Produtivos",
        mediador = "Eng. Marina Kobayashi",
        horario = "Sexta, 17h00",
        descricao = "Aprofundamento em qualificação de equipamentos (IQ/OQ/PQ) com " +
            "exemplos de protocolos reais.",
        participantes = 9,
        capacidade = 20,
        aoVivo = false
    ),
    SalaEstudo(
        id = "sala-excel",
        titulo = "Dashboards no Excel para indicadores de qualidade",
        cursoRelacionado = "Excel Avançado para Análise de Dados",
        mediador = "Tiago Almeida",
        horario = "Segunda, 12h30",
        descricao = "Oficina prática de montagem de dashboards de indicadores usando " +
            "tabelas dinâmicas.",
        participantes = 14,
        capacidade = 30,
        aoVivo = false
    )
)

fun buscarSalaPorId(id: String): SalaEstudo? = salasEstudo.firstOrNull { it.id == id }

fun salasDeHoje(): List<SalaEstudo> = salasEstudo.filter { it.horario.startsWith("Hoje") }
