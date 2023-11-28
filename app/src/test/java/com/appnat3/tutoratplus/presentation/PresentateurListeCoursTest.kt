package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.presentation.listeCours.PresentateurListeCours
import com.appnat3.tutoratplus.presentation.listeCours.VueListeCours
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class PresentateurListeCoursTest {

    var listeDesCours = mutableListOf<Cours>()
    init {
        var cours1 = Cours("Programmation 1", "programmation")
        var cours2 = Cours("Programmation 2 (Java)", "programmation")
        var cours3 = Cours("Programmation 2 (Python)", "reseau")
        var cours4 = Cours("Programmation Autre et BD", "programmation")
        var cours5 = Cours("Réseautique", "reseau")
        listeDesCours.add(cours1)
        listeDesCours.add(cours2)
        listeDesCours.add(cours3)
        listeDesCours.add(cours4)
        listeDesCours.add(cours5)
    }

    @Test
    fun `étant donné un présentateur nouvellement instancié, lorsqu'on veux choisir un cours pour faire un demande de tutotat, la liste de cours s'affiche`(){
        //Mise en place
        val mockVue = mock(VueListeCours::class.java)
        val presentateur = PresentateurListeCours(mockVue)

        // Prévoit l'entrée à saisir
        var listeCoursPresentateur = presentateur.traiterListeCours()

        // Appel de la méthode à tester
        for (itemListe in listeCoursPresentateur.indices) {
            assertEquals(listeDesCours[itemListe].nomCours, listeCoursPresentateur[itemListe].nomCours)
        }
    }

    @Test
    fun `étant donné un présentateur nouvellement instancié, losqu'on choisi le cours de programmation 1, le présentateur prend le choix de selection et le transmet au modèle`(){
        //Mise en place
        val mockVue = mock(VueListeCours::class.java)
        val presentateur = PresentateurListeCours(mockVue)
        val modele = Modele.Companion
        val recuperationAttandu = listeDesCours[3]
        var recuperationObtenus :Cours? = null

        // Prévoit l'entrée à saisir
        presentateur.recuperationCours(listeDesCours[3])
        recuperationObtenus = modele.coursSelectionne

        // Appel de la méthode à tester
        assertEquals(recuperationAttandu, recuperationObtenus)

    }

}