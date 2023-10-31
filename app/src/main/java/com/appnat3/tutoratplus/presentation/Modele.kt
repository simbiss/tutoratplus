package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entité.Cours


object Modele{
    var listeDesCours = mutableListOf<Cours>()
    var coursSelectionne: Cours? = null
    /**
     * initialisation des different cours de tutorat
     */

    fun retourCoursSelectionne(): Cours? {
        return coursSelectionne
    }

    init {
        var cours1 = Cours("Programmation 1", "programmation")
        var cours2 = Cours("Programmation 2", "reseau")
        var cours3 = Cours("Programmation 2", "programmation")
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


    var listeTuteur = mutableListOf<Cours>()
}
