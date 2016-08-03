package com.revmedia.volumecalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private Button cubeButton;
    private Button rectangularPrismButton;
    private Button triangularPrismButton;
    private Button rectangularPyramidButton;
    private Button triangularPyramidButton;
    private Button cylinderButton;
    private Button coneButton;
    private Button sphereButton;
    InterstitialAd mInterstitialAd;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        cubeButton = (Button)rootView.findViewById(R.id.buttonCube);
        rectangularPrismButton = (Button)rootView.findViewById(R.id.buttonRectangularPrism);
        triangularPrismButton = (Button)rootView.findViewById(R.id.buttonTriangularPrism);
        rectangularPyramidButton = (Button)rootView.findViewById(R.id.buttonRectangularPyramid);
        triangularPyramidButton = (Button)rootView.findViewById(R.id.buttonTriangularPyramid);
        cylinderButton = (Button)rootView.findViewById(R.id.buttonCylinder);
        coneButton = (Button)rootView.findViewById(R.id.buttonCone);
        sphereButton = (Button)rootView.findViewById(R.id.buttonSphere);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.app_name));

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();

        cubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CubeFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        rectangularPrismButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new RectangularPrismFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        triangularPrismButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Fragment fragment = new TriangularPrismFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        rectangularPyramidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new RectangularPyramidFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        triangularPyramidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Fragment fragment = new TriangularPyramidFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        cylinderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Fragment fragment = new CylinderFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        coneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Fragment fragment = new ConeFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });
        sphereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Fragment fragment = new SphereFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .addToBackStack("tag")
                        .commit();
            }
        });

        return rootView;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

}
