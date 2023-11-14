package com.appnat3.tutoratplus.presentation.pageConfirmation

import android.os.Build
import androidx.annotation.RequiresApi
import com.appnat3.tutoratplus.presentation.Modele
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class PresentateurConfirmation(var vue: VueConfirmation) {



    /**
     * Méthode qui permet de retourner les choisies de l'utilisateur
     */

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionDaInfoPerso():String?{
        return Modele.retourDaInfoPerso()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionPrenomInfoPerso(): String?{
        return Modele.retourPrenomInfoPerso()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionNomInfoPerso():String?{
        return Modele.retourNomInfoPerso()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionCourrielInfoPerso():String?{
        return Modele.retourCourrielInfoPerso()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionCoursSelectionne(): String?{
        return Modele.retourCoursChoisi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionTuteurSelectionne():String?{
        return Modele.retourTuteurChoisi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionDateSelectionne(): LocalDate?{
        return Modele.retourDateChoisie()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun collectionHeureSelectionne(): LocalTime?{
        return Modele.retourHeureSelectionne()
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