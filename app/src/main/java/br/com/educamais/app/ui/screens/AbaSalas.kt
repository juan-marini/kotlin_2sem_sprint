package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.salasEstudo
import br.com.educamais.app.ui.components.CartaoSalaEstudo

@Composable
fun AbaSalas(aoAbrirSala: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(salasEstudo, key = { it.id }) { sala ->
            CartaoSalaEstudo(sala = sala, onClick = { aoAbrirSala(sala.id) })
        }
    }
}
