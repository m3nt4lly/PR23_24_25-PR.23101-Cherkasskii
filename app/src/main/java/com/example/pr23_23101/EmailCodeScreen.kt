package com.example.pr23_23101

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun EmailCodeScreen(
    onNavigateToCreatePassword: () -> Unit,
    modifier: Modifier = Modifier
) {
    var code by remember { mutableStateOf("") }
    var timeLeft by remember { mutableIntStateOf(59) }

    code.length == 4

    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    Column(
        modifier = modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Back arrow (icon placeholder)
        Text("<", fontSize = 24.sp, modifier = Modifier.align(Alignment.Start).padding(start = 24.dp).clickable { })

        Spacer(modifier = Modifier.height(24.dp))
        Text("Р’РІРµРґРёС‚Рµ РєРѕРґ РёР· E-mail", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        // 4 Box for code
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(4) { index ->
                val digit = if (index < code.length) code[index].toString() else ""
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
                        .border(
                            width = if (index == code.length) 2.dp else 0.dp,
                            color = Color(0xFF0560FA),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(digit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("РћС‚РїСЂР°РІРёС‚СЊ РєРѕРґ РїРѕРІС‚РѕСЂРЅРѕ РјРѕР¶РЅРѕ Р±СѓРґРµС‚ С‡РµСЂРµР· $timeLeft СЃРµРєСѓРЅРґ", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.weight(1f))

        // Custom Keyboard
        val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "вЊ«")
        keys.chunked(3).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                row.forEach { key ->
                    if (key.isEmpty()) {
                        Spacer(modifier = Modifier.size(80.dp))
                    } else {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(40.dp))
                                .clickable {
                                    if (key == "вЊ«") {
                                        if (code.isNotEmpty()) code = code.dropLast(1)
                                    } else if (code.length < 4) {
                                        code += key
                                        if (code.length == 4) {
                                            // Auto navigate or wait
                                        }
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            if (key == "вЊ«") {
                                Text("вЊ«", fontSize = 24.sp)
                            } else {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(key, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                                    if (key == "2") Text("ABC", fontSize = 10.sp, color = Color.Gray)
                                    if (key == "3") Text("DEF", fontSize = 10.sp, color = Color.Gray)
                                    // ... РјРѕР¶РЅРѕ РґРѕР±Р°РІРёС‚СЊ РѕСЃС‚Р°Р»СЊРЅС‹Рµ Р±СѓРєРІС‹
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))


    }

    LaunchedEffect(code) {
        if (code.length == 4) {
            delay(500)
            onNavigateToCreatePassword()
        }
    }
}
