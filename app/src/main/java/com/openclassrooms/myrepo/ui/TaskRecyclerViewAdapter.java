package com.openclassrooms.myrepo.ui;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.openclassrooms.myrepo.R;
import com.openclassrooms.myrepo.model.Task;

import java.util.Calendar;
import java.util.Date;

/**
 * Un adaptateur pour afficher la liste de tâches dans un RecyclerView.
 */
public class TaskRecyclerViewAdapter extends ListAdapter<Task, TaskRecyclerViewAdapter.ViewHolder> {

    /**
     * Constructeur de l'adaptateur.
     */
    public TaskRecyclerViewAdapter() {
        super(new ItemCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    /**
     * ViewHolder pour afficher les éléments de la liste de tâches.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView factTextView;
        private final TextView dueTimeTextView;

        private final LinearProgressIndicator progressBar;

        /**
         * Constructeur du ViewHolder.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            factTextView = itemView.findViewById(R.id.task_description);
            dueTimeTextView = itemView.findViewById(R.id.task_duetime);
            progressBar = itemView.findViewById(R.id.progress_horizontal);
        }

        /**
         * Lie les données de la tâche au ViewHolder.
         *
         * @param task La tâche à afficher.
         */
        public void bind(Task task) {

            /**
             *
             * Formate la date récupérée de l'objet task
             */

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String textDate = simpleDateFormat.format(task.getDueTime());

            progressBar.setProgress(getPercent(task.getDueTime()));
            dueTimeTextView.setText(textDate);
            factTextView.setText(task.getDescription());
        }

        /**
         *
         * return the percent calculated with the param date, based on ten days
         */
        private int getPercent(Date date){
            Date today = Calendar.getInstance().getTime();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR,10);
            Date tenDays = calendar.getTime();
            int intTen = (int) (tenDays.getTime() - today.getTime())/1000;
            int intDate = (int) (tenDays.getTime()-date.getTime())/1000;
            int percent = intDate*100 / intTen;

            return percent;
        }
    }

    /**
     * Callback pour la comparaison des éléments de la liste.
     */
    private static class ItemCallback extends DiffUtil.ItemCallback<Task> {
        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getDescription().equals(newItem.getDescription());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.equals(newItem);
        }
    }
}
