package com.hackathon.hackers.hackathon;

import com.harman.hkwirelessapi.*;
import android.util.Log;


public class HkConnection implements HKWirelessListener {
    static final String LOG_TAG="hackathon";

    public HkConnection() {
        HKWirelessHandler hControlHandler = new HKWirelessHandler();

        // Initialize the HKWControlHandler and start wireless audio
        if (hControlHandler.initializeHKWirelessController("2FA8-2FD6-C27D-47E8-A256-D011-3751-2BD6") != 0) {
            Log.d(LOG_TAG, "Invalid license key");
        }
        if (hControlHandler.isInitialized()) {
            int deviceCount = hControlHandler.getDeviceCount();
            Log.d(LOG_TAG, "HK device count: " + deviceCount);

            for (int i = 0; i < deviceCount; i++) {
                DeviceObj DeviceInfo = hControlHandler.getDeviceInfoByIndex(i);
                if (DeviceInfo != null) {
                    Log.d(LOG_TAG, "name :" + DeviceInfo.deviceName);
                    Log.d(LOG_TAG, "ipAddress :" + DeviceInfo.ipAddress);
                    Log.d(LOG_TAG, "volume :" + DeviceInfo.volume);
                    Log.d(LOG_TAG, "port :" + DeviceInfo.port);
                    Log.d(LOG_TAG, "role :" + DeviceInfo.role);
                    Log.d(LOG_TAG, "modelName :" + DeviceInfo.modelName);
                    Log.d(LOG_TAG, "zoneName :" + DeviceInfo.zoneName);
                    Log.d(LOG_TAG, "active :" + DeviceInfo.active);
                    Log.d(LOG_TAG, "version :" + DeviceInfo.version);
                    Log.d(LOG_TAG, "wifi :" + DeviceInfo.wifiSignalStrength);
                    Log.d(LOG_TAG, "groupID :" + DeviceInfo.groupId);
                    Log.d(LOG_TAG, "balance :" + DeviceInfo.balance);
                    Log.d(LOG_TAG, "isPlaying :" + DeviceInfo.isPlaying);
                    Log.d(LOG_TAG, "channelType :" + DeviceInfo.channelType);
                    Log.d(LOG_TAG, "isMaster :" + DeviceInfo.isMaster);
                } else {
                    Log.d(LOG_TAG, "Failed to get device info for device: " + i);
                }
            }
        }
    }

    public void onDeviceStateUpdated(long deviceId, int reason){

    }
    public void onPlaybackStateChanged(int playState){

    }
    public void onVolumeLevelChanged(long deviceId, int deviceVolume, int avgVolume){

    }
    public void onPlayEnded(){

    }
    public void onPlaybackTimeChanged(int timeElapsed){

    }
    public void onErrorOccurred(int errorCode, String errorMesg){

    }
}
