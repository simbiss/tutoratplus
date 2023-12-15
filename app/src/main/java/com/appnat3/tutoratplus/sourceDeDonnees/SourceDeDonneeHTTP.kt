package com.appnat3.tutoratplus.sourceDeDonnees

import android.util.JsonReader
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.Disponibilite
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.StringReader
import java.time.LocalDate
import java.time.LocalTime

class SourceDeDonneeHTTP(var context: Modele.Companion){


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
        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/listeCours"

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
        var nomCours = ""
        var nomProgramme = ""
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
        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/listeTuteurs"

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

        //Traitements---------------------------
        jsonRead.beginArray()  //listeDisponibilités
        while (jsonRead.hasNext()){
            var nomTuteur = ""
            var programme = ""
            var id = 0
            lateinit var tuteur:Tuteur
            var date: LocalDate = LocalDate.now()
            var heures: MutableList<LocalTime>
            var disponibilite:Disponibilite
            var heure :LocalTime
            var listedisponibilites = mutableListOf<Disponibilite>()
            var year = 0
            var month = 0
            var dayOfMonth = 0
            var hour = 0
            var minutes = 0
            jsonRead.beginObject()  //Tuteur
            while (jsonRead.hasNext()) {
                val cle = jsonRead.nextName()
                when (cle) {
                    "id" -> id = jsonRead.nextInt()
                    "nomTuteur" -> nomTuteur = jsonRead.nextString()
                    "programme" -> programme = jsonRead.nextString()
                    "disponibilites" -> {
                        jsonRead.beginArray()  //listeDisponibilite
                        while (jsonRead.hasNext()) {
                            heures = mutableListOf() // Nouvelle liste d'heures pour chaque disponibilité
                            jsonRead.beginObject()  //Disponibilite
                            while (jsonRead.hasNext()) {
                                val cleDisponibilite = jsonRead.nextName()
                                when (cleDisponibilite) {
                                    "date" -> {
                                        jsonRead.beginObject()  //date
                                        while (jsonRead.hasNext()) {
                                            val cleDate = jsonRead.nextName()
                                            when (cleDate) {
                                                "year" -> year = jsonRead.nextInt()
                                                "month" -> month = jsonRead.nextInt()
                                                "dayOfMonth" -> dayOfMonth = jsonRead.nextInt()
                                                else -> jsonRead.skipValue()
                                            }
                                        }
                                        jsonRead.endObject()  //date
                                        date = LocalDate.of(year, month, dayOfMonth)
                                    }
                                    "heures" -> {
                                        jsonRead.beginArray()
                                        while (jsonRead.hasNext()) {  //heures
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
                                        jsonRead.endArray()  //heures

                                    }
                                }

                            }
                            jsonRead.endObject()  //Disponibilite
                            disponibilite = Disponibilite(date, heures)
                            listedisponibilites.add(disponibilite)
                        }
                        jsonRead.endArray()  //listeDisponibilite

                    }
                    else -> jsonRead.skipValue()
                }
            }
            jsonRead.endObject()  //Tuteur
            tuteur = Tuteur(id, nomTuteur, programme, listedisponibilites)
            listeTuteur.add(tuteur)
        }
        jsonRead.endArray()  //listeDisponibilités
        return listeTuteur

    }



    //ListeInfoLogin---------------------------------------------------------------------
    fun obtenirListeInfoLogin():List<InfoLogin>{
        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/listeInfoLogin"

        val result = connectionHttpRequest(url)
        try {
            println("HTTP Request Result : $result")
        }catch (e: Exception){
            println("ERREUR: ${e.message}")
        }
        return retourListeInfoLogin(result)
    }


    private fun retourListeInfoLogin(json : String):List<InfoLogin>{
        var jsonRead = JsonReader(StringReader(json))
        return lectureInfoLogin(jsonRead)
    }

    private fun lectureInfoLogin(jsonRead:JsonReader): List<InfoLogin>{

        var listeInfoLogin = mutableListOf<InfoLogin>()
        var nomUtilisateur = ""
        var motDePasse = ""
        jsonRead.beginArray()
        while (jsonRead.hasNext()){
            jsonRead.beginObject()
            while (jsonRead.hasNext()) {
                val name = jsonRead.nextName()
                when (name) {
                    "nomUtilisateur" -> nomUtilisateur = jsonRead.nextString()
                    "motDePasse" -> motDePasse = jsonRead.nextString()
                    else -> jsonRead.skipValue()
                }
            }
            jsonRead.endObject()
            var nouveauLogin = InfoLogin(nomUtilisateur,motDePasse)
            listeInfoLogin.add(nouveauLogin)
        }
        jsonRead.endArray()

        return listeInfoLogin
    }
}