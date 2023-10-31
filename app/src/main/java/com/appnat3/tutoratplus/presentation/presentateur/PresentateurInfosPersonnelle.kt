package com.appnat3.tutoratplus.presentation.presentateur

import com.appnat3.tutoratplus.presentation.vue.InformationPersonnlle


class PresentateurInfosPersonnelle(var vue: InformationPersonnlle) {
    fun effectuerNaviguationCalendrier() {
        vue.naviguerVerspage_calendrier()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerVerspage_confirmation()
    }
}