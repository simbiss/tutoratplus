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
    fun traiterAjoutdelaDate(selectedDate: LocalDate) {
        Modele.dateSelected = selectedDate
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
    fun date_exites(date:LocalDate) : Boolean {
        //Déclaration de variables
        val tuteurSelectionne = Modele.tuteurSelectionne
        val disponibilites = tuteurSelectionne?.disponibilites

        //Traitements-------------

        if (disponibilites != null) {
                /*Si la date selectionne == la date du tuteur*/
            if (date.toString().equals(disponibilites.date.toString())) {
                retournerListesDisposHeuresTuteur(date, disponibilites)
                return true
            }

        }
        return false

    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun retournerListesDisposHeuresTuteur(date: LocalDate, disponibilites:Disponibilites) {
            /*alors pour chaque heure de disponibilités*/
            var cpt = disponibilites.heures.count()
            if(cpt > 0) {
                for(heure in disponibilites.heures) {
                    /*le mettre dans le boutton invisible chaque heure et minutes*/
                    //Ajouter le texte au boutton
                    if (cpt == disponibilites.heures.count()) {
                        vue.btnDisponibilite1.setText(heure.toString())
                        vue.btnDisponibilite1.setTextColor(Color.WHITE)
                        vue.btnDisponibilite1.setBackgroundColor(Color.BLUE)
                        vue.btnDisponibilite1.visibility = View.VISIBLE
                    }
                    else if (cpt == disponibilites.heures.count()-1) {
                        vue.btnDisponibilite2.setText(heure.toString())
                        vue.btnDisponibilite2.setTextColor(Color.WHITE)
                        vue.btnDisponibilite2.setBackgroundColor(Color.BLUE)
                        vue.btnDisponibilite2.visibility = View.VISIBLE
                    }

                    else if (cpt == disponibilites.heures.count()-2) {
                        vue.btnDisponibilite3.setText(heure.toString())
                        vue.btnDisponibilite3.setTextColor(Color.WHITE)
                        vue.btnDisponibilite3.setBackgroundColor(Color.BLUE)
                        vue.btnDisponibilite3.visibility = View.VISIBLE
                    }
                    cpt -= disponibilites.heures.count()
                }
                traiterAjoutdelaDate(date)
            } else {
                vue.txtdisponibiliteVide.setText("Aucune disponibilités")
            }





    }

}