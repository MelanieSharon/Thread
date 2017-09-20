package doapps.me.hilos.networking.backgroud;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import doapps.me.hilos.MainActivity;
import doapps.me.hilos.database.process.PersonProcess;
import doapps.me.hilos.model.Person;

/**
 * Created by Melanie Veliz on 19/09/2017.
 */

public class PersonAsynctask extends AsyncTask<String, Integer, Boolean> {
    public static PersonProcess personProcess;

    private finishThead finishThead;
    private nofinishThead nofinishThead;

    private ProgressBar progressBar;
    private TextView textView;
    private TextView second;

    private int secondThread = 0;

    Random random = new Random();

    String[] names = {"Melanie", "Lesly", "Raquel", "Katty", "Leslie"};
    String[] lastName = {"Veliz", "Romero", "Moreno", "Ruiz", "Garcia"};
    String[] hobby = {"Leer", "Comer", "Dibujar", "Voley", "Ver tele"};
    String[] career = {"Desarrollo", "Gestion", "Diseño", "Administracion", "Diseño Grafico"};
    String[] city = {"Lima", "Trujillo", "Barranca", "Oyon", "Huaral"};

    int[] ages = {12, 13, 54, 45, 76};

    public PersonAsynctask(Context context, ProgressBar progressBar, TextView textView) {
        personProcess = new PersonProcess(context);
        this.progressBar = progressBar;
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
        textView.setText(values[0] + "%");
    }

    @Override
    protected Boolean doInBackground(String... params) {
        for (int i = 0; i < 100; i++) {
            String nameRandom = names[random.nextInt(names.length)];
            int ageRandom = ages[random.nextInt(ages.length)];
            String lastRandom = lastName[random.nextInt(lastName.length)];
            String hobbyRandom = hobby[random.nextInt(hobby.length)];
            String careerRandom = career[random.nextInt(career.length)];
            String cityRandom = city[random.nextInt(city.length)];

            personProcess.insert(new Person(nameRandom, lastRandom, ageRandom, hobbyRandom, careerRandom, cityRandom));

            Log.e("size persom", personProcess.findAll().size() + "");

            publishProgress((int) (((i + 1) / (float) (100)) * 100));

            Log.e("process size", personProcess.findAll().size() + "");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (personProcess.findAll().size() == 100) {
            finishThead.finish();

        } else {
            nofinishThead.noFinish();
        }
    }

    public interface finishThead {
        void finish();
    }

    public interface nofinishThead {
        void noFinish();
    }

    public void setOnFinish(finishThead finishThead) {
        this.finishThead = finishThead;
    }

    public void setOnNoFinish(nofinishThead nofinishThead) {
        this.nofinishThead = nofinishThead;
    }
}
