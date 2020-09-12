package e.welcome.acmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText eemail,epassword;
    Button btsignin;
    TextView tforgotpassword,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eemail=findViewById(R.id.editemail);
        epassword=findViewById(R.id.editpassword);
        btsignin=findViewById(R.id.buttonlogin);
        tforgotpassword=findViewById(R.id.forgotpassword);
        signin=findViewById(R.id.donthaveanaccount);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignupSecondActivity.class);
                startActivity(i);
            }
        });
    }
}
