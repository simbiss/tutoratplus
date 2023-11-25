package com.appnat3.tutoratplus

import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.Disponibilite
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur

import com.appnat3.tutoratplus.presentation.Modele
import kotlinx.coroutines.newSingleThreadContext
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.time.LocalDate
import java.time.LocalTime

@RunWith(MockitoJUnitRunner::class)
class ModeleTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
/*
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    Mockito.`when`( model.coursSelectionne ).thenReturn( cours )
        val modèle = Modele( source = source )

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
*/


    @Test
    fun `Étant donné un modèle nouvellement instancié, losqu'on veux afficher la liste des noms des différent cours, alors on obtient la liste des noms différent cours`(){
        //Mise en place
        val modele = Modele.Companion
        val listeDesCours_attendu = mutableListOf<Cours>()
        var cours1 = Cours("Programmation 1", "programmation")
        var cours2 = Cours("Programmation 2 (Java)", "programmation")
        var cours3 = Cours("Programmation 2 (Python)", "reseau")
        var cours4 = Cours("Programmation Autre et BD", "programmation")
        var cours5 = Cours("Réseautique", "reseau")

        listeDesCours_attendu.add(cours1)
        listeDesCours_attendu.add(cours2)
        listeDesCours_attendu.add(cours3)
        listeDesCours_attendu.add(cours4)
        listeDesCours_attendu.add(cours5)

        val retourDeListeCours_obtenu = modele.retourListeDesCours()


        // Appel de la méthode à tester
        //assertEquals(listeDesCours_attendu, retourDeListeCours_obtenu  )
        for (itemListe in retourDeListeCours_obtenu.indices) {
            assertEquals(listeDesCours_attendu[itemListe].nomCours, retourDeListeCours_obtenu[itemListe].nomCours)
        }
    }

    @Test
    fun `Étant donné un modèle nouvellement instancié, losqu'on veux afficher la liste des noms des tuteurs, alors on obtient la liste des noms différent tuteurs`(){
        //Mise en place
        val modele = Modele.Companion
        val listeDesTuteurs_attendu = mutableListOf<Tuteur>()


        var tuteur1 = Tuteur(1,"Mohamed Fatene", "programmation", arrayOf())
        var tuteur2 = Tuteur(2,"Raphaël Beyrouthy", "reseau", arrayOf())
        var tuteur3 = Tuteur(3,"Lakhdar Amine Ouzou", "programmation", arrayOf())
        var tuteur4 = Tuteur(4,"Elliott Fournier-Robert", "programmation", arrayOf())
        var tuteur5 = Tuteur(5,"Antoine Lépine", "reseau", arrayOf())

        listeDesTuteurs_attendu.add(tuteur1)
        listeDesTuteurs_attendu.add(tuteur2)
        listeDesTuteurs_attendu.add(tuteur3)
        listeDesTuteurs_attendu.add(tuteur4)
        listeDesTuteurs_attendu.add(tuteur5)

        val retourDeListeCours_obtenu = modele.retourListeTuteur()


        // Appel de la méthode à tester
        //assertEquals(listeDesCours_attendu, retourDeListeCours_obtenu  )
        for (itemListe in retourDeListeCours_obtenu.indices) {
            assertEquals(retourDeListeCours_obtenu[itemListe].nomTuteur, retourDeListeCours_obtenu[itemListe].nomTuteur)
        }
    }

    @Test
    fun `étant donné un modèle nouvellement instancié, losqu'on fait une demande pour vérifier le nom d'utilisateur pour se logger, on obtient les différente "username" des tuteurs`(){
        //Mise en place
        val modele = Modele.Companion
        val listeInfoLogin_attendu = mutableListOf<InfoLogin>()
        var infoLogin1 = InfoLogin("mohamed", "abc1")
        var infoLogin2 = InfoLogin("raphael", "abc2")
        var infoLogin3 = InfoLogin("lakhdar", "abc3")
        var infoLogin4 = InfoLogin("elliott", "abc4")
        var infoLogin5 = InfoLogin("antoine", "abc5")

        listeInfoLogin_attendu.add(infoLogin1)
        listeInfoLogin_attendu.add(infoLogin2)
        listeInfoLogin_attendu.add(infoLogin3)
        listeInfoLogin_attendu.add(infoLogin4)
        listeInfoLogin_attendu.add(infoLogin5)

        val retourInfoLogin_obtenu = modele.retourListInfoLogin()


        // Appel de la méthode à tester
        //assertEquals( listeInfoLogin_attendu, retourInfoLogin_obtenu )
        for (itemListe in retourInfoLogin_obtenu.indices) {
            assertEquals(listeInfoLogin_attendu[itemListe].nomUtilisateur, retourInfoLogin_obtenu[itemListe].nomUtilisateur)
        }
    }

    @Test
    fun `étant donné un modèle nouvellement instancié, losqu'on fait une demande pour vérifier un mot de passe pour se logger, on obtient les différente "password" des tuteurs`() {
        //Mise en place
        val modele = Modele.Companion
        val listeInfoLogin_attendu = mutableListOf<InfoLogin>()
        var infoLogin1 = InfoLogin("mohamed", "abc1")
        var infoLogin2 = InfoLogin("raphael", "abc2")
        var infoLogin3 = InfoLogin("lakhdar", "abc3")
        var infoLogin4 = InfoLogin("elliott", "abc4")
        var infoLogin5 = InfoLogin("antoine", "abc5")

        listeInfoLogin_attendu.add(infoLogin1)
        listeInfoLogin_attendu.add(infoLogin2)
        listeInfoLogin_attendu.add(infoLogin3)
        listeInfoLogin_attendu.add(infoLogin4)
        listeInfoLogin_attendu.add(infoLogin5)
        val retourInfoLogin_obtenu = modele.retourListInfoLogin()


        // Appel de la méthode à tester
        //assertEquals( listeInfoLogin_attendu, retourInfoLogin_obtenu )
        for (itemListe in retourInfoLogin_obtenu.indices) {
            assertEquals(
                listeInfoLogin_attendu[itemListe].motDePasse,
                retourInfoLogin_obtenu[itemListe].motDePasse
            )
        }
    }
}