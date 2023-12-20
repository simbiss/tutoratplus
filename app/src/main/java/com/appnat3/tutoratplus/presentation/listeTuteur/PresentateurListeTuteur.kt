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
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                listeTuteurs = traiterListeTuteurs()
                CoroutineScope(Dispatchers.Main).launch {
                    vue.initialiserListeTuteurs(listeTuteurs)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    vue.afficherErreur("Veuillez vérifier votre connection internet")
                }
            }
        }
    }

    fun effectuerNavigationCours(){
        vue.navigationVersListeCours()
    }

    fun effectuerNavigationAccueil(){
        vue.navigationVersAcceuil()
    }

    fun effectuerNavigationListeDispoTuteur(){
        vue.navigationVersListeDispoTuteur()
    }
}