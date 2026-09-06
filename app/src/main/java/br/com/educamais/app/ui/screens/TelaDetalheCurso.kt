package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.buscarCursoPorId
import br.com.educamais.app.ui.components.EstadoVazio

// Versão provisória: a Fase 8 substitui pelo layout final (cabeçalho,
// módulos expansíveis). Já demonstra a busca por id vinda da navegação e o
// estado vazio quando o id não existe, que é a parte específica da Fase 5.
@Composable
fun TelaDetalheCurso(
    cursoId: String?,
    aoVoltar: () -> Unit,
    aoPerguntarNaEdia: (tituloCurso: String) -> Unit
) {
    val curso = cursoId?.let { buscarCursoPorId(it) }
    Scaffold { paddingInterno ->
        if (curso == null) {
            EstadoVazio(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingInterno),
                emoji = "🔍",
                titulo = "Curso não encontrado",
                mensagem = "Esse curso pode ter sido removido ou o link está incorreto.",
                textoAcao = "Voltar",
                aoClicarAcao = aoVoltar
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingInterno)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Detalhe do curso (Fase 8 monta a tela final)")
                Text(curso.titulo)
                Text("${curso.percentual}% concluído")
                Button(onClick = { aoPerguntarNaEdia(curso.titulo) }) {
                    Text("Perguntar à EdIA sobre este curso")
                }
                Button(onClick = aoVoltar) { Text("Voltar") }
            }
        }
    }
}
