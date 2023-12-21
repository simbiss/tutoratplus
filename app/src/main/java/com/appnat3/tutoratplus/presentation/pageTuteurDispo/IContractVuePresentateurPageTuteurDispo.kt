package com.appnat3.tutoratplus.presentation.pageTuteurDispo

interface IContractVuePresentateurPageTuteurDispo {

    interface IVuePageTuteurDispo{
        fun collectDateChoisi()
        fun dateChoisi()
    }

    interface IPresentateurPageTuteurDispo{
        fun incrementationIdDispo(): Int
        fun recuperationTuteur(jour:Int, mois:Int, annee:Int, heure:Int, minute:Int)
        fun traiterEnvoiDispo()

    }
}