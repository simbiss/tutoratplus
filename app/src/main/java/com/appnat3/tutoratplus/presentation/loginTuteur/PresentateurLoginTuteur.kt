package com.appnat3.tutoratplus.presentation.loginTuteur

import android.os.Build
import androidx.annotation.RequiresApi


import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.domaine.entite.Tuteur
import com.appnat3.tutoratplus.presentation.Modele
import kotlin.collections.mapOf as hashMap

class PresentateurLoginTuteur(var vue : VueLoginTuteur, private val modele : Modele) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun traiterValidationInfoLogin(username:String, password:String):Boolean{

        var listeInfoLogin = modele.retourListInfoLogin()
        for (item in listeInfoLogin){
            if(item.nomUtilisateur == username) {
                if (item.motDePasse == password) {
                    return true
                }
            }
        }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun traiterCollectInformationLogin(username: String){

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

        for ((key, InfoLogin) in mapInfoLogin){
            if(InfoLogin.nomUtilisateur == username){       //condition pour trouver la position de la clée du tuteur a logger
                var idOuvertureSessionLogin = key

                for ((key, Tuteur) in mapListTuteur){
                    if(key == idOuvertureSessionLogin) {        //condition pour assigner dans le modele quelle tuteur logger
                        modele.ouvertureSessionTuteur = Tuteur
                    }
                }
            }
        }


    }

    fun effectuerNavigationAcceuil(){
        vue.naviguerVersmenu_principal()
    }

    fun effectuerNavigationPageTuteur(){
        vue.navigationVerspage_principal_tuteur()
    }


}