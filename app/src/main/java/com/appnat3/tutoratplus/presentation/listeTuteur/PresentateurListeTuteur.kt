package com.appnat3.tutoratplus.presentation.listeTuteur

import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PresentateurListeTuteur(var vue: VueListeTuteurs):
    IContractVuePresentateurListeTuteur.IPresentateurListeTuteur {
    //Déclaration de variables------------------------------------
    val modele = Modele.Companion
    private var job: Job? = null
    var listeTuteurs = arrayOf<Tuteur>()

    override suspend fun traiterListeTuteurs():Array<Tuteur>{
        for(tuteur in modele.retourListeTuteur()) {
            if (tuteur.programme == modele.coursSelectionne?.programme)
                listeTuteurs += tuteur
        }
        return listeTuteurs
    }

    override fun recuperationTuteur(item:Tuteur){
        modele.tuteurSelectionne = item
    }

    override fun traiter_affichageListeTuteur() {

        job = CoroutineScope( Dispatchers.IO ).launch {
            listeTuteurs = traiterListeTuteurs()
            CoroutineScope( Dispatchers.Main ).launch {
                vue.initialiserListeTuteurs(listeTuteurs)
            }
        }
    }

    fun effectuerNavigationCours(){
        vue.navigationVersListeCours()
    }

    fun effectuerNavigationCalendrier(){
        vue.navigationVersCalendrier()
    }

    fun effectuerNavigationAccueil(){
        vue.navigationVersAcceuil()
    }

    fun effectuerNavigationListeDispoTuteur(){
        vue.navigationVersListeDispoTuteur()
    }
}