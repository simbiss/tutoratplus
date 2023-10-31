package com.appnat3.tutoratplus.présentation.présentateur

import com.appnat3.tutoratplus.présentation.vue.InformationPersonnlle


class PrésentateurInfosPersonnelle(var vue: InformationPersonnlle) {
    fun effectuerNaviguationCalendrier() {
        vue.naviguerVerspage_calendrier()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerVersmenu_principal()
    }
}