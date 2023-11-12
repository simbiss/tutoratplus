package com.appnat3.tutoratplus.domaine.entite

import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class Disponibilites(val date: LocalDate, val heures: MutableList<LocalTime> = MutableList(4) { LocalTime.NOON }) {

    override fun toString(): String {

        return date.toString()
    }

}