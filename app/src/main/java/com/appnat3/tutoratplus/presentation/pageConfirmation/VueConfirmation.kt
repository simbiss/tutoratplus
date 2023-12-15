package com.appnat3.tutoratplus.presentation.pageConfirmation

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appnat3.tutoratplus.R
import com.appnat3.tutoratplus.presentation.Modele
import com.appnat3.tutoratplus.presentation.pageConfirmation.IContractVuePresentateurConfirmation.IVueConfirmation
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

@Suppress("DEPRECATION")
class VueConfirmation : Fragment(), IVueConfirmation{

    lateinit var txtNomCours: TextView
    lateinit var navController: NavController
    lateinit var txtNomTuteur: TextView
    lateinit var txtDate: TextView

    lateinit var txtDA: TextView
    lateinit var txtPrenom: TextView
    lateinit var txtNom: TextView
    lateinit var txtCourriel: TextView

    lateinit var btnAjoutCalendrier: Button
    lateinit var btnAcceuil: TextView
    lateinit var btnRetour: LinearLayout
    val modele = Modele.Companion
    var présentateur = PresentateurConfirmation(this)
    val CALENDAR_PERMISSION_REQUEST_CODE = 123

    @SuppressLint("SuspiciousIndentation", "QueryPermissionsNeeded")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_page_confirmation, container, false)

        btnAcceuil = vue.findViewById(R.id.textAcceuil)
        btnAcceuil.setOnClickListener {
            présentateur.effectuerNaviguationAcceuil()
        }

        btnRetour = vue.findViewById(R.id.buttonRetour)
        btnRetour.setOnClickListener {
            présentateur.effectuerNaviguationInformationPersonnelle()
        }

        txtNomCours = vue.findViewById(R.id.champNomCours)
        // Accédez à la VueListeCours parente pour obtenir le présentateur et le cours sélectionné

        val coursSelectionne = présentateur.collectionCoursSelectionnee()
        if (coursSelectionne != null) {
            txtNomCours.text = "Cours sélectionné : ${coursSelectionne.nomCours}"
        } else {
            txtNomCours.text = "Aucun cours sélectionné"
        }


        txtNomTuteur = vue.findViewById(R.id.champNomTuteur)
        val tuteurSelectionne = présentateur.collectionTuteurSelectionnee()
            if(tuteurSelectionne!= null){
            txtNomTuteur.text = "Tuteur sélectionné : ${tuteurSelectionne.nomTuteur}"
        }else{
            txtNomTuteur.text = "Aucun tuteur sélectionné"
        }


        txtDate = vue.findViewById(R.id.champDate)
        //val dateSelectionnee = présentateur.collectionDateSelectionne()
        //val heureChoisie = présentateur.collectionHeureSelectionne()
        val reservationChoisie = présentateur.collectionReservationDispo()
        txtDate.text = "Date sélectionné : ${reservationChoisie}"


        txtDA = vue.findViewById(R.id.champDAConfirmation)
        val daInfoPerso = présentateur.collectionInfoPerso()
        if (daInfoPerso != null) {
            txtDA.text = "DA : ${daInfoPerso.da}"
        } else {
            txtDA.text = "Aucun DA entrez"
        }


        txtPrenom = vue.findViewById(R.id.champPrenomConfirmation)
        val prenomInfoPerso = présentateur.collectionInfoPerso()
        if (prenomInfoPerso != null) {
            txtPrenom.text = "Prenom : ${prenomInfoPerso.prenom}"
        } else {
            txtPrenom.text = "Aucun prenom entrez"
        }
        txtNom = vue.findViewById(R.id.champNomConfirmation)
        val nomInfoPerso = présentateur.collectionInfoPerso()
        if (nomInfoPerso != null) {
            txtNom.text = "Nom : ${nomInfoPerso.nom}"
        } else {
            txtNom.text = "Aucun nom entrer"
        }
        txtCourriel = vue.findViewById(R.id.champCourrielConfirmation)
        val courrielInfoPerso = présentateur.collectionInfoPerso()
        if (courrielInfoPerso != null) {
            txtCourriel.text = "Courriel : ${courrielInfoPerso.courriel}"
        } else {
            txtCourriel.text = "Aucun courriel entrer"
        }

        btnAjoutCalendrier = vue.findViewById(R.id.buttonContinuer)
        btnAjoutCalendrier.setOnClickListener {
            checkAndRequestCalendarPermission()
            présentateur.effectuerNaviguationMenuConfirmation()
        }
        return vue
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtient le NavController pour la navigation
        navController = Navigation.findNavController(view)

    }

    private fun checkAndRequestCalendarPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            // La permission n'est pas accordée, demandez-la
            requestPermissions(arrayOf(Manifest.permission.WRITE_CALENDAR), CALENDAR_PERMISSION_REQUEST_CODE)
        } else {
            // La permission est déjà accordée, procédez à l'ajout de l'événement
            addEventToCalendar()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CALENDAR_PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    addEventToCalendar()                                                                        // La permission est accordée
                } else {
                    Toast.makeText(context, "Permission refusée", Toast.LENGTH_SHORT).show()            // La permission est refusée
                }
            }
        }
    }

    private fun addEventToCalendar() {
        val reservationChoisie = présentateur.collectionReservationDispo()
        val tuteurSelectionne = présentateur.collectionTuteurSelectionnee()
        val coursSelectionne = présentateur.collectionCoursSelectionnee()
        // info calendrier
        val dateStr = reservationChoisie.toString()
        val titre = "Tuteur: ${tuteurSelectionne.nomTuteur}"
        val descricption = "Cours: ${coursSelectionne.nomCours}"

        //Convertir la chaine de date au format jj-mm-aaaa hh:mm en objet DAte
        val dateFormat = SimpleDateFormat ("dd-MM-yyyy HH:mm", Locale.getDefault())
        val date = dateFormat.parse(dateStr)

        //Creer un objet Calendar et l'initialiser avec la date choisi
        val calendar = Calendar.getInstance()
        calendar.time = date!!

        //Ajouter les spécification du rdv à la création d'évènement
        val intent = Intent(Intent.ACTION_INSERT)
        intent.setData(CalendarContract.Events.CONTENT_URI)
        intent.putExtra(CalendarContract.Events.DTEND,calendar.timeInMillis + 60 * 60 * 1000)   //Evenement de une heure
        intent.putExtra(CalendarContract.Events.DTSTART, calendar.timeInMillis)
        intent.putExtra(CalendarContract.Events.TITLE, titre)
        intent.putExtra(CalendarContract.Events.DESCRIPTION, descricption)
        //intent.putExtra(CalendarContract.Events.ALL_DAY, false)


        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=          PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(requireActivity(),  arrayOf<String>(Manifest.permission.ACCESS_COARSE_LOCATION), 1)
        ActivityCompat.requestPermissions(requireActivity(),  arrayOf(Manifest.permission.WRITE_CALENDAR), 1)
        Log.d("dateHeureTest", "$dateStr, $date, ${calendar.time}, ${calendar.timeInMillis}")
        startActivity(intent)

    }

    fun ajoutEvenementCalendrier(context : Context, dateStr: String, titre: String, descricption : String){
        try {
            //Convertir la chaine de date au format jj-mm-aaaa hh:mm en objet DAte
            val dateFormat = SimpleDateFormat ("dd-MM-yyyy HH:mm", Locale.getDefault())
            val date = dateFormat.parse(dateStr)

            //Creer un objet Calendar et l'initialiser avec la date choisi
            val calendar = Calendar.getInstance()
            calendar.time = date

            //Ajoputer l'evenement au calendrier
            var values = ContentValues().apply {
                put(CalendarContract.Events.DTSTART, calendar.timeInMillis)
                put(CalendarContract.Events.DTEND,calendar.timeInMillis + 60 * 60 * 1000)   //Evenement de une heure
                put(CalendarContract.Events.TITLE, titre)
                put(CalendarContract.Events.DESCRIPTION, descricption)
                put(CalendarContract.Events.CALENDAR_ID, 1)
                put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().id)
            }

            Log.d("calendar", "msg test avant uri ")
            val uri = context.contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)
            val eventID: Long = uri?.lastPathSegment!!.toLong()
            Log.d("calendrier", eventID.toString())

        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun naviguerversmenu_principal() {
        navController.navigate(R.id.action_page_confirmation_to_menu_principal)
    }

    fun naviguerversacceuil() {
        navController.navigate(R.id.action_page_confirmation_to_menu_principal)
    }

    fun naviguerversinformation_personnelle() {
        navController.navigate(R.id.action_page_confirmation_to_informationPersonnlle4)
    }
}