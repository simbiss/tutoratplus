package com.appnat3.tutoratplus.presentation.pageConfirmation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.InfoPersonnelle
import com.appnat3.tutoratplus.domaine.entite.Tuteur

interface IContractVuePresentateurConfirmation {

    interface IVueConfirmation{

    }

    interface IPresentateurConfirmation {
        fun collectionCoursSelectionnee(): Cours
        fun collectionTuteurSelectionnee(): Tuteur
        fun collectionInfoPerso(): InfoPersonnelle
        fun collectionReservationDispo(): DispoTuteur
    }

}