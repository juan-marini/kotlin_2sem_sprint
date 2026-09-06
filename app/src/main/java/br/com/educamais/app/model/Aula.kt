package br.com.educamais.app.model

data class Aula(
    val titulo: String,
    val duracaoMinutos: Int,
    val tipo: TipoAula,
    val concluida: Boolean
) {
    val duracaoFormatada: String
        get() = if (duracaoMinutos >= 60) {
            val horas = duracaoMinutos / 60
            val minutosRestantes = duracaoMinutos % 60
            if (minutosRestantes == 0) "${horas}h" else "${horas}h${minutosRestantes}min"
        } else {
            "${duracaoMinutos}min"
        }
}
