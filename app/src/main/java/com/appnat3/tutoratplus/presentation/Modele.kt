package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur


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
     * initialisation des different cours de tutorat
     */
    var listeTuteurs = mutableListOf<Tuteur>()
    var tuteurSelectionne: Tuteur? = null

    init {
        var tuteur1 = Tuteur(1,"Mohamed Fatene","programmation")
        var tuteur2 = Tuteur(2,"Raphaël Beyrouthy", "reseau")
        var tuteur3 = Tuteur(3,"Lakhdar Amine Ouzou", "programmation")
        var tuteur4 = Tuteur(4,"Elliott Fournier-Robert", "programmation")
        var tuteur5 = Tuteur(5,"Antoine Lépine", "reseau")

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







}
