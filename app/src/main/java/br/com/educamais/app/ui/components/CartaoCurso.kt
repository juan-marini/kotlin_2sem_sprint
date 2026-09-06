package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.educamais.app.model.Curso

// Usado tanto na LazyRow "Continue de onde parou" (compacto = true)
// quanto na listagem completa da aba Cursos (compacto = false).
@Composable
fun CartaoCurso(
    curso: Curso,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    compacto: Boolean = false
) {
    val modificadorLargura = if (compacto) modifier.width(220.dp) else modifier.fillMaxWidth()
    SuperficieCartao(modifier = modificadorLargura, aoClicar = onClick) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                BadgeCategoria(curso.categoria)
                BadgeRisco(curso.risco)
            }
            Text(
                text = curso.titulo,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            if (!compacto) {
                Text(
                    text = curso.instrutor,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
            BarraDeProgresso(progresso = curso.progresso)
            Text(
                text = "${curso.percentual}% concluído",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
