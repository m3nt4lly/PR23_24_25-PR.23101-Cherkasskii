package com.example.pr23_23101

data class AnalysisItem(
    val id: Int,
    val name: String,
    val price: String,
    val category: String,
    val imageResId: Int
)

val mockAnalyses = listOf(
    AnalysisItem(1, "РћР±С‰РёР№ Р°РЅР°Р»РёР· РєСЂРѕРІРё", "500 в‚Ѕ", "popular", R.drawable.ic_analyses),
    AnalysisItem(2, "Р‘РёРѕС…РёРјРёСЏ", "1200 в‚Ѕ", "popular", R.drawable.ic_analyses),
    AnalysisItem(3, "РџР¦Р  РЅР° COVID-19", "900 в‚Ѕ", "covid", R.drawable.ic_analyses),
    AnalysisItem(4, "РђРЅС‚РёС‚РµР»Р° IgG", "700 в‚Ѕ", "covid", R.drawable.ic_analyses),
    AnalysisItem(5, "РљРѕРјРїР»РµРєСЃ 'Р–РµРЅСЃРєРѕРµ Р·РґРѕСЂРѕРІСЊРµ'", "3500 в‚Ѕ", "complex", R.drawable.ic_monitoring),
    AnalysisItem(6, "РљРѕРјРїР»РµРєСЃ 'Р©РёС‚РѕРІРёРґРЅР°СЏ Р¶РµР»РµР·Р°'", "2800 в‚Ѕ", "complex", R.drawable.ic_monitoring)
)

val newsItems = listOf(
    "РЎРєРёРґРєР° 20% РЅР° РџР¦Р  РґРѕ 31 РјР°СЏ",
    "РќРѕРІС‹Р№ РјРµС‚РѕРґ СЌРєСЃРїСЂРµСЃСЃ-Р°РЅР°Р»РёР·РѕРІ",
    "РџРѕРґР°СЂРѕРє РїСЂРё Р·Р°РєР°Р·Рµ РѕС‚ 5000в‚Ѕ"
)
