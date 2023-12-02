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

    fun incrementationIdDispo(): Int{       //méthode pour donner un le id prochain id disponible a une nouvelle dispo tuteur
        val idSuivant = modele.listeDispoTuteur.size + 1
        return idSuivant
    }

    fun recuperationTuteur(jour:Int, mois:Int, annee:Int, heure:Int, minute:Int){
        val idTuteurLogger = modele.ouvertureSessionTuteur?.id
        modele.listeDispoTuteur.add(DispoTuteur(incrementationIdDispo(),idTuteurLogger!!, jour,mois,annee,heure,minute))
    }

}



