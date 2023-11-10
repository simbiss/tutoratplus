package com.appnat3.tutoratplus.domaine.entite

class InfoLogin(val nomUtilisateur: String, val motDePasse:String) {

    override fun toString(): String {
        return "$nomUtilisateur $motDePasse"
    }


}