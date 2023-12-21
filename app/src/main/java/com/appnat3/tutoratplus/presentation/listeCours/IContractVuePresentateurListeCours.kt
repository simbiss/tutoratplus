package com.appnat3.tutoratplus.presentation.listeCours

import com.appnat3.tutoratplus.domaine.entite.Cours

interface IContractVuePresentateurListeCours {
    interface IVueListeCours{
           fun initialiserListeCours(liste: Array<Cours>?)
           fun afficherErreur(message: String)
    }

    interface IPresentateurListeCours{
        suspend fun traiterListeCours():Array<Cours>
        fun recuperationCours(item:Cours)
        fun traiter_démarrage()
    }
}