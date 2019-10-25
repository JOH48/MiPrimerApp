package com.android.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.miprimerapp.dataBase.UserDataBase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtUser;
    EditText txtName;
    EditText txtSecondName;
    EditText txtPassword;
    EditText txtRepeatedPassword;
    Button btnRegister;
    Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Unimos los widget o vistas de la parte grafica con el codigo.
        txtUser = findViewById(R.id.register_activity_txtUser);
        txtName = findViewById(R.id.register_activity_txtName);
        txtSecondName = findViewById(R.id.register_activitytxtSecondName);
        txtPassword = findViewById(R.id.register_activity_txtPassword);
        txtRepeatedPassword = findViewById(R.id.register_activity_txtRepeatedPassword);
        btnRegister = findViewById(R.id.register_activity_btnRegister);
        btnCancel = findViewById(R.id.register_activity_btnCancel);

        //ACCEDEMOS AL METODO ESPECIAL DE LOS BOTONES.. QUE LE DA FUNCIONALIDAD.
        btnRegister.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_activity_btnCancel:
                this.finish();
                break;
            case R.id.register_activity_btnRegister:
                registerUser();
                break;
        }
    }


    //METODO QUE SE MANDA A LLAMAR CUANDO SE PRESIONA EL BOTON DE REGISTRO.
    private void registerUser(){
        if(validateFields()==true){
            if(UserDataBase.searchUsername(txtUser.getText().toString().trim())==true){
                Toast.makeText(this,"IMPOSIBLE REGISTRAR, EL USUARIO YA EXISTE",Toast.LENGTH_SHORT).show();
            } else {
                UserDataBase.insertUser(txtUser.getText().toString().trim(),txtName.getText().toString().trim(),
                        txtSecondName.getText().toString().trim(),txtPassword.getText().toString().trim());
                this.finish();
            }
        }
    }



    //sE VALIDA QUE TODOS LOS CAMPOS SEAN OBLIGATORIOS
    //DEVUELVE TRUE SI TODOS LOS CAMPOS ESTAN LLENOS Y DEVUELVE FALSE SI ALGUNO NO ESTA LLENO
    //O SI LAS CONTRASEÑAS NO SON IGUALES.
    private Boolean validateFields(){
        if(txtUser.getText().toString().trim().equals("")){
            Toast.makeText(this, "EL CAMPO DE USUARIO NO PUEDE ESTAR VACIO",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtName.getText().toString().trim().equals("")){
            Toast.makeText(this,"EL CAMPO NOMBRE NO PUEDE ESTAR VACIO",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtSecondName.getText().toString().trim().equals("")){
            Toast.makeText(this, "EL CAMPO APELLIDO NO PUEDE ESTAR VACIOS",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtPassword.getText().toString().trim().equals("")){
            Toast.makeText(this,"EL CAMPO CONTRASEÑA NO PUEDE ESTAS VACIOS",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtRepeatedPassword.getText().toString().trim().equals("")){
            Toast.makeText(this,"EL CAMPO REPETIR CONTRASEÑA NO PUEDE ESTAS VACIO",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!txtPassword.getText().toString().trim().equals(
                txtRepeatedPassword.getText().toString().trim()
        )){ Toast.makeText(this,"LAS CONTRASEÑAS NO SON IGUALES",
                Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
