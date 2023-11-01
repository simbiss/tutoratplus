package com.appnat3.tutoratplus.presentation.informationPersonnelle

import com.appnat3.tutoratplus.presentation.informationPersonnelle.InformationPersonnlle


class PresentateurInfosPersonnelle(var vue: InformationPersonnlle) {
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