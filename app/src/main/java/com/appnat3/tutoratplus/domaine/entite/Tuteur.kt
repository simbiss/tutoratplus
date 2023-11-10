package com.appnat3.tutoratplus.domaine.entite

class Tuteur(val id: Int, val nomTuteur:String, val programme:String, /** val loginInfo : InfoLogin*/) {




    override fun toString(): String {
        return "$nomTuteur"
    }
}