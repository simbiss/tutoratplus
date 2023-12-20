package com.appnat3.tutoratplus.presentation.loginTuteur

import android.util.Log
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.loginTuteur.IConractVuePresentateurLoginTuteur.IPresentateurLoginTuteur
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.collections.mapOf as hashMap

class PresentateurLoginTuteur(var vue: VueLoginTuteur ): IPresentateurLoginTuteur {

    val modele = Modele.Companion
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var job: Job? = null

    override fun traiterValidationInfoLogin(username:String, password:String):Boolean{
        var result = false
        job = CoroutineScope(Dispatchers.IO).launch {
            val listeInfoLogin = modele.retourListInfoLogin()
            for (item in listeInfoLogin) {
                if (item.nomUtilisateur == username && item.motDePasse == password) {
                    result = true
                    Log.d("LoginTest1", "$result")
                }
            }

        }

        runBlocking {
            job!!.join()
        }


        return result
    }

    override fun traiterCollectInformationLogin(username: String) {

        coroutineScope.launch {

            val listeInfoLogin = modele.retourListInfoLogin()
            val mapInfoLogin = hashMap<Int, InfoLogin>(
                1 to listeInfoLogin[0],
                2 to listeInfoLogin[1],
                3 to listeInfoLogin[2],
                4 to listeInfoLogin[3],
                5 to listeInfoLogin[4]
            )

            val listeTuteurs = modele.retourListeTuteur()
            var mapListTuteur = hashMap<Int, Tuteur>(
                1 to listeTuteurs[0],
                2 to listeTuteurs[1],
                3 to listeTuteurs[2],
                4 to listeTuteurs[3],
                5 to listeTuteurs[4]
            )

            var idOuvertureSessionLogin: Int?
            for ((key, InfoLogin) in mapInfoLogin) {
                if (InfoLogin.nomUtilisateur == username) {       //condition pour trouver la position de la clée du tuteur a logger
                    idOuvertureSessionLogin = key

                    for ((key, Tuteur) in mapListTuteur) {
                        if (key == idOuvertureSessionLogin) {        //condition pour assigner dans le modele quelle tuteur logger
                            modele.ouvertureSessionTuteur = Tuteur
                            Log.d("TuteurLoggger", "${modele.ouvertureSessionTuteur}")

                        }
                    }
                }
            }
        }
    }

            fun effectuerNavigationAcceuil() {
                vue.naviguerVersmenu_principal()
            }

            fun effectuerNavigationPageTuteur() {
                vue.navigationVerspage_principal_tuteur()
            }

}