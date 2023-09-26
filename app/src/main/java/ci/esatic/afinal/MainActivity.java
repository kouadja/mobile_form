package ci.esatic.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button popupBtn;
    Dialog mDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
//        new Handler().postDelayed(runnable , 3000);

        popupBtn = findViewById(R.id.popupBtn);
        Button btnAnnullé = findViewById(R.id.button2);

        EditText champNom = findViewById(R.id.text1);
        EditText champPrenom = findViewById(R.id.text2);

        mDialog  = new Dialog(this);

        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Titre de la boîte de dialogue");
                String nom = champNom.getText().toString();
                String prenom = champPrenom.getText().toString();
                builder.setMessage("votre nom est " + nom + " et votre prenom est " + prenom);
//                builder.setMessage("Contenu de la boîte de dialogue");

                // Ajoutez un bouton "OK" à la boîte de dialogue
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        // Code à exécuter lorsque l'utilisateur clique sur "OK"
                        dialog.dismiss(); // Ferme la boîte de dialogue
                    }
                });

                // Créez la boîte de dialogue
                AlertDialog dialog = builder.create();

                // Affichez la boîte de dialogue
                dialog.show();

            }
        });
        btnAnnullé.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                champNom.setText("");
                champPrenom.setText("");
            }
        });
    }
}
