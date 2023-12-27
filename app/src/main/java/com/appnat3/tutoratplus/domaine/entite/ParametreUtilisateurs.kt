package com.appnat3.tutoratplus.domaine.entite

import android.app.Application

class ParametreUtilisateurs : Application() {
     val PRÉFÉRENCES = "préférences"
     val THÈME_PERSONNALISÉ = "Thèmepersonnalisé"
     val THÈME_BLANC = "ThèmeBlanc"
     val DARK_THEME  = "ThèmeNoir"

      var themePersonalisé : String = ""
           get() = field
          set(value) { field = value }
}