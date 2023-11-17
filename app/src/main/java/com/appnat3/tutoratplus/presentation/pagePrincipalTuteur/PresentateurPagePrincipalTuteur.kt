package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurPagePrincipalTuteur(var vue: VuePagePrincipalTuteur){
    val modele= Modele.Companion

    fun traiderNomTuteurLogger(): Tuteur? {
        return modele.ouvertureSessionTuteur
    }
    //fun testprint():String?{
    //    return modele.test
    //}
    //fun testHellow():String?{
    //    return modele.testhardCode
    //}

}