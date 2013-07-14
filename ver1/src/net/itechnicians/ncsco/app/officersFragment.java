package net.itechnicians.ncsco.app;

import java.util.ArrayList;
import java.util.List;

import net.itechnicians.ncsco.R;
import net.itechnicians.ncsco.entities.DaoMaster;
import net.itechnicians.ncsco.entities.DaoMaster.DevOpenHelper;
import net.itechnicians.ncsco.entities.DaoSession;
import net.itechnicians.ncsco.entities.Officer;
import net.itechnicians.ncsco.entities.OfficerDao;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class officersFragment extends Fragment
{
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private OfficerDao OfficerDAO;
	ListView lv;
	
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
				
				lv = (ListView) getActivity().findViewById(R.id.lvofficers);
		        
				
				//ListAdapter officers_array_list ;
				
		        ///officers_array_list=(ListAdapter) OfficerDAO.queryBuilder().list();
		       
//		         ArrayAdapter<Officer> arrayAdapter =      
//		         new ArrayAdapter<Officer>(getActivity(),android.R.layout.simple_list_item_1);
		         //lv.setAdapter((ListAdapter) daoSession.loadAll(Officer.class));
		
		return rootView;
	}
	
	


	

		

		

}

