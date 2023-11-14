package com.appnat3.tutoratplus.presentation.listeTuteur

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurListeTuteur(var vue: VueListeTuteurs, private val modele:Modele):
    IContractVuePresentateurListeTuteur.IPresentateurListeTuteur {

    @RequiresApi(Build.VERSION_CODES.O)

    var listeTuteurs = arrayOf<Tuteur>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun traiterListeTuteurs():Array<Tuteur>{
        for(tuteur in modele.retourListeTuteur()) {
            if (tuteur.programme == modele.coursSelectionne?.programme)
                listeTuteurs += tuteur
        }
        return listeTuteurs
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun recuperationTuteur(item:Tuteur){
        modele.tuteurSelectionne = item
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

}