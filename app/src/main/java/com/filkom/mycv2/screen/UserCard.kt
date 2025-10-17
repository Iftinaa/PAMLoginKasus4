package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.filkom.mycv2.data.UserData

@Composable
fun UserCard(user: UserData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "NIM: ${user.nim}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Nama: ${user.nama}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Alamat: ${user.alamat}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
