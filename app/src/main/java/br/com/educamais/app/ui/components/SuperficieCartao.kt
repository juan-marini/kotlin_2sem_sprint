package br.com.educamais.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Estilo base de cartão do EducaMais: cantos de 16dp e borda fina de 1dp
// em vez de sombra pesada. Todos os cartões reutilizáveis usam esta base.
@Composable
fun SuperficieCartao(
    modifier: Modifier = Modifier,
    aoClicar: (() -> Unit)? = null,
    conteudoPadding: PaddingValues = PaddingValues(16.dp),
    conteudo: @Composable () -> Unit
) {
    val cores = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    val borda = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    if (aoClicar != null) {
        Card(
            onClick = aoClicar,
            modifier = modifier,
            shape = MaterialTheme.shapes.large,
            colors = cores,
            border = borda
        ) {
            Box(Modifier.padding(conteudoPadding)) { conteudo() }
        }
    } else {
        Card(
            modifier = modifier,
            shape = MaterialTheme.shapes.large,
            colors = cores,
            border = borda
        ) {
            Box(Modifier.padding(conteudoPadding)) { conteudo() }
        }
    }
}
