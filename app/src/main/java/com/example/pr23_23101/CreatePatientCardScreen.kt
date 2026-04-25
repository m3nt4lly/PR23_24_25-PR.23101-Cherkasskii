package com.example.pr23_23101

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePatientCardScreen(
    onNavigateToMain: () -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("28 С„РµРІСЂР°Р»СЏ 1991") }
    var gender by remember { mutableStateOf("РњСѓР¶СЃРєРѕР№") }

    val isFormValid = name.isNotBlank() && surname.isNotBlank()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("РЎРѕР·РґР°РЅРёРµ РєР°СЂС‚С‹ РїР°С†РёРµРЅС‚Р°", color = Color.Black) },
                actions = {
                    TextButton(onClick = onNavigateToMain) {
                        Text("РџСЂРѕРїСѓСЃС‚РёС‚СЊ", color = Color(0xFF0560FA))
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(24.dp)
        ) {
            Text("Р‘РµР· РєР°СЂС‚С‹ РїР°С†РёРµРЅС‚Р° РІС‹ РЅРµ СЃРјРѕР¶РµС‚Рµ Р·Р°РєР°Р·Р°С‚СЊ Р°РЅР°Р»РёР·РѕРІ...", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("РРјСЏ") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp))
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("РћС‚С‡РµСЃС‚РІРѕ") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp))
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(value = surname, onValueChange = { surname = it }, label = { Text("Р¤Р°РјРёР»РёСЏ") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp))
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = birthDate,
                onValueChange = { birthDate = it },
                label = { Text("Р”Р°С‚Р° СЂРѕР¶РґРµРЅРёСЏ") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                trailingIcon = { Icon(Icons.Default.CalendarToday, contentDescription = null) }
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = gender,
                onValueChange = { gender = it },
                label = { Text("РџРѕР»") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                readOnly = true
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onNavigateToMain,
                enabled = isFormValid,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = if (isFormValid) Color(0xFF0560FA) else Color(0xFFE0E0E0))
            ) {
                Text("РЎРѕР·РґР°С‚СЊ", color = if (isFormValid) Color.White else Color.Gray)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
