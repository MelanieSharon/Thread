package doapps.me.hilos;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import doapps.me.hilos.database.process.PersonProcess;
import doapps.me.hilos.networking.backgroud.PersonAsynctask;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.loading_bar)
    ProgressBar progressBar;

    @BindView(R.id.porcent_text)
    TextView porcent;

    @BindView(R.id.ready_image)
    ImageView ready_image;

    @BindView(R.id.count_text)
    TextView count_text;

    @BindView(R.id.count_fail_text)
    TextView count_fail_text;

    @BindView(R.id.seconds_text)
    TextView seconds_text;

    @BindView(R.id.bd_text)
    TextView bd_text;

    @BindView(R.id.fail_image)
    ImageView fail_image;

    PersonAsynctask personAsynctask;

    Handler handler = new Handler();
    public int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        personAsynctask = new PersonAsynctask(this, progressBar, porcent);
        personAsynctask.execute();
        goThread();

    }

    public void goThread() {
        personAsynctask.setOnFinish(new PersonAsynctask.finishThead() {
            @Override
            public void finish() {
                Log.e("MainActivity", "finish");
                ready_image.setVisibility(View.VISIBLE);
                count_text.setText(String.valueOf(PersonAsynctask.personProcess.findAll().size()));
                count_fail_text.setText(String.valueOf(PersonAsynctask.personProcess.findAll().size() - 100));

                PersonAsynctask.personProcess.showLengt();
            }
        });

        personAsynctask.setOnNoFinish(new PersonAsynctask.nofinishThead() {
            @Override
            public void noFinish() {
                Log.e("MainActivity", "faild");
                fail_image.setVisibility(View.VISIBLE);
                count_text.setText(String.valueOf(PersonAsynctask.personProcess.findAll().size() + ""));
                count_fail_text.setText(String.valueOf(PersonAsynctask.personProcess.findAll().size() - 100));

            }
        });
    }

    public void sizeDataBae() {
        File f = this.getDatabasePath("db.hilo");
        long sise = f.length();

        Log.e("size databse", sise + "");
    }
}
