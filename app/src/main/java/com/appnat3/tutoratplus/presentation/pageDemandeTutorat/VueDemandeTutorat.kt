package com.appnat3.tutoratplus.presentation.pageDemandeTutorat

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
import com.appnat3.tutoratplus.domaine.entite.DemandeTutorat
import com.appnat3.tutoratplus.presentation.pageDemandeTutorat.IContractVuePresentateurDemandeTutorat.IVueDemandeTutorat



class VueDemandeTutorat : Fragment(),IVueDemandeTutorat {

    var présentateur: PresentateurDemandeTutorat? = null
    lateinit var adapter: ArrayAdapter<DemandeTutorat>
    lateinit var navController: NavController
    lateinit var listeDemandeTutorat : ListView
    lateinit var btn_retour : LinearLayout
    lateinit var btn_acceuil: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_demande_tutorat, container, false)
        présentateur = PresentateurDemandeTutorat(this)
        btn_retour = vue.findViewById(R.id.buttonRetour)
        btn_retour.setOnClickListener{
            présentateur?.effectuerNavigationPagePrincipalTuteur()
        }

        btn_acceuil = vue.findViewById(R.id.textAcceuil)
        btn_acceuil.setOnClickListener {
            présentateur?.effectuerNaviguationAcceuil()
        }

        listeDemandeTutorat = vue.findViewById(R.id.listeDemandeTutorat)

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initialiserListeDemandeTuteur(présentateur?.traiterListeTuteur())

    }

    override fun initialiserListeDemandeTuteur(liste: List<DemandeTutorat>?){
        adapter = ArrayAdapter<DemandeTutorat>(requireContext(), android.R.layout.simple_list_item_1, liste!!)
        this.listeDemandeTutorat.setAdapter(adapter)
    }

    fun navigationVersAcceuil(){
        navController.navigate(R.id.action_demande_tutorat_to_menu_principal)
    }

    fun navigationVersVersPagePrincipalTuteur() {
        navController.navigate(R.id.action_demande_tutorat_to_page_principal_tuteur)
    }
}