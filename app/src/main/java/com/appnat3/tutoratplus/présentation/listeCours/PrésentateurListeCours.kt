package com.appnat3.tutoratplus.présentation.listeCours

import com.appnat3.tutoratplus.domaine.entité.Cours
import com.appnat3.tutoratplus.présentation.Modele
import com.appnat3.tutoratplus.présentation.listeCours.IContractVuePresentateurListeCours.IPresentateurListeCours


class PrésentateurListeCours(var vue: VueListeCours): IPresentateurListeCours {

    var listeCours = arrayOf<Cours>()

    override fun traiterListeCours(): Array<Cours> {
        for (cours in Modele.getListeDesCours()){
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
}