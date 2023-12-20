package com.appnat3.tutoratplus.presentation.listeCours

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.listeCours.IContractVuePresentateurListeCours.IPresentateurListeCours
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class PresentateurListeCours(var vue: VueListeCours): IPresentateurListeCours {

    val modele = Modele.Companion
    private var job: Job? = null
    var listeCours = arrayOf<Cours>()


    fun traiter_démarrage(){
        job = CoroutineScope( Dispatchers.IO ).launch {
            try {
                listeCours = traiterListeCours()
                CoroutineScope( Dispatchers.Main ).launch {
                    vue.initialiserListeCours(listeCours)
                }
            }catch (e: Exception){
                CoroutineScope(Dispatchers.Main).launch {
                    vue.afficherErreur( "Erreur de connexion")
                }
            }
        }
    }

    override suspend fun traiterListeCours(): Array<Cours> {
        for (cours in modele.retourListeDesCours()){
            listeCours+=cours
        }
        return listeCours
    }

    override fun recuperationCours(item:Cours){
        modele.coursSelectionne = item
    }

    // Méthode pour effectuer la navigation vers l'écran menu_principal
    fun effectuerNavigationMenu() {
        vue.naviguerVersmenu_principal()
    }

    // Méthode pour effectuer la navigation vers l'écran de liste des tuteurs
    fun effectuerNavigationTuteur() {
        vue.naviguerVersTuteurs()
    }
}