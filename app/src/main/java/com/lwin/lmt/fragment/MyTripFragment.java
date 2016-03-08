package com.lwin.lmt.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lwin.lmt.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lwin on 3/8/16.
 */
public class MyTripFragment extends ListFragment {

    private String title;
    private int page;
    private String [] hotel;
    public static final String TAG_IMAGE = "image";
    public static final String TAG_TITLE = "title";
    public static final String TAG_PAGE = "page";
    public static final String TAG_HOTEL="hotel";

    @Bind(R.id.txtlbl)
    TextView txtlbl;

    @Bind(R.id.pImage)
    ImageView profileImage;


    // newInstance constructor for creating fragment with arguments
    public static MyTripFragment newInstance(int image,int page,String title,String[] hotel) {
        MyTripFragment myTripFragment = new MyTripFragment();
        Bundle args = new Bundle();
        args.putInt(TAG_IMAGE,image);
        args.putInt(TAG_PAGE, page);
        args.putString(TAG_TITLE, title);
        args.putStringArray(TAG_HOTEL,hotel);
        myTripFragment.setArguments(args);
        return myTripFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        page = getArguments().getInt(TAG_PAGE);
        title = getArguments().getString(TAG_TITLE);
        hotel=getArguments().getStringArray(TAG_HOTEL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mytrip, container, false);
        ButterKnife.bind(this, view);

        profileImage.setImageResource(getArguments().getInt(TAG_IMAGE));
        txtlbl.setText(title);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, hotel);
        setListAdapter(adapter);

        return view;
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnCalendar)
    public void checkCalendar(){

        Toast.makeText(getActivity(),"Bookmark",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnMap)
    public void viewOnMap(){

        Toast.makeText(getActivity(),"View on Map",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnMore)
    public void viewMore(){

        Toast.makeText(getActivity(),"More",Toast.LENGTH_SHORT).show();
    }

}
