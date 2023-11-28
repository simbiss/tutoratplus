package com.appnat3.tutoratplus.sourceDeDonnees

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Disponibilite
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import java.time.LocalDate
import java.time.LocalTime


class SourceBidon : SourceDeDonnees {

    /**
     * initialisation des different cours de tutorat
     */

    /*
    var listeDesCours = mutableListOf<Cours>()

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

    override fun obtenirListeDesCours():List<Cours>{
        return listeDesCours
    }
    */

    /**
     * Création des different disponibilités
     */
    @RequiresApi(Build.VERSION_CODES.O)
    val date1 = LocalDate.of(2023, 11, 12)

    @RequiresApi(Build.VERSION_CODES.O)
    val date2 = LocalDate.of(2023, 11, 16)

    @RequiresApi(Build.VERSION_CODES.O)
    val date3 = LocalDate.of(2023, 11, 17)

    @RequiresApi(Build.VERSION_CODES.O)
    val date4 = LocalDate.of(2023, 11, 18)

    @RequiresApi(Build.VERSION_CODES.O)
    val date5 = LocalDate.of(2023, 11, 19)


    var listeDisponibiliteHeure1 = mutableListOf<LocalTime>(
        LocalTime.of(10, 30),
        LocalTime.of(11, 0),
        LocalTime.of(11, 30)
    )

    var listeDisponibiliteHeure2 = mutableListOf<LocalTime>(
        LocalTime.of(10, 30),
        LocalTime.of(11, 0),
        LocalTime.of(11, 30)
    )

    var listeDisponibiliteHeure3 = mutableListOf<LocalTime>(
        LocalTime.of(11, 30),
        LocalTime.of(12, 0),
        LocalTime.of(12, 30)
    )

    var listeDisponibiliteHeure4 = mutableListOf<LocalTime>(
        LocalTime.of(13, 0),
        LocalTime.of(13, 30),
        LocalTime.of(14, 0)
    )

    var listeDisponibiliteHeure5 = mutableListOf<LocalTime>(
        LocalTime.of(16, 0),
        LocalTime.of(16, 30)
    )

    val ListedisponibiliteTuteur1: MutableList<Disponibilite> = mutableListOf<Disponibilite>(
        Disponibilite(date1, listeDisponibiliteHeure1),
        Disponibilite(date2, listeDisponibiliteHeure2),
        Disponibilite(date3, listeDisponibiliteHeure3),
        Disponibilite(date4, listeDisponibiliteHeure4),
        Disponibilite(date5, listeDisponibiliteHeure5)
    )
    val ListedisponibiliteTuteur2: MutableList<Disponibilite> = mutableListOf<Disponibilite>(
        Disponibilite(date1, listeDisponibiliteHeure1),
        Disponibilite(date2, listeDisponibiliteHeure2),
        Disponibilite(date3, listeDisponibiliteHeure3),
        Disponibilite(date4, listeDisponibiliteHeure4),
        Disponibilite(date5, listeDisponibiliteHeure5)
    )

    val ListedisponibiliteTuteur3: MutableList<Disponibilite> = mutableListOf<Disponibilite>(
        Disponibilite(date1, listeDisponibiliteHeure1),
        Disponibilite(date2, listeDisponibiliteHeure2),
        Disponibilite(date3, listeDisponibiliteHeure3),
        Disponibilite(date4, listeDisponibiliteHeure4),
        Disponibilite(date5, listeDisponibiliteHeure5)
    )
    val ListedisponibiliteTuteur4: MutableList<Disponibilite> = mutableListOf<Disponibilite>(
        Disponibilite(date1, listeDisponibiliteHeure1),
        Disponibilite(date2, listeDisponibiliteHeure2),
        Disponibilite(date3, listeDisponibiliteHeure3),
        Disponibilite(date4, listeDisponibiliteHeure4),
        Disponibilite(date5, listeDisponibiliteHeure5)
    )
    val ListedisponibiliteTuteur5: MutableList<Disponibilite> = mutableListOf<Disponibilite>(
        Disponibilite(date1, listeDisponibiliteHeure1),
        Disponibilite(date2, listeDisponibiliteHeure2),
        Disponibilite(date3, listeDisponibiliteHeure3),
        Disponibilite(date4, listeDisponibiliteHeure4),
        Disponibilite(date5, listeDisponibiliteHeure5)
    )

    /**
     * initialisation des different cours de tutorat
     */
    var listeTuteurs = mutableListOf<Tuteur>()

    init {
        var tuteur1 = Tuteur(1,"Mohamed Fatene", "programmation", ListedisponibiliteTuteur1)
        var tuteur2 = Tuteur(2,"Raphaël Beyrouthy", "réseau", ListedisponibiliteTuteur2)
        var tuteur3 = Tuteur(3,"Lakhdar Amine Ouzou", "programmation", ListedisponibiliteTuteur3)
        var tuteur4 = Tuteur(4,"Elliott Fournier-Robert", "programmation", ListedisponibiliteTuteur4)
        var tuteur5 = Tuteur(5,"Antoine Lépine", "réseau", ListedisponibiliteTuteur5)

        listeTuteurs.add(tuteur1)
        listeTuteurs.add(tuteur2)
        listeTuteurs.add(tuteur3)
        listeTuteurs.add(tuteur4)
        listeTuteurs.add(tuteur5)
    }

    override fun obtenirlisteTuteur():List<Tuteur>{
        return listeTuteurs
    }

    /**
     * initialisation information login tuteur
     */
    var listeInfoLogin = mutableListOf<InfoLogin>()

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
    override fun obtenirListeInfoLogin(): List<InfoLogin>{
        return listeInfoLogin
    }












}