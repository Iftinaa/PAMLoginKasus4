package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.filkom.mycv2.data.UserData

@Composable
fun DetailScreen(
    userData: UserData?,
    onBackToList: () -> Unit
) {
    if (userData == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Belum ada data")
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "DETAIL",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center
        )

        Text(text = "NIM: ${userData.nim}", fontSize = 14.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Nama: ${userData.nama}", fontSize = 14.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Email: ${userData.email}", fontSize = 14.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Alamat: ${userData.alamat}", fontSize = 14.sp, modifier = Modifier.padding(10.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onBackToList
        ) {
            Text("Kembali ke Daftar")
        }
    }
}
