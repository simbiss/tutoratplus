package com.appnat3.tutoratplus.domaine.entite

class DispoTuteur(val id:Int, val jour: Int, val mois: Int, val annee: Int, val heure: Int, val minute: Int) {

    override fun toString(): String {
        return "Dispo: $jour-$mois-$annee $heure:$minute" //(jj-mm-aaaa hh:mm)
    }
}