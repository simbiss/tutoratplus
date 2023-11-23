package com.appnat3.tutoratplus.presentation.pageTuteurDispo

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.VuePagePrincipalTuteur

class PresentateurPageTuteurDispo(var vue:VuePageTuteurDispo) {
    val modele= Modele.Companion
    var idTuteurLogger = modele.ouvertureSessionTuteur?.id


    fun recuperationTuteur(jour:Int, mois:Int, annee:Int, heure:Int, minute:Int){
        //modele.jour = jour
        //modele.mois = mois
        //modele.annee = annee
        //modele.heure = heure
        //modele.minute = minute
        modele.listeDispoTuteur.add(DispoTuteur(idTuteurLogger!!, jour,mois,annee,heure,minute))
    }
    fun effectuerNavigationPageTuteur(){
        vue.naviguerVerspage_principal_tuteur()
    }
}



