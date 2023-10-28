package com.appnat3.tutoratplus.présentation.présentateur

import com.appnat3.tutoratplus.présentation.vue.menu_principal

class PrésentateurMenu(var vue: menu_principal) {

    // Méthode pour effectuer la navigation vers l'écran des listes des cours
    fun effectuerNavigationChoixCours() {
        vue.naviguerVersliste_des_cours()
    }

    // Méthode pour effectuer la navigation vers l'écran de la page d'information de l'application
    fun effectuerNavigationPageInformation() {
        vue.naviguerVerspage_information()
    }

}