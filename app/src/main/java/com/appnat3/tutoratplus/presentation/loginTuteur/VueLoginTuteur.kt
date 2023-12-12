
package com.appnat3.tutoratplus.presentation.loginTuteur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.loginTuteur.IConractVuePresentateurLoginTuteur.IVueLoginTuteur

class VueLoginTuteur : Fragment(), IVueLoginTuteur{
    var présentateur: PresentateurLoginTuteur? = null
    lateinit var navController: NavController
    lateinit var btnAcceuil: TextView
    lateinit var btnRetour: LinearLayout
    lateinit var btnConnection : Button
    lateinit var mesgErreur : TextView
    //val modele = Modele.Companion //singleton - companion object


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_vue_login_tuteur, container, false)
        présentateur = PresentateurLoginTuteur(this)
        mesgErreur = vue.findViewById(R.id.msgErreurEntre)
        btnConnection = vue.findViewById(R.id.btnLogin)
        collectInformationLogin(vue)
        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur?.effectuerNavigationAcceuil()
        }

        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur?.effectuerNavigationAcceuil()
        }
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)              // Obtient le NavController pour la navigation

    }

    fun collectInformationLogin(vue :View){
        btnConnection.setOnClickListener {
            val username = vue.findViewById<EditText>(R.id.entreeUsername).text.toString()
            val motDePasse = vue.findViewById<EditText>(R.id.entreePassword).text.toString()
            présentateur?.traiterCollectInformationLogin(username)                              //ajouter dans le modele le id du tuteur à logger

            val validationResult = présentateur?.traiterValidationInfoLogin(username,motDePasse)        //validation des information login

            if(validationResult == true) {
                présentateur?.effectuerNavigationPageTuteur()
            }
            else{
                mesgErreur.text = "Nom d'utilisateur et/ou mot de passe invalide"
                }
            }
        }

    fun naviguerVersmenu_principal(){
        navController.navigate(R.id.action_vueLoginTuteur_to_menu_principal)
    }

    fun navigationVerspage_principal_tuteur(){
        navController.navigate(R.id.action_vueLoginTuteur_to_page_principal_tuteur)
    }
}
