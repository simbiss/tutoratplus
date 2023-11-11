package com.appnat3.tutoratplus.presentation.informationPersonnelle

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.informationPersonnelle.InformationPersonnlle


class PresentateurInfosPersonnelle(var vue: InformationPersonnlle) {


    @RequiresApi(Build.VERSION_CODES.O)
    fun traiterCreationInfoPerso(da:String, prenom:String, nom:String, courriel:String){
        Modele.daInfoPerso = da
        Modele.prenomInfoPerso = prenom
        Modele.nomInfoPerso = nom
        Modele.courrielInfoPerso = courriel
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