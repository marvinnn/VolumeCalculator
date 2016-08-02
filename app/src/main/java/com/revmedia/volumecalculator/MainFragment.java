package com.revmedia.volumecalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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
        return rootView;
    }

}
