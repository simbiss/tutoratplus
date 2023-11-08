package com.appnat3.tutoratplus.domaine.entite

import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class Disponibilites(val date: LocalDate, val heures: MutableList<LocalTime>) {

    override fun toString(): String {

        return date.toString()
    }

}