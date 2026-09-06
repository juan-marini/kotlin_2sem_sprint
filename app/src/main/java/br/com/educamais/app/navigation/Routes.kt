package br.com.educamais.app.navigation

import android.net.Uri

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val SOBRE = "sobre"

    const val CURSO_DETALHE = "curso/{cursoId}"
    const val SALA_DETALHE = "sala/{salaId}"
    const val EDIA = "edia?curso={curso}"

    const val ARG_CURSO_ID = "cursoId"
    const val ARG_SALA_ID = "salaId"
    const val ARG_CURSO_CONTEXTO = "curso"

    fun cursoDetalhe(cursoId: String) = "curso/$cursoId"

    fun salaDetalhe(salaId: String) = "sala/$salaId"

    fun edia(cursoContexto: String? = null): String =
        if (cursoContexto.isNullOrBlank()) "edia" else "edia?curso=${Uri.encode(cursoContexto)}"
}

// Chave usada pela tela de detalhe da sala para devolver a confirmação de
// presença à lista, via savedStateHandle do back stack entry anterior.
const val RESULTADO_PRESENCA_CONFIRMADA = "presencaConfirmada"
