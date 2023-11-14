package com.appnat3.tutoratplus.presentation.listeTuteur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.domaine.entite.Tuteur

class VueListeTuteurs  : Fragment() {
    var présentateur: PresentateurListeTuteur? = null
    lateinit var navController: NavController
    lateinit var adapter: ArrayAdapter<Tuteur>
    lateinit var btnAccueil: TextView
    lateinit var btnRetour: LinearLayout
    lateinit var liste_tuteurs: ListView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_liste_tuteur, container, false)
        présentateur = PresentateurListeTuteur(this)

        liste_tuteurs = vue.findViewById(R.id.liste_tuteur)
        liste_tuteurs.setOnItemClickListener { parent, view, position, id ->
            val tuteurSelectionne=adapter.getItem(position)

            présentateur?.effectuerNavigationCalendrier()
            if (tuteurSelectionne != null) {
                présentateur?.recuperationTuteur(tuteurSelectionne)
            }
        }


        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur?.effectuerNavigationCours()
        }

        btnAccueil = vue.findViewById(R.id.textAcceuil)
        btnAccueil.setOnClickListener {
            présentateur?.effectuerNavigationAccueil()
        }
        return vue

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation
        initialiserListeTuteurs(présentateur?.traiterListeTuteurs())        //lister les tuteurs
    }

    fun initialiserListeTuteurs(liste: Array<Tuteur>?){
        adapter = ArrayAdapter<Tuteur>(requireContext(), android.R.layout.simple_list_item_1, liste!!)
        this.liste_tuteurs.setAdapter(adapter)
    }

    fun navigationVersCalendrier() {
        navController.navigate(R.id.action_liste_tuteur_to_pageCalendrier)
    }

    fun navigationVersListeCours(){
        navController.navigate(R.id.action_liste_tuteur_to_liste_des_cours)
    }

    fun navigationVersAcceuil() {
        navController.navigate(R.id.action_liste_tuteur_to_menu_principal)
    }


}