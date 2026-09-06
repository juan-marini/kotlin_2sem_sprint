package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.educamais.app.mock.cursos
import br.com.educamais.app.mock.salasEstudo
import br.com.educamais.app.navigation.RESULTADO_PRESENCA_CONFIRMADA
import br.com.educamais.app.navigation.Routes

private enum class AbaHome { INICIO, CURSOS, SALAS, PERFIL }

// Versão provisória: a Fase 6 substitui a Row de abas por uma
// NavigationBar de verdade e a Fase 7/8 dão o layout final a cada aba.
// Já demonstra: navegação com passagem de parâmetro (curso/sala), argumento
// opcional (EdIA) e recebimento do retorno de dados da tela de sala.
@Composable
fun TelaHome(navController: NavHostController) {
    var abaSelecionada by rememberSaveable { mutableStateOf(AbaHome.INICIO) }
    val snackbarHostState = remember { SnackbarHostState() }

    val handleAtual = navController.currentBackStackEntry?.savedStateHandle
    val presencaConfirmada by handleAtual
        ?.getStateFlow<String?>(RESULTADO_PRESENCA_CONFIRMADA, null)
        ?.collectAsState() ?: remember { mutableStateOf(null) }

    LaunchedEffect(presencaConfirmada) {
        if (presencaConfirmada != null) {
            snackbarHostState.showSnackbar("Presença confirmada na sala $presencaConfirmada")
            handleAtual?.set(RESULTADO_PRESENCA_CONFIRMADA, null)
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(16.dp)
        ) {
            Text("Home do EducaMais (Fase 6 monta a NavigationBar final)")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AbaHome.entries.forEach { aba ->
                    TextButton(onClick = { abaSelecionada = aba }) { Text(aba.name) }
                }
            }
            when (abaSelecionada) {
                AbaHome.INICIO -> Column {
                    Text("Início")
                    Button(onClick = { navController.navigate(Routes.edia()) }) {
                        Text("Falar com a EdIA")
                    }
                }

                AbaHome.CURSOS -> Column {
                    cursos.forEach { curso ->
                        TextButton(
                            onClick = { navController.navigate(Routes.cursoDetalhe(curso.id)) }
                        ) { Text(curso.titulo) }
                    }
                }

                AbaHome.SALAS -> Column {
                    salasEstudo.forEach { sala ->
                        TextButton(
                            onClick = { navController.navigate(Routes.salaDetalhe(sala.id)) }
                        ) { Text(sala.titulo) }
                    }
                }

                AbaHome.PERFIL -> Column {
                    Text("Perfil")
                    TextButton(onClick = { navController.navigate(Routes.SOBRE) }) {
                        Text("Sobre")
                    }
                    TextButton(
                        onClick = {
                            navController.navigate(Routes.LOGIN) {
                                popUpTo(Routes.HOME) { inclusive = true }
                            }
                        }
                    ) { Text("Sair") }
                }
            }
        }
    }
}
