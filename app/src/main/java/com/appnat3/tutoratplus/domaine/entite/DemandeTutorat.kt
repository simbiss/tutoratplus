package com.appnat3.tutoratplus.domaine.entite

class DemandeTutorat (val infoEleve: InfoPersonnelle, val tuteurChoisi:Tuteur ){

    override fun toString(): String {
        return "$infoEleve"
    }
}