package com.appnat3.tutoratplus.sourceDeDonnees

import android.util.JsonReader
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.presentation.Modele
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.StringReader

class SourceDeDonneeHTTP(var context: Modele.Companion){

    var listeCourt = mutableListOf<Cours>()

    fun connectionHttpRequest(url:String):String{
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        if(response.isSuccessful){
            return response.body?.string()?:""
        }else{
            throw Exception("HTTP request Failed : ${response.code}")
        }
    }

    fun obtenirListeCours():List<Cours>{
        val url = "https://8ecb8b23-ca98-4584-8a0d-0dccfa014a81.mock.pstmn.io/listeCours"

        val result = connectionHttpRequest(url)
       try {
           println("HTTP Request Result : $result")
       }catch (e: Exception){
           println("ERREUR: ${e.message}")
       }
        return retourLiseCours(result)
    }

    private fun retourLiseCours(json : String):List<Cours>{
        var jsonRead = JsonReader(StringReader(json))
        return lectureListeCoursJson(jsonRead)
    }

    private fun lectureListeCoursJson(jsonRead:JsonReader):List<Cours>{
        var listeDesCours = mutableListOf<Cours>()
        var nomCours: String = ""
        var nomProgramme : String = ""
        jsonRead.beginObject()
        while (jsonRead.hasNext()){
            var cle = jsonRead.nextName()
            when (cle){
                "nomCours" -> {
                    nomCours = jsonRead.nextString()
                }
                "programme"-> {
                    nomProgramme = jsonRead.nextString()
                }
                else ->{
                    jsonRead.skipValue()
                }
            }
            var nouveauCours = Cours(nomCours,nomProgramme)
            listeDesCours.add(nouveauCours)
        }
        jsonRead.endObject()
        return listeDesCours
    }



}