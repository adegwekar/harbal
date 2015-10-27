package com.hackathon.hackers.hackathon;

import com.harman.hkwirelessapi.*;
import android.util.Log;


public class HkConnection implements HKWirelessListener {
    static final String LOG_TAG="HarBalHkConnection";

    public HkConnection(HKWirelessHandler hControlHandler) {
        hControlHandler.registerHKWirelessControllerListener(this);

        //hControlHandler.startRefreshDeviceInfo();

        if (hControlHandler.isInitialized()) {
            int deviceCount = hControlHandler.getDeviceCount();
            Log.d(LOG_TAG, "HK device count: " + deviceCount);

            for (int i = 0; i < deviceCount; i++) {
                DeviceObj DeviceInfo = hControlHandler.getDeviceInfoByIndex(i);

                if (DeviceInfo != null) {
                    Log.d(LOG_TAG, "--- Device information ---");
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
                    Log.d(LOG_TAG, "groupName :" + DeviceInfo.groupName);
                    Log.d(LOG_TAG, "groupId :" + DeviceInfo.groupId);
                    Log.d(LOG_TAG, "deviceId :" + DeviceInfo.deviceId);
                    Log.d(LOG_TAG, "-----------------------");
                    if (DeviceInfo.deviceId != 31684328765616L) {
                        hControlHandler.removeDeviceFromSession(DeviceInfo.deviceId);
                        Log.d(LOG_TAG, "Removed " + DeviceInfo.deviceId + " from session");
                    }

                    //hControlHandler.addDeviceToSession(i);
                    //AudioCodecHandler hAudioControl = new AudioCodecHandler();
                    //hAudioControl.playWAV("/sdcard/Music/applause.wav");
                } else {
                    Log.d(LOG_TAG, "Failed to get device info for device: " + i);
                }
            }

            //if (hControlHandler.isDeviceActive(31684328765616L)) {
                hControlHandler.addDeviceToSession(31684328765616L);
                AudioCodecHandler hAudioControl = new AudioCodecHandler();
                Log.d(LOG_TAG, "Device 31684328765616L isPlaying: " + hAudioControl.isPlaying());
                hAudioControl.playCAF("/sdcard/Music/MozartPresto.mp3", "Mozart Presto", false);
                //hAudioControl.playWAV("/sdcard/Music/applause.wav");
                Log.d(LOG_TAG, "Device 31684328765616L isPlaying: " + hAudioControl.isPlaying());
                hAudioControl.stop();
                hControlHandler.removeDeviceFromSession(31684328765616L);
            //}
        }
    }

    public void onDeviceStateUpdated(long deviceId, int reason){
        if (deviceId == 31684328765616L) {
            Log.d(LOG_TAG, "Device " + deviceId + " state updated due to: " + reason);
        }
    }
    public void onPlaybackStateChanged(int playState){
        Log.d(LOG_TAG, "Playback state: " + playState);
    }
    public void onVolumeLevelChanged(long deviceId, int deviceVolume, int avgVolume){

    }
    public void onPlayEnded(){
        Log.d(LOG_TAG, "Play ended");
    }
    public void onPlaybackTimeChanged(int timeElapsed){

    }
    public void onErrorOccurred(int errorCode, String errorMesg){
        Log.e(LOG_TAG, "Error " + errorCode + ": " + errorMesg);
    }
}
