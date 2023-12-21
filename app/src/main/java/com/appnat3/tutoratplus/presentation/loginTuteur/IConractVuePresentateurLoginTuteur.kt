package com.appnat3.tutoratplus.presentation.loginTuteur

import android.view.View

interface IConractVuePresentateurLoginTuteur {

    interface IVueLoginTuteur{
        fun afficherErreur(message: String)
        fun collectInformationLogin(vue : View)
    }

    interface IPresentateurLoginTuteur{
        fun traiterValidationInfoLogin(username:String, password:String):Boolean

        fun traiterCollectInformationLogin(username: String)
    }
}