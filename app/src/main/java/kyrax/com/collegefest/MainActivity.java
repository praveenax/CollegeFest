package kyrax.com.collegefest;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageSwitcher imageSwitcher;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
//                case R.id.navigation_info:
//                    mTextMessage.setText(R.string.title_info);
//                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        imageSwitcher = (ImageSwitcher)findViewById(R.id.photoswitch);

//        Uri img_uri = Uri.parse("https://cdn.pixabay.com/photo/2017/08/07/01/41/magnifying-glass-2598507_960_720.jpg");


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return myView;
            }
        });

//        imageSwitcher.setImageURI(img_uri);
//        imageSwitcher.setImageResource(R.drawable.ic_home_black_24dp);

        final Uri img_uri = Uri.parse("android.resource://kyrax.com.collegefest/drawable/im1.jpg");
        final Uri img_uri2 = Uri.parse("android.resource://kyrax.com.collegefest/drawable/im2.jpg");
//         .parse("drawable/im1.jpg");
//        final Uri img_uri2 = Uri.parse("drawable/im2.jpg");
        imageSwitcher.postDelayed(new Runnable() {
            int i = 0;
            public void run() {
                int drawable = i++ % 2 == 0 ?R.drawable.ic_home_black_24dp :R.drawable.ic_dashboard_black_24dp;
                imageSwitcher.setImageResource(drawable);
//                imageSwitcher.setImageURI(i++ % 2 == 0 ?img_uri :img_uri2);
//                imageSwitcher.setImageResource();
                imageSwitcher.postDelayed(this, 2000);
            }
        }, 2000);


//        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);


    }

}
