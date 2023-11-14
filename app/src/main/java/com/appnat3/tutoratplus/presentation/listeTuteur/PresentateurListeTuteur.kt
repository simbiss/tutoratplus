package com.appnat3.tutoratplus.presentation.listeTuteur

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurListeTuteur(var vue: VueListeTuteurs){

    @RequiresApi(Build.VERSION_CODES.O)
    private val modele = Modele()
    var listeTuteurs = arrayOf<Tuteur>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun traiterListeTuteurs():Array<Tuteur>{
        for(tuteur in modele.retourListeTuteur()) {
            if (tuteur.programme == modele.coursSelectionne?.programme)
                listeTuteurs += tuteur
        }
        return listeTuteurs
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun recuperationTuteur(item:Tuteur){
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