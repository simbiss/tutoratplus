package com.appnat3.tutoratplus.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.Disponibilite
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
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
     * Création des different disponibilités
     */

    @RequiresApi(Build.VERSION_CODES.O)
    val date1 = LocalDate.of(2023,11, 12 )
    @RequiresApi(Build.VERSION_CODES.O)
    val date2 = LocalDate.of(2023,11, 16 )

    @RequiresApi(Build.VERSION_CODES.O)
    val date3 = LocalDate.of(2023,11, 17 )
    @RequiresApi(Build.VERSION_CODES.O)
    val date4 = LocalDate.of(2023,11, 18 )

    @RequiresApi(Build.VERSION_CODES.O)
    val date5 = LocalDate.of(2023,11, 19 )


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

        val ListedisponibiliteTuteur1 : Array<Disponibilite> = arrayOf(
            Disponibilite( date1, listeDisponibiliteHeure1),
            Disponibilite(date2, listeDisponibiliteHeure2),
            Disponibilite(date3, listeDisponibiliteHeure3),
            Disponibilite(date4, listeDisponibiliteHeure4),
            Disponibilite(date5, listeDisponibiliteHeure5)
        )
        val ListedisponibiliteTuteur2 : Array<Disponibilite> = arrayOf(
            Disponibilite( date1, listeDisponibiliteHeure1),
            Disponibilite(date2, listeDisponibiliteHeure2),
            Disponibilite(date3, listeDisponibiliteHeure3),
            Disponibilite(date4, listeDisponibiliteHeure4),
            Disponibilite(date5, listeDisponibiliteHeure5)
        )

        val ListedisponibiliteTuteur3 : Array<Disponibilite> = arrayOf(
            Disponibilite( date1, listeDisponibiliteHeure1),
            Disponibilite(date2, listeDisponibiliteHeure2),
            Disponibilite(date3, listeDisponibiliteHeure3),
            Disponibilite(date4, listeDisponibiliteHeure4),
            Disponibilite(date5, listeDisponibiliteHeure5)
        )
        val ListedisponibiliteTuteur4 : Array<Disponibilite> = arrayOf(
            Disponibilite( date1, listeDisponibiliteHeure1),
            Disponibilite(date2, listeDisponibiliteHeure2),
            Disponibilite(date3, listeDisponibiliteHeure3),
            Disponibilite(date4, listeDisponibiliteHeure4),
            Disponibilite(date5, listeDisponibiliteHeure5)
        )
        val ListedisponibiliteTuteur5 : Array<Disponibilite> = arrayOf(
            Disponibilite( date1, listeDisponibiliteHeure1),
            Disponibilite(date2, listeDisponibiliteHeure2),
            Disponibilite(date3, listeDisponibiliteHeure3),
            Disponibilite(date4, listeDisponibiliteHeure4),
            Disponibilite(date5, listeDisponibiliteHeure5)
        )


    /**
     * initialisation des different cours de tutorat
     */
    var listeTuteurs = mutableListOf<Tuteur>()
    var tuteurSelectionne: Tuteur? = null

    init {

        var tuteur1 = Tuteur(1,"Mohamed Fatene", "programmation", ListedisponibiliteTuteur1)
        var tuteur2 = Tuteur(2,"Raphaël Beyrouthy", "reseau", ListedisponibiliteTuteur2)
        var tuteur3 = Tuteur(3,"Lakhdar Amine Ouzou", "programmation", ListedisponibiliteTuteur3)
        var tuteur4 = Tuteur(4,"Elliott Fournier-Robert", "programmation", ListedisponibiliteTuteur4)
        var tuteur5 = Tuteur(5,"Antoine Lépine", "reseau", ListedisponibiliteTuteur5)

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
     * initialisation information login tuteur
     */

    var listeInfoLogin = mutableListOf<InfoLogin>()
    //var loginEntree = InfoLogin("","")

    init {
        var infoLogin1 = InfoLogin("mohamed", "abc1")
        var infoLogin2 = InfoLogin("raphael", "abc2")
        var infoLogin3 = InfoLogin("lakhdar", "abc3")
        var infoLogin4 = InfoLogin("elliott", "abc4")
        var infoLogin5 = InfoLogin("antoine", "abc5")

        listeInfoLogin.add(infoLogin1)
        listeInfoLogin.add(infoLogin2)
        listeInfoLogin.add(infoLogin3)
        listeInfoLogin.add(infoLogin4)
        listeInfoLogin.add(infoLogin5)
    }
    fun retourListInfoLogin(): List<InfoLogin>{
        return listeInfoLogin
    }

    /**
     * information sur l'utilisateur qui login
     */

    var ouvertureSessionTuteur: Tuteur? = null

    var mapInfoLogin = mapOf<Int, InfoLogin>(1 to listeInfoLogin[0],2 to listeInfoLogin[1],3 to listeInfoLogin[2],4 to listeInfoLogin[3],5 to listeInfoLogin[4])
    var mapListTuteur = mapOf<Int, Tuteur>(1 to listeTuteurs[0], 2 to listeTuteurs[1], 3 to listeTuteurs[2], 4 to listeTuteurs[3], 5 to listeTuteurs[4])


    /**
     * initialisation des variable d'informations personnelles
     */
    var daInfoPerso:String? = null
    var prenomInfoPerso:String? = null
    var nomInfoPerso:String? = null
    var courrielInfoPerso:String?=null


    fun retourDaInfoPerso(): String? {
        return daInfoPerso
    }
    fun retourPrenomInfoPerso():String?{
        return prenomInfoPerso
    }

    fun retourNomInfoPerso():String?{
        return nomInfoPerso
    }

    fun retourCourrielInfoPerso():String?{
        return courrielInfoPerso
    }

    /**
     * initialisation des variable pour selection de date (Calendrier)
     */
    var dateSelected:LocalDate?=null
    var heureSelectionne:LocalTime?=null








}
