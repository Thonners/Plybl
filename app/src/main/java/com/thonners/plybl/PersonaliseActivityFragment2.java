package com.thonners.plybl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PersonaliseActivityFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PersonaliseActivityFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonaliseActivityFragment2 extends Fragment implements View.OnClickListener{

    private final ArrayList<RadioButtonView> qualityButtons = new ArrayList<>(5) ;
    private final ArrayList<RadioButtonView> paintColourButtons = new ArrayList<>(5) ;
    private final ArrayList<RadioButtonView> jointTypeButtons = new ArrayList<>(5) ;

    private int selectedQuality = -1 ;
    private int selectedColour = -1 ;
    private int selectedJoint = -1;

    private OnFragmentInteractionListener mListener;

    public PersonaliseActivityFragment2() {
        // Required empty public constructor
    }

    /**
     * @return A new instance of fragment PersonaliseActivityFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonaliseActivityFragment2 newInstance() {
        PersonaliseActivityFragment2 fragment = new PersonaliseActivityFragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personalise_2, container, false);

        // Clear the arraylists so that we keep the correct indices for the newly created views
        qualityButtons.clear();
        paintColourButtons.clear();
        jointTypeButtons.clear();

        // Get the instances and add them to the collections
        qualityButtons.add((RadioButtonView) view.findViewById(R.id.wood_finish_1)) ;
        qualityButtons.add((RadioButtonView) view.findViewById(R.id.wood_finish_2)) ;
        qualityButtons.add((RadioButtonView) view.findViewById(R.id.wood_finish_3)) ;
        qualityButtons.add((RadioButtonView) view.findViewById(R.id.wood_finish_4)) ;
        qualityButtons.add((RadioButtonView) view.findViewById(R.id.wood_finish_5)) ;
        qualityButtons.get(0).initialise(getContext(), getResources().getDrawable(R.drawable.wood_quality_raw, null), "Raw", RadioButtonView.Type.QUALITY) ;
        qualityButtons.get(1).initialise(getContext(), getResources().getDrawable(R.drawable.wood_quality_walnut, null), "Walnut", RadioButtonView.Type.QUALITY) ;
        qualityButtons.get(2).initialise(getContext(), getResources().getDrawable(R.drawable.wood_quality_blackbutt, null), "Blackbutt", RadioButtonView.Type.QUALITY) ;
        qualityButtons.get(3).initialise(getContext(), getResources().getDrawable(R.drawable.wood_quality_jarrah, null), "Jarrah", RadioButtonView.Type.QUALITY) ;
        qualityButtons.get(4).initialise(getContext(), getResources().getDrawable(R.drawable.wood_quality_mahogany, null), "Mahogany", RadioButtonView.Type.QUALITY) ;

        paintColourButtons.add((RadioButtonView) view.findViewById(R.id.colour_1)) ;
        paintColourButtons.add((RadioButtonView) view.findViewById(R.id.colour_2)) ;
        paintColourButtons.add((RadioButtonView) view.findViewById(R.id.colour_3)) ;
        paintColourButtons.add((RadioButtonView) view.findViewById(R.id.colour_4)) ;
        paintColourButtons.add((RadioButtonView) view.findViewById(R.id.colour_5)) ;
        paintColourButtons.get(0).initialise(getContext(), view.findViewById(R.id.colour_1), ContextCompat.getColor(getContext(),R.color.clear), "None", RadioButtonView.Type.COLOUR);
        paintColourButtons.get(1).initialise(getContext(), view.findViewById(R.id.colour_2), ContextCompat.getColor(getContext(),R.color.primer), "Primed", RadioButtonView.Type.COLOUR) ;
        paintColourButtons.get(2).initialise(getContext(), view.findViewById(R.id.colour_3), ContextCompat.getColor(getContext(),R.color.white), "White", RadioButtonView.Type.COLOUR) ;
        paintColourButtons.get(3).initialise(getContext(), view.findViewById(R.id.colour_4), ContextCompat.getColor(getContext(),R.color.black), "Black", RadioButtonView.Type.COLOUR) ;
        paintColourButtons.get(4).initialise(getContext(), view.findViewById(R.id.colour_5), ContextCompat.getColor(getContext(),R.color.colorPrimary), "Custom", RadioButtonView.Type.COLOUR) ;


        jointTypeButtons.add((RadioButtonView) view.findViewById(R.id.joint_1)) ;
        jointTypeButtons.add((RadioButtonView) view.findViewById(R.id.joint_2)) ;
        jointTypeButtons.add((RadioButtonView) view.findViewById(R.id.joint_3)) ;
        jointTypeButtons.add((RadioButtonView) view.findViewById(R.id.joint_4)) ;
        jointTypeButtons.add((RadioButtonView) view.findViewById(R.id.joint_5)) ;
        jointTypeButtons.get(0).initialise(getContext(), getResources().getDrawable(R.drawable.joint_wedge, null), "Wedged", RadioButtonView.Type.JOINT) ;
        jointTypeButtons.get(1).initialise(getContext(), getResources().getDrawable(R.drawable.joint_dovetail, null), "Dovetail", RadioButtonView.Type.JOINT) ;
        jointTypeButtons.get(2).initialise(getContext(), getResources().getDrawable(R.drawable.joint_mortise, null), "Mortise and Tenon", RadioButtonView.Type.JOINT) ;
        jointTypeButtons.get(3).initialise(getContext(), getResources().getDrawable(R.drawable.joint_dowel, null), "Dowel", RadioButtonView.Type.JOINT) ;
        jointTypeButtons.get(4).initialise(getContext(), getResources().getDrawable(R.drawable.joint_rabbet, null), "Rabbet", RadioButtonView.Type.JOINT) ;

        // On Click Listeners
        for (RadioButtonView button : qualityButtons) {
            button.setOnClickListener(this);
        }
        for (RadioButtonView button : paintColourButtons) {
            button.setOnClickListener(this);
        }
       for (RadioButtonView button : jointTypeButtons) {
            button.setOnClickListener(this);
        }

        // Reinstate previously selected values
        if (selectedQuality >= 0) qualityButtons.get(selectedQuality).setButtonSelected(true);
        if (selectedColour >= 0) paintColourButtons.get(selectedColour).setButtonSelected(true);
        if (selectedJoint >= 0) jointTypeButtons.get(selectedJoint).setButtonSelected(true);

        return view ;
    }

    @Override
    public void onClick(View v) {
        if (v instanceof RadioButtonView) {
            switch (((RadioButtonView) v).getType()) {
                case QUALITY:
                    selectedQuality = qualityButtons.indexOf(v) ;
                    setSelected(((RadioButtonView) v), qualityButtons) ;
                    break;
                case COLOUR:
                    selectedColour = paintColourButtons.indexOf(v) ;
                    setSelected(((RadioButtonView) v), paintColourButtons) ;
                    break;
                case JOINT:
                    selectedJoint = jointTypeButtons.indexOf(v) ;
                    setSelected(((RadioButtonView) v), jointTypeButtons) ;
                    break;
            }
        }
    }

    public void setSelected(RadioButtonView v, ArrayList<RadioButtonView> buttons) {
        for (RadioButtonView button : buttons) {
            button.setButtonSelected(false);
        }
        v.setButtonSelected(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
/*        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void checkoutClicked();
    }

}
