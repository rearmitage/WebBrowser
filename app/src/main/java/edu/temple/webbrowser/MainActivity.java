package edu.temple.webbrowser;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends Activity implements BrowserFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager = getFragmentManager();
    int spot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, new BrowserFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String instruction) {
        BrowserFragment browserFrag = new BrowserFragment();
        ArrayList fragments = new ArrayList();

        if(instruction.equals("New")) {
            fragments.add(browserFrag);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, browserFrag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(instruction.equals("Previous")){
            fragments.get(spot-1);
            browserFrag =(BrowserFragment)fragments.get(spot-1);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, browserFrag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
       else if(instruction.equals("Next")){
            fragments.get(spot+1);
            browserFrag =(BrowserFragment)fragments.get(spot+1);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, browserFrag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }
}
