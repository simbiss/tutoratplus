package com.appnat3.tutoratplus.presentation.pageCalendrier

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R

class PageCalendrier: Fragment() {
    //Déclaration de variables
    lateinit var navController: NavController
    lateinit var btnSuivant: Button
    lateinit var btnDisponibilite1: Button
    lateinit var btnDisponibilite2: Button
    lateinit var btnDisponibilite3: Button
    lateinit var btnRetour: LinearLayout
    lateinit var btnAcceuil: TextView
    lateinit var calendarView: CalendarView
    lateinit var myDate: TextView

    var présentateur = PresentateurPageCalendrier(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_calendrier, container, false)

        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur.effectuerNaviguationlisteTuteurs()
        }


        btnDisponibilite1 = vue.findViewById(R.id.buttonDisponibilite1)
        btnDisponibilite2 = vue.findViewById(R.id.buttonDisponibilite2)
        btnDisponibilite3 = vue.findViewById(R.id.buttonDisponibilite3)

        calendarView = vue.findViewById(R.id.calendar)
        myDate = vue.findViewById(R.id.textDate)
        collectdateRendezVous()


        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur.effectuerNaviguationAcceuil()
        }

        btnSuivant = vue.findViewById(R.id.buttonContinuer)
        btnSuivant.setOnClickListener {
            présentateur.effectuerNaviguationInformationPersonnelle()
        }
        return  vue
    }

    fun collectdateRendezVous(){
        //Après une action
            //Chercher le composant
            //Obtenir texte du composant
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            myDate.text = selectedDate

            //Ajouter le texte au boutton
            btnDisponibilite1.setText("10:00")
            btnDisponibilite1.setTextColor(Color.WHITE)
            btnDisponibilite1.setBackgroundColor(Color.BLUE)
            btnDisponibilite1.visibility = View.VISIBLE

            btnDisponibilite2.setText("10:30")
            btnDisponibilite2.setTextColor(Color.WHITE)
            btnDisponibilite2.setBackgroundColor(Color.BLUE)
            btnDisponibilite2.visibility = View.VISIBLE

            btnDisponibilite3.setText("11:30")
            btnDisponibilite3.setTextColor(Color.WHITE)
            btnDisponibilite3.setBackgroundColor(Color.BLUE)
            btnDisponibilite3.visibility = View.VISIBLE
            présentateur.traiterAjoutdelaDate(selectedDate)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }




    fun naviguerVerspagesInfosPersonnelle() {
        navController.navigate(R.id.action_pageCalendrier_to_informationPersonnlle)
    }

    fun naviguerVersliste_tuteurs() {
        navController.navigate(R.id.action_pageCalendrier_to_liste_tuteur)
    }

    fun naviguerVersmenu() {
        navController.navigate(R.id.action_pageCalendrier_to_menu_principal)
    }
}