package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.Tuteur

interface IContractVuePresentateurPagePrincipalTuteur {

    interface IVuePagePrincipalTuteur{
        fun initialiserListeDispo(liste: List<DispoTuteur>?)
    }

    interface IPresentateurPagePrincipalTuteur{
        fun traiderNomTuteurLogger(): Tuteur?
        fun traiterListeDispo():List<DispoTuteur>
        fun traiterNbrDemandeTutorat():Int
    }
}