package id.sch.smktelkom_mlg.tugas01.xiirpl5030.formlamarankerja;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
    String cbHasil1="";

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
        cbHasil1 = "";
    }

    private void doClick()
    {
        if(isValid())
        {
            String nama = etNama.getText().toString();
            int strartlen1 = cbHasil1.length();
            String irb;

            if (cb1.isChecked()) cbHasil1 += "\t- "+cb1.getText() +"\n";
            if (cb2.isChecked()) cbHasil1 += "\t- "+cb2.getText() +"\n";
            if (cb3.isChecked()) cbHasil1 += "\t- "+cb3.getText() +"\n";
            if (cb4.isChecked()) cbHasil1 += "\t- "+cb4.getText() +"\n";
            if (cbHasil1.length()==strartlen1)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Anda Belum Mengisi Posisi Yang Diincar!!");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "Ok",
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog, int id){
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
            if (rgStatus.getCheckedRadioButtonId()!= -1)
            {
                RadioButton rb = (RadioButton) findViewById(rgStatus.getCheckedRadioButtonId());
                irb = rb.getText().toString();
            }
            else
            {
                irb = null;
            }

            if (irb == null)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Anda Belum Memilih Lama Pengalaman Kerja!!");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "Ok",
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog, int id){
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
            else
            {
                tvHasil.setText("Nama Pelamar : "+nama+ "\nPendidikan Terakhir : "+SpPendidikan.getSelectedItem().toString()+ "\nLama Pengalaman Kerja : "+irb
                        +"\nPosisi Yang Diincar : \n"+cbHasil1);
                kondisiawal();
            }

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
