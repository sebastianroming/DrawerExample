package de.sebastianroming.drawerexample;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    private ArrayList<DrawerItem> mItems = new ArrayList<DrawerItem>() {{
    	
        add(new DrawerItem(R.drawable.drw_ic_settings, R.string.drwitm_one));
        add(new DrawerItem(R.drawable.drw_ic_settings, R.string.drwitm_two));
        add(new DrawerItem(R.drawable.drw_ic_settings, R.string.drwitm_three));
        
    }};

	// ----------------------------------------------------------------------
    public NavDrawerAdapter(Context ctx) {
    	
        mContext = ctx;
        mInflater = LayoutInflater.from(mContext);    
        
    }

	// ----------------------------------------------------------------------
    public static int getResourceId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
        	return -1;
        }
    }

	// ----------------------------------------------------------------------
    @Override
    public int getCount() {
        return mItems.size();
    }

	// ----------------------------------------------------------------------
    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

	// ----------------------------------------------------------------------
    @Override
    public long getItemId(int i) {
        return i;
    }

	// ----------------------------------------------------------------------
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = mInflater.inflate(R.layout.drawer_list_item, null);

        ImageView mIcon = (ImageView)view.findViewById(R.id.icon);
        TextView mTitle = (TextView)view.findViewById(R.id.title);

        DrawerItem item = (DrawerItem) getItem(i);
        mIcon.setImageResource(item.getIcon());
        mTitle.setText(item.getTitle());

        return view;
    }

	// ----------------------------------------------------------------------
    public class DrawerItem {
        private int mIcon, mTitle;

        public DrawerItem(int icon, int title) {
            mIcon = icon;
            mTitle = title;
        }

        public int getIcon() {
            return mIcon;
        }
        
        public void setIcon(int mIcon) {
            this.mIcon = mIcon;
        }

        public int getTitle() {
            return mTitle;
        }

        public void setTitle(int mTitle) {
            this.mTitle = mTitle;
        }
    }
}