package br.com.educamais.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.educamais.app.ui.screens.TelaDetalheCurso
import br.com.educamais.app.ui.screens.TelaDetalheSala
import br.com.educamais.app.ui.screens.TelaEdia
import br.com.educamais.app.ui.screens.TelaHome
import br.com.educamais.app.ui.screens.TelaLogin
import br.com.educamais.app.ui.screens.TelaSobre

@Composable
fun EducaMaisNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            TelaLogin(
                aoEntrar = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                },
                aoAbrirSobre = { navController.navigate(Routes.SOBRE) }
            )
        }

        composable(Routes.HOME) {
            TelaHome(navController = navController)
        }

        composable(
            route = Routes.CURSO_DETALHE,
            arguments = listOf(navArgument(Routes.ARG_CURSO_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            val cursoId = backStackEntry.arguments?.getString(Routes.ARG_CURSO_ID)
            TelaDetalheCurso(
                cursoId = cursoId,
                aoVoltar = { navController.popBackStack() },
                aoPerguntarNaEdia = { tituloCurso ->
                    navController.navigate(Routes.edia(tituloCurso))
                }
            )
        }

        composable(
            route = Routes.SALA_DETALHE,
            arguments = listOf(navArgument(Routes.ARG_SALA_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            val salaId = backStackEntry.arguments?.getString(Routes.ARG_SALA_ID)
            TelaDetalheSala(
                salaId = salaId,
                aoVoltar = { navController.popBackStack() },
                aoConfirmarPresenca = { idConfirmado ->
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set(RESULTADO_PRESENCA_CONFIRMADA, idConfirmado)
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.EDIA,
            arguments = listOf(
                navArgument(Routes.ARG_CURSO_CONTEXTO) {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val cursoContexto = backStackEntry.arguments?.getString(Routes.ARG_CURSO_CONTEXTO)
            TelaEdia(cursoContexto = cursoContexto, aoVoltar = { navController.popBackStack() })
        }

        composable(Routes.SOBRE) {
            TelaSobre(aoVoltar = { navController.popBackStack() })
        }
    }
}
