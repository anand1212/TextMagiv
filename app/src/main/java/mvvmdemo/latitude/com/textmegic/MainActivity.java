package mvvmdemo.latitude.com.textmegic;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;
    ImageView closedrawer;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        createDrawer();
    }

    private void setUpView() {
        drawer_layout = findViewById(R.id.drawer_layout2);
        closedrawer = drawer_layout.findViewById(R.id.closedrawer);

    }

    public void createDrawer() {


        ImageView ivMenu = findViewById(R.id.ivMenu);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.openDrawer(GravityCompat.START);
            }
        });
        closedrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.closeDrawer(Gravity.START);
            }
        });
        hideFragment();
        fragment = new TextRepeter();
        loadFragment(fragment);
    }

    private void hideFragment() {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().add(R.id.content_frame, fragment).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
    }

}
