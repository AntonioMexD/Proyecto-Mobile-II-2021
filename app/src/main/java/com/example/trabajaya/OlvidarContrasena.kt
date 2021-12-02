package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class OlvidarContrasena : AppCompatActivity() {
    private lateinit var txtEmail: EditText
    private lateinit var auth:FirebaseAuth
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvidar_contrasena)
        txtEmail=findViewById(R.id.txtEmail)
        progressBar=findViewById(R.id.progressBar)
        auth= FirebaseAuth.getInstance()

        /*//actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Trabaja Ya!"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)*/

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    fun send(view: View){
        val email=txtEmail.text.toString()

        if (!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        progressBar.visibility=View.VISIBLE
                        startActivity(Intent(this, IniciarSesion::class.java))
                    }else{
                        Toast.makeText(this, "Error al enviar el email", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    fun irInicioSesion(view: View){
        startActivity(Intent(this, IniciarSesion::class.java))
    }
}