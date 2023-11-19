package com.appnat3.tutoratplus.presentation.pageTuteurDispo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.PresentateurPagePrincipalTuteur
import java.util.Calendar
import kotlin.math.min

class VuePageTuteurDispo :Fragment() , DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    var présentateur: PresentateurPageTuteurDispo? = null
    lateinit var navController: NavController
    lateinit var btn_rdv : Button
    lateinit var txt_rdv:TextView

    var jour = 0
    var mois = 0
    var annee = 0
    var heure = 0
    var minute = 0

    var sauvegardeJour = 0
    var sauvegardeMois = 0
    var sauvegardeAnnee = 0
    var sauvegardeHeure = 0
    var sauvegardeMinute = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_tuteur_page_dispo, container, false)
        présentateur = PresentateurPageTuteurDispo(this)
        btn_rdv = vue.findViewById(R.id.btn_choisirDate)
        txt_rdv = vue.findViewById(R.id.txt_tempsChoisi)
        dateChoisi()


        return vue

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation

    }

    fun collectDateChoisi(){
        val cal = Calendar.getInstance()
        jour = cal.get(Calendar.DAY_OF_MONTH)
        mois = cal.get(Calendar.MONTH)
        annee = cal.get(Calendar.YEAR)
        heure = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    fun dateChoisi(){
        btn_rdv.setOnClickListener{
            collectDateChoisi()

            DatePickerDialog( this.requireContext(),this, annee, mois, jour).show()
        }
    }

    override fun onDateSet(view: DatePicker?, annee: Int, mois: Int, jour: Int) {
        sauvegardeAnnee = annee
        sauvegardeMois = mois
        sauvegardeJour = jour

        collectDateChoisi()
        TimePickerDialog(this.requireContext(),this,heure,minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, heure: Int, minute: Int) {

        sauvegardeHeure = heure
        sauvegardeMinute = minute

        txt_rdv.text="$sauvegardeJour-$sauvegardeMois-$sauvegardeAnnee \n Heure: $sauvegardeHeure Minute: $sauvegardeMinute"
    }

    //fun naviguerVersmenu_principal(){}
}