package com.example.bootcamp.odev2

// Derece → Fahrenheit Dönüşümü
fun dereceToFahrenheit(celsius: Double): Double {
    return celsius * 1.8 + 32
}

// Dikdörtgen Çevresi
fun dikdortgenCevre(kenar1: Int, kenar2: Int): Int {
    return 2 * (kenar1 + kenar2)
}

// Faktöriyel Hesaplama (Recursive)
fun faktoriyelHesapla(sayi: Int): Long {
    return if (sayi <= 1) 1 else sayi * faktoriyelHesapla(sayi - 1)
}

// 'a' Harfi Sayma (Küçük/büyük harf duyarsız)
fun aHarfiSay(kelime: String): Int {
    return kelime.lowercase().count { it == 'a' }
}

// İç Açılar Toplamı
fun icAciToplami(kenarSayisi: Int): Int {
    return (kenarSayisi - 2) * 180
}

// Maaş Hesaplama
fun maasHesapla(gunSayisi: Int): Int {
    val toplamSaat = gunSayisi * 8
    val normalSaat = if (toplamSaat > 160) 160 else toplamSaat
    val mesaiSaat = if (toplamSaat > 160) toplamSaat - 160 else 0
    return (normalSaat * 10) + (mesaiSaat * 20)
}

// Kota Ücreti Hesaplama
fun kotaUcretiHesapla(kotaGB: Int): Int {
    val sabitUcret = 100
    val asimGB = if (kotaGB > 50) kotaGB - 50 else 0
    return sabitUcret + (asimGB * 4)
}