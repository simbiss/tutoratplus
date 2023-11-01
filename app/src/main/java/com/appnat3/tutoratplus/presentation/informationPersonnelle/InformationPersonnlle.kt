package com.appnat3.tutoratplus.presentation.informationPersonnelle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R


class InformationPersonnlle : Fragment() {
    //Déclaration de variables
    var présentateur = PresentateurInfosPersonnelle(this)
    lateinit var navController: NavController
    lateinit var btnSuivant: Button
    lateinit var btnRetour: LinearLayout
    lateinit var btnAcceuil: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_information_personnlle, container, false)


        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur.effectuerNaviguationCalendrier()
        }

        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur.effectuerNaviguationAcceuil()
        }
        btnSuivant = vue.findViewById(R.id.buttonContinuer)
        btnSuivant.setOnClickListener {
            présentateur.effectuerNaviguationPageConfirmation()
        }
        return  vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }

    fun naviguerVerspage_calendrier() {
       navController.navigate(R.id.action_informationPersonnlle_to_pageCalendrier)
    }

    fun naviguerVerspage_confirmation() {
        navController.navigate(R.id.action_informationPersonnlle_to_page_confirmation)
    }

    fun naviguerVersmenu_principal() {
       navController.navigate(R.id.action_informationPersonnlle_to_menu_principal)
    }

}
