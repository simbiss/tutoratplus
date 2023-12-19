package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur

interface IContractVuePresentateurPagePrincipalTuteur {

    interface IVuePagePrincipalTuteur{
        fun initialiserListeDispo(liste: List<DispoTuteur>?)
    }

    interface IPresentateurPagePrincipalTuteur{
        fun traiterListeDispo():List<DispoTuteur>
    }
}