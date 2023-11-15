package com.appnat3.tutoratplus.presentation
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.domaine.entite.Disponibilite
import com.appnat3.tutoratplus.domaine.entite.Tuteur
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

    Mockito.`when`( model.coursSelectionne ).thenReturn( cours )
        val modèle = Modele( source = source )


    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
*/











}