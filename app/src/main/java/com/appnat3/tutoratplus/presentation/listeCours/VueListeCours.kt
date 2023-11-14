package com.appnat3.tutoratplus.presentation.listeCours

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.domaine.entite.Cours
import com.appnat3.tutoratplus.presentation.listeCours.IContractVuePresentateurListeCours.IVueListeCours



class VueListeCours : Fragment(), IVueListeCours{
    //Déclaration de variables
    var présentateur: PresentateurListeCours? = null
    lateinit var liste_des_cours: ListView
    lateinit var navController: NavController
    lateinit var btnAcceuil: TextView
    lateinit var btnRetour: LinearLayout
    lateinit var adapter: ArrayAdapter<Cours>
    lateinit var nomCours: TextView
    lateinit var imgCours: ImageView



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_liste_des_cours, container, false)
        //val vueItem = inflater.inflate(R.layout.element_liste, container, false)
        présentateur = PresentateurListeCours(this, /**Modèle()*/)


        liste_des_cours = vue.findViewById(R.id.liste_des_cours)
        liste_des_cours.setOnItemClickListener {
                parent, view, position, id ->
            val coursSelectionne=adapter.getItem(position)

            présentateur!!.effectuerNavigationTuteur()
            if (coursSelectionne != null) {
                présentateur?.recuperationCours(coursSelectionne)
            }
        }

        //imgCours = vueItem.findViewById(R.id.img_item)
        //nomCours = vueItem.findViewById(R.id.nom_item)

        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur?.effectuerNavigationMenu()
        }

        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur?.effectuerNavigationMenu()
        }
        return vue
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = Navigation.findNavController(view)          // Obtient le NavController pour la navigation
        initialiserListeCours(présentateur?.traiterListeCours())        //lister les cours
    }

    override fun initialiserListeCours(liste: Array<Cours>?){
        adapter = ArrayAdapter<Cours>(requireContext(), android.R.layout.simple_list_item_1, liste!!)
        this.liste_des_cours.setAdapter(adapter)
    }



    fun naviguerVersmenu_principal() {
        navController.navigate(R.id.action_liste_des_cours_menu_principal)
    }

    fun naviguerVersTuteurs() {
        navController.navigate(R.id.action_liste_des_cours_to_liste_tuteur)
    }
}
