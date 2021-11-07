package com.example.bambinoclassroom.util;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

public final class AudioUtils {
    private AudioUtils() {
        //do nothing
    }

    public static MediaPlayer prepareAudio(AssetManager assets, String path) {
        try {
            Log.d("AUDIO",path);
            AssetFileDescriptor afd = assets.openFd(path);
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            player.prepare();

            return player;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
