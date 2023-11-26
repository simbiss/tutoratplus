package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.presentation.loginTuteur.PresentateurLoginTuteur
import com.appnat3.tutoratplus.presentation.loginTuteur.VueLoginTuteur
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PresentateurLoginTuteurTest {

    @Test
    fun `étant donné un présentateur nouvellement instancié pour une connexion d'un utilisateur, lorsqu'on saisit «mohamed» pour le nom d'utilisateur et «abc1» pour le mot de passe, on obtient la réponse true`() {
        //mise en place
        val mockVue = Mockito.mock(VueLoginTuteur::class.java)
        val presentateur = PresentateurLoginTuteur(mockVue)
        val reponseAttandu = true

        //prévoit l'entrée à saisir
        val reponseObtenu = presentateur.traiterValidationInfoLogin("mohamed", "abc1")

        //appel de la méthode à tester
        assertEquals(reponseAttandu, reponseObtenu)
    }

    @Test
    fun `étant donné un présentateur nouvellement instancié pour une connexion d'un utilisateur, lorsqu'on saisit un nom d'utilisateur et un mot de passe non valide, on obtient la réponse false`() {
        //mise en place
        val mockVue = Mockito.mock(VueLoginTuteur::class.java)
        val presentateur = PresentateurLoginTuteur(mockVue)
        val reponseAttandu = false

        //prévoit l'entrée à saisir
        val reponseObtenu = presentateur.traiterValidationInfoLogin("dini", "web1")

        //appel de la méthode à tester
        assertEquals(reponseAttandu, reponseObtenu)
    }
}