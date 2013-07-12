package net.itechnicians.ncsco.app;

import com.actionbarsherlock.app.SherlockListFragment;
import com.example.pruebaactionbar.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class officersFragment extends SherlockListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_officer_list, container, false);
		//TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
		//dummyTextView.setText("1");
		return rootView;
	}
}
