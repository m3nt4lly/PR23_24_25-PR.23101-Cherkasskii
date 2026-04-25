package com.example.pr23_23101

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onNavigateToEmailCode: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    val isFormValid = email.contains("@") && email.contains(".")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text("рџ‘‹", fontSize = 40.sp)
        Text(
            "Р”РѕР±СЂРѕ РїРѕР¶Р°Р»РѕРІР°С‚СЊ!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF141414)
        )
        Text(
            "Р’РѕР№РґРёС‚Рµ, С‡С‚РѕР±С‹ РїРѕР»СЊР·РѕРІР°С‚СЊСЃСЏ С„СѓРЅРєС†РёСЏРјРё РїСЂРёР»РѕР¶РµРЅРёСЏ",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text("Р’С…РѕРґ РїРѕ E-mail", color = Color.Gray, fontSize = 14.sp)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("example@mail.ru", color = Color.LightGray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0560FA),
                unfocusedBorderColor = Color(0xFFE0E0E0)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNavigateToEmailCode,
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFormValid) Color(0xFF0560FA) else Color(0xFFE0E0E0)
            )
        ) {
            Text("Р”Р°Р»РµРµ", color = if (isFormValid) Color.White else Color.Gray)
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { /* Р›РѕРіРёРєР° РЇРЅРґРµРєСЃ */ },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White
            )
        ) {
            Text("Р’РѕР№С‚Рё СЃ РЇРЅРґРµРєСЃ", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
