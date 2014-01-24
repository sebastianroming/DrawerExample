package de.sebastianroming.drawerexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import de.sebastianroming.drawerexample.R;

public class FragmentThree extends SherlockFragment {
	 
    public static Fragment newInstance(Context context) {
        FragmentThree f = new FragmentThree();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null); 
        return root;
    }
 
}