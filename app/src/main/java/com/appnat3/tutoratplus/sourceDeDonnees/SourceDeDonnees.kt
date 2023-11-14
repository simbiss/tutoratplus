package com.appnat3.tutoratplus.sourceDeDonnees

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur


class SourceDeDonneesException(message:String) : Exception(message){}
interface SourceDeDonnees {

    @Throws(SourceDeDonneesException::class)
    fun obtenirListeDesCours():List<Cours>{
        return obtenirListeDesCours()
    }

    @Throws(SourceDeDonneesException::class)
    fun obtenirListeInfoLogin():List<InfoLogin>{
        return obtenirListeInfoLogin()
    }

    fun obtenirlisteTuteur():List<Tuteur>{
        return obtenirlisteTuteur()
    }




}