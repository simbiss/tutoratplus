package com.appnat3.tutoratplus.presentation.pageConfirmation

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.presentation.Modele
import java.time.LocalDate
import java.time.LocalTime

class PresentateurConfirmation(var vue: VueConfirmation) {

    val modele =Modele.Companion
    @RequiresApi(Build.VERSION_CODES.O)


    /**
     * Méthode qui permet de retourner les choisies de l'utilisateur
     */
    fun collectionDaInfoPerso():String?{
        return modele.retourDaInfoPerso()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionPrenomInfoPerso(): String?{
        return modele.retourPrenomInfoPerso()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionNomInfoPerso():String?{
        return modele.retourNomInfoPerso()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionCourrielInfoPerso():String?{
        return modele.retourCourrielInfoPerso()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionCoursSelectionne(): String?{
        return modele.retourCoursChoisi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionTuteurSelectionne():String?{
        return modele.retourTuteurChoisi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionDateSelectionne(): LocalDate?{
        return modele.retourDateChoisie()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionHeureSelectionne(): LocalTime?{
        return modele.retourHeureSelectionne()
    }


    /**
     * Méthode qui permet de rediriger vers d'autre page
     *
     */
    fun effectuerNaviguationMenuConfirmation() {
        vue.naviguerversmenu_principal()
    }

    fun effectuerNaviguationAcceuil() {
        vue.naviguerversacceuil()
    }

    fun effectuerNaviguationInformationPersonnelle() {
        vue.naviguerversinformation_personnelle()
    }

}