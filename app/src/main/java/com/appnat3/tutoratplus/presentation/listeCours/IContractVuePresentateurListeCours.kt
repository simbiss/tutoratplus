package com.appnat3.tutoratplus.presentation.listeCours

import com.appnat3.tutoratplus.domaine.entité.Cours

interface IContractVuePresentateurListeCours {
    interface IVueListeCours{
        fun initialiserListeCours(liste: Array<Cours>?)
    }

    interface IPresentateurListeCours{
        fun traiterListeCours():Array<Cours>


    }
}