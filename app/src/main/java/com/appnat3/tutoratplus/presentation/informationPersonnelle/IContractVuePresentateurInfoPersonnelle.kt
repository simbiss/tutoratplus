package com.appnat3.tutoratplus.presentation.informationPersonnelle

import android.view.View

interface IContractVuePresentateurInfoPersonnelle {

    interface IVueInfoPersonnelle{
        fun collectInformationPersonnelle(vue: View)
    }

    interface IPresentateurInfoPersonnelle{
        fun traiterCreationInfoPerso(da:String, prenom:String, nom:String, courriel:String)
    }
}