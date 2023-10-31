package com.appnat3.tutoratplus.presentation.listeTuteur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R

class VueListeTuteurs  : Fragment() {
    var présentateur: PresentateurListeTuteur? = null
    lateinit var btnSuivant: Button
    lateinit var btnRetour: Button
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_liste_tuteur, container, false)
        présentateur = PresentateurListeTuteur(this)

        btnRetour = vue.findViewById(R.id.btn_retour_tuteur)
        btnRetour.setOnClickListener {
            présentateur!!.effectuerNavigationCours()
        }

        btnSuivant = vue.findViewById(R.id.btn_suivant_tuteur)
        btnSuivant.setOnClickListener {
            présentateur!!.effectuerNavigationCalendrier()
        }
        return vue

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)

    }

    fun navigationVersCalendrier() {
        navController.navigate(R.id.action_liste_tuteur_to_page_calendrier)
    }

    fun navigationVersListeCours(){
        navController.navigate(R.id.action_liste_tuteur_to_liste_des_cours)
    }


}