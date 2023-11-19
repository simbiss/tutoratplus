package com.appnat3.tutoratplus.presentation.listeCours

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.listeCours.IContractVuePresentateurListeCours.IPresentateurListeCours


class PresentateurListeCours(var vue: VueListeCours): IPresentateurListeCours {

    val modele = Modele.Companion

    var listeCours = arrayOf<Cours>()
    @RequiresApi(Build.VERSION_CODES.O)


    override fun traiterListeCours(): Array<Cours> {
        for (cours in modele.retourListeDesCours()){
            listeCours+=cours
        }
        return listeCours
    }


    // Méthode pour effectuer la navigation vers l'écran menu_principal
    fun effectuerNavigationMenu() {
        vue.naviguerVersmenu_principal()
    }

    // Méthode pour effectuer la navigation vers l'écran de liste des tuteurs
    fun effectuerNavigationTuteur() {
        vue.naviguerVersTuteurs()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun recuperationCours(item:Cours){
        modele.coursSelectionne = item
    }
}