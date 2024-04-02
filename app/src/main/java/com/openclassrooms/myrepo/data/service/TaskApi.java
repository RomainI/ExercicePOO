package com.openclassrooms.myrepo.data.service;

import com.openclassrooms.myrepo.model.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Cette classe simule la récupération de tâches depuis une API.
 * Les tâches générées sont utilisées à des fins de démonstration.
 */
public class TaskApi {
    /**
     * Récupère une liste de tâches simulées depuis l'API.
     *
     * @return Une liste de tâches simulées avec des descriptions pré-définies.
     */
    public List<Task> getTasks() {
        // Simule la récupération des tâches depuis une API
        List<Task> tasks = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0); //Date du jour

        Date dueTime = calendar.getTime(); //Jour 0

        tasks.add(new Task("Faire les courses pour le dîner", dueTime));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Préparer le rapport pour la réunion", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Répondre aux e-mails en attente", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Faire de l'exercice pendant 30 minutes", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Planifier les vacances d'été", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Rendre le livre à la bibliothèque", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Réviser pour l'examen de mathématiques", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Appeler le plombier pour la fuite d'eau", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Nettoyer le garage", calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,1); //+1 jour
        tasks.add(new Task("Préparer une liste de courses", calendar.getTime()));
        return tasks;
    }

}
