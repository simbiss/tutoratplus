package com.appnat3.tutoratplus.presentation.pageCalendrier

import com.appnat3.tutoratplus.presentation.Modele
import java.time.LocalDate


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

    fun traiterAjoutdelaDate(selectedDate: LocalDate) {
        Modele.dateSelected = selectedDate
    }

    fun retournerNomTuteur() : String{
        val tuteurSelectionne = Modele.tuteurSelectionne
        if(tuteurSelectionne!= null){
            return "Tuteur sélectionné : ${tuteurSelectionne.nom}"
        }else{
            return "Aucun tuteur sélectionné"
        }
    }
}