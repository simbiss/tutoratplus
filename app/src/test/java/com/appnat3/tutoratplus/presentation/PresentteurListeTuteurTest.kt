package com.appnat3.tutoratplus.presentation

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.listeTuteur.PresentateurListeTuteur
import com.appnat3.tutoratplus.presentation.listeTuteur.VueListeTuteurs
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PresentteurListeTuteurTest {


    @Test fun `étant donnée un présentateur nouvellement instancié, losqu'on choisi le cours de réseau, on obtient les tuteurs qui font parti du programme de réseau`(){
        //Mise en place
        val mockVue = mock(VueListeTuteurs::class.java)
        val presentateur = PresentateurListeTuteur(mockVue)

        var listeTuteurs = mutableListOf<Tuteur>()
            var tuteur2 = Tuteur(2,"Raphaël Beyrouthy", "reseau", arrayOf())
            var tuteur5 = Tuteur(5,"Antoine Lépine", "reseau", arrayOf())
            listeTuteurs.add(tuteur2)
            listeTuteurs.add(tuteur5)



        val mockModele = mock (Modele.Companion::class.java)
        mockModele.coursSelectionne = Cours("Réseautique", "reseau")
        //Mockito.`when`(mockModele.coursSelectionne).thenReturn(Cours("Réseautique", "reseau"))

        var listeTuteurPresentateur = presentateur.traiterListeTuteurs()

        for (itemListe in listeTuteurPresentateur.indices) {
            assertEquals( listeTuteurs[itemListe], listeTuteurPresentateur[itemListe]
            )
        }
    }

    @Test
    fun `étant donné un présentateur nouvellement instancié, losqu'on choisi le tuteur "Mohamed Fatene" le présentateur prend le choix de selection et le transmet au modèle`(){
        //Mise en place
        val mockVue = mock(VueListeTuteurs::class.java)
        val presentateur = PresentateurListeTuteur(mockVue)
        val modele = Modele.Companion
        val recuperationAttandu = Tuteur(1,"Mohamed Fatene", "programmation", arrayOf())
        var recuperationObtenus :Tuteur? = null

        // Prévoit l'entrée à saisir
        presentateur.recuperationTuteur(Tuteur(1,"Mohamed Fatene", "programmation", arrayOf()))
        recuperationObtenus = modele.tuteurSelectionne

        // Appel de la méthode à tester
        assertEquals(recuperationAttandu.nomTuteur, recuperationObtenus?.nomTuteur)

    }



}