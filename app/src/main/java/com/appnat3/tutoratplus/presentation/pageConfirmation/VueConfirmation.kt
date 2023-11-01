package com.appnat3.tutoratplus.presentation.pageConfirmation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.informationPersonnelle.PresentateurInfosPersonnelle

class VueConfirmation : Fragment(){

    lateinit var txtNomCours: TextView
    lateinit var navController: NavController
    lateinit var txtNomTuteur: TextView
    lateinit var txtDate: TextView

    lateinit var btnAjoutCalendrier: Button
    lateinit var btnAcceuil: TextView
    lateinit var btnRetour: LinearLayout
    var présentateur = PresentateurConfirmation(this)

    lateinit var txtDA: TextView
    lateinit var txtPrenom: TextView
    lateinit var txtNom: TextView
    lateinit var txtCourriel: TextView


    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_confirmation, container, false)

        btnAjoutCalendrier = vue.findViewById(R.id.buttonContinuer)
        btnAjoutCalendrier.setOnClickListener {
            présentateur.effectuerNaviguationMenuConfirmation()
        }

        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur.effectuerNaviguationAcceuil()
        }
        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur.effectuerNaviguationInformationPersonnelle()
        }


        txtNomCours = vue.findViewById(R.id.champNomCours)
        // Accédez à la VueListeCours parente pour obtenir le présentateur et le cours sélectionné

        val coursSelectionne = Modele.coursSelectionne
        if (coursSelectionne != null) {
            txtNomCours.text = "Cours sélectionné : ${coursSelectionne.nomCours}"
        } else {
            txtNomCours.text = "Aucun cours sélectionné"
        }

        txtNomTuteur = vue.findViewById(R.id.champNomTuteur)
        val tuteurSelectionne = Modele.tuteurSelectionne
        if(tuteurSelectionne!= null){
            txtNomTuteur.text = "Tuteur sélectionné : ${tuteurSelectionne.nom}"
        }else{
            txtNomCours.text = "Aucun tuteur sélectionné"
        }

        txtDA = vue.findViewById(R.id.champDAConfirmation)
        val daInfoPerso = Modele.daInfoPerso
        if (daInfoPerso != null) {
            txtDA.text = "DA : $daInfoPerso"
        } else {
            txtDA.text = "Aucun DA entrez"
        }
        txtPrenom = vue.findViewById(R.id.champPrenomConfirmation)
        val prenomInfoPerso = Modele.prenomInfoPerso
        if (prenomInfoPerso != null) {
            txtPrenom.text = "DA : $prenomInfoPerso"
        } else {
            txtPrenom.text = "Aucun prenom entrez"
        }
        txtNom = vue.findViewById(R.id.champNomConfirmation)
        val nomInfoPerso = Modele.nomInfoPerso
        if (nomInfoPerso != null) {
            txtNom.text = "DA : $nomInfoPerso"
        } else {
            txtNom.text = "Aucun nom entrez"
        }
        txtCourriel = vue.findViewById(R.id.champCourrielConfirmation)
        val courrielInfoPerso = Modele.courrielInfoPerso
        if (courrielInfoPerso != null) {
            txtCourriel.text = "Courriel : $courrielInfoPerso"
        } else {
            txtCourriel.text = "Aucun courriel entrez"
        }


        return vue
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }

    fun naviguerversmenu_principal() {
        navController.navigate(R.id.action_page_confirmation_to_menu_principal)
    }

    fun naviguerversacceuil() {
        navController.navigate(R.id.action_page_confirmation_to_menu_principal)
    }

    fun naviguerversinformation_personnelle() {
        navController.navigate(R.id.action_page_confirmation_to_informationPersonnlle4)
    }
}