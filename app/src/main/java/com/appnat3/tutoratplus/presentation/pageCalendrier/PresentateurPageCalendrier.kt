package com.appnat3.tutoratplus.presentation.pageCalendrier

import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageCalendrier.IContractVuePresentateurPageCalendrier.IPresentateurPageCalendrier
import java.time.LocalDate
import java.time.LocalTime



class PresentateurPageCalendrier (var vue: PageCalendrier ): IPresentateurPageCalendrier {


    val modele = Modele.Companion
    fun effectuerNaviguationInformationPersonnelle() {
        vue.naviguerVerspagesInfosPersonnelle()
    }

    fun effectuerNaviguationlisteTuteurs() {
        vue.naviguerVersliste_tuteurs()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerVersmenu()
    }

    fun traiterAjoutdelaDate(selectedDate: LocalDate, p_heureSelectionne:LocalTime) {
        modele.dateSelected = selectedDate
        modele.heureSelectionne = p_heureSelectionne
    }


    fun retournerNomTuteur() : String{
        val tuteurSelectionne = modele.tuteurSelectionne
        if(tuteurSelectionne!= null){
            return "Tuteur sélectionné : ${tuteurSelectionne.nomTuteur}"
        }else{
            return "Aucun tuteur sélectionné"
        }
    }


    fun retournerDateTuteur(date: LocalDate) : LocalDate? {
        //Déclaration de variables
        val listedisponibilitesTuteur = modele.tuteurSelectionne
        var dateRetournee: LocalDate? = null
        //Traitements-------------
        /*Si la date sélectionné fait partie des dates du tuteur*/
        //if (listedisponibilitesTuteur != null) {
        //    for (disponibilite in listedisponibilitesTuteur) {
        //        if (disponibilite.date.equals(date))  {
        //            dateRetournee = date
        //        }
        //    }
        //}
    return dateRetournee
    }


    fun retournerDateDisponibilités(date:LocalDate): MutableList<LocalTime>?{
        //Déclaration de variables
        val tuteurSelectionne = modele.tuteurSelectionne
        val disponibilites = tuteurSelectionne
        var listeHeuresTuteurs : MutableList<LocalTime>? = null
        //Traitements-------------

        //if (disponibilites) {
        //    //Pour chaque disponibilite
        //    for ( disponibilite in disponibilites) {
        //        /*Si la date selectionne == la date du tuteur*/
        //        if (date.toString().equals(disponibilite.date.toString())) {
        //            listeHeuresTuteurs = disponibilite.heures
        //        }
        //    }
        //}
        return listeHeuresTuteurs
    }

}