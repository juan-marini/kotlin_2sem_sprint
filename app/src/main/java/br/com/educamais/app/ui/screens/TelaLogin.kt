package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.com.educamais.app.ui.components.BlocoComGradienteMarca
import br.com.educamais.app.ui.components.MarcaEducaMais
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TelaLogin(
    aoEntrar: () -> Unit,
    aoAbrirSobre: () -> Unit
) {
    var matricula by rememberSaveable { mutableStateOf("") }
    var senha by rememberSaveable { mutableStateOf("") }
    var senhaVisivel by rememberSaveable { mutableStateOf(false) }
    var carregando by rememberSaveable { mutableStateOf(false) }
    var erroMatricula by remember { mutableStateOf<String?>(null) }
    var erroSenha by remember { mutableStateOf<String?>(null) }
    val escopo = rememberCoroutineScope()

    fun validar(): Boolean {
        erroMatricula = if (matricula.isBlank()) "Informe sua matrícula" else null
        erroSenha = when {
            senha.isBlank() -> "Informe sua senha"
            senha.length < 4 -> "A senha deve ter pelo menos 4 caracteres"
            else -> null
        }
        return erroMatricula == null && erroSenha == null
    }

    BlocoComGradienteMarca(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MarcaEducaMais()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            ) {
                OutlinedTextField(
                    value = matricula,
                    onValueChange = {
                        matricula = it
                        if (erroMatricula != null) erroMatricula = null
                    },
                    label = { Text("Matrícula") },
                    singleLine = true,
                    isError = erroMatricula != null,
                    supportingText = { erroMatricula?.let { Text(it) } },
                    colors = coresCampoLogin(),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = senha,
                    onValueChange = {
                        senha = it
                        if (erroSenha != null) erroSenha = null
                    },
                    label = { Text("Senha") },
                    singleLine = true,
                    isError = erroSenha != null,
                    supportingText = { erroSenha?.let { Text(it) } },
                    visualTransformation = if (senhaVisivel) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        TextButton(onClick = { senhaVisivel = !senhaVisivel }) {
                            Text(if (senhaVisivel) "Ocultar" else "Mostrar", color = Color.White)
                        }
                    },
                    colors = coresCampoLogin(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                )

                Button(
                    onClick = {
                        if (!carregando && validar()) {
                            carregando = true
                            escopo.launch {
                                delay(700)
                                carregando = false
                                aoEntrar()
                            }
                        }
                    },
                    enabled = !carregando,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    if (carregando) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp,
                            color = Color.White
                        )
                    } else {
                        Text("Entrar")
                    }
                }
            }

            TextButton(onClick = aoAbrirSobre, modifier = Modifier.padding(top = 16.dp)) {
                Text("O que é o EducaMais?", color = Color.White)
            }
        }
    }
}

@Composable
private fun coresCampoLogin() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White,
    focusedBorderColor = Color.White,
    unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
    focusedLabelColor = Color.White,
    unfocusedLabelColor = Color.White.copy(alpha = 0.7f),
    cursorColor = Color.White,
    focusedContainerColor = Color.White.copy(alpha = 0.08f),
    unfocusedContainerColor = Color.White.copy(alpha = 0.08f)
)
