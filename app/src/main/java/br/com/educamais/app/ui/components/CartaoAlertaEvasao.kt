package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.educamais.app.model.AlertaEvasao
import br.com.educamais.app.model.RiscoEvasao
import br.com.educamais.app.ui.theme.EducaMaisTokens

// Único bloco com fundo colorido cheio da interface — reservado para o
// alerta preditivo em destaque na aba Início.
@Composable
fun CartaoAlertaEvasao(
    alerta: AlertaEvasao,
    modifier: Modifier = Modifier
) {
    val cores = EducaMaisTokens.cores
    val corFundo = when (alerta.nivel) {
        RiscoEvasao.ALTO -> cores.risco
        RiscoEvasao.MEDIO -> cores.atencao
        RiscoEvasao.BAIXO -> cores.sucesso
    }
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = corFundo
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${alerta.probabilidade}% de chance de abandono",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White
            )
            Text(text = alerta.titulo, style = MaterialTheme.typography.titleMedium, color = Color.White)
            Text(
                text = alerta.descricao,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.9f)
            )
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = Color.White.copy(alpha = 0.16f)
            ) {
                Text(
                    text = "Ação sugerida: ${alerta.acaoSugerida}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}
