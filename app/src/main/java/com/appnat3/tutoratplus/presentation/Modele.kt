package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.sourceDeDonnees.SourceDeDonneeHTTP
import java.time.LocalDate
import java.time.LocalTime


class Modele(val source: SourceDeDonneeHTTP = SourceDeDonneeHTTP(this)) {
    fun retourListeDesCoursHttpTest(): List<Cours> {
        return source.obtenirListeCours()
    }

    fun retourListeTuteurHTTPTest(): List<Tuteur> {
        return source.obtenirListeTuteurs()
    }

    fun retourListInfoLoginTest(): List<InfoLogin> {
        return source.obtenirListeInfoLogin()
    }

    fun retourListeDispoTuteur(): List<DispoTuteur> {
        return source.obtenirListeDispoTuteur()
    }



    fun envoiDispoTuteurTest(p_listeDispoTuteur: List<DispoTuteur>){
         sourceHttp.postDispoTuteurs(p_listeDispoTuteur)
    }


    companion object {
        //Déclaration de variables----------------------------------
        var instance = Modele()
        val sourceHttp = instance.source
        var ouvertureSessionTuteur: Tuteur? = null
        var tuteurSelectionne: Tuteur? = null
        var daInfoPerso: String? = null
        var prenomInfoPerso: String? = null
        var nomInfoPerso: String? = null
        var courrielInfoPerso: String? = null
        var coursSelectionne: Cours? = null
        var dateSelected: LocalDate? = null
        var heureSelectionne: LocalTime? = null
        var dispoSelectionnee: DispoTuteur? = null


        /**
         * utilisation liste
         */
        var listeDesCours = mutableListOf<Cours>()
        var listeTuteurs = mutableListOf<Tuteur>()

        var listeInfoLogin = mutableListOf<InfoLogin>()
        var listeDispoTuteur = mutableListOf<DispoTuteur>()
        var listeDemandeTutorat = mutableListOf<DemandeTutorat>()


        //Méthodes  ----------------------------------

        /**
         * Méthode pour retourner tout les cours de tutorat
         */

        fun retourListeDesCours(): List<Cours>{
            listeDesCours = sourceHttp.obtenirListeCours().toMutableList()
            return listeDesCours
        }

        fun retourListeTuteur(): List<Tuteur> {
            listeTuteurs =  sourceHttp.obtenirListeTuteurs().toMutableList()
            return  listeTuteurs
        }

        /**
         * Méthode pour retourner les informations login tuteur
         */

        fun retourListInfoLogin(): List<InfoLogin> {
            listeInfoLogin = sourceHttp.obtenirListeInfoLogin().toMutableList()
            return listeInfoLogin
        }

        fun envoiDispoTuteur(){
            sourceHttp.postDispoTuteurs(listeDispoTuteur)
        }


    }
}
