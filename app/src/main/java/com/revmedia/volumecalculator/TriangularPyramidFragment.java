package com.revmedia.volumecalculator;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TriangularPyramidFragment extends Fragment {
    private EditText inputTriangleBase, inputTriangleHeight, inputHeight, result;
    private TextInputLayout inputLayoutTriangleBase, inputLayoutTriangleHeight, inputLayoutHeight;
    private Button btnSubmit;
    private View rootView;


    public TriangularPyramidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_triangular_pyramid, container, false);;

        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.triangular_pyramid_text));

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        inputLayoutTriangleBase = (TextInputLayout)rootView.findViewById(R.id.input_layout_triangle_base);
        inputLayoutTriangleHeight = (TextInputLayout)rootView.findViewById(R.id.input_layout_triangle_height);
        inputLayoutHeight = (TextInputLayout)rootView.findViewById(R.id.input_layout_height);
        inputTriangleBase = (EditText)rootView.findViewById(R.id.input_triangle_base);
        inputTriangleHeight = (EditText)rootView.findViewById(R.id.input_triangle_height);
        inputHeight = (EditText)rootView.findViewById(R.id.input_height);
        result = (EditText)rootView.findViewById(R.id.result);
        btnSubmit = (Button)rootView.findViewById(R.id.calculateTriangularPyramid);

        inputTriangleBase.addTextChangedListener(new MyTextWatcher(inputTriangleBase));
        inputTriangleHeight.addTextChangedListener(new MyTextWatcher(inputTriangleHeight));
        inputHeight.addTextChangedListener(new MyTextWatcher(inputHeight));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        return rootView;
    }

    private void submitForm(){
        if(!validateTriangleBase()){
            return;
        }
        if(!validateTriangleHeight()){
            return;
        }
        if(!validateHeight()){
            return;
        }
        double triangleBase = Double.parseDouble(inputTriangleBase.getText().toString().trim());
        double triangleHeight = Double.parseDouble(inputTriangleHeight.getText().toString().trim());
        double height = Double.parseDouble(inputHeight.getText().toString().trim());
        double resultSquare = (((triangleBase * triangleHeight)/2)*height)/3;
        result.setText(""+resultSquare);
        //Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_LONG).show();
    }

    private boolean validateTriangleBase(){
        if(inputTriangleBase.getText().toString().trim().isEmpty()){
            inputLayoutTriangleBase.setError(getString(R.string.error_text));
            requestFocus(inputTriangleBase);
            return false;
        }
        else{
            inputLayoutTriangleBase.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateTriangleHeight(){
        if(inputTriangleHeight.getText().toString().trim().isEmpty()){
            inputLayoutTriangleHeight.setError(getString(R.string.error_text));
            requestFocus(inputTriangleHeight);
            return false;
        }
        else{
            inputLayoutTriangleHeight.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateHeight(){
        if(inputHeight.getText().toString().trim().isEmpty()){
            inputLayoutHeight.setError(getString(R.string.error_text));
            requestFocus(inputHeight);
            return false;
        }
        else{
            inputLayoutHeight.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view){
        if(view.requestFocus()){
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view){
            this.view = view;
        }
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch(view.getId()){
                case R.id.input_triangle_base:
                    validateTriangleBase();
                    break;
                case R.id.input_triangle_height:
                    validateTriangleHeight();
                    break;
                case R.id.input_height:
                    validateHeight();
                    break;
            }
        }
    }
}
