package br.com.educamais.app.model

import kotlin.math.roundToInt

data class Curso(
    val id: String,
    val titulo: String,
    val categoria: String,
    val instrutor: String,
    val descricao: String,
    val cargaHoraria: Int,
    val progresso: Float,
    val risco: RiscoEvasao,
    val obrigatorio: Boolean,
    val prazo: String,
    val modulos: List<Modulo>
) {
    val percentual: Int
        get() = (progresso * 100).roundToInt()

    val concluido: Boolean
        get() = progresso >= 1f

    val naoIniciado: Boolean
        get() = progresso <= 0f

    val totalAulas: Int
        get() = modulos.sumOf { it.aulas.size }

    val aulasConcluidas: Int
        get() = modulos.sumOf { it.aulasConcluidas }

    val proximaAula: Aula?
        get() = modulos.flatMap { it.aulas }.firstOrNull { !it.concluida }
}
