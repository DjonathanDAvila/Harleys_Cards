package com.djonathan.harleys_cards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HarleysLayout()
                }
            }
        }
    }
}

@Composable
fun HarleysLayout() {
    var id by remember { mutableStateOf(1) }

    val card = loadCard(id)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 30.dp)
            .verticalScroll(rememberScrollState())// ativar o scrool da tela
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (card != null) {
            Image(
                painter = painterResource(id = card.imagem),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = card?.nome ?: "", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card?.anoFab.toString() ?: "", fontStyle = FontStyle.Italic)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { id = if (id > 1) id - 1 else 4 },
                modifier = Modifier
                    .weight(1f)
                    .width(0.dp)
            ) {
                Text(text = "Previous", fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { id = if (id < 4) id + 1 else 1 },
                modifier = Modifier
                    .weight(1f)
                    .width(0.dp)
            ) {
                Text(text = "Next", fontSize = 12.sp)

            }
        }

    }
}

private fun loadCard(id: Int): Card? {
    val harleys = Card()
    harleys.getDataCards()

    return harleys.findCardByID(id)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        HarleysLayout()
    }
}