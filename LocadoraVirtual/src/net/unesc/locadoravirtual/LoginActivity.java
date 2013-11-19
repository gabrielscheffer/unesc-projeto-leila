package net.unesc.locadoravirtual;

import net.unesc.locadoravirtual.utils.MyActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends MyActionBarActivity implements
		OnClickListener {

	private static Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		btnLogin = (Button) findViewById(R.id.login_btn_login);
		btnLogin.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn_login: {
			Intent newIntent = new Intent(this, MainActivity.class);
			startActivity(newIntent);
		}
			break;
		default:
			break;
		}

	}

}
