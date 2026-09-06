package br.com.educamais.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import br.com.educamais.app.ui.theme.EducaMaisTokens

// Gradiente da marca: reservado para o login, o cabeçalho do Sobre e o
// bloco do Modo áudio — em nenhum outro lugar da interface.
@Composable
fun brushGradienteMarca(): Brush {
    val cores = EducaMaisTokens.cores
    return Brush.linearGradient(listOf(cores.navy, cores.azulEletrico, cores.ciano))
}

@Composable
fun BlocoComGradienteMarca(
    modifier: Modifier = Modifier,
    conteudo: @Composable () -> Unit
) {
    Box(modifier = modifier.background(brushGradienteMarca())) {
        conteudo()
    }
}
