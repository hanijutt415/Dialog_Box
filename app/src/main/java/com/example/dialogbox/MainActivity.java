 package com.example.dialogbox;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // set up button to show custom dialog
        Button signbtn = findViewById(R.id.signbtn);

        signbtn.setOnClickListener(v ->

            showCustomDialog()
        );
    }

    // Moved this method outside onCreate()

     private void showCustomDialog(){
        // create the object dialog
         Dialog dialog = new Dialog(this);

         // set custom layout for the dialog

         View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog , null);

         dialog.setContentView(dialogView);

         // initialize dialog view
         TextView dialogTittle = dialog.findViewById(R.id.dialogTittle);
         EditText dialogInput = dialog.findViewById(R.id.dialogInput);
         Button dialogButton = dialog.findViewById(R.id.dialogButton);

         // set on click listener
         dialogButton.setOnClickListener(v -> {
              String inputText = dialogInput.getText().toString();
              dialogTittle.setText("Hello," + inputText);
              dialog.dismiss();  // close the dialog after action
         });

         // set the dialog
         dialog.show(); 
     }
}