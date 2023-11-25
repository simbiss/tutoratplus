package com.appnat3.tutoratplus.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.sourceDeDonnees.SourceBidon
import com.appnat3.tutoratplus.sourceDeDonnees.SourceDeDonnees
import java.time.LocalDate
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
class Modele(source: SourceDeDonnees = SourceBidon()) {


    companion object {
        /*var instance: Modele? = null
        fun getInstance(): Modele {
            if (instance == null) {
                instance = Modele()
            }
            return instance as Modele
        }*/

        val source: SourceDeDonnees = SourceBidon()
        private var _source: SourceDeDonnees = source

        var ouvertureSessionTuteur: Tuteur? = null
        var tuteurSelectionne: Tuteur? = null

        var daInfoPerso: String? = null
        var prenomInfoPerso: String? = null
        var nomInfoPerso: String? = null
        var courrielInfoPerso: String? = null


        /**
         * sauvegarde date et heure dispo tuteur
         */
        var idtuteurDispo:Int = 0
        var jour:Int = 0
        var mois:Int = 0
        var annee:Int = 0
        var heure:Int = 0
        var minute:Int = 0

        // id jj mm aaaa hh mm
        var listeDispoTuteur = mutableListOf<DispoTuteur>()


        /**
         * initialisation des different cours de tutorat
         */
        //var listeDesCours = mutableListOf<Cours>()
        var coursSelectionne: Cours? = null

        fun retourCoursSelectionne(): Cours? {
            return coursSelectionne
        }


        /**
         * Méthode pour retourner tout les cours de tutorat
         */
        fun retourListeDesCours(): List<Cours> {
            return _source.obtenirListeDesCours()
        }


        /**
         * initialisation des different cours de tutorat
         */
//    var listeTuteurs = mutableListOf<Tuteur>()


        fun retourListeTuteur(): List<Tuteur> {
            return _source.obtenirlisteTuteur()
        }

        /**
         * initialisation information login tuteur
         */

        fun retourListInfoLogin(): List<InfoLogin> {
            return _source.obtenirListeInfoLogin()
        }

        /**
         * information sur l'utilisateur qui login
         */

        //var ouvertureSessionTuteur: Tuteur? = null  // a d.placer dans la source bonfd
        var test: String? = null
        var testhardCode = "Hellow"


        /**
         * initialisation des variable d'informations personnelles
         */


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
         * initialisation des variable pour selection de date (Calendrier)
         */
        var dateSelected: LocalDate? = null
        var heureSelectionne: LocalTime? = null

    }
}
