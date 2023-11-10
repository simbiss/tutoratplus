package com.appnat3.tutoratplus.presentation.informationPersonnelle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R


class VueInformationPersonnlle : Fragment() {
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
        collectInformationPersonnelle(vue)
        return  vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }


    fun collectInformationPersonnelle(vue:View){
        btnSuivant.setOnClickListener {
            var da = vue.findViewById<EditText>(R.id.champDAInfo)
            var prenom = vue.findViewById<EditText>(R.id.champPrenomInfo)
            var nom = vue.findViewById<EditText>(R.id.champNomInfo)
            var courriel = vue.findViewById<EditText>(R.id.champCourrielInfo)

            var txtDa = da.text.toString()
            var txtprenom = prenom.text.toString()
            var txtnom = nom.text.toString()
            var txtcourriel = courriel.text.toString()

            présentateur.traiterCreationInfoPerso(txtDa, txtprenom, txtnom, txtcourriel)               //ajout des donnees entrez dans la model
            présentateur.effectuerNaviguationPageConfirmation()                     //changement de page vers pageConfirmation

/**
            if(da == ""){
                vue.findViewById<TextInputEditText>(R.id.champDAConfirmation).error = "Invalide"
            }else if(prenom == ""){
                vue.findViewById<TextInputEditText>(R.id.champPrenomConfirmation).error = "Invalide"
            }else if(nom == ""){
                vue.findViewById<TextInputEditText>(R.id.champNomConfirmation).error = "Invalide"
            }else if(courriel == ""){
                vue.findViewById<TextInputEditText>(R.id.champCourrielConfirmation).error = "Invalide"
            }else{
                présentateur?.traiterCreationInfoPerso(da, prenom, nom, courriel)               //ajout des donnees entrez dans la model
                présentateur.effectuerNaviguationPageConfirmation()                     //changement de page vers pageConfirmation
            }*/


        }
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
