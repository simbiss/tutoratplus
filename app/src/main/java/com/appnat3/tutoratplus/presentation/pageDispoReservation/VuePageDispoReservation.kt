package com.appnat3.tutoratplus.presentation.pageDispoReservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.domaine.entite.DispoTuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageDispoReservation.IContractVuePresentateurPageDispoReservation.IVuePageDispoReservation

class VuePageDispoReservation : Fragment(), IVuePageDispoReservation{
    //Déclaration de variables
    var présentateur: PresentateurPageDispoReservation? = null
    val modele = Modele.Companion
    lateinit var liste_des_dispo: ListView
    lateinit var navController: NavController
    lateinit var btnAcceuil: TextView
    lateinit var btnRetour: LinearLayout
    lateinit var adapter: ArrayAdapter<DispoTuteur>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_dispo_reservation, container, false)
        présentateur = PresentateurPageDispoReservation(this)


        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)          // Obtient le NavController pour la navigation
    }


    fun navigerVersmenu_Principal(){
        navController.navigate(R.id.action_page_dispo_reservation_to_menu_principal)
    }

    fun navigerVersinformation_personnelle(){
        navController.navigate(R.id.action_page_dispo_reservation_to_informationPersonnlle)
    }




}