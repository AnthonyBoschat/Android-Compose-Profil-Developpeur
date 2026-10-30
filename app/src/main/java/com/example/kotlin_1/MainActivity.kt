package com.example.kotlin_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.ui.theme.Kotlin1Theme

// Oui je suis un peu maniaque sur les alignement des paramètres.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Profil(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Profil(modifier: Modifier = Modifier) {
    val skills: List<String> = listOf(
        "Kotlin et Jetpack Compose",
        "JavaScript, TypeScript et React",
        "Python et Django (Framework)",
        "Conception de bases de données",
        "Git et DevOps (CICD)"
    )

    ProfilCard(
        name         = "Anthony Boschat",
        title        = "Concepteur & développeur d'application",
        age          = 32,
        description  = "Développeur full-stack passionné par la compréhension des systèmes, les sciences et l’automatisation. Je conçois et développe des solutions adaptées à vos besoins.",
        skills       = skills,
        email        = "AnthonyBoschat.dev@hotmail.com",
        availability = "Non disponible",
        onContactClick = {

        },
        modifier     = modifier.fillMaxWidth()
    )
}

@Composable
fun ProfilCard(
    name: String,
    title: String,
    age: Int,
    description: String,
    skills: List<String>,
    email: String,
    availability: String,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cardShape     = RoundedCornerShape(12.dp)
    val cardElevation = 4.dp
    val sectionSpace  = 16.dp

    Surface(
        shape           = cardShape,
        shadowElevation = cardElevation,
        modifier        = modifier
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            ProfilHeader(
                name        = name,
                title       = title,
                age         = age,
                description = description,
                modifier    = Modifier.padding(bottom = sectionSpace)
            )


            SectionTitle(text = "Compétences")
            skills.forEach { skill ->
                Skill(
                    sentence = skill,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            Information(
                title    = "Contact",
                sentence = email,
                modifier = Modifier.padding(top = sectionSpace)
            )

            Information(
                title    = "Disponibilité",
                sentence = availability,
                modifier = Modifier.padding(top = 12.dp)
            )

            Action(
                title    = "Contacter $name",
                onClick  = onContactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
        }
    }
}

@Composable
fun ProfilHeader(
    name: String,
    title: String,
    age: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text       = name,
            style      = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text  = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text     = "$age ans",
            style    = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Text(
            text  = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text            = text,
        style           = MaterialTheme.typography.titleSmall,
        fontWeight      = FontWeight.Bold,
        modifier        = modifier.padding(bottom = 8.dp),
        textDecoration  = TextDecoration.Underline
    )
}

@Composable
fun Skill(
    sentence: String,
    modifier: Modifier = Modifier
) {
    Text(
        text     = "• $sentence",
        style    = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Composable
fun Action(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick  = onClick,
        modifier = modifier,
        shape    = RoundedCornerShape(8.dp)
    ) {
        Text(text = title)
    }
}

@Composable
fun Information(
    title: String,
    sentence: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(text = title)
        Text(
            text  = sentence,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilPreview() {
    Kotlin1Theme {
        Profil(
            modifier = Modifier.padding(16.dp)
        )
    }
}