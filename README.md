# GitHub User Portfolio

[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-orange?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-blue?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Room](https://img.shields.io/badge/Room-Database-lightgrey?logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/room)
[![Retrofit](https://img.shields.io/badge/Retrofit-Networking-blueviolet?logo=retrofit&logoColor=white)](https://square.github.io/retrofit/)
[![Hilt](https://img.shields.io/badge/Hilt-DI-red?logo=dagger&logoColor=white)](https://developer.android.com/training/dependency-injection/hilt-android)

Aplikasi Android sederhana yang menampilkan daftar pengguna GitHub, detail pengguna, pencarian/filter, dan penyimpanan lokal menggunakan Room Database. Dibangun menggunakan Kotlin dan Jetpack Compose dengan arsitektur MVVM.

---

## Fitur

- 📋 **Daftar Pengguna**: Menampilkan daftar pengguna GitHub dari API publik.
- 🔍 **Pencarian/Filter**: Filter daftar pengguna berdasarkan username.
- 👤 **Halaman Detail**: Informasi lengkap pengguna GitHub.
- 💾 **Offline Support**: Penyimpanan lokal menggunakan Room Database.
- ⚡ **State Management**: Menggunakan `StateFlow` dan `Sealed Class` untuk menampilkan Loading, Success, dan Error state.
- 🏗 **Clean Architecture**: Memisahkan layer Domain, Data, dan UI.

---

## Teknologi

- Kotlin
- Jetpack Compose
- Hilt (Dependency Injection)
- Retrofit + Moshi (Networking & JSON parsing)
- Room Database (Penyimpanan lokal)
- Coroutines & Flow (Asynchronous programming)
- Material3 UI Components

---

## Instalasi

1. Clone repositori:

```bash
git clone https://github.com/username/github-user-portfolio.git
