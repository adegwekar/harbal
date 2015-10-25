package com.hackathon.hackers.hackathon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.gimbal.android.Gimbal;
import com.gimbal.android.PlaceManager;
import com.gimbal.android.PlaceEventListener;
import com.gimbal.android.Place;
import com.gimbal.android.Visit;
import com.gimbal.android.BeaconSighting;
import com.harman.hkwirelessapi.HKWirelessHandler;

import java.util.List;

public class MainActivity extends ActionBarActivity {
    static final String LOG_TAG="hackathon";
    static HKWirelessHandler hControlHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hControlHandler = new HKWirelessHandler();

        // Initialize the HKWControlHandler and start wireless audio
        if (hControlHandler.initializeHKWirelessController("2FA8-2FD6-C27D-47E8-A256-D011-3751-2BD6") != 0) {
            Log.d(LOG_TAG, "Invalid license key");
        }
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
            //Gimbal.setApiKey(this.getApplication(), "6f45d2aa-cd72-42d4-9642-5e482b6596a8");
            //PlaceManager.getInstance().startMonitoring();
            HkConnection hc = new HkConnection(hControlHandler);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onVisitStart(Visit visit) {

        // This will be invoked when a place is entered
        Log.d(LOG_TAG, "Visit start!");
    }

    public void onVisitEnd(Visit visit) {
        // This will be invoked when a place is exited
    }

    public void onBeaconSighting(BeaconSighting sighting, List<Visit> visits) {
        // This will be invoked when a beacon assigned to a place within a current visit is sighted.
        Log.d(LOG_TAG, "Beacon sighting!");
    }
}
