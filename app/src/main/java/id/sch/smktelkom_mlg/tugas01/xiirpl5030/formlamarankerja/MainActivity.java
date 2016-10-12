package id.sch.smktelkom_mlg.tugas01.xiirpl5030.formlamarankerja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bOk;
    RadioButton radioButton, radioButton2, radioButton3;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

            }
        });
    }

    private boolean doProcess() {
        if (isValid()) {
            boolean valid = true;

            String nama = etNama.getText().toString();
            tvHasil.setText(nama);

            if(nama.isEmpty())
            {
                etNama.setError("Nama belum diisi");
                valid = false;
            }
            else if(nama.length()<3)
            {
                etNama.setError("Nama minimal 3 karakter");
                valid = false;
            }
            else
            {
                etNama.setError(null);
            }

            return valid;
        }
        return false;
    }

    private boolean isValid() {
        return false;
    }
}
