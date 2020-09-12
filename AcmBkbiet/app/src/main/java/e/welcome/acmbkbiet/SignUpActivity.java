package e.welcome.acmbkbiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    TextView tlogin;
    Button signup;
    EditText eemail,ename,epassword;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference("");
    String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
    String regexpass = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$";
    String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tlogin=findViewById(R.id.textlogin);
        mAuth = FirebaseAuth.getInstance();
        eemail=findViewById(R.id.emailSignup);
        ename=findViewById(R.id.namesignup);
        epassword=findViewById(R.id.passworgsignup);
        signup=findViewById(R.id.btnsignup);
        tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                finish();
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatenewAccount();
            }
        });
    }
    private void CreatenewAccount() {
        verifyDetails();
        if (!verifyDetails()) {
            return;
        }
        else {
            final ProgressDialog p = new ProgressDialog(this);
            p.setMessage("Signing Up...");
            p.show();
            p.setCancelable(false);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                p.cancel();
                                sendVerificationLink();
                            } else {
                                p.cancel();
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }    }
    private void sendVerificationLink() {
        mUser = mAuth.getCurrentUser();
        mUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                AlertDialog.Builder alert = new AlertDialog.Builder(SignUpActivity.this);
                alert.setTitle("Verify your email");
                alert.setMessage("Go to your email to verify your account");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAuth.signOut();
                        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                        finish();
                    }
                });
                AlertDialog newalert = alert.create();
                newalert.show();}
                else {
                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean verifyDetails() {
        name = ename.getText().toString();
        email = eemail.getText().toString();
        password = epassword.getText().toString();
        if(name.equals("") || email.equals("") || password.equals("")){
            Toast.makeText(this,"All fields are compulsory",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!(password.length()>=8)){
            //give user notice
            epassword.setError("Min 8 characters required");
            return false;
        }
        if(!email.matches(regex)){
            //give user notice
            eemail.setError("Please enter a valid email address");
            return false;
        }
        return true;
    }
    void emptyalllfields(){
        ename.setText("");
        eemail.setText("");
        epassword.setText("");
    }
}
