    package com.example.examen_yusef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examen_yusef.ui.theme.Examen_YusefTheme
/*Soy el número 1*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Examen_YusefTheme {
                Card_estudiante(name = "Alumno:"+ nombre,  tipo = "Soy alumno")
                Conversation(messages = Mensajes.conversationSample)
            }
        }
    }
}

@Composable
fun Card_estudiante(name : String, tipo : String){

}



/* Creamos los valores que utilizaremos más adelante */

val perfil = R.drawable.avatar1
    val alumno1= Color(0xFF8C9EFF)
    val nombre = "Yusef"
    val  background1=Color(0xFF311B92)

    @Composable
    fun Conversation(messages: List<com.example.examen_yusef.Message>) {
        LazyColumn {
            items(messages) { Message ->
                MessageCard(Message)
            }
        }
    }
    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: com.example.examen_yusef.Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.profesor),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(
                if (isExpanded) Color.Magenta else Color.Gray,
            )


            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleSmall ,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                )
               Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

        }
    }
    }

    object Mensajes {
        // Sample conversation data
        val conversationSample = listOf(
            Message(
                "Profesor",
                "Pues si utilizan todo lo que hemos dado en clase con sabiduría no deberían tener problemas"
            ),
            Message(
                "Profesor",
                "Con este ejercicio practican:\n" +
                        "Lo que vimos del instructivo, de hecho pueden partir de ahí\n" +
                        "De la aplicación de loterías cómo hacer observables, con variables que se leen en tiempo de ejecución\n" +
                        "También del de loterías cómo seleccionar un elemento aleatorio de una lista\n" +
                        "Los botones lo hemos visto en varios proyectos\n" +
                        "Así como el lazyrow y cómo modificar el layout\n" +
                        "También hemos visto cómo crear componentes que pueden cambiar dependiendo de los parámetros\n" +
                        "Espero que les sirva de ayuda)\n"
            ),
            Message(
                "Profesor",
                "Si no han practicado lo tienen fastidiado pero ...es lo que tiene.\n" +
                        "Hay que echarle horas para poder hacerlo rápido en los examenes!"
            ),
            Message(
                "Profesor",
                "También vimos cómo cambiar colores definidos en el MatherialTheme."

            ),
            Message(
                "Profesor",
                "Se me ocurrieron montón de cosas para mejorar esto como que pudieras poner distintos avatares automáticamente si eres profesor o alumno, pero ya me flipé un poco. "
            ),
            Message(
                "Profesor",
                "Pues mucha suerte!\n" +
                        "En este examen y en el futuro" +
                        "No queda nada para empezar las prácticas." +
                        "Ánimooooooooooooo:)"
            )
        )
    }
