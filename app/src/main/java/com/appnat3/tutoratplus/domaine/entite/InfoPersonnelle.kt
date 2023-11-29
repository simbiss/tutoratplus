package com.appnat3.tutoratplus.domaine.entite

class InfoPersonnelle(val da:String, val prenom:String, val nom:String, val courriel:String) {

    override fun toString(): String {
        return " DA: $da \n Nom Élève: $prenom $nom \n courriel: $courriel"
    }
}