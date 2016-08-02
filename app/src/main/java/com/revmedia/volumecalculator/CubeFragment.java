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
public class CubeFragment extends Fragment {
    private EditText inputEdge, result;
    private TextInputLayout inputLayoutEdge;
    private Button btnSubmit;
    private View rootView;

    public CubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_cube, container, false);;

        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.cube_text));

        inputLayoutEdge = (TextInputLayout)rootView.findViewById(R.id.input_layout_edge);
        inputEdge = (EditText)rootView.findViewById(R.id.input_edge);
        result = (EditText)rootView.findViewById(R.id.result);
        btnSubmit = (Button)rootView.findViewById(R.id.calculateCube);

        inputEdge.addTextChangedListener(new MyTextWatcher(inputEdge));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        return rootView;
    }

    private void submitForm(){
        if(!validateEdge()){
            return;
        }
        double edge = Double.parseDouble(inputEdge.getText().toString().trim());
        double resultSquare = edge * edge * edge;
        result.setText(""+resultSquare);
        //Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_LONG).show();
    }

    private boolean validateEdge(){
        if(inputEdge.getText().toString().trim().isEmpty()){
            inputLayoutEdge.setError(getString(R.string.error_text));
            requestFocus(inputEdge);
            return false;
        }
        else{
            inputLayoutEdge.setErrorEnabled(false);
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
                case R.id.input_edge:
                    validateEdge();
                    break;
            }
        }
    }


}
