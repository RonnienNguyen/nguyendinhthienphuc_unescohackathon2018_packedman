package tabian.com.instagramclone.Camera;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import tabian.com.instagramclone.R;
import tabian.com.instagramclone.Utils.BottomNavigationViewHelper;

/**
 * Created by User on 5/28/2017.
 */

public class CameraActivity extends AppCompatActivity{
    private static final String TAG = "CameraActivity";
    private static final int ACTIVITY_NUM = 1;

    private Context mContext = CameraActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started.");

        setupCameraAblum();
        setupBottomNavigationView();




    }

    private void setupCameraAblum() {

        Camera_support adapter = new Camera_support(getSupportFragmentManager());
        adapter.addFragment(new Camera_album_fragment());
        adapter.addFragment(new Camera_camera_fragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Information");
        tabLayout.getTabAt(1).setText("Camera");
    }


    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
