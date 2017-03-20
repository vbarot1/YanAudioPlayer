package edu.gsu.httpscs.yanaudioplayer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.yanaudioplayer.AudioOb;
import edu.gsu.httpscs.yanaudioplayer.MainActivity;
import edu.gsu.httpscs.yanaudioplayer.R;
import edu.gsu.httpscs.yanaudioplayer.audio.BaseAudioOb;
import edu.gsu.httpscs.yanaudioplayer.audio.MusicController;
import edu.gsu.httpscs.yanaudioplayer.util.UtilLog;

/**
 * Created by Yan on 3/16/17.
 */

public class PlayView extends LinearLayout {

    private final View view;
    private MainActivity mContext;

    @BindView(R.id.main_player_title) TextView name;

    @OnClick(R.id.main_play_play)
    public void play(){
        UtilLog.logD("Music","Play");
        mContext.toastShort("Play");
    }

    public PlayView(Context context) {
        super(context);
        this.mContext = (MainActivity)context;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.viewpage_player, this);
        ButterKnife.bind(this,view);
    }

    public void update(){

    }
}
