package com.appnat3.tutoratplus.presentation.informationPersonnelle

import com.appnat3.tutoratplus.presentation.informationPersonnelle.InformationPersonnlle


class PresentateurInfosPersonnelle(var vue: InformationPersonnlle) {
    fun effectuerNaviguationCalendrier() {
        vue.naviguerVerspage_calendrier()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerVerspage_confirmation()
    }
}