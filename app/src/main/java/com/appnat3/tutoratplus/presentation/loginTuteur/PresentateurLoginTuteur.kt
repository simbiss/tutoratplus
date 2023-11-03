package com.appnat3.tutoratplus.presentation.loginTuteur

import com.appnat3.tutoratplus.presentation.Modele
class PresentateurLoginTuteur(var vue : VueLoginTuteur) {


    fun traiterValidationInfoLogin(username:String, password:String):Boolean{
        for (item in Modele.listeTuteurs){
            if(item.nomLogin ==username && item.motDePasse == password){
                return true
            }
        }
        return false
    }

}