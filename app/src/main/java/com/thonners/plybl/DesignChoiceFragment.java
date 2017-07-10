package com.thonners.plybl;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment to display a recyclerView of the items passed in.
 */
public class DesignChoiceFragment extends Fragment {

    private final static String DESIGN_CATEGORY_BUNDLE_EXTRA = "com.thonners.plybl.DesignChoiceFragment.designCategoryBundle" ;
    private final static String DESIGN_TAB_BUNDLE_EXTRA = "com.thonners.plybl.DesignChoiceFragment.designTabBundle" ;

    private RecyclerView rv ;

    public DesignChoiceFragment() {
        DesignLibraryManager dlm = new DesignLibraryManager();

    }

    public static DesignChoiceFragment newInstance(int designCategoryID, int tabNumber) {
        DesignChoiceFragment fragment = new DesignChoiceFragment() ;

        Bundle args = new Bundle() ;
        args.putInt(DESIGN_CATEGORY_BUNDLE_EXTRA, designCategoryID);
        args.putInt(DESIGN_TAB_BUNDLE_EXTRA, tabNumber);
        fragment.setArguments(args);

        return fragment ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_design_choice, container, false);

        rv = (RecyclerView) view.findViewById(R.id.recyclerView) ;
        // Get the cards
        List<CardEntry> list = getCardEntries() ;
        RecyclerViewAdapterDefault adapter = new RecyclerViewAdapterDefault(getContext(), list) ;
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        return view ;
    }

    private List<CardEntry> getCardEntries() {
        List<CardEntry> list = new ArrayList<>(6) ;
        list.add(new CardEntry(getContext().getDrawable(R.drawable.bookcase_4_512), "Spiral bookcase")) ;
        list.add(new CardEntry(getContext().getDrawable(R.drawable.bookcase_3_256), "Slanted bookcase")) ;
        list.add(new CardEntry(getContext().getDrawable(R.drawable.bookcase_2_256), "Abstract bookcase")) ;
        list.add(new CardEntry(getContext().getDrawable(R.drawable.bookcase_1), "Rounded bookcase")) ;
        list.add(new CardEntry(getContext().getDrawable(R.drawable.bookcase_4_512), "Spiral bookcase")) ;
        list.add(new CardEntry(getContext().getDrawable(R.drawable.bookcase_3_256), "Slanted bookcase")) ;
        return list ;
    }
}
