package com.appnat3.tutoratplus.presentation

import android.os.Build
import androidx.annotation.RequiresApi
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


@RequiresApi(Build.VERSION_CODES.O)
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
        var listeDesCours = mutableListOf<Cours>()
        var listeTuteurs = mutableListOf<Tuteur>()
        var dateSelected: LocalDate? = null
        var heureSelectionne: LocalTime? = null
        var listeDispoTuteur = mutableListOf<DispoTuteur>()


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
         * initialisation des different cours de tutorat
         */



        fun retourCoursSelectionne(): Cours? {
            return coursSelectionne
        }


        /**
         * Méthode pour retourner tout les cours de tutorat
         */
      //  fun retourListeDesCours(): List<Cours> {
      //      return _source.obtenirListeDesCours()
      //  }


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
        fun retourDaInfoPerso(): String? {
            return daInfoPerso
        }

        fun retourPrenomInfoPerso(): String? {
            return prenomInfoPerso
        }

        fun retourNomInfoPerso(): String? {
            return nomInfoPerso
        }

        fun retourCourrielInfoPerso(): String? {
            return courrielInfoPerso
        }

        fun retourCoursChoisi(): String? {
            return coursSelectionne?.nomCours
        }

        fun retourTuteurChoisi(): String? {
            return tuteurSelectionne?.nomTuteur
        }

        fun retourDateChoisie(): LocalDate? {
            return dateSelected
        }

        fun retourHeureSelectionne(): LocalTime? {
            return heureSelectionne
        }


        /**
         * initialisation des variable pour les demandes de tutorat
         */
        var listeDemandeTutorat = mutableListOf<DemandeTutorat>()

    }
}
