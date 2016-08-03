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
public class ConeFragment extends Fragment {
    private EditText inputRadius, inputHeight, result;
    private TextInputLayout inputLayoutRadius, inputLayoutHeight;
    private Button btnSubmit;
    private View rootView;


    public ConeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_cone, container, false);;

        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.cone_text));

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        inputLayoutRadius = (TextInputLayout)rootView.findViewById(R.id.input_layout_radius);
        inputLayoutHeight = (TextInputLayout)rootView.findViewById(R.id.input_layout_height);
        inputRadius = (EditText)rootView.findViewById(R.id.input_radius);
        inputHeight = (EditText)rootView.findViewById(R.id.input_height);
        result = (EditText)rootView.findViewById(R.id.result);
        btnSubmit = (Button)rootView.findViewById(R.id.calculateCylinder);

        inputRadius.addTextChangedListener(new MyTextWatcher(inputRadius));
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
        if(!validateRadius()){
            return;
        }
        if(!validateHeight()){
            return;
        }
        double radius = Double.parseDouble(inputRadius.getText().toString().trim());
        double height = Double.parseDouble(inputHeight.getText().toString().trim());
        double tempJari = 0;
        double resultSquare = 0;
        if(radius%7==0){
            tempJari /= 7;
            resultSquare = 22 * tempJari * radius * height;
        }
        else{
            tempJari = radius;
            resultSquare = 3.14 * radius * radius * height;
        }
        resultSquare /= 3;
        result.setText(""+resultSquare);
        //Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_LONG).show();
    }

    private boolean validateRadius(){
        if(inputRadius.getText().toString().trim().isEmpty()){
            inputLayoutRadius.setError(getString(R.string.error_text));
            requestFocus(inputRadius);
            return false;
        }
        else{
            inputLayoutRadius.setErrorEnabled(false);
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
                case R.id.input_radius:
                    validateRadius();
                    break;
                case R.id.input_height:
                    validateHeight();
                    break;
            }
        }
    }
}
