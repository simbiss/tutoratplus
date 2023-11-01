package com.appnat3.tutoratplus.presentation.listeCours

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.listeCours.IContractVuePresentateurListeCours.IPresentateurListeCours


class PresentateurListeCours(var vue: VueListeCours): IPresentateurListeCours {

    var listeCours = arrayOf<Cours>()

    override fun traiterListeCours(): Array<Cours> {
        for (cours in Modele.retourListeDesCours()){
            listeCours+=cours
        }
        return listeCours
    }


    // Méthode pour effectuer la navigation vers l'écran menu_principal
    fun effectuerNavigationMenu() {
        vue.naviguerVersmenu_principal()
    }

    // Méthode pour effectuer la navigation vers l'écran de liste des tuteurs
    fun effectuerNavigationTuteur() {
        vue.naviguerVersTuteurs()
    }

    fun recuperationCours(item:Cours){
        Modele.coursSelectionne = item
    }
}