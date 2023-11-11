package com.appnat3.tutoratplus.domaine.entite

class Tuteur(val nom:String, val programme:String, val motDePasse:String, val disponibilites: Disponibilites) {


    override fun toString(): String {
        return "$nom"
    }
}