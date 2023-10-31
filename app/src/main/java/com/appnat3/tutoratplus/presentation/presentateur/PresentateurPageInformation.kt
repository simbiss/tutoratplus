package com.appnat3.tutoratplus.presentation.presentateur

import com.appnat3.tutoratplus.presentation.vue.page_information

class PresentateurPageInformation(var vue: page_information) {
            // Méthode pour effectuer la navigation vers l'écran menu_principal
            fun effectuerNavigationMenu() {
                vue.naviguerVersmenu_principal()
            }


}