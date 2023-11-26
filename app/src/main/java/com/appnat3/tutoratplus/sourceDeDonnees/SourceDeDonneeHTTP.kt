package com.appnat3.tutoratplus.sourceDeDonnees

import com.appnat3.tutoratplus.domaine.entite.Cours
import okhttp3.OkHttpClient
import okhttp3.Request
import android.util.JsonReader
import com.appnat3.tutoratplus.domaine.entite.Disponibilite
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import java.io.StringReader
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class SourceDeDonneeHTTP(var context: Modele.Companion){

    //var listeCourt = mutableListOf<Cours>()

    fun connectionHttpRequest(url:String):String{
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        if(response.isSuccessful){
            client.dispatcher.executorService.shutdown() // Fermeture de la session
            client.connectionPool.evictAll() // Éviter les fuites de ressources
            return response.body?.string()?:""

        }else{
            throw Exception("HTTP request Failed : ${response.code}")
        }

    }

    //ListeCours------------------------------------------------------------------------------------
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
        jsonRead.beginArray()
            while (jsonRead.hasNext()){
                jsonRead.beginObject()
                while (jsonRead.hasNext()) {
                    val name = jsonRead.nextName()
                    when (name) {
                        "nomCours" -> nomCours = jsonRead.nextString()
                        "programme" -> nomProgramme = jsonRead.nextString()
                        else -> jsonRead.skipValue()
                    }
                }
                jsonRead.endObject()
                var nouveauCours = Cours(nomCours,nomProgramme)
                listeDesCours.add(nouveauCours)
            }

        jsonRead.endArray()
        return listeDesCours
    }

    //ListeTuteurs------------------------------------------------------------------------------------

    fun obtenirListeTuteurs():List<Tuteur>{
        val url = "https://8ecb8b23-ca98-4584-8a0d-0dccfa014a81.mock.pstmn.io/listeTuteur"

        val result = connectionHttpRequest(url)
        try {
            println("HTTP Request Result : $result")
        }catch (e: Exception){
            println("ERREUR: ${e.message}")
        }
        println(result)
        return retourListeTuteurs(result)
    }



    private fun retourListeTuteurs(json : String):List<Tuteur>{
        var jsonRead = JsonReader(StringReader(json))
        return lectureListeTuteursJson(jsonRead)
    }

    private fun lectureListeTuteursJson(jsonRead:JsonReader):List<Tuteur>{

        //Déclaration de variables---------------------------
        var listeTuteur = mutableListOf<Tuteur>()
        //println(jsonRead)

        //Traitements---------------------------
        jsonRead.beginArray()
        while (jsonRead.hasNext()){
            var nomTuteur: String = ""
            var programme : String = ""
            var id: Int = 0
            lateinit var tuteur:Tuteur
            var date: LocalDate = LocalDate.now()
            var heures: MutableList<LocalTime> = mutableListOf<LocalTime>()
            var disponibilite:Disponibilite = Disponibilite(date, heures)
            var heure :LocalTime = LocalTime.NOON
            var listedisponibilites = mutableListOf<Disponibilite>()
            var year:Int = 0
            var month:Int = 0
            var dayOfMonth:Int = 0
            var hour:Int = 0
            var minutes:Int = 0
            jsonRead.beginObject()
            while (jsonRead.hasNext()) {
                val cle = jsonRead.nextName()
                when (cle) {
                    "id" -> id = jsonRead.nextInt()
                    "nomTuteur" -> nomTuteur = jsonRead.nextString()
                    "programme" -> programme = jsonRead.nextString()
                    "disponibilites" -> {
                        jsonRead.beginArray()
                        while (jsonRead.hasNext()) {
                            heures = mutableListOf() // Nouvelle liste d'heures pour chaque disponibilité
                            jsonRead.beginObject()
                            while (jsonRead.hasNext()) {
                                val cleDisponibilite = jsonRead.nextName()
                                when (cleDisponibilite) {
                                    "date" -> {
                                        jsonRead.beginObject()
                                        val cleDate = jsonRead.nextName()
                                        when (cleDate) {
                                            "year" -> year = jsonRead.nextInt()
                                            "month" -> month = jsonRead.nextInt()
                                            "dayOfMonth" -> dayOfMonth = jsonRead.nextInt()
                                            else -> jsonRead.skipValue()
                                        }
                                        jsonRead.endObject()
                                        date = LocalDate.of(year, month, dayOfMonth)
                                    }
                                    "heures" -> {
                                        jsonRead.beginArray()
                                        while (jsonRead.hasNext()) {
                                            jsonRead.beginObject()
                                            while (jsonRead.hasNext()) {
                                                val cleHeures = jsonRead.nextName()
                                                when (cleHeures) {
                                                    "hour" -> hour = jsonRead.nextInt()
                                                    "minutes" -> minutes = jsonRead.nextInt()
                                                    else -> jsonRead.skipValue()
                                                }
                                            }
                                            jsonRead.endObject()
                                            heure = LocalTime.of(hour, minutes)
                                            heures.add(heure)
                                        }
                                        jsonRead.endArray()

                                    }
                                }

                            }
                            jsonRead.endObject()
                            disponibilite = Disponibilite(date, heures)
                            listedisponibilites.add(disponibilite)
                        }
                        jsonRead.endArray()

                    }
                    else -> jsonRead.skipValue()
                }
            }
            jsonRead.endObject()
            tuteur = Tuteur(id, nomTuteur, programme, listedisponibilites)
            listeTuteur.add(tuteur)
        }
        jsonRead.endArray()
        println(listeTuteur)

        return listeTuteur
    }







}