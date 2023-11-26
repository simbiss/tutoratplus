package com.appnat3.tutoratplus.presentation.loginTuteur

interface IConractVuePresentateurLoginTuteur {

    interface IVueLoginTuteur{}

    interface IPresentateurLoginTuteur{
        fun traiterValidationInfoLogin(username:String, password:String):Boolean

        fun traiterCollectInformationLogin(username: String)
    }
}