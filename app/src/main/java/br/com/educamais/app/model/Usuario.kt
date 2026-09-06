package br.com.educamais.app.model

data class Usuario(
    val nome: String,
    val cargo: String,
    val area: String,
    val matricula: String,
    val nivel: Int,
    val xp: Int,
    val xpProximoNivel: Int,
    val ofensivaDias: Int,
    val cursosConcluidos: Int,
    val horasEstudo: Int
) {
    val primeiroNome: String
        get() = nome.trim().substringBefore(" ")

    val iniciais: String
        get() = nome.trim()
            .split(" ")
            .filter { it.isNotBlank() }
            .take(2)
            .joinToString("") { it.first().uppercase() }
}
