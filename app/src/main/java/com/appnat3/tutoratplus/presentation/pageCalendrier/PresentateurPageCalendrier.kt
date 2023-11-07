package com.appnat3.tutoratplus.presentation.pageCalendrier

import com.appnat3.tutoratplus.presentation.Modele


class PresentateurPageCalendrier (var vue: PageCalendrier) {
    fun effectuerNaviguationInformationPersonnelle() {
        vue.naviguerVerspagesInfosPersonnelle()
    }

    fun effectuerNaviguationlisteTuteurs() {
        vue.naviguerVersliste_tuteurs()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerVersmenu()
    }

    fun traiterAjoutdelaDate(selectedDate: String) {
        Modele.dateSelected = selectedDate
    }
}