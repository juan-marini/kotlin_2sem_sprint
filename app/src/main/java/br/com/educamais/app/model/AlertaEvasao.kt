package br.com.educamais.app.model

data class AlertaEvasao(
    val titulo: String,
    val descricao: String,
    val cursoRelacionado: String,
    val acaoSugerida: String,
    val nivel: RiscoEvasao,
    val probabilidade: Int
)
