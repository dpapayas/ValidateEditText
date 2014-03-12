package com.dpapayas.validateedittext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText emailEditText;
	private EditText passEditText;
	
	private Button signup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		emailEditText = (EditText) findViewById(R.id.editText_email);
		passEditText = (EditText) findViewById(R.id.editText_password);

		signup = (Button)findViewById(R.id.btn_signup);
		signup.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						final String email = emailEditText.getText().toString();
						if (!isValidEmail(email)) {
							emailEditText.setError("Invalid Email");
						}

						final String pass = passEditText.getText().toString();
						if (!isValidPassword(pass)) {
							passEditText.setError("Invalid Password");
						}

					}
				});
	}

	// validating email id
	private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }

	// validating password with retype password 	
	private boolean isValidPassword(String pass) {
		if (pass != null && pass.length() > 6) {
			return true;
		}
		return false;
	}
}