package com.appnat3.tutoratplus.presentation.pageDispoReservation

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur

interface IContractVuePresentateurPageDispoReservation {

    interface IVuePageDispoReservation{
        fun initialiserListeDispoTuteurSelectionnee(liste  : List<DispoTuteur>)
    }

    interface IPresentateurPageDispoReservation{
        fun traiterAffichageDispoTuteurSelectionnee(): List<DispoTuteur>
        fun traiterAffichageTuteurselectionner(): String
        fun recuporationDispoSelectionne(item:DispoTuteur)
    }

}