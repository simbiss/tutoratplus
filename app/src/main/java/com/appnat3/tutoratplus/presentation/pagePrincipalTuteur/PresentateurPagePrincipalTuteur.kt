package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurPagePrincipalTuteur(var vue: VuePagePrincipalTuteur){
    val modele= Modele.Companion
    private var idTuteurLogger = modele.ouvertureSessionTuteur?.id

    var listeDispoTuteur = arrayListOf<DispoTuteur>()

    fun traiderNomTuteurLogger(): Tuteur? {
        return modele.ouvertureSessionTuteur
    }

    fun traiderListeDispo():List<DispoTuteur>{
        for (item in modele.listeDispoTuteur){
            if (idTuteurLogger == item.id){
                listeDispoTuteur+=item
            }
        }
        return listeDispoTuteur
    }

    fun effectuerNavigationPageDispo(){
        vue.navigationVerstuteur_page_dispo()
    }

}