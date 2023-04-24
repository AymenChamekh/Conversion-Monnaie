package com.example.miniappconvmonnaie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
            EditText entree;
            RadioGroup groupConversion;
            Button convertir;
            TextView sortie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entree =findViewById(R.id.edtxtMonnaie);
        groupConversion = findViewById(R.id.groupBtn);
        convertir = findViewById(R.id.BtnConvert);
        sortie = findViewById(R.id.textResult);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (entree.getText().toString().equals("")){
                    AlertDialog.Builder alertDialogue = new AlertDialog.Builder(MainActivity.this);
                    alertDialogue.setTitle("champ manquant");
                    alertDialogue.setMessage("Vous devez saisir une valeur");
                    alertDialogue.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialogue.show();
                }
                else {
                    Float vInit=0.0F,res;
                    vInit = Float.valueOf(entree.getText().toString());

                    if(groupConversion.getCheckedRadioButtonId()== R.id.btnEuroDinar){
                        res = euroToDinar(vInit);
                        sortie.setText(String.valueOf(res));
                    }
                    else{
                        res = DinarToEuro(vInit);
                        sortie.setText(String.valueOf(res));
                    }

                }
            }
        });
    }

    private Float DinarToEuro(Float vDinar) {
        return (float) (vDinar * 0.326);
    }

    private Float euroToDinar(Float vEuro) {
        return (float) (vEuro * 3.26);
    }
}