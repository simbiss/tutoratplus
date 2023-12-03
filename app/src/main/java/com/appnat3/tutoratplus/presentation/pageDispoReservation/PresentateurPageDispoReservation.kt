package com.appnat3.tutoratplus.presentation.pageDispoReservation

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageDispoReservation.IContractVuePresentateurPageDispoReservation.IPresentateurPageDispoReservation
import kotlinx.coroutines.Job

class PresentateurPageDispoReservation(var vue : VuePageDispoReservation): IPresentateurPageDispoReservation{

    val modele = Modele.Companion
    private var job: Job? = null
    var listeDisponibiliteTuteurSelectionnee = arrayListOf<DispoTuteur>()

    override fun traiterAffichageTuteurselectionner(): String {
        val tuteurSelectionnee = modele.tuteurSelectionne
        return tuteurSelectionnee!!.nomTuteur
    }

    fun traiterAffichageDispoTuteurSelectionnee(): List<DispoTuteur> {
        var idTuteur = modele.tuteurSelectionne?.id
        for(item in modele.listeDispoTuteur){
            if (item.idTuteur == idTuteur){
                listeDisponibiliteTuteurSelectionnee+=item
            }
        }
        return listeDisponibiliteTuteurSelectionnee
    }

    override fun recuporationDispoSelectionne(item:DispoTuteur){
        modele.dispoSelectionnee = item
    }


}