package com.android.miprimerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.miprimerapp.dataBase.UserDataBase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_btnLogin)
    Button btnLogin;
    @BindView(R.id.activity_main_btnRegister)
    Button btnRegister;
    @BindView(R.id.activity_main_txtUser)
    EditText txtUser;
    @BindView(R.id.activity_main_txtPassword)
    EditText txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.activity_main_btnLogin)
    public void tryLogin() {
        if (txtUser.getText().toString().trim().equals("") ||
                txtPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, "EL USUARIO Y CONTRASEÑA SON OBLIGATORIOS",
                    Toast.LENGTH_SHORT).show();
        } else {
            Boolean searchUser = UserDataBase.searchUsername(txtUser.getText().toString().trim());

            if (searchUser == true) {
                if (UserDataBase.login(txtUser.getText().toString().trim(),
                        txtPassword.getText().toString().trim()) == true) {
                    startLandingActivity();
                } else {
                    Toast.makeText(this, "Contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "EL USUARIO NO EXISTE", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @OnClick(R.id.activity_main_btnRegister)
    public void tryRegister() {
        startRegisterActivity();
    }


    private Boolean validateLogin() {
        Boolean vlog = false;
        if (UserDataBase.searchUsername(txtUser.getText().toString().trim()) == false) {
            Toast.makeText(this, "EL USUARIO NO EXISTE", Toast.LENGTH_SHORT).show();
            vlog = false;

        } else {
            vlog = true;
        }
        return vlog;
    }

    public Boolean validateFields() {
        Boolean breturn = true;
        // 0                                              +        1    =  1
        if (txtUser.getText().toString().trim().equals("") || txtPassword.getText().toString().
                trim().equals("")) {
            Toast.makeText(this, "EL USUARIO Y CONTRASEÑA NO PUEDEN ESTAR EN BLANCO", Toast.LENGTH_SHORT).show();
            breturn = false;
        } else {
            breturn = true;
        }
        return breturn;
    }


    public void startLandingActivity() {
        Intent intentLog = new Intent(this, LandingActivity.class);
        startActivity(intentLog);
        this.finish();
    }


    public void startRegisterActivity() {
        Intent intentRegister = new Intent(this, RegisterActivity.class); //aca creamos la variable de tipo intent y le indicamos de que contexto venimos y a cual activity vamos.
        startActivity(intentRegister); //Con esto lanzamos el nuevo activity que llamamos en el intent.

    }
}
