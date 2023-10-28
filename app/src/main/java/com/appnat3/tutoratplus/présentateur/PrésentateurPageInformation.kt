package com.appnat3.tutoratplus.présentateur

import com.appnat3.tutoratplus.vue.page_information

class PrésentateurPageInformation(var vue: page_information) {
            // Méthode pour effectuer la navigation vers l'écran menu_principal
            fun effectuerNavigationMenu() {
                vue.naviguerVersmenu_principal()
            }


}