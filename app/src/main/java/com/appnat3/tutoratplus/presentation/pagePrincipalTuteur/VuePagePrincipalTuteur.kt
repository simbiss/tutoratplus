package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.pagePrincipalTuteur.IContractVuePresentateurPagePrincipalTuteur.IVuePagePrincipalTuteur


class VuePagePrincipalTuteur : Fragment(), IVuePagePrincipalTuteur {

    var présentateur: PresentateurPagePrincipalTuteur? = null
    lateinit var navController: NavController
    lateinit var txtNomTuteurLogger: TextView
    lateinit var btn_rdv: Button
    lateinit var btn_demandeTutorat: Button
    lateinit var adapter: ArrayAdapter<String>
    lateinit var listeDispo: ListView
    lateinit var txtDeconnexion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_principal_tuteur, container, false)
        présentateur = PresentateurPagePrincipalTuteur(this)

        listeDispo = vue.findViewById(R.id.listeDispoTuteur)
        txtNomTuteurLogger = vue.findViewById(R.id.afficherNomTuteur)
        val nomTuteurLogger = présentateur!!.traiderNomTuteurLogger()

        btn_rdv = vue.findViewById(R.id.btn_rdv)
        btn_rdv.setOnClickListener {
            présentateur?.effectuerNavigationPageDispo()
        }


        btn_demandeTutorat = vue.findViewById(R.id.btn_demande)
        btn_demandeTutorat.text = "Demande Tutorat (${présentateur?.traiterNbrDemandeTutorat()})"
        btn_demandeTutorat.setOnClickListener {
            présentateur?.effectuerNavigationDemandeTutorat()
        }

        txtDeconnexion = vue.findViewById(R.id.textDeconnexion)
        txtDeconnexion.setOnClickListener {
            présentateur?.effectuerNavigationAcceuil()
        }


        if (nomTuteurLogger != null) {
            txtNomTuteurLogger.text = "Bienvenue : ${nomTuteurLogger.nomTuteur}"
        }else if(nomTuteurLogger == null) {
            txtNomTuteurLogger.text = "null ...$nomTuteurLogger"
        }else {
            txtNomTuteurLogger.text = "Erreur! Tuteur introuvable :/"
        }
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation
        initialiserListeDispo(présentateur?.traiterListeDispo())
    }

    override fun initialiserListeDispo(liste: List<String>?) {
        adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, liste!!)
        this.listeDispo.setAdapter(adapter)
    }



    fun navigationVerstuteur_page_dispo(){
        navController.navigate(R.id.action_page_principal_tuteur_to_tuteur_page_dispo)
    }

    fun navigationVers_demande_tutorat(){
        navController.navigate(R.id.action_page_principal_tuteur_to_demande_tutorat2)
    }

    fun navigationVersAcceuil(){
        navController.navigate(R.id.action_page_principal_tuteur_to_menu_principal)
    }
}