package e.welcome.acmbkbiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText eemail,epassword;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
    TextView tsignup,tforgotpassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isConnected(MainActivity.this))
        {
            setContentView(R.layout.activity_main);
            tforgotpassword=findViewById(R.id.txtForgotPassword);
            tsignup=findViewById(R.id.txtCreateAccount);
            btnLogin=findViewById(R.id.buttonLogin);
            mAuth = FirebaseAuth.getInstance();
           eemail=findViewById(R.id.emailLogin);
           epassword=findViewById(R.id.passwordLogin);
            if(mAuth.getCurrentUser()!=null)
            {
                finish();
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email=eemail.getText().toString();
                    if(eemail.getText().toString().isEmpty())
                    {
                        eemail.setError("Write your email");
                    }
                    if(!email.matches(regex)){
                        //give user notice
                        eemail.setError("Please enter a valid email address");
                    }
                    else
                    {    String password=epassword.getText().toString();

                        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {   mUser=mAuth.getCurrentUser();
                                    if(mUser.isEmailVerified())
                                    {
                                        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                                        startActivity(i);
                                    }
                                    else
                                    {
                                        Toast.makeText(MainActivity.this, "You email are not verified yet",
                                                Toast.LENGTH_SHORT).show();
                                        mAuth.signOut();
                                    }
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                }
            });
            tforgotpassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getApplicationContext(),ForgotPasswordActivity.class);
                    startActivity(i);
                }
            });
            tsignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
                    startActivity(i);
                }
            });


        }
        else
        {
            buildDialog(MainActivity.this).show();
        }
    }
    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();
        return netinfo !=null && netinfo.isConnected();
    }
    public AlertDialog.Builder buildDialog(Context c)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have mobile data or wifi connection");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        return  builder;
    }
}
