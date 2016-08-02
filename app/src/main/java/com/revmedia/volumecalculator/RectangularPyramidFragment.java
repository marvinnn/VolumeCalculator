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


/**
 * A simple {@link Fragment} subclass.
 */
public class RectangularPyramidFragment extends Fragment {
    private EditText inputBaseLength, inputBaseWidth, inputHeight, result;
    private TextInputLayout inputLayoutBaseLength, inputLayoutBaseWidth, inputLayoutHeight;
    private Button btnSubmit;
    private View rootView;


    public RectangularPyramidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_rectangular_pyramid, container, false);;

        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.rectangular_prism_text));

        inputLayoutBaseLength = (TextInputLayout)rootView.findViewById(R.id.input_layout_base_length);
        inputLayoutBaseWidth = (TextInputLayout)rootView.findViewById(R.id.input_layout_base_width);
        inputLayoutHeight = (TextInputLayout)rootView.findViewById(R.id.input_layout_height);
        inputBaseLength = (EditText)rootView.findViewById(R.id.input_base_length);
        inputBaseWidth = (EditText)rootView.findViewById(R.id.input_base_width);
        inputHeight = (EditText)rootView.findViewById(R.id.input_height);
        result = (EditText)rootView.findViewById(R.id.result);
        btnSubmit = (Button)rootView.findViewById(R.id.calculateRectangularPyramid);

        inputBaseLength.addTextChangedListener(new MyTextWatcher(inputBaseLength));
        inputBaseWidth.addTextChangedListener(new MyTextWatcher(inputBaseWidth));
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
        if(!validateBaseWidth()){
            return;
        }
        if(!validateBaseLength()){
            return;
        }
        if(!validateHeight()){
            return;
        }
        double baseLength = Double.parseDouble(inputBaseLength.getText().toString().trim());
        double baseWidth = Double.parseDouble(inputBaseWidth.getText().toString().trim());
        double height = Double.parseDouble(inputHeight.getText().toString().trim());
        double resultSquare = (baseLength * baseWidth * height)/3;
        result.setText(""+resultSquare);
        //Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_LONG).show();
    }

    private boolean validateBaseLength(){
        if(inputBaseLength.getText().toString().trim().isEmpty()){
            inputLayoutBaseLength.setError(getString(R.string.error_text));
            requestFocus(inputBaseLength);
            return false;
        }
        else{
            inputLayoutBaseLength.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateBaseWidth(){
        if(inputBaseWidth.getText().toString().trim().isEmpty()){
            inputLayoutBaseWidth.setError(getString(R.string.error_text));
            requestFocus(inputBaseWidth);
            return false;
        }
        else{
            inputLayoutBaseWidth.setErrorEnabled(false);
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
                case R.id.input_base_length:
                    validateBaseLength();
                    break;
                case R.id.input_base_width:
                    validateBaseWidth();
                    break;
                case R.id.input_height:
                    validateHeight();
                    break;
            }
        }
    }
}
