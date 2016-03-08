
package com.lwin.lmt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.lwin.lmt.fragment.MyTripFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.pager)
    ViewPager vPager;

    FragmentPagerAdapter adapterViewPager;

    static String[] trip1 = new String[] { "Aung Hotel", "Beach Hotel", "City Shine Hotel",
            "Dream High", "Favorite Hotel", "G-One Hotel", "Max Hotel", "Neo Hotel"};

    static String[] trip = new String[] { "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vPager.setClipToPadding(false);
        vPager.setPageMargin(15);
        vPager.setPadding(35, 5, 35, 5);
        vPager.setAdapter(adapterViewPager);
        Toast.makeText(this,"Trip "+String.valueOf(vPager.getCurrentItem()+1),Toast.LENGTH_SHORT).show();
        vPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getApplicationContext(), "Trip " + (position + 1), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 10;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MyTripFragment.newInstance(R.mipmap.wp1, 1, "Trip 1",trip1);
                case 1:
                    return MyTripFragment.newInstance(R.mipmap.wp2, 2, "Trip 2",trip);
                case 2:
                    return MyTripFragment.newInstance(R.mipmap.wp3, 3, "Trip 3",trip1);
                case 3:
                    return MyTripFragment.newInstance(R.mipmap.wp4, 4, "Trip 4",trip);
                case 4:
                    return MyTripFragment.newInstance(R.mipmap.wp5, 5, "Trip 5",trip1);
                case 5:
                    return MyTripFragment.newInstance(R.mipmap.wp6, 6, "Trip 6",trip);
                case 6:
                    return MyTripFragment.newInstance(R.mipmap.wp7, 7, "Trip 7",trip1);
                case 7:
                    return MyTripFragment.newInstance(R.mipmap.wp8, 8, "Trip 8",trip);
                case 8:
                    return MyTripFragment.newInstance(R.mipmap.wp9, 9, "Trip 9",trip1);
                case 9:
                    return MyTripFragment.newInstance(R.mipmap.wp10, 10, "Trip 10",trip);

                default:
                    return null;
            }
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "Trip " + position;
        }


    }
}
