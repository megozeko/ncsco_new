package net.itechnicians.ncsco.app;

import java.util.ArrayList;
import java.util.List;

import net.itechnicians.ncsco.R;
import net.itechnicians.ncsco.entities.DaoMaster;
import net.itechnicians.ncsco.entities.DaoMaster.DevOpenHelper;
import net.itechnicians.ncsco.entities.DaoSession;
import net.itechnicians.ncsco.entities.NCSCO;
import net.itechnicians.ncsco.entities.Officer;
import net.itechnicians.ncsco.entities.OfficerDao;
import net.itechnicians.ncsco.entities.OfficerDao.Properties;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockListFragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class officersFragment extends Fragment
{
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private OfficerDao OfficerDAO;
	ListView lvofficers;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_officer, container, false);
		
		
		// database things
				DevOpenHelper helper = new DaoMaster.DevOpenHelper(getActivity(), "Ncsco_db",null);
				db = helper.getWritableDatabase();
				daoMaster = new DaoMaster(db);
				daoSession = daoMaster.newSession();
				OfficerDAO = daoSession.getOfficerDao();
				// database things
				
				//bindings
				
				lvofficers=(ListView)getView().findViewById(R.id.lvofficers);
//				
//				ArrayList<Officer> officers = (ArrayList<Officer>) OfficerDAO.queryBuilder().list();
//				lvofficers.setAdapter((ListAdapter) officers);
		
		return rootView;
	}
	
	


	

		

		

}

