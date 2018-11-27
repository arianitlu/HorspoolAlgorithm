package com.example.pluscomputers.harspoolalgorithm;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText patternTxt , mainTxt;
    TextView txtRezultati;
    HorspoolAlgorithm hs;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patternTxt = findViewById(R.id.patternText);
        mainTxt = findViewById(R.id.mainText);
        txtRezultati = findViewById(R.id.txtRezultati);

        hs = new HorspoolAlgorithm();


    }

    public void check(View view) {

        new TestAsync().execute();
    }

    class TestAsync extends AsyncTask<Void, Integer, Integer>
    {

        @Override
        protected Integer doInBackground(Void... voids) {

            hs.shifttable(patternTxt.getText().toString());

            pos = hs.horspool(mainTxt.getText().toString(),patternTxt.getText().toString());

            return pos;
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);

            if (pos == 0){
                txtRezultati.setText("Teksti i kerkuar nuk gjendet brenda mesazhit");
                txtRezultati.setTextColor(getResources().getColor(R.color.colorAccent));
            }else{
                txtRezultati.setText("Teksti i kerkuar u gjet brenda mesazhit dhe eshte ne poziten: " + pos);
                txtRezultati.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        }
    }
}
