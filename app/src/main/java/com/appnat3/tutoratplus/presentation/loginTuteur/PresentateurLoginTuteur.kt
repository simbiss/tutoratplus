package com.appnat3.tutoratplus.presentation.loginTuteur

import android.icu.text.IDNA.Info
import android.util.Log
import android.view.Display.Mode
import com.appnat3.tutoratplus.domaine.entite.InfoLogin
import com.appnat3.tutoratplus.presentation.Modele

class PresentateurLoginTuteur(var vue : VueLoginTuteur) {



                //private var listeInfoLogin = arrayListOf<InfoLogin>()


    fun traiterValidationInfoLogin(username:String, password:String):Boolean{

        var listeInfoLogin = Modele.listeInfoLogin


        for (item in listeInfoLogin){
            if(item.nomUtilisateur == username) {
                if (item.motDePasse == password) {
                    return true
                }
            }
        }
        return false
    }

    fun effectuerNavigationAcceuil(){
        vue.naviguerVersmenu_principal()
    }

    fun effectuerNavigationPageTuteur(){
        vue.navigationVerspage_principal_tuteur()
    }


}