package com.appnat3.tutoratplus.presentation.informationPersonnelle

import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat
import com.appnat3.tutoratplus.domaine.entite.InfoPersonnelle
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.informationPersonnelle.IContractVuePresentateurInfoPersonnelle.IPresentateurInfoPersonnelle



class PresentateurInfosPersonnelle(var vue: VueInformationPersonnlle): IPresentateurInfoPersonnelle {

    val modele = Modele.Companion


    override fun traiterCreationInfoPerso(da:String, prenom:String, nom:String, courriel:String){
        modele.daInfoPerso = da
        modele.prenomInfoPerso = prenom
        modele.nomInfoPerso = nom
        modele.courrielInfoPerso = courriel

        val tuteurSelect= modele.tuteurSelectionne
        val infoPersonnelle = InfoPersonnelle(da, prenom, nom, courriel)
        val nouvelleDemande = DemandeTutorat(infoPersonnelle, tuteurSelect!!, modele.dispoSelectionnee!!)
        modele.listeDemandeTutorat.add(nouvelleDemande)
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