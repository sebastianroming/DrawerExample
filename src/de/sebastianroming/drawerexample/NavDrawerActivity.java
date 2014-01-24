package de.sebastianroming.drawerexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;

public class NavDrawerActivity extends SherlockFragmentActivity {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerContent;
	private SherlockActionBarDrawerToggle mDrawerToggle;
	
	private int mTitle;

    protected NavDrawerAdapter mDrawerAdapter;

	// ----------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// ----------------------------------------------------------------------
    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);
        
        initDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
    }

	// ----------------------------------------------------------------------
    public void initDrawer() {
    	
    	mTitle = R.string.app_name;
    	 
        mDrawerLayout	= (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerContent	= (ListView) findViewById(R.id.drawer_list);
    	
        mDrawerAdapter	= new NavDrawerAdapter(this);
        
        mDrawerContent.setAdapter(mDrawerAdapter);
        mDrawerContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				NavDrawerAdapter.DrawerItem item = (NavDrawerAdapter.DrawerItem) mDrawerAdapter.getItem(i);
				
				mTitle = item.getTitle();
				
				switch (mTitle) {
				
					case R.string.drwitm_one:
						load(FragmentOne.class);
						break;
					case R.string.drwitm_two:
						load(TestActivity.class);
						break;
					case R.string.drwitm_three:
						load(FragmentThree.class);
						break;
				
				}
				
			}
        	
        	
        });
        
		mDrawerToggle = new SherlockActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(R.string.app_name);
            }
        };
        
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame,Fragment.instantiate(NavDrawerActivity.this, "de.sebastianroming.drawerexample.FragmentOne"));
        tx.commit();
    	
    }

	// ----------------------------------------------------------------------
    private void load(Class<?> activityClass) {
    	
    	if (SherlockActivity.class.isAssignableFrom(activityClass)) {
    		
    		Intent i = new Intent(NavDrawerActivity.this, activityClass);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
            
    	} else if (SherlockFragment.class.isAssignableFrom(activityClass))  {
    		
    		FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.content_frame, Fragment.instantiate(NavDrawerActivity.this, activityClass.getName()));
            tx.commit();
            
    	} else {
    		Toast.makeText(NavDrawerActivity.this, activityClass.getName() + " is no valid Activity or Fragment.", Toast.LENGTH_SHORT).show();
    	}

        mDrawerLayout.closeDrawers();
        
    }

	// ----------------------------------------------------------------------
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

	// ----------------------------------------------------------------------
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

	// ----------------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        if (mDrawerToggle.onOptionsItemSelected(item)) {
          return true;
        }

        return super.onOptionsItemSelected(item);
    }
	
}
