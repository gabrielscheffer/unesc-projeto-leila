package net.unesc.locadoravirtual.utils;

import android.support.v7.app.ActionBarActivity;

public class MyActionBarActivity extends ActionBarActivity {

	public MyActionBarActivity() {
		super();
	}

	@SuppressWarnings("unchecked")
	public <T> T getComponente(int id) {
		return (T) findViewById(id);
	}
}
