package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import br.com.educamais.app.navigation.RESULTADO_PRESENCA_CONFIRMADA
import br.com.educamais.app.navigation.Routes

private enum class AbaHome(val titulo: String, val emoji: String) {
    INICIO("Início", "🏠"),
    CURSOS("Cursos", "📚"),
    SALAS("Salas de Estudo", "💬"),
    PERFIL("Perfil", "👤")
}

// Casca da Home: NavigationBar de 4 abas, top bar própria com título por
// aba e ação de info, e FAB estendido da EdIA. Início e Cursos já têm o
// layout final (Fase 7); Salas e Perfil ainda são provisórios (Fases 8 e 9).
@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(abaSelecionada.titulo) },
                actions = {
                    IconButton(onClick = { navController.navigate(Routes.SOBRE) }) {
                        Text("ℹ")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = { navController.navigate(Routes.edia()) }) {
                Text("✦ EdIA")
            }
        },
        bottomBar = {
            NavigationBar {
                AbaHome.entries.forEach { aba ->
                    NavigationBarItem(
                        selected = abaSelecionada == aba,
                        onClick = { abaSelecionada = aba },
                        icon = { Text(aba.emoji) },
                        label = { Text(aba.titulo) }
                    )
                }
            }
        }
    ) { paddingInterno ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
        ) {
            when (abaSelecionada) {
                AbaHome.INICIO -> AbaInicio(
                    aoAbrirCurso = { id -> navController.navigate(Routes.cursoDetalhe(id)) },
                    aoAbrirSala = { id -> navController.navigate(Routes.salaDetalhe(id)) }
                )

                AbaHome.CURSOS -> AbaCursos(
                    aoAbrirCurso = { id -> navController.navigate(Routes.cursoDetalhe(id)) }
                )

                AbaHome.SALAS -> AbaSalas(
                    aoAbrirSala = { id -> navController.navigate(Routes.salaDetalhe(id)) }
                )

                AbaHome.PERFIL -> Column(modifier = Modifier.padding(16.dp)) {
                    Text("Perfil (Fase 9 monta a tela final)")
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
