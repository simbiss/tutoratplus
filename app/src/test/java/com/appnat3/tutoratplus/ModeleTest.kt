package com.appnat3.tutoratplus
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.sourceDeDonnees.SourceDeDonnees
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import org.junit.After
import org.junit.Test
import java.util.Scanner
import java.io.PrintStream

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before

@RunWith(MockitoJUnitRunner::class)
class ModeleTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
/*
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
*/
    @Test
    fun `Lorsqu'on choisi le cours de Programmation2 alors on btient la liste des tuteurs de ce cours`() {
        // Mise en place

        // Prévoit l'entrée à saisir
        /*
        val source : SourceDeDonnees = Mockito.mock( SourceDeDonnees::class.java )
        Mockito.`when`( source.obtenirlisteTuteur() ).thenReturn(  )
        val modèle = Modele( source = source )

        val pourcentage_données = modele.
        assertEquals( 99, pourcentage_données )
        */


    }
}