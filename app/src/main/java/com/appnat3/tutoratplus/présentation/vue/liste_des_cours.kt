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
import com.appnat3.tutoratplus.présentation.présentateur.PrésentateurListeCours
import com.appnat3.tutoratplus.présentation.présentateur.PrésentateurMenu


class liste_des_cours : Fragment() {
    //Déclaration de variables
    lateinit var navController: NavController
    lateinit var btnSuivant: Button
    lateinit var btnRetour: Button
    var présentateur = PrésentateurListeCours(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_liste_des_cours, container, false)

        btnRetour = vue.findViewById(R.id.btn_retour_cours)
        btnRetour.setOnClickListener {
            présentateur.effectuerNavigationMenu()
        }

        btnSuivant = vue.findViewById(R.id.btn_suivant_cours)
        btnSuivant.setOnClickListener {
            présentateur.effectuerNavigationTuteur()
        }

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }

    fun naviguerVersmenu_principal() {
        navController.navigate(R.id.action_liste_des_cours_to_menu_principal2)
    }

    fun naviguerVersTuteurs() {
        navController.navigate(R.id.action_liste_des_cours_to_menu_principal2)
    }
}
