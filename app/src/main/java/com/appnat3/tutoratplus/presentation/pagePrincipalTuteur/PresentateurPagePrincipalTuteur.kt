package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.IContractVuePresentateurPagePrincipalTuteur.IPresentateurPagePrincipalTuteur

class PresentateurPagePrincipalTuteur(var vue: VuePagePrincipalTuteur): IPresentateurPagePrincipalTuteur{
    val modele= Modele.Companion
    private var idTuteurLogger = modele.ouvertureSessionTuteur?.id

    var listeDispoTuteur = arrayListOf<DispoTuteur>()

    fun traiderNomTuteurLogger(): Tuteur? {
        return modele.ouvertureSessionTuteur
    }

    override fun traiderListeDispo():List<DispoTuteur>{
        for (item in modele.listeDispoTuteur){
            if (idTuteurLogger == item.idTuteur){
                listeDispoTuteur+=item
            }
        }
        return listeDispoTuteur
    }

    fun effectuerNavigationPageDispo(){
        vue.navigationVerstuteur_page_dispo()
    }

    fun effectuerNavigationDemandeTutorat(){
        vue.navigationVers_demande_tutorat()
    }

}