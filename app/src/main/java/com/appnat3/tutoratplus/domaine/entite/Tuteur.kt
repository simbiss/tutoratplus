package com.appnat3.tutoratplus.domaine.entite

class Tuteur(val nomTuteur:String, val nomLogin:String, val programme:String, val motDePasse:String) {


    override fun toString(): String {
        return "$nomTuteur"
    }
}