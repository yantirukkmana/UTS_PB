package com.example.gajisalesman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText inpNama, inpBulan, inpOmset;
    private RadioGroup rbgrup;
    private RadioButton inpPemula, inpSenior, inpManager, inpManagerPusat;
    private Button btnHitung;
    private TextView outTotalGaji;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Aplikasi Gaji Salesman");
        inpPemula   = (RadioButton) findViewById(R.id.inpPemula);
        inpSenior   = (RadioButton) findViewById(R.id.inpSenior);
        inpManager  = (RadioButton) findViewById(R.id.inpManager);
        inpManagerPusat = (RadioButton) findViewById(R.id.inpManagerPusat);
        inpNama     = (EditText) findViewById(R.id.inpNama);
        inpBulan    = (EditText) findViewById(R.id.inpBulan);
        inpOmset    = (EditText) findViewById(R.id.inpOmset);
        rbgrup      = (RadioGroup) findViewById(R.id.rbgrup);
        btnHitung   = (Button) findViewById(R.id.btnHitung);
        outTotalGaji= (TextView) findViewById(R.id.outTotalGaji);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, bulan, omset;
                double bonus = 0, omset1, bonus1, bonus2, total, gaji = 0;
                int p, s, m, mp;

                nama    = inpNama.getText().toString();
                bulan   = inpBulan.getText().toString();
                omset   = inpOmset.getText().toString();
                omset1  = Double.parseDouble(omset);

                p     = 1500000;
                s     = p + 1000000;
                m     = s + 1000000;
                mp    = p + m ;

                if (omset1 > 50000000) {
                    bonus = 0.04 * omset1;
                } else if (omset1 < 10000000) {
                    bonus = 0;
                } else {
                    bonus = 0.02 * omset1;
                }

                double aa = rbgrup.getCheckedRadioButtonId();
                if (aa == R.id.inpPemula){
                    gaji = p;
                } else if (aa == R.id.inpSenior){
                    gaji = s;
                } else if (aa == R.id.inpManager){
                    gaji = m;
                } else if  (aa == R.id.inpManagerPusat){
                    gaji = mp;
                }

                total = bonus + gaji;

                if (TextUtils.isEmpty(nama)){
                    inpNama.setError("Tidak Boleh Kosong !");
                    inpNama.requestFocus();
                } else if (TextUtils.isEmpty(bulan)) {
                    inpBulan.setError("Tidak Boleh Kosong !");
                    inpBulan.requestFocus();}

                    outTotalGaji.setText(
                            "Total Bulan  : " +bulan+
                            "\nSaudara       : " +nama+
                            "\nRincian        : \n    Gaji Kotor = Rp " +gaji+
                            "\n    Total Bonus = Rp " +bonus+
                            "\n    Gaji Total  = Rp " +total);
                }
            });
    }

}
