package br.com.educamais.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.educamais.app.model.AutorMensagem
import br.com.educamais.app.model.MensagemEdia

// Balão do chat da EdIA. Toda resposta da EdIA com fonte mostra o bloco de
// citação — regra de zero alucinação do produto.
@Composable
fun BalaoMensagem(mensagem: MensagemEdia, modifier: Modifier = Modifier) {
    val doAluno = mensagem.autor == AutorMensagem.ALUNO
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = if (doAluno) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier.widthIn(max = 280.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Surface(
                shape = MaterialTheme.shapes.large,
                color = if (doAluno) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                border = if (doAluno) null else BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
            ) {
                Text(
                    text = mensagem.texto,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (doAluno) Color.White else MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(12.dp)
                )
            }
            if (mensagem.fonte != null) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "Fonte: ${mensagem.fonte}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }
        }
    }
}
