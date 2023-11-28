package com.appnat3.tutoratplus.presentation.pageTuteurDispo

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurPageTuteurDispo(var vue:VuePageTuteurDispo) {
    val modele= Modele.Companion

    fun effectuerNavigationPagePrincipalTuteur() {
        vue.navigationVersPagePrincipalTuteur()
    }

    fun effectuerNavigationAccueil() {
        vue.navigationVersAcceuil()
    }

    var idTuteurLogger = modele.ouvertureSessionTuteur?.id


    fun recuperationTuteur(jour:Int, mois:Int, annee:Int, heure:Int, minute:Int){
        //modele.jour = jour
        //modele.mois = mois
        //modele.annee = annee
        //modele.heure = heure
        //modele.minute = minute
        modele.listeDispoTuteur.add(DispoTuteur(idTuteurLogger!!, jour,mois,annee,heure,minute))
    }

}



