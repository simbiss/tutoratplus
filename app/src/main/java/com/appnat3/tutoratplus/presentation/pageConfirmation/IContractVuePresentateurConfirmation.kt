package com.appnat3.tutoratplus.presentation.pageConfirmation

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime

interface IContractVuePresentateurConfirmation {

    interface IVueConfirmation{}

    interface IPresentateurConfirmation{
        fun collectionDaInfoPerso():String?

        fun collectionPrenomInfoPerso(): String?


}