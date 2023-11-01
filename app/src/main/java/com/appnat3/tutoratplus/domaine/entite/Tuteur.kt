package com.appnat3.tutoratplus.domaine.entite

class Tuteur(val nom:String, val programme:String, val motDePasse:String) {


    override fun toString(): String {
        return "$nom"
    }
}