package com.appnat3.tutoratplus.presentation.pageDemandeTutorat

import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat

interface IContractVuePresentateurDemandeTutorat {

    interface IVueDemandeTutorat{
        fun initialiserListeDemandeTuteur(liste: List<DemandeTutorat>?)
    }

    interface IPresentateurDemandeTutorat{
        fun traiterListeTuteur():List<DemandeTutorat>
    }
}