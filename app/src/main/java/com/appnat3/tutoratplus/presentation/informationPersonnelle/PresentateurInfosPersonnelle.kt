package com.appnat3.tutoratplus.presentation.informationPersonnelle

import com.appnat3.tutoratplus.presentation.Modele


class PresentateurInfosPersonnelle(var vue: VueInformationPersonnlle) {


    fun traiterCreationInfoPerso(da:String, prenom:String, nom:String, courriel:String){
        Modele.daInfoPerso = da
        Modele.prenomInfoPerso = prenom
        Modele.nomInfoPerso = nom
        Modele.courrielInfoPerso = courriel
    }

    fun effectuerNaviguationCalendrier() {
        vue.naviguerVerspage_calendrier()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerVersmenu_principal()
    }

    fun effectuerNaviguationPageConfirmation() {
        vue.naviguerVerspage_confirmation()
    }
}