package br.com.educamais.app.model

data class SalaEstudo(
    val id: String,
    val titulo: String,
    val cursoRelacionado: String,
    val mediador: String,
    val horario: String,
    val descricao: String,
    val participantes: Int,
    val capacidade: Int,
    val aoVivo: Boolean
) {
    val lotada: Boolean
        get() = participantes >= capacidade

    val vagasRestantes: Int
        get() = (capacidade - participantes).coerceAtLeast(0)

    val ocupacao: Float
        get() = if (capacidade <= 0) 0f else (participantes / capacidade.toFloat()).coerceIn(0f, 1f)
}
