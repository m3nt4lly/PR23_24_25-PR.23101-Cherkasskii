package com.example.pr23_23101

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun MainDashboardScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        Pair("РђРЅР°Р»РёР·С‹", Icons.Default.Analytics),
        Pair("Р РµР·СѓР»СЊС‚Р°С‚С‹", Icons.Default.Description),
        Pair("РџРѕРґРґРµСЂР¶РєР°", Icons.Default.HeadsetMic),
        Pair("РџСЂРѕС„РёР»СЊ", Icons.Default.Person)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color(0xFF0560FA)
            ) {
                tabs.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.second, contentDescription = item.first) },
                        label = { Text(item.first, fontSize = 10.sp) },
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF0560FA),
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color(0xFF0560FA),
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            when (selectedTab) {
                0 -> AnalysesScreen()
                else -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Р­РєСЂР°РЅ РІ СЂР°Р·СЂР°Р±РѕС‚РєРµ", color = Color.Gray)
                }
            }
        }
    }
}
