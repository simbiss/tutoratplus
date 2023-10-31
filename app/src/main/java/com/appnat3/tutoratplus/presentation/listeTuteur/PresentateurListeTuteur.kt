package com.appnat3.tutoratplus.presentation.listeTuteur

class PresentateurListeTuteur(var vue: VueListeTuteurs){

    fun effectuerNavigationCours(){
        vue.navigationVersListeCours()
    }

    fun effectuerNavigationCalendrier(){
        vue.navigationVersCalendrier()
    }

}