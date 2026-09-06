package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.model.SalaEstudo
import br.com.educamais.app.ui.theme.EducaMaisTokens

// Usado na lista "salas de hoje" da aba Início e na listagem completa da aba Salas.
@Composable
fun CartaoSalaEstudo(
    sala: SalaEstudo,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SuperficieCartao(modifier = modifier.fillMaxWidth(), aoClicar = onClick) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = sala.horario,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                if (sala.aoVivo) {
                    Text(
                        text = "AO VIVO",
                        style = MaterialTheme.typography.labelSmall,
                        color = EducaMaisTokens.cores.risco
                    )
                }
            }
            Text(text = sala.titulo, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Mediador: ${sala.mediador} · ${sala.cursoRelacionado}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Text(
                text = if (sala.lotada) "Sala lotada" else "${sala.vagasRestantes} vagas restantes",
                style = MaterialTheme.typography.labelMedium,
                color = if (sala.lotada) EducaMaisTokens.cores.risco else EducaMaisTokens.cores.sucesso
            )
        }
    }
}
