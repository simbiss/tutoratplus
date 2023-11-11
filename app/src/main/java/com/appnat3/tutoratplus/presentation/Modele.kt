package com.appnat3.tutoratplus.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.Disponibilites
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import java.time.LocalDate
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
object Modele{


    /**
     * initialisation des different cours de tutorat
     */
    var listeDesCours = mutableListOf<Cours>()
    var coursSelectionne: Cours? = null

    init {
        var cours1 = Cours("Programmation 1", "programmation")
        var cours2 = Cours("Programmation 2 (Java)", "programmation")
        var cours3 = Cours("Programmation 2 (Python)", "reseau")
        var cours4 = Cours("Programmation Autre et BD", "programmation")
        var cours5 = Cours("Réseautique", "reseau")

        listeDesCours.add(cours1)
        listeDesCours.add(cours2)
        listeDesCours.add(cours3)
        listeDesCours.add(cours4)
        listeDesCours.add(cours5)
    }

    /**
     * Méthode pour retourner tout les cours de tutorat
     */
    fun retourListeDesCours():List<Cours> {
        return listeDesCours
    }

    fun retourCoursSelectionne(): Cours? {
        return coursSelectionne
    }



    /**
     * initialisation des different disponibilités
     */

    @RequiresApi(Build.VERSION_CODES.O)
    val date1 = LocalDate.of(2023,11, 9 )
    @RequiresApi(Build.VERSION_CODES.O)
    val date2 = LocalDate.of(2023,11, 9 )

    @RequiresApi(Build.VERSION_CODES.O)
    val date3 = LocalDate.of(2023,11, 9 )
    @RequiresApi(Build.VERSION_CODES.O)
    val date4 = LocalDate.of(2023,11, 9 )

    @RequiresApi(Build.VERSION_CODES.O)
    val date5 = LocalDate.of(2023,11, 9 )


    var listeDisponibiliteHeure1 = mutableListOf<LocalTime>(
        LocalTime.of(10,30),
        LocalTime.of(11,0),
        LocalTime.of(11,30)
    )

    var listeDisponibiliteHeure2 = mutableListOf<LocalTime>(
        LocalTime.of(10,30),
        LocalTime.of(11,0),
        LocalTime.of(11,30)
    )

    var listeDisponibiliteHeure3 = mutableListOf<LocalTime>(
        LocalTime.of(11,30),
        LocalTime.of(12,0),
        LocalTime.of(12,30)
    )

    var listeDisponibiliteHeure4 = mutableListOf<LocalTime>(
        LocalTime.of(13,0),
        LocalTime.of(13,30),
        LocalTime.of(14,0)
    )

    var listeDisponibiliteHeure5 = mutableListOf<LocalTime>(
        LocalTime.of(16,0),
        LocalTime.of(16,30)
    )

        var disponibilite1 = Disponibilites( date1, listeDisponibiliteHeure1)

        var disponibilite2 = Disponibilites(date2, listeDisponibiliteHeure2)
        var disponibilite3 = Disponibilites(date3, listeDisponibiliteHeure3)
        var disponibilite4 = Disponibilites(date4, listeDisponibiliteHeure4)
        var disponibilite5 = Disponibilites(date5, listeDisponibiliteHeure5)




    /**
     * initialisation des different cours de tutorat
     */
    var listeTuteurs = mutableListOf<Tuteur>()
    var tuteurSelectionne: Tuteur? = null

    init {
        var tuteur1 = Tuteur("Mohamed Fatene", "programmation", "Mohamed456", disponibilite1)
        var tuteur2 = Tuteur("Raphaël Beyrouthy", "reseau", "Raphael123", disponibilite1)
        var tuteur3 = Tuteur("Lakhdar Amine Ouzou", "programmation", "LakhdarOuzou", disponibilite1)
        var tuteur4 = Tuteur("Elliott Fournier-Robert", "programmation", "RobertMr", disponibilite1)
        var tuteur5 = Tuteur("Antoine Lépine", "reseau", "LepinA", disponibilite1)

        listeTuteurs.add(tuteur1)
        listeTuteurs.add(tuteur2)
        listeTuteurs.add(tuteur3)
        listeTuteurs.add(tuteur4)
        listeTuteurs.add(tuteur5)
    }

    fun retourListeTuteur():List<Tuteur>{
        return listeTuteurs
    }

    /**
     * initialisation des variable d'informations personnelles
     */
    var daInfoPerso:String? = null
    var prenomInfoPerso:String? = null
    var nomInfoPerso:String? = null
    var courrielInfoPerso:String?=null
    var dateSelected:LocalDate?=null
}
