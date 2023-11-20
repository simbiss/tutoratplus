package com.appnat3.tutoratplus.sourceDeDonnees

import android.content.Context
import com.appnat3.tutoratplus.domaine.entite.Cours
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class SourceDeDonneeHTTP (var context : Context){

    val client = OkHttpClient()
    val url = "https://8ecb8b23-ca98-4584-8a0d-0dccfa014a81.mock.pstmn.io"
    val request = Request.Builder()
        .url(url)
        .build()


    var listeCourt = mutableListOf<Cours>()

    fun retourListeCours():List<Cours>{



        return listeCourt
    }



}