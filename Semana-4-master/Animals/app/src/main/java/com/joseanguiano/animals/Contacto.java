package com.joseanguiano.animals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contacto extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;

    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        editTextEmail = (EditText) findViewById(R.id.edtnombre);
        editTextSubject = (EditText) findViewById(R.id.edtdireccion);
        editTextMessage = (EditText) findViewById(R.id.edtmensaje);

        buttonSend = (Button) findViewById(R.id.btnEnviar);

        buttonSend.setOnClickListener(this);
    }


    private void sendEmail() {
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        SendMail sm = new SendMail(this, email, subject, message);

        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
