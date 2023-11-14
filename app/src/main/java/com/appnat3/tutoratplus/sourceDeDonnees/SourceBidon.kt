package com.appnat3.tutoratplus.sourceDeDonnees

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur


class SourceBidon : SourceDeDonnees {

    /**
     * initialisation des different cours de tutorat
     */
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

    /**
     * Création des different disponibilités
     */

        /// HELLO WORLD

    /**
     * initialisation des different cours de tutorat
     */
    var listeTuteurs = mutableListOf<Tuteur>()

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