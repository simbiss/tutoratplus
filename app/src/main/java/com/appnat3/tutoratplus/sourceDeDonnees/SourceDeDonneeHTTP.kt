package com.appnat3.tutoratplus.sourceDeDonnees

import android.util.JsonReader
import android.util.JsonWriter
import android.util.Log
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException
import java.io.StringReader
import java.io.StringWriter

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

        val result = try {
            connectionHttpRequest(url)
        }catch (e: Exception){
            throw e
        }
        println("HTTP Request Result : $result")
        return retourLiseCours(result)
    }



    private fun retourLiseCours(json : String):List<Cours>{
        val jsonRead = JsonReader(StringReader(json))
        return lectureListeCoursJson(jsonRead)
    }



    private fun lectureListeCoursJson(jsonRead:JsonReader):List<Cours>{
        val listeDesCours = mutableListOf<Cours>()
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
                val nouveauCours = Cours(nomCours,nomProgramme)
                listeDesCours.add(nouveauCours)
            }

        jsonRead.endArray()
        return listeDesCours
    }

    //ListeTuteurs------------------------------------------------------------------------------------

    fun obtenirListeTuteurs():List<Tuteur>{
        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/listeTuteurs"

        val result = try {
            connectionHttpRequest(url)
        }catch (e: Exception){
            throw e
        }
        println("HTTP Request Result : $result")
        return retourListeTuteurs(result)
    }

    private fun retourListeTuteurs(json : String):List<Tuteur>{
        val jsonRead = JsonReader(StringReader(json))
        return lectureListeTuteursJson(jsonRead)
    }

    private fun lectureListeTuteursJson(jsonRead:JsonReader):List<Tuteur>{
        //Déclaration de variables---------------------------
        val listeTuteur = mutableListOf<Tuteur>()

        //Traitements---------------------------
        jsonRead.beginArray()
        while (jsonRead.hasNext()){
            var nomTuteur = ""
            var programme = ""
            var id = 0
            lateinit var tuteur:Tuteur
            jsonRead.beginObject()  //Tuteur
            while (jsonRead.hasNext()) {
                val cle = jsonRead.nextName()
                when (cle) {
                    "id" -> id = jsonRead.nextInt()
                    "nomTuteur" -> nomTuteur = jsonRead.nextString()
                    "programme" -> programme = jsonRead.nextString()
                    else -> jsonRead.skipValue()
                }
            }
            jsonRead.endObject()  //Tuteur
            tuteur = Tuteur(id, nomTuteur, programme)
            listeTuteur.add(tuteur)
        }
        jsonRead.endArray()
        return listeTuteur
    }

    //ListeInfoLogin---------------------------------------------------------------------
    fun obtenirListeInfoLogin():List<InfoLogin>{
        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/listeInfoLogin"

        val result = try {
            connectionHttpRequest(url)
        }catch (e: Exception){
            throw e
        }
        println("HTTP Request Result : $result")
        return retourListeInfoLogin(result)
    }


    private fun retourListeInfoLogin(json : String):List<InfoLogin>{
        val jsonRead = JsonReader(StringReader(json))
        return lectureInfoLogin(jsonRead)
    }

    private fun lectureInfoLogin(jsonRead:JsonReader): List<InfoLogin>{
        val listeInfoLogin = mutableListOf<InfoLogin>()
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
            val nouveauLogin = InfoLogin(nomUtilisateur,motDePasse)
            listeInfoLogin.add(nouveauLogin)
        }
        jsonRead.endArray()

        return listeInfoLogin
    }

    //DispoTuteur---------------------------------------------------------------------

    fun encodeurDispoTuteursJson(dispoTuteurs: List<DispoTuteur>): String {
        val stringWriter = StringWriter()
        val jsonWriter = JsonWriter(stringWriter)

        jsonWriter.beginArray()
        for (dispoTuteur in dispoTuteurs) {
            jsonWriter.beginObject()

            jsonWriter.name("idDispo").value(dispoTuteur.idDispo)
            jsonWriter.name("idTuteur").value(dispoTuteur.idTuteur)
            jsonWriter.name("reserver").value(dispoTuteur.reserver)
            jsonWriter.name("jour").value(dispoTuteur.jour)
            jsonWriter.name("mois").value(dispoTuteur.mois)
            jsonWriter.name("annee").value(dispoTuteur.annee)
            jsonWriter.name("heure").value(dispoTuteur.heure)
            jsonWriter.name("minute").value(dispoTuteur.minute)

            jsonWriter.endObject()
        }
        jsonWriter.endArray()
        jsonWriter.close()

        return stringWriter.toString()
    }

    fun postDispoTuteurs(dispoTuteurs: List<DispoTuteur>) {
        val client = OkHttpClient()
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val requestBody = encodeurDispoTuteursJson(dispoTuteurs).toRequestBody(mediaType)

        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/DispoTuteur"

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    Log.d("RequettePostDispoTuteur","$responseData")
                }
                 else {
                    throw IOException("Erreur inattendue: $response")
                }
            }
        })
    }




    /*fun obtenirListeDispoTuteur():List<DispoTuteur>{

        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/DispoTuteur"

        val result = try {
            connectionHttpRequest(url)
        }catch (e: Exception){
            throw e
        }
        return retourListeDispoTuteur(result)
    }*/

    fun obtenirListeDispoTuteur(): List<DispoTuteur> {
        val url = "https://2050daa9-5ca2-40e1-ad46-34b6203d7bd4.mock.pstmn.io/DispoTuteur"
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        val response = client.newCall(request).execute()
        client.dispatcher.executorService.shutdown() // Fermeture de la session
        client.connectionPool.evictAll() // Éviter les fuites de ressources

        if (!response.isSuccessful) {
            throw Exception("HTTP request Failed : ${response.code}")
        }

        val jsonResponse = response.body?.string() ?: ""
        return retourListeDispoTuteur(jsonResponse)
    }

    private fun retourListeDispoTuteur(json : String):List<DispoTuteur>{
        val jsonRead = JsonReader(StringReader(json))
        return lectureDispoTuteur(jsonRead)
    }

    private fun lectureDispoTuteur( json: JsonReader): List<DispoTuteur>{
        val listeDispoTuteur = mutableListOf<DispoTuteur>()

        json.beginArray()
        while (json.hasNext()) {
            var idDispo = 0
            var idTuteur = 0
            var reserver = false
            var jour = 0
            var mois = 0
            var annee = 0
            var heure = 0
            var minute = 0

            json.beginObject()
            while (json.hasNext()) {
                when (json.nextName()) {
                    "idDispo" -> idDispo = json.nextInt()
                    "idTuteur" -> idTuteur = json.nextInt()
                    "reserver" -> reserver = json.nextBoolean()
                    "jour" -> jour = json.nextInt()
                    "mois" -> mois = json.nextInt()
                    "annee" -> annee = json.nextInt()
                    "heure" -> heure = json.nextInt()
                    "minute" -> minute = json.nextInt()
                    else -> json.skipValue()
                }
            }
            json.endObject()
            listeDispoTuteur.add(DispoTuteur(idDispo, idTuteur, reserver, jour, mois, annee, heure, minute))
        }
        json.endArray()
        json.close()

        return listeDispoTuteur
    }

}