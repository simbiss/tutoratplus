package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.sourceDeDonnees.SourceBidon
import com.appnat3.tutoratplus.sourceDeDonnees.SourceDeDonneeHTTP
import com.appnat3.tutoratplus.sourceDeDonnees.SourceDeDonnees
import java.time.LocalDate
import java.time.LocalTime



class Modele(val source: SourceDeDonneeHTTP = SourceDeDonneeHTTP(this), val _source:  SourceDeDonnees = SourceBidon()) {
    fun retourListeDesCoursHttpTest(): List<Cours> {
        return source.obtenirListeCours()
    }

    fun retourListeTuteurHTTPTest(): List<Tuteur> {
        return source.obtenirListeTuteurs()
    }

    fun retourListInfoLoginTest(): List<InfoLogin> {
        return _source.obtenirListeInfoLogin()
    }

    companion object {
        //Déclaration de variables----------------------------------
        var instance = Modele()
        val sourceHttp = instance.source
        private val _source = instance._source
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

        var listeDispoTuteur = mutableListOf<DispoTuteur>()
        var listeDemandeTutorat = mutableListOf<DemandeTutorat>()


        /**
         * sauvegarde date et heure dispo tuteur
         */
        var idtuteurDispo:Int = 0
        var jour:Int = 0
        var mois:Int = 0
        var annee:Int = 0
        var heure:Int = 0
        var minute:Int = 0


        //Méthodes  ----------------------------------

        /**
         * Méthode pour retourner tout les cours de tutorat
         */

        fun retourListeDesCours(): List<Cours>{
            listeDesCours = sourceHttp.obtenirListeCours().toMutableList()
            return listeDesCours
        }

        /**
         * initialisation des different cours de tutorat
         */
        fun retourListeTuteurBidon(): List<Tuteur> {
            return _source.obtenirlisteTuteur()
        }

        fun retourListeTuteur(): List<Tuteur> {
            listeTuteurs =  sourceHttp.obtenirListeTuteurs().toMutableList()
            return  listeTuteurs
        }


        /**
         * initialisation information login tuteur
         */

        fun retourListInfoLogin(): List<InfoLogin> {
            return _source.obtenirListeInfoLogin()
        }

        /**
         * méthode pour retourner les informations entrées choisies par l'utilisateur
         */

        fun retourDateChoisie(): LocalDate? {
            return dateSelected
        }

        fun retourHeureSelectionne(): LocalTime? {
            return heureSelectionne
        }


        /**
         * initialisation des variable pour les demandes de tutorat
         */
    }
}
