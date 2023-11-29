package com.appnat3.tutoratplus.presentation.informationPersonnelle

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat
import com.appnat3.tutoratplus.domaine.entite.InfoPersonnelle
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.informationPersonnelle.IContractVuePresentateurInfoPersonnelle.IPresentateurInfoPersonnelle



class PresentateurInfosPersonnelle(var vue: VueInformationPersonnlle): IPresentateurInfoPersonnelle {


    val modele = Modele.Companion


    @RequiresApi(Build.VERSION_CODES.O)
    override fun traiterCreationInfoPerso(da:String, prenom:String, nom:String, courriel:String){
        modele.daInfoPerso = da
        modele.prenomInfoPerso = prenom
        modele.nomInfoPerso = nom
        modele.courrielInfoPerso = courriel

        var tuteurSelect= modele.tuteurSelectionne
        var infoPersonnelle = InfoPersonnelle(da, prenom, nom, courriel)
        var nouvelleDemande = DemandeTutorat(infoPersonnelle, tuteurSelect!!)
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