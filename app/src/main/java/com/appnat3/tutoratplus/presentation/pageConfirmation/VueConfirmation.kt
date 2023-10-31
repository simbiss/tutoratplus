package com.appnat3.tutoratplus.presentation.pageConfirmation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.Modele

class VueConfirmation : Fragment(){

    lateinit var txtNomCours: TextView
    lateinit var txtNomTuteur: TextView
    lateinit var txtDate: TextView
    var presentateur: PresentateurConfirmation? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_confirmation, container, false)

        txtNomCours = vue.findViewById(R.id.champNomCours)
        txtNomTuteur = vue.findViewById(R.id.champNomTuteur)




        // Accédez à la VueListeCours parente pour obtenir le présentateur et le cours sélectionné
        val coursSélectionné = Modele.coursSelectionne

        if (coursSélectionné != null) {
            txtNomCours.text = "Cours sélectionné : ${coursSélectionné.nomCours}"
        } else {
            txtNomCours.text = "Aucun cours sélectionné"
        }
        return vue
    }
}