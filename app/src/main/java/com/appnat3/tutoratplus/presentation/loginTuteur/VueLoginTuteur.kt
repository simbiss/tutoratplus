package com.appnat3.tutoratplus.presentation.loginTuteur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.listeTuteur.PresentateurListeTuteur

class VueLoginTuteur : Fragment() {
    var présentateur: PresentateurLoginTuteur? = null
    lateinit var navController: NavController
    lateinit var btnConnection : Button
    lateinit var mesgErreur : TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_login_tuteur, container, false)
        mesgErreur = vue.findViewById(R.id.msgErreurEntre)
        btnConnection = vue.findViewById(R.id.btnLogin)

        return vue

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation

    }

    fun collectInformationLogin(vue :View){
        btnConnection.setOnClickListener {
            var username = vue.findViewById<EditText>(R.id.entreeUsername)
            var motDePasse = vue.findViewById<EditText>(R.id.entreePassword)

            var txtUsername = username.text.toString()
            var txtMotDePasse = motDePasse.text.toString()

            if(présentateur?.traiterValidationInfoLogin(txtUsername,txtMotDePasse ) == true){
                // NAVIGATION VERS PAGE PRINCIPAL TUTEUR !!!!!!!!!!!!!!!!!!!!!!!!
            }else{
                mesgErreur.error = "Nom d'utilisateur / Mot de passe invalide "
            }

        }

    }
}