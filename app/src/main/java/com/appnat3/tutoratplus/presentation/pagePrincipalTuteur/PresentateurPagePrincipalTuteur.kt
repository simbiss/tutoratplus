package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurPagePrincipalTuteur(var vue: VuePagePrincipalTuteur, private val modele: Modele){


    fun traiderNomTuteurLogger(): Tuteur? {
        return modele.ouvertureSessionTuteur
    }
    fun testprint():String?{
        return modele.test
    }

}