package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.filkom.mycv2.data.UserData


@Composable
fun DaftarScreen(onSimpan: (UserData) -> Unit = {}) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "DAFTAR",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(value = nim, onValueChange = { nim = it }, label = { Text("NIM") }, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))
        OutlinedTextField(value = nama, onValueChange = { nama = it }, label = { Text("Nama") }, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))
        OutlinedTextField(value = alamat, onValueChange = { alamat = it }, label = { Text("Alamat") }, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 20.dp),
            onClick = {
                onSimpan(
                    UserData(
                        email = email,
                        nim = nim,
                        nama = nama,
                        alamat = alamat,
                        password = password
                    )
                )
            }
        ) {
            Text("SIMPAN")
        }
    }
}

@Preview
@Composable
fun DaftarPreview() {
    DaftarScreen()
}
