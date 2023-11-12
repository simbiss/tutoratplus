package com.appnat3.tutoratplus.presentation.pageCalendrier

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import java.time.LocalDate
import java.time.LocalTime

class PageCalendrier: Fragment() {
    //Déclaration de variables
    lateinit var navController: NavController
    lateinit var btnSuivant: Button
    lateinit var btnDisponibilite1: Button
    lateinit var btnDisponibilite2: Button
    lateinit var btnDisponibilite3: Button
    lateinit var btnDisponibilite4: Button
    lateinit var btnRetour: LinearLayout
    lateinit var btnAcceuil: TextView
    lateinit var textProbleme: TextView   //Variable de test
    lateinit var calendarView: CalendarView
    lateinit var myDate: TextView
    lateinit var txtdisponibiliteVide: TextView

    var présentateur = PresentateurPageCalendrier(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_calendrier, container, false)

        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur.effectuerNaviguationlisteTuteurs()
        }

        textProbleme = vue.findViewById(R.id.textProbleme)
        //textProbleme.setText(présentateur.retournerNomTuteur())

        txtdisponibiliteVide = vue.findViewById(R.id.txtAucuneDisponibilite)



        btnDisponibilite1 = vue.findViewById(R.id.buttonDisponibilite1)
        btnDisponibilite2 = vue.findViewById(R.id.buttonDisponibilite2)
        btnDisponibilite3 = vue.findViewById(R.id.buttonDisponibilite3)
        btnDisponibilite4 = vue.findViewById(R.id.buttonDisponibilite4)

        calendarView = vue.findViewById(R.id.calendar)
        myDate = vue.findViewById(R.id.textDate)
        myDate.text = LocalDate.now().toString()
        afficherDisponibilites(LocalDate.now())
        collectdateRendezVous()


        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur.effectuerNaviguationAcceuil()
        }

        btnSuivant = vue.findViewById(R.id.buttonContinuer)
        btnSuivant.setOnClickListener {
            présentateur.effectuerNaviguationInformationPersonnelle()
        }
        return  vue
    }
    // Fonction pour récupérer et afficher les disponibilités quand la page du calendrier s'affiche directement
    @SuppressLint("NewApi")
    fun afficherDisponibilites(dateSelectionnee: LocalDate) {
        val listeHeuresTuteurs = présentateur.retournerDateDisponibilités(dateSelectionnee)

        if (présentateur.retournerDateTuteur(dateSelectionnee) != null) {
            txtdisponibiliteVide.setText("")
            //Mettre tous les bouttons invisible pour afficher de nouveaux
            btnDisponibilite1.visibility = View.INVISIBLE
            btnDisponibilite2.visibility = View.INVISIBLE
            btnDisponibilite3.visibility = View.INVISIBLE
            btnDisponibilite4.visibility = View.INVISIBLE
            if (listeHeuresTuteurs != null) {
                var cpt= listeHeuresTuteurs.count()
                if (listeHeuresTuteurs.count() > 0) {
                    for (i in 0 until cpt ) {
                        if(i == 0) {
                            btnDisponibilite1.setText(listeHeuresTuteurs[i].toString())
                            btnDisponibilite1.setTextColor(Color.WHITE)
                            btnDisponibilite1.setBackgroundColor(Color.BLUE)
                            btnDisponibilite1.visibility = View.VISIBLE
                            btnDisponibilite1.setOnClickListener {
                                var heureSelectectionne = listeHeuresTuteurs[i]
                                présentateur.traiterAjoutdelaDate(dateSelectionnee,heureSelectectionne)
                            }
                        }

                        else if(i == 1) {
                            btnDisponibilite2.setText(listeHeuresTuteurs[i].toString())
                            btnDisponibilite2.setTextColor(Color.WHITE)
                            btnDisponibilite2.setBackgroundColor(Color.BLUE)
                            btnDisponibilite2.visibility = View.VISIBLE
                            btnDisponibilite2.setOnClickListener {
                                var heureSelectectionne = listeHeuresTuteurs[i]
                                présentateur.traiterAjoutdelaDate(dateSelectionnee,heureSelectectionne)
                            }

                        }
                        else if(i == 2) {
                            btnDisponibilite3.setText(listeHeuresTuteurs[i].toString())
                            btnDisponibilite3.setTextColor(Color.WHITE)
                            btnDisponibilite3.setBackgroundColor(Color.BLUE)
                            btnDisponibilite3.visibility = View.VISIBLE
                            btnDisponibilite3.setOnClickListener {
                                var heureSelectectionne = listeHeuresTuteurs[i]
                                présentateur.traiterAjoutdelaDate(dateSelectionnee,heureSelectectionne)
                            }
                        }
                        else if(i == 3) {
                            btnDisponibilite4.setText(listeHeuresTuteurs[i].toString())
                            btnDisponibilite4.setTextColor(Color.WHITE)
                            btnDisponibilite4.setBackgroundColor(Color.BLUE)
                            btnDisponibilite4.visibility = View.VISIBLE
                            btnDisponibilite4.setOnClickListener {
                                var heureSelectectionne = listeHeuresTuteurs[i]
                                présentateur.traiterAjoutdelaDate(dateSelectionnee,heureSelectectionne)
                            }
                        }
                    }


                }
            }
        } else {
            btnDisponibilite1.visibility = View.INVISIBLE
            btnDisponibilite2.visibility = View.INVISIBLE
            btnDisponibilite3.visibility = View.INVISIBLE
            btnDisponibilite4.visibility = View.INVISIBLE

            txtdisponibiliteVide.setText("Aucune disponibolinité")
            val couleurInt = ResourcesCompat.getColor(resources, R.color.gris, null)
            txtdisponibiliteVide.setTextColor(couleurInt)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectdateRendezVous(){
        //Déclaration de variables

        //Après une action
            //Chercher le composant
            //Obtenir texte du composant
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val dateSelectionnee = LocalDate.of(year,month + 1, dayOfMonth )
            myDate.text = dateSelectionnee.toString()
            afficherDisponibilites(dateSelectionnee)





        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)
    }



    fun afficherDisponibilitésHeuresTuteur(p_listeHeuresTuteurs:MutableList<LocalTime>) {

    }
    fun naviguerVerspagesInfosPersonnelle() {
        navController.navigate(R.id.action_pageCalendrier_to_informationPersonnlle)
    }

    fun naviguerVersliste_tuteurs() {
        navController.navigate(R.id.action_pageCalendrier_to_liste_tuteur)
    }

    fun naviguerVersmenu() {
        navController.navigate(R.id.action_pageCalendrier_to_menu_principal)
    }
}