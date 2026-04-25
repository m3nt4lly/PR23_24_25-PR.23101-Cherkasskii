package com.example.pr23_23101

import androidx.annotation.DrawableRes

data class OnboardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

val onboardingPages = listOf(
    OnboardingPage(
        image = R.drawable.ic_analyses,
        title = "РђРЅР°Р»РёР·С‹",
        description = "Р­РєСЃРїСЂРµСЃСЃ СЃР±РѕСЂ Рё РїРѕР»СѓС‡РµРЅРёРµ РїСЂРѕР±"
    ),
    OnboardingPage(
        image = R.drawable.ic_notifications,
        title = "РЈРІРµРґРѕРјР»РµРЅРёСЏ",
        description = "Р’С‹ Р±С‹СЃС‚СЂРѕ СѓР·РЅР°РµС‚Рµ Рѕ СЂРµР·СѓР»СЊС‚Р°С‚Р°С…"
    ),
    OnboardingPage(
        image = R.drawable.ic_monitoring,
        title = "РњРѕРЅРёС‚РѕСЂРёРЅРі",
        description = "РќР°С€Рё РІСЂР°С‡Рё РІСЃРµРіРґР° РЅР°Р±Р»СЋРґР°СЋС‚ Р·Р° РІР°С€РёРјРё РїРѕРєР°Р·Р°С‚РµР»СЏРјРё Р·РґРѕСЂРѕРІСЊСЏ"
    )
)
