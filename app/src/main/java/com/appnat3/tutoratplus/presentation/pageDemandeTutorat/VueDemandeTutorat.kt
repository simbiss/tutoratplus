package com.appnat3.tutoratplus.presentation.pageDemandeTutorat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_demande_tutorat, container, false)
        présentateur = PresentateurDemandeTutorat(this)

        listeDemandeTutorat = vue.findViewById(R.id.listeDemandeTutorat)

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initialiserListeDemandeTuteur(présentateur?.traiterListeTuteur())

    }

    fun initialiserListeDemandeTuteur(liste: List<DemandeTutorat>?){
        adapter = ArrayAdapter<DemandeTutorat>(requireContext(), android.R.layout.simple_list_item_1, liste!!)
        this.listeDemandeTutorat.setAdapter(adapter)
    }
}