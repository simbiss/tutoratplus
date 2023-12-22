package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.PresentateurPagePrincipalTuteur
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.VuePagePrincipalTuteur
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito

class PresentateurPagePrincipalTuteurTest {


    @Test
    fun `étant donné un présentateur nouvellement instancié, lorsqu'on ce connecte dans le compte de "Mohamed Fatene", on obtient le nom la classe Tuteur() de "Mohamed Fatene"`(){
        val mockVue = Mockito.mock(VuePagePrincipalTuteur::class.java)
        val presentateur = PresentateurPagePrincipalTuteur(mockVue)
        val tuteurAttandu = Tuteur(1,"Mohamed Fatene", "programmation")
        val modele = Modele.Companion
        modele.ouvertureSessionTuteur = Tuteur(1,"Mohamed Fatene", "programmation")
        //prévoit l'entrée à saisir
        val tuteurObtenu = presentateur.traiderNomTuteurLogger()

        //appel de la méthode à tester
        assertEquals(tuteurAttandu.nomTuteur, tuteurObtenu?.nomTuteur )
    }
}


