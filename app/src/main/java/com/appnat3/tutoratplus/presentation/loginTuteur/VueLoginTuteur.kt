package com.appnat3.tutoratplus.presentation.loginTuteur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.listeTuteur.PresentateurListeTuteur

class VueLoginTuteur : Fragment() {
    var présentateur: PresentateurLoginTuteur? = null
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_login_tuteur, container, false)

        return vue

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation

    }
}