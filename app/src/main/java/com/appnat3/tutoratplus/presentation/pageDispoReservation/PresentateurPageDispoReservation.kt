package com.appnat3.tutoratplus.presentation.pageDispoReservation

import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageDispoReservation.IContractVuePresentateurPageDispoReservation.IPresentateurPageDispoReservation
import kotlinx.coroutines.Job

class PresentateurPageDispoReservation(var vue : VuePageDispoReservation): IPresentateurPageDispoReservation{

    val modele = Modele.Companion
    private var job: Job? = null
    var listeDisponibiliteTuteur = arrayOf<DispoTuteur>()





}