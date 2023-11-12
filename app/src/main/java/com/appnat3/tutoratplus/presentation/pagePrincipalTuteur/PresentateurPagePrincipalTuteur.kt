package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import com.appnat3.tutoratplus.presentation.Modele

class PresentateurPagePrincipalTuteur(var vue: VuePagePrincipalTuteur){


    fun traiderNomTuteurLogger(): String?{
        return Modele.ouvertureSessionTuteur?.nomTuteur
    }

}