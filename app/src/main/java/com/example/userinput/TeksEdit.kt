package com.example.userinput

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textSP by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var statusPernikahan by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val status: List<String> = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .width(400.dp)
                .height(100.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Text(
                modifier = Modifier.padding(top = 35.dp, start = 50.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = stringResource(id = R.string.formulirPendaftara),
            )
        }

        Card(
            modifier = Modifier
                .padding(10.dp)
                .width(400.dp)
                .height(600.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(5.dp, Color.Black)
        ) {
            Text(
                modifier = Modifier.padding(top = 15.dp, start = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                text = stringResource(id = R.string.namaLengkap),
            )
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .width(width = 250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    textNama = it
                }
            )
            Row {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ), verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            })
                        Text(item)
                    }
                }
            }
            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                modifier = Modifier.width(width = 250.dp),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = {
                    textAlamat = it
                }
            )
            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(
                        id = R.dimen.padding_small
                    )
                ),
                thickness = dimensionResource(R.dimen.divider_tipis),
                color = Color.DarkGray
            )
            Button(
                modifier = Modifier
                    .padding(bottom = 25.dp).fillMaxWidth(1f),
                enabled = textAlamat.isNotEmpty(),
                onClick = {
                    nama = textNama
                    jenis = textJK
                    alamat = textAlamat
                }
            ) {
                Text(stringResource(R.string.submit))
            }

            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(
                        R.dimen.padding_medium
                    )
                ),
                thickness = dimensionResource(
                    R.dimen.divider_tipis
                ),
                color = Color.DarkGray
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .height(100.dp)
                    .width(300.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),
                )
                {
                    Text(text = "Nama : " + nama, color = Color.White)
                    Text(text = "Gender : " + jenis, color = Color.White)
                    Text(text = "Alamat : " + alamat, color = Color.White)
                }
            }
        }
    }
}
