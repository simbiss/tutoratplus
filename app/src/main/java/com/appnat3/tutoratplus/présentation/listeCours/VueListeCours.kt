package com.appnat3.tutoratplus.présentation.listeCours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.domaine.entité.Cours
import com.appnat3.tutoratplus.présentation.listeCours.IContractVuePresentateurListeCours.IVueListeCours


class VueListeCours : Fragment(), IVueListeCours{
    //Déclaration de variables
    var présentateur: PrésentateurListeCours? = null
    lateinit var liste_des_cours: ListView
    lateinit var navController: NavController
    lateinit var btnSuivant: Button
    lateinit var btnRetour: Button
    lateinit var adapter: ArrayAdapter<Cours>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_liste_des_cours, container, false)
        liste_des_cours = vue.findViewById(R.id.liste_des_cours)
        liste_des_cours.setOnItemClickListener { parent, view, position, id -> présentateur!!.effectuerNavigationTuteur() }
        présentateur = PrésentateurListeCours(this)
        btnRetour = vue.findViewById(R.id.btn_retour_cours)
        btnRetour.setOnClickListener {
            présentateur!!.effectuerNavigationMenu()
        }
        btnSuivant = vue.findViewById(R.id.btn_suivant_cours)
        btnSuivant.setOnClickListener {
            présentateur!!.effectuerNavigationTuteur()
        }
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
        initialiserListeCours(présentateur?.traiterListeCours())
    }

    override fun initialiserListeCours(liste: Array<Cours>?){
        adapter = ArrayAdapter<Cours>(requireContext(), android.R.layout.simple_list_item_1, liste!!)
        this.liste_des_cours.setAdapter(adapter)
    }

    fun naviguerVersmenu_principal() {
        navController.navigate(R.id.action_informationPersonnlle_to_menu_principal2)
    }

    fun naviguerVersTuteurs() {
        navController.navigate(R.id.action_liste_des_cours_to_liste_tuteur)
    }




}
