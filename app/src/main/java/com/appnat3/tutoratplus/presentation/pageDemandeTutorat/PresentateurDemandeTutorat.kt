package com.appnat3.tutoratplus.presentation.pageDemandeTutorat

import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageDemandeTutorat.IContractVuePresentateurDemandeTutorat.IPresentateurDemandeTutorat

class PresentateurDemandeTutorat(var vue: VueDemandeTutorat) :IPresentateurDemandeTutorat{

    var modele = Modele.Companion
    var listeDemandeTutorat = mutableListOf<DemandeTutorat>()

    override fun traiterListeTuteur():List<DemandeTutorat>{

        for (item in modele.listeDemandeTutorat){
            if(item.tuteurChoisi == modele.tuteurSelectionne)
                listeDemandeTutorat += item
        }
        return listeDemandeTutorat
    }

    fun effectuerNaviguationAcceuil(){
        vue.navigationVersAcceuil()
    }

    fun effectuerNavigationPagePrincipalTuteur(){
        vue.navigationVersVersPagePrincipalTuteur()
    }

}