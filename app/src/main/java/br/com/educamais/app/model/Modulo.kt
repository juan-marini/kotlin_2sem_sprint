package br.com.educamais.app.model

data class Modulo(
    val titulo: String,
    val aulas: List<Aula>
) {
    val aulasConcluidas: Int
        get() = aulas.count { it.concluida }

    val progresso: Float
        get() = if (aulas.isEmpty()) 0f else aulasConcluidas / aulas.size.toFloat()

    val concluido: Boolean
        get() = aulas.isNotEmpty() && aulas.all { it.concluida }

    val duracaoMinutos: Int
        get() = aulas.sumOf { it.duracaoMinutos }
}
