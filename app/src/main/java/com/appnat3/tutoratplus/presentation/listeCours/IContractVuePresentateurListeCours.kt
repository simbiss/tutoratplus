package com.appnat3.tutoratplus.presentation.listeCours

import com.appnat3.tutoratplus.domaine.entite.Cours

interface IContractVuePresentateurListeCours {
    interface IVueListeCours{
           fun initialiserListeCours(liste: Array<Cours>?)
    }

    interface IPresentateurListeCours{
        suspend fun traiterListeCours():Array<Cours>


    }
}