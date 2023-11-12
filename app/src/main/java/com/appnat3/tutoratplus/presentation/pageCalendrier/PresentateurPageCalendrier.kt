package com.appnat3.tutoratplus.presentation.pageCalendrier

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Disponibilites
import com.appnat3.tutoratplus.presentation.Modele
import java.time.LocalDate
import java.time.LocalTime


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

    @RequiresApi(Build.VERSION_CODES.O)
    fun traiterAjoutdelaDate(selectedDate: LocalDate, p_heureSelectionne:LocalTime) {
        Modele.dateSelected = selectedDate
        Modele.heureSelectionne = p_heureSelectionne
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun retournerNomTuteur() : String{
        val tuteurSelectionne = Modele.tuteurSelectionne
        if(tuteurSelectionne!= null){
            return "Tuteur sélectionné : ${tuteurSelectionne.nom}"
        }else{
            return "Aucun tuteur sélectionné"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun retournerDateTuteur() : LocalDate? {
        val dateTuteur = Modele.tuteurSelectionne?.disponibilites?.date
        return dateTuteur
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun retournerDateDisponibilités(date:LocalDate): MutableList<LocalTime>?{
        //Déclaration de variables
        val tuteurSelectionne = Modele.tuteurSelectionne
        val disponibilites = tuteurSelectionne?.disponibilites
        val listeHeuresTuteurs : MutableList<LocalTime>? = null
        //Traitements-------------

        if (disponibilites != null) {
                /*Si la date selectionne == la date du tuteur*/
            if (date.toString().equals(disponibilites.date.toString())) {
                return disponibilites.heures

            }

        }
        return listeHeuresTuteurs
    }

}