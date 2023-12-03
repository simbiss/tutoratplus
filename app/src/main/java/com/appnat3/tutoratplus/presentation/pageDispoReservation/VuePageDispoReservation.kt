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
    lateinit var navController: NavController
    lateinit var liste_des_dispo: ListView
    lateinit var nomTuteurSelectionnee:TextView
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

        nomTuteurSelectionnee = vue.findViewById(R.id.nomTuteurDispo)
        nomTuteurSelectionnee.text = présentateur?.traiterAffichageTuteurselectionner()

        liste_des_dispo = vue.findViewById(R.id.liste_dispo)
        liste_des_dispo.setOnItemClickListener{ parent, view, position, id ->
            val dispoSelectionnee = adapter.getItem(position)

            if(dispoSelectionnee != null){
                présentateur?.recuporationDispoSelectionne(dispoSelectionnee)
            }
            // navigation ...  A termier et implementation de la liste a TERMINER !!!!!!!!!!!!
        }
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)          // Obtient le NavController pour la navigation
        initialiserListeDispoTuteurSelectionnee(présentateur?.traiterAffichageDispoTuteurSelectionnee()!!)
    }

    override fun initialiserListeDispoTuteurSelectionnee(liste : List<DispoTuteur>){
        adapter = ArrayAdapter<DispoTuteur>(requireContext(),android.R.layout.simple_list_item_1,liste )
        this.liste_des_dispo.setAdapter(adapter)
    }

    fun navigerVersmenu_Principal(){
        navController.navigate(R.id.action_page_dispo_reservation_to_menu_principal)
    }

    fun navigerVersinformation_personnelle(){
        navController.navigate(R.id.action_page_dispo_reservation_to_informationPersonnlle)
    }




}