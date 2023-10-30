package com.appnat3.tutoratplus.présentation

class Cours(val nomCours:String, val programme:String) {

    override fun toString(): String {
        return "\nCours(nomCours='$nomCours', programme='$programme')"
    }
}