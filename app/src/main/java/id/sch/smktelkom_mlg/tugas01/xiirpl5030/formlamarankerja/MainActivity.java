package id.sch.smktelkom_mlg.tugas01.xiirpl5030.formlamarankerja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bOk;
    CheckBox cb1, cb2, cb3, cb4;
    RadioGroup rgStatus;
    TextView tvHasil;
    Spinner SpPendidikan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgStatus = (RadioGroup) findViewById(R.id.RadioGroup);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        SpPendidikan = (Spinner) findViewById(R.id.SpinnerPendidikan);

        kondisiawal();
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void kondisiawal()
    {
        etNama.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        rgStatus.clearCheck();
        SpPendidikan.setSelection(0);
    }

    private void doClick()
    {
        if(isValid())
        {


        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty())
        {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        }
        else if (nama.length()<3)
        {
            etNama.setError("Nama Minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        return valid;
    }
}
