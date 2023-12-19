package com.appnat3.tutoratplus.domaine.entite

class DemandeTutorat (val infoEleve: InfoPersonnelle, val tuteurChoisi:Tuteur, val date: DispoTuteur ){

    override fun toString(): String {
        return "$infoEleve \n$date"
    }
}