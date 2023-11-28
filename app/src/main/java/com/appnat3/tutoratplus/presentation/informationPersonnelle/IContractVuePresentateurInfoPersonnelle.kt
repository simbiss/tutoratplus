package com.appnat3.tutoratplus.presentation.informationPersonnelle

interface IContractVuePresentateurInfoPersonnelle {

    interface IVueInfoPersonnelle{
    }

    interface IPresentateurInfoPersonnelle{
        fun traiterCreationInfoPerso(da:String, prenom:String, nom:String, courriel:String)
    }
}