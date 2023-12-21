package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.Tuteur

interface IContractVuePresentateurPagePrincipalTuteur {

    interface IVuePagePrincipalTuteur{
        fun initialiserListeDispo(liste: List<String>?)
    }

    interface IPresentateurPagePrincipalTuteur{
        fun traiderNomTuteurLogger(): Tuteur?
        fun traiterListeDispo():List<String>
        fun traiterNbrDemandeTutorat():Int
    }
}