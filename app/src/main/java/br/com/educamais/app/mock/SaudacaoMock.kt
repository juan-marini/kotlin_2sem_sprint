package br.com.educamais.app.mock

import java.util.Calendar

fun saudacaoPorHorario(
    hora: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
): String = when (hora) {
    in 5..11 -> "Bom dia"
    in 12..17 -> "Boa tarde"
    else -> "Boa noite"
}
