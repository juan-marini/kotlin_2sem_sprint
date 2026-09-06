package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.buscarCursoPorId
import br.com.educamais.app.model.Curso
import br.com.educamais.app.model.Modulo
import br.com.educamais.app.ui.components.BadgeCategoria
import br.com.educamais.app.ui.components.BadgeObrigatorio
import br.com.educamais.app.ui.components.BadgeRisco
import br.com.educamais.app.ui.components.BarraDeProgresso
import br.com.educamais.app.ui.components.EstadoVazio
import br.com.educamais.app.ui.components.SuperficieCartao
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaDetalheCurso(
    cursoId: String?,
    aoVoltar: () -> Unit,
    aoPerguntarNaEdia: (tituloCurso: String) -> Unit
) {
    val curso = cursoId?.let { buscarCursoPorId(it) }
    val snackbarHostState = remember { SnackbarHostState() }
    val escopo = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(curso?.titulo ?: "Curso") },
                navigationIcon = { TextButton(onClick = aoVoltar) { Text("Voltar") } }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingInterno ->
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
            ConteudoDetalheCurso(
                curso = curso,
                modifier = Modifier.padding(paddingInterno),
                aoPerguntarNaEdia = { aoPerguntarNaEdia(curso.titulo) },
                aoContinuar = {
                    val proxima = curso.proximaAula
                    escopo.launch {
                        snackbarHostState.showSnackbar(
                            if (proxima != null) "Abrindo aula: ${proxima.titulo}" else "Curso já concluído!"
                        )
                    }
                }
            )
        }
    }
}

@Composable
private fun ConteudoDetalheCurso(
    curso: Curso,
    aoPerguntarNaEdia: () -> Unit,
    aoContinuar: () -> Unit,
    modifier: Modifier = Modifier
) {
    var moduloExpandido by rememberSaveable { mutableStateOf<Int?>(0) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    BadgeCategoria(curso.categoria)
                    if (curso.obrigatorio) BadgeObrigatorio()
                    BadgeRisco(curso.risco)
                }

                Text(curso.descricao, style = MaterialTheme.typography.bodyMedium)

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    BarraDeProgresso(progresso = curso.progresso)
                    Text(
                        text = "${curso.percentual}% concluído · " +
                            "${curso.aulasConcluidas}/${curso.totalAulas} aulas",
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                SuperficieCartao(modifier = Modifier.fillMaxWidth()) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Instrutor", style = MaterialTheme.typography.labelMedium)
                        Text(curso.instrutor, style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = "Carga horária: ${curso.cargaHoraria}h · Prazo: ${curso.prazo}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Button(onClick = aoContinuar, modifier = Modifier.fillMaxWidth()) {
                    Text(if (curso.concluido) "Revisar curso" else "Continuar")
                }

                OutlinedButton(onClick = aoPerguntarNaEdia, modifier = Modifier.fillMaxWidth()) {
                    Text("Perguntar à EdIA sobre este curso")
                }
            }
        }

        item {
            Text("Conteúdo do curso", style = MaterialTheme.typography.titleMedium)
        }

        itemsIndexed(curso.modulos) { indice, modulo ->
            CartaoModuloExpansivel(
                modulo = modulo,
                expandido = moduloExpandido == indice,
                aoAlternar = {
                    moduloExpandido = if (moduloExpandido == indice) null else indice
                }
            )
        }
    }
}

@Composable
private fun CartaoModuloExpansivel(
    modulo: Modulo,
    expandido: Boolean,
    aoAlternar: () -> Unit
) {
    SuperficieCartao(modifier = Modifier.fillMaxWidth(), aoClicar = aoAlternar) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(modulo.titulo, style = MaterialTheme.typography.titleSmall)
                    Text(
                        text = "${modulo.aulasConcluidas}/${modulo.aulas.size} aulas concluídas",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(if (expandido) "▲" else "▼")
            }

            BarraDeProgresso(progresso = modulo.progresso)

            if (expandido) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    modulo.aulas.forEach { aula ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "${if (aula.concluida) "✓" else "○"} ${aula.titulo}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = "${aula.tipo.label} · ${aula.duracaoFormatada}",
                                style = MaterialTheme.typography.labelSmall,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    }
}
