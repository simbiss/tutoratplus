package com.appnat3.tutoratplus.presentation.pageCalendrier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R

class PageCalendrier: Fragment() {
    //Déclaration de variables
    lateinit var navController: NavController
    lateinit var btnSuivant: Button
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

        /*calendarView = vue.findViewById(R.id.calendar)
        myDate = vue.findViewById(R.id.textDate)
        calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener() {
            override fun onSelectedDayChange(@NonNull CalendarView CalendarView, int i1, int i2) {

            }
        })*/

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