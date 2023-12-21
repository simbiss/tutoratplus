package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import android.util.Log
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.IContractVuePresentateurPagePrincipalTuteur.IPresentateurPagePrincipalTuteur

class PresentateurPagePrincipalTuteur(var vue: VuePagePrincipalTuteur): IPresentateurPagePrincipalTuteur{
    val modele= Modele.Companion
    private var idTuteurLogger = modele.ouvertureSessionTuteur?.id

    var listeDispoTuteur = arrayListOf<DispoTuteur>()

    override fun traiderNomTuteurLogger(): Tuteur? {
        Log.d("retournTuteurLogger","${modele.ouvertureSessionTuteur}")
        return modele.ouvertureSessionTuteur
    }

    override fun traiterListeDispo():List<DispoTuteur>{
        for (item in modele.listeDispoTuteur){
            if (idTuteurLogger == item.idTuteur){
                listeDispoTuteur+=item
            }
        }
        return listeDispoTuteur
    }

    override fun traiterNbrDemandeTutorat():Int{
        return modele.listeDemandeTutorat.size
    }

    fun effectuerNavigationPageDispo(){
        vue.navigationVerstuteur_page_dispo()
    }

    fun effectuerNavigationDemandeTutorat(){
        vue.navigationVers_demande_tutorat()
    }

}