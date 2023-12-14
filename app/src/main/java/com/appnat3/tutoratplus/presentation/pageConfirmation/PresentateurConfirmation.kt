package com.appnat3.tutoratplus.presentation.pageConfirmation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.domaine.entite.InfoPersonnelle
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageConfirmation.IContractVuePresentateurConfirmation.IPresentateurConfirmation

class PresentateurConfirmation(var vue: VueConfirmation) : IPresentateurConfirmation{

    val modele = Modele.Companion


    /**
     * Méthode qui permet de retourner les choisies de l'utilisateur
     */

    override fun collectionCoursSelectionnee(): Cours {
        return modele.coursSelectionne!!
    }
    override fun collectionTuteurSelectionnee(): Tuteur {
        return modele.tuteurSelectionne!!
    }

    override fun collectionInfoPerso():InfoPersonnelle{
        val infoPerso = InfoPersonnelle(modele.daInfoPerso!!, modele.prenomInfoPerso!!, modele.nomInfoPerso!!, modele.courrielInfoPerso!!)
        return infoPerso
    }

    override fun collectionReservationDispo():DispoTuteur{
        return modele.dispoSelectionnee!!
    }

    /**
     * Méthode qui permet d'ajouter la demande de tutorat dans le calendrier local
     */

    override fun traiterAjoutEvenementCalendrier(){

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