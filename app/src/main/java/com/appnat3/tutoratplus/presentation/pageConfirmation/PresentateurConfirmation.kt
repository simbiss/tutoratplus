package com.appnat3.tutoratplus.presentation.pageConfirmation

class PresentateurConfirmation(var vue: VueConfirmation) {
    fun effectuerNaviguationMenuConfirmation() {
        vue.naviguerversmenu_principal()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerversacceuil()
    }

    fun effectuerNaviguationInformationPersonnelle() {
        vue.naviguerversinformation_personnelle()
    }

}