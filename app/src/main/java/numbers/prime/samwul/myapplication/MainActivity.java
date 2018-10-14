package numbers.prime.samwul.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import numbers.prime.samwul.myapplication.adapters.PrimeListAdapter;
import numbers.prime.samwul.myapplication.generator.PrimeNumbers;

public class MainActivity extends Activity {

    private PrimeListAdapter adapter;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PrimeListAdapter(getApplicationContext());
        progressbar = findViewById(R.id.progressBar);

        GridView v = findViewById(R.id.gridView);
        v.setAdapter(adapter);



        final EditText editText = findViewById(R.id.editText);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                try {
                    int size = Integer.parseInt(value);
                    new CalculatePrimeNumbers().execute(size);
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        };
        editText.addTextChangedListener(textWatcher);

        try {
            int s = Integer.parseInt(editText.getText().toString());
            new CalculatePrimeNumbers().execute(s);
        }
        catch(Exception e){ }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



    private class CalculatePrimeNumbers extends AsyncTask<Integer, Integer, List<int[]>> {

        protected void onPreExecute(){
            progressbar.setVisibility(View.VISIBLE);
        }
        protected List<int[]> doInBackground(Integer... size) {
            PrimeNumbers prime = new PrimeNumbers(size[0]);
            prime.generate();
            return prime.getList();
        }

        protected void onPostExecute(List<int[]> result) {
            progressbar.setVisibility(View.GONE);
            adapter.setList(result);
            adapter.notifyDataSetChanged();
        }
    }
}
