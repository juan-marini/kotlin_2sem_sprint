package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.categoriasDeCursos
import br.com.educamais.app.mock.filtrarCursos
import br.com.educamais.app.ui.components.CartaoCurso
import br.com.educamais.app.ui.components.ChipFiltro
import br.com.educamais.app.ui.components.EstadoVazio

// A busca e o filtro em si vivem na camada mock (filtrarCursos): esta tela
// só guarda o que o usuário escolheu e mostra o resultado.
@Composable
fun AbaCursos(aoAbrirCurso: (String) -> Unit) {
    var busca by rememberSaveable { mutableStateOf("") }
    var categoriaSelecionada by rememberSaveable { mutableStateOf<String?>(null) }

    val categorias = categoriasDeCursos()
    val resultado = filtrarCursos(busca, categoriaSelecionada)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = busca,
            onValueChange = { busca = it },
            label = { Text("Buscar curso ou instrutor") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        LazyRow(
            modifier = Modifier.padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                ChipFiltro(
                    texto = "Todas",
                    selecionado = categoriaSelecionada == null,
                    onClick = { categoriaSelecionada = null }
                )
            }
            items(categorias) { categoria ->
                ChipFiltro(
                    texto = categoria,
                    selecionado = categoriaSelecionada == categoria,
                    onClick = {
                        categoriaSelecionada = if (categoriaSelecionada == categoria) null else categoria
                    }
                )
            }
        }

        Text(
            text = "${resultado.size} curso(s) encontrado(s)",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
        )

        if (resultado.isEmpty()) {
            EstadoVazio(
                emoji = "🔍",
                titulo = "Nenhum curso encontrado",
                mensagem = "Tente outra palavra-chave ou remova o filtro de categoria."
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(resultado, key = { it.id }) { curso ->
                    CartaoCurso(curso = curso, onClick = { aoAbrirCurso(curso.id) })
                }
            }
        }
    }
}
