package com.wilsonrc.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by W on 9/6/2018.
 */

public class FragmentLeft extends Fragment {

    // This method will be invoked when the Fragment view object is created.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_left, container);

        // Get Fragment belonged Activity
        final FragmentActivity fragmentBelongActivity = getActivity();

        if(retView!=null)
        {
            // Click this button will show the text in right fragment.
            AppCompatImageButton androidButton = (AppCompatImageButton)retView.findViewById(R.id.fragmentLeftButtonAndroid);
            androidButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Do not use fragmentBelongActivity.getFragmentManager() method which is not compatible with older android os version. .
                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();

                    // Get right Fragment object.
                    Fragment rightFragment = fragmentManager.findFragmentById(R.id.fragmentRight);

                    // Get the TextView object in right Fragment.
                    final TextView rightFragmentTextView = (TextView)rightFragment.getView().findViewById(R.id.fragmentRightTextView);

                    // Set text in right Fragment TextView.
                    rightFragmentTextView.setText("You click Android button.");
                }
            });


            // Click this button will show a Toast popup.
            AppCompatImageButton iosButton = (AppCompatImageButton)retView.findViewById(R.id.fragmentLeftButtonIos);
            iosButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(fragmentBelongActivity, "You click IOS button.", Toast.LENGTH_SHORT).show();
                }
            });


            // Click this button will show an alert dialog.
            AppCompatImageButton windowsButton = (AppCompatImageButton)retView.findViewById(R.id.fragmentLeftButtonWindows);
            windowsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog alertDialog = new AlertDialog.Builder(fragmentBelongActivity).create();
                    alertDialog.setMessage("You click Windows button.");
                    alertDialog.show();
                }
            });
        }

        return retView;
    }
}