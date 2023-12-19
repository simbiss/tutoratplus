package com.appnat3.tutoratplus.presentation.pageTuteurDispo

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.presentation.Modele
import kotlinx.coroutines.Job

class PresentateurPageTuteurDispo(var vue:VuePageTuteurDispo) {
    val modele= Modele.Companion
    private var job: Job? = null


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
        modele.listeDispoTuteur.add(DispoTuteur(incrementationIdDispo(),idTuteurLogger!!,false, jour,mois,annee,heure,minute))
    }

    fun traiterEnvoiDispo(){
        modele.envoiDispoTuteur()
    }
}



