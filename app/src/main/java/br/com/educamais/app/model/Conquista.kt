package br.com.educamais.app.model

data class Conquista(
    val titulo: String,
    val descricao: String,
    val tipo: TipoConquista,
    val desbloqueada: Boolean
)
