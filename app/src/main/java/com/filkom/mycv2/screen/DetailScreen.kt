package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(onDaftar: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "DETAIL",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(text = "NIM: 235150407111003", fontSize = 14.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Nama: Iftina Dewi Anisa Damayanti", fontSize = 14.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Email: email@example.com", fontSize = 14.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Alamat: Jalan Veteran", fontSize = 14.sp, modifier = Modifier.padding(10.dp))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onDaftar
        ) {
            Text("DAFTAR")
        }
    }
}

@Preview
@Composable
fun DetailPreview() {
    DetailScreen()
}
