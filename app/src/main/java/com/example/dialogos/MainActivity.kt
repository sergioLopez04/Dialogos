package com.example.dialogos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dialogos.ui.theme.DialogosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var texto by rememberSaveable { mutableStateOf("Texto Mutable") }

    var mostrarConfirmacion by rememberSaveable { mutableStateOf(false) }
    var mostrarEliminacion by rememberSaveable { mutableStateOf(false) }
    var mostrarInformacion by rememberSaveable { mutableStateOf(false) }
    var mostrarAutenticacion by rememberSaveable { mutableStateOf(false) }
    var mostrarError by rememberSaveable { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(texto)

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {

            mostrarConfirmacion = true

        }) {

            Text("Confirmacion")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            mostrarEliminacion = true

        }) {

            Text("Eliminación")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            mostrarInformacion = true

        }) {

            Text("Información")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            mostrarAutenticacion = true

        }) {

            Text("Autenticación")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            mostrarError = true

        }) {

            Text("Error Crítico")
        }

    }

    if (mostrarConfirmacion) {
        AlertDialog(
            onDismissRequest = { mostrarConfirmacion = false },
            title = { Text("Confirmación de Acción") },
            text = { Text("¿Estás seguro de que deseas continuar con esta acción?") },
            confirmButton = {
                Button(onClick = {
                    texto = "Acción Confirmada"
                    mostrarConfirmacion = false
                }) {
                    Text("Sí")
                }
            },
            dismissButton = {
                Button(onClick = { mostrarConfirmacion = false }) {
                    Text("No")
                }
            }
        )
    }

    if (mostrarEliminacion) {
        AlertDialog(
            onDismissRequest = { mostrarEliminacion = false },
            title = { Text("Eliminar Elemento") },
            text = { Text("Esta acción es irreversible. ¿Deseas eliminar este elemento?") },
            confirmButton = {
                Button(onClick = {
                    texto = "Elemento eliminado exitosamente"
                    mostrarEliminacion = false
                },) {
                    Text("Eliminar", color = Color.White)
                }
            },
            dismissButton = {
                Button(onClick = { mostrarEliminacion = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    if (mostrarInformacion) {
        AlertDialog(
            onDismissRequest = { mostrarInformacion = false },
            title = { Text("Aviso Importante") },
            text = { Text("Recuerda que los cambios realizados no se pueden deshacer.") },
            confirmButton = {
                Button(onClick = { mostrarInformacion = false }) {
                    Text("Entendido")
                }
            }
        )
    }

    if (mostrarAutenticacion) {
        AlertDialog(
            onDismissRequest = { mostrarAutenticacion = false },
            title = { Text("Requiere Autenticación") },
            text = { Text("Para continuar, necesitas autenticarte de nuevo.") },
            confirmButton = {
                Button(onClick = {
                    texto = "Usuario Autenticado"
                    mostrarAutenticacion = false
                }) {
                    Text("Autenticar")
                }
            },
            dismissButton = {
                Button(onClick = { mostrarAutenticacion = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    if (mostrarError) {
        AlertDialog(
            onDismissRequest = { mostrarError = false },
            title = { Text("Error Crítico") },
            text = { Text("Se ha producido un error crítico. ¿Deseas intentar nuevamente?") },
            confirmButton = {
                Button(onClick = {
                    texto = "Intento de Reintento"
                    mostrarError = false
                }) {
                    Text("Reintentar")
                }
            },
            dismissButton = {
                Button(onClick = { mostrarError = false }) {
                    Text("Cancelar")
                }
            }
        )
    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogosTheme {
        Greeting("Android")
    }
}