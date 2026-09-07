package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.responder
import br.com.educamais.app.mock.sugestoesDePergunta
import br.com.educamais.app.model.AutorMensagem
import br.com.educamais.app.model.MensagemEdia
import br.com.educamais.app.ui.components.BalaoMensagem
import br.com.educamais.app.ui.components.ChipFiltro
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaEdia(cursoContexto: String?, aoVoltar: () -> Unit) {
    val mensagens = remember {
        mutableStateListOf<MensagemEdia>().apply {
            if (!cursoContexto.isNullOrBlank()) {
                add(
                    MensagemEdia(
                        texto = "Vi que você estava em \"$cursoContexto\". Pergunte algo " +
                            "específico sobre o conteúdo dele ou escolha uma sugestão abaixo.",
                        autor = AutorMensagem.EDIA
                    )
                )
            }
        }
    }
    var campoTexto by rememberSaveable { mutableStateOf("") }
    var consultando by remember { mutableStateOf(false) }
    val escopo = rememberCoroutineScope()
    val listState = rememberLazyListState()

    fun enviar(pergunta: String) {
        if (pergunta.isBlank() || consultando) return
        mensagens.add(MensagemEdia(texto = pergunta, autor = AutorMensagem.ALUNO))
        campoTexto = ""
        consultando = true
        escopo.launch {
            delay(900)
            mensagens.add(responder(pergunta))
            consultando = false
        }
    }

    LaunchedEffect(mensagens.size, consultando) {
        if (mensagens.isNotEmpty()) {
            listState.animateScrollToItem(mensagens.size - 1)
        }
    }

    val mostrarSugestoes = mensagens.none { it.autor == AutorMensagem.ALUNO }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EdIA") },
                navigationIcon = { TextButton(onClick = aoVoltar) { Text("Voltar") } }
            )
        },
        bottomBar = {
            Column {
                if (mostrarSugestoes) {
                    LazyRow(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(sugestoesDePergunta) { sugestao ->
                            ChipFiltro(
                                texto = sugestao,
                                selecionado = false,
                                onClick = { enviar(sugestao) }
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = campoTexto,
                        onValueChange = { campoTexto = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Pergunte à EdIA...") },
                        singleLine = true
                    )
                    Button(onClick = { enviar(campoTexto) }, enabled = !consultando) {
                        Text("Enviar")
                    }
                }
            }
        }
    ) { paddingInterno ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mensagens) { mensagem ->
                BalaoMensagem(mensagem = mensagem)
            }
            if (consultando) {
                item {
                    Text(
                        text = "EdIA está consultando o material...",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}
