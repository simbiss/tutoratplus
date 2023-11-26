package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.PresentateurPagePrincipalTuteur
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.VuePagePrincipalTuteur
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class PresentateurPagePrincipalTuteurTest {

    @Test
    fun `étant donné un présentateur nouvellement instancié, lorsqu'on ce connecte dans le compte de "Mohamed Fatene", on obtient le nom la classe Tuteur() de "Mohamed Fatene"`(){
        val mockVue = Mockito.mock(VuePagePrincipalTuteur::class.java)
        val presentateur = PresentateurPagePrincipalTuteur(mockVue)
        val tuteurAttandu = Tuteur(1,"Mohamed Fatene", "programmation", arrayOf())
        val modele = Modele.Companion
        modele.ouvertureSessionTuteur = Tuteur(1,"Mohamed Fatene", "programmation", arrayOf())
        //prévoit l'entrée à saisir
        val tuteurObtenu = presentateur.traiderNomTuteurLogger()

        //appel de la méthode à tester
        Assert.assertEquals(tuteurAttandu.nomTuteur, tuteurObtenu?.nomTuteur )
    }
}