package br.com.educamais.app.model

data class MensagemEdia(
    val texto: String,
    val autor: AutorMensagem,
    val fonte: String? = null
)
