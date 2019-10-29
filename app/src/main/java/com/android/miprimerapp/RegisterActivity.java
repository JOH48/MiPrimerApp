package com.android.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.miprimerapp.dataBase.UserDataBase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity{
    @BindView(R.id.register_activity_txtUser)
    EditText txtUser;
    @BindView(R.id.register_activity_txtName)
    EditText txtName;
    @BindView(R.id.register_activitytxtSecondName)
    EditText txtSecondName;
    @BindView(R.id.register_activity_txtPassword)
    EditText txtPassword;
    @BindView(R.id.register_activity_txtRepeatedPassword)
    EditText txtRepeatedPassword;
    @BindView(R.id.register_activity_btnRegister)
    Button btnRegister;
    @BindView(R.id.register_activity_btnCancel)
    Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.register_activity_btnRegister)
    public void tryRegister() {
        registerUser();
    }


    @OnClick(R.id.register_activity_btnCancel)
    public void tryCancel() {
        this.finish();
    }



    //METODO QUE SE MANDA A LLAMAR CUANDO SE PRESIONA EL BOTON DE REGISTRO.
    private void registerUser() {
        if (validateFields() == true) {
            if (UserDataBase.searchUsername(txtUser.getText().toString().trim()) == true) {
                Toast.makeText(this, "IMPOSIBLE REGISTRAR, EL USUARIO YA EXISTE", Toast.LENGTH_SHORT).show();
            } else {
                UserDataBase.insertUser(txtUser.getText().toString().trim(), txtName.getText().toString().trim(),
                        txtSecondName.getText().toString().trim(), txtPassword.getText().toString().trim());
                this.finish();
            }
        }
    }


    //sE VALIDA QUE TODOS LOS CAMPOS SEAN OBLIGATORIOS
    //DEVUELVE TRUE SI TODOS LOS CAMPOS ESTAN LLENOS Y DEVUELVE FALSE SI ALGUNO NO ESTA LLENO
    //O SI LAS CONTRASEÑAS NO SON IGUALES.
    private Boolean validateFields() {
        if (txtUser.getText().toString().trim().equals("")) {
            Toast.makeText(this, "EL CAMPO DE USUARIO NO PUEDE ESTAR VACIO",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtName.getText().toString().trim().equals("")) {
            Toast.makeText(this, "EL CAMPO NOMBRE NO PUEDE ESTAR VACIO",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtSecondName.getText().toString().trim().equals("")) {
            Toast.makeText(this, "EL CAMPO APELLIDO NO PUEDE ESTAR VACIOS",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, "EL CAMPO CONTRASEÑA NO PUEDE ESTAS VACIOS",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtRepeatedPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, "EL CAMPO REPETIR CONTRASEÑA NO PUEDE ESTAS VACIO",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!txtPassword.getText().toString().trim().equals(
                txtRepeatedPassword.getText().toString().trim()
        )) {
            Toast.makeText(this, "LAS CONTRASEÑAS NO SON IGUALES",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
