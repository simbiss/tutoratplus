package com.appnat3.tutoratplus.présentateur

import com.appnat3.tutoratplus.vue.liste_des_cours

class PrésentateurListeCours(var vue: liste_des_cours) {
// Méthode pour effectuer la navigation vers l'écran menu_principal
    fun effectuerNavigationMenu() {
        vue.naviguerVersmenu_principal()
    }

    // Méthode pour effectuer la navigation vers l'écran de liste des tuteurs
    fun effectuerNavigationTuteur() {
        vue.naviguerVersTuteurs()
    }
}