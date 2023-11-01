package com.appnat3.tutoratplus.presentation.listeTuteur

import com.appnat3.tutoratplus.domaine.entité.Tuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurListeTuteur(var vue: VueListeTuteurs){

    var listeTuteurs = arrayOf<Tuteur>()

    fun traiterListeTuteurs():Array<Tuteur>{
        for(tuteur in Modele.retourListeTuteur()) {
            if (tuteur.programme == Modele.coursSelectionne?.programme)
                listeTuteurs += tuteur
        }
        return listeTuteurs
    }

    fun recuperationTuteur(item:Tuteur){
        Modele.tuteurSelectionne = item
    }

    fun effectuerNavigationCours(){
        vue.navigationVersListeCours()
    }

    fun effectuerNavigationCalendrier(){
        vue.navigationVersCalendrier()
    }

}