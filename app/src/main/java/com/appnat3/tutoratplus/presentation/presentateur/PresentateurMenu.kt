package com.appnat3.tutoratplus.presentation.presentateur

import com.appnat3.tutoratplus.presentation.vue.menu_principal

class PresentateurMenu(var vue: menu_principal) {

    // Méthode pour effectuer la navigation vers l'écran des listes des cours
    fun effectuerNavigationChoixCours() {
        vue.naviguerVersliste_des_cours()
    }

    // Méthode pour effectuer la navigation vers l'écran de la page d'information de l'application
    fun effectuerNavigationPageInformation() {
        vue.naviguerVerspage_information()
    }

}