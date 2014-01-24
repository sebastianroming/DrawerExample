package de.sebastianroming.drawerexample;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

import de.sebastianroming.drawerexample.R;
import de.sebastianroming.drawerexample.R.layout;

public class TestActivity extends SherlockActivity {

	// ----------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
	}

}
