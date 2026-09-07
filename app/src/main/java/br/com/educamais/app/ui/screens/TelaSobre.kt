package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.ui.components.BlocoComGradienteMarca
import br.com.educamais.app.ui.components.MarcaEducaMais
import br.com.educamais.app.ui.components.SuperficieCartao

private data class Pilar(val titulo: String, val descricao: String)

private val pilares = listOf(
    Pilar(
        titulo = "Preditiva de evasão",
        descricao = "Cruza acessos, notas e ritmo de estudo para avisar antes do abandono " +
            "— sempre com uma ação sugerida junto do alerta."
    ),
    Pilar(
        titulo = "EdIA em chat",
        descricao = "Assistente com busca no material da empresa. Regra de zero " +
            "alucinação: toda resposta mostra a fonte; sem fonte, ela não responde."
    ),
    Pilar(
        titulo = "Salas de Estudo",
        descricao = "Encontros síncronos curtos, mediados por colaboradores que já " +
            "dominam o conteúdo."
    ),
    Pilar(
        titulo = "Multicanal",
        descricao = "Mesmo conteúdo em app, modo áudio e WhatsApp — nesta Sprint, " +
            "representado apenas na interface."
    )
)

@Composable
fun TelaSobre(aoVoltar: () -> Unit) {
    Scaffold { paddingInterno ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
        ) {
            item {
                BlocoComGradienteMarca(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 40.dp, horizontal = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MarcaEducaMais()
                    }
                }
            }

            item {
                Text(
                    text = "Os quatro pilares",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                )
            }

            items(pilares) { pilar ->
                SuperficieCartao(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 6.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(pilar.titulo, style = MaterialTheme.typography.titleMedium)
                        Text(pilar.descricao, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Escopo desta Sprint", style = MaterialTheme.typography.titleLarge)
                    Text(
                        text = "Protótipo funcional em Kotlin e Jetpack Compose, com todos " +
                            "os dados mockados em memória — sem backend, sem persistência " +
                            "real. O foco foi demonstrar a experiência dos quatro pilares e " +
                            "a navegação completa entre as telas do app.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Button(
                        onClick = aoVoltar,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text("Voltar")
                    }
                }
            }
        }
    }
}
