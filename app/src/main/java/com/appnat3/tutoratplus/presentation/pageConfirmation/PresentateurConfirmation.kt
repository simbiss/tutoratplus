package com.appnat3.tutoratplus.presentation.pageConfirmation

import com.appnat3.tutoratplus.presentation.Modele

class PresentateurConfirmation(var vue: VueConfirmation) {



    /**
     * Méthode qui permet de retourner les choisies de l'utilisateur
     */

    fun collectionDaInfoPerso():String?{
        return Modele.retourDaInfoPerso()
    }
    fun collectionPrenomInfoPerso(): String?{
        return Modele.retourPrenomInfoPerso()
    }
    fun collectionNomInfoPerso():String?{
        return Modele.retourNomInfoPerso()
    }
    fun collectionCourrielInfoPerso():String?{
        return Modele.retourCourrielInfoPerso()
    }

    /**
     * Méthode qui permet de rediriger vers d'autre page
     *
     */
    fun effectuerNaviguationMenuConfirmation() {
        vue.naviguerversmenu_principal()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerversacceuil()
    }

    fun effectuerNaviguationInformationPersonnelle() {
        vue.naviguerversinformation_personnelle()
    }

}