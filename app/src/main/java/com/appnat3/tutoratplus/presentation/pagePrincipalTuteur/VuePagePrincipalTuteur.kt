package com.appnat3.tutoratplus.presentation.pagePrincipalTuteur

import android.graphics.ColorSpace.Model
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.Modele


class VuePagePrincipalTuteur : Fragment() {

    var présentateur: PresentateurPagePrincipalTuteur? = null
    lateinit var navController: NavController
    lateinit var txtNomTuteurLogger: TextView
    val modele:Modele = Modele()



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_principal_tuteur, container, false)
        présentateur = PresentateurPagePrincipalTuteur(this, modele)

        txtNomTuteurLogger = vue.findViewById(R.id.afficherNomTuteur)
        val nomTuteurLogger = présentateur?.traiderNomTuteurLogger()
        if (nomTuteurLogger != null) {
            txtNomTuteurLogger.text = "Bienvenue : $nomTuteurLogger"
        }else if(nomTuteurLogger == null) {
            txtNomTuteurLogger.text = "null  "
        }

        else {
            txtNomTuteurLogger.text = "Erreur! Tuteur introuvable :/"
        }

        return vue

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation

    }

    //fun naviguerVersmenu_principal(){}


}