package com.appnat3.tutoratplus.presentation.listeTuteur

import com.appnat3.tutoratplus.domaine.entite.Tuteur

interface IContractVuePresentateurListeTuteur {

    interface IVueListeTuteur{
        fun initialiserListeTuteurs(liste: Array<Tuteur>?)
        fun afficherErreur(message: String)
    }

    interface IPresentateurListeTuteur{
         suspend fun traiterListeTuteurs():Array<Tuteur>
        fun recuperationTuteur(item:Tuteur)
        fun traiter_affichageListeTuteur()
    }

}