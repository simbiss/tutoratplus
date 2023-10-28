package com.appnat3.tutoratplus.présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.présentation.présentateur.PrésentateurMenu


class menu_principal : Fragment() {
    //Déclaration de variables
    lateinit var navController: NavController
    lateinit var btnPriseRendezVous: Button
    lateinit var btnApropos: Button
    var présentateur = PrésentateurMenu(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue =  inflater.inflate(R.layout.fragment_menu_principal, container, false)

        btnPriseRendezVous = vue.findViewById(R.id.btn_reservation)
        btnPriseRendezVous.setOnClickListener {
            présentateur.effectuerNavigationChoixCours()
        }

        btnApropos = vue.findViewById(R.id.btn_a_propos)
        btnApropos.setOnClickListener {
            présentateur.effectuerNavigationPageInformation()
        }

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }

    fun naviguerVersliste_des_cours() {
        navController.navigate(R.id.action_menu_principal2_to_liste_des_cours)
    }

    fun naviguerVerspage_information() {
        navController.navigate(R.id.action_menu_principal2_to_page_information)
    }

}