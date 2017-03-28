package edu.gsu.httpscs.yanaudioplayer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpscs.yanaudioplayer.MainActivity;
import edu.gsu.httpscs.yanaudioplayer.R;
import edu.gsu.httpscs.yanaudioplayer.adapter.PlayListAdapter;
import edu.gsu.httpscs.yanaudioplayer.audio.MusicController;

/**
 * Created by YoungH on 3/16/17.
 */

public class PlayListView extends LinearLayout implements MusicController.IPlayerStatus{

    private final View view;
    private MainActivity mContext;
    private final MusicController controller;
    private PlayListAdapter adapter;


    @BindView(R.id.playlist_listview) ListView listView;

    public PlayListView(Context context) {
        super(context);
        this.mContext = (MainActivity)context;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.play_listview, this);
        ButterKnife.bind(this,view);
        initListView();
        controller = MusicController.getInstance(mContext);
        controller.addListener("PlayListView", this);

    }

    private void initListView() {
        adapter = new PlayListAdapter(mContext,mContext.getContent(),controller);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == controller.position) {
                        if (controller.isPlaying) {
                            controller.pause();
                    }else {
                            controller.play();
                        }
                }else {
                        controller.position = position;
                        controller.play();
                    }
            }
        });
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onProgress(int i) {

    }

    @Override
    public void onError(String error) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPrepared() {

    }

    @Override
    public void onSeekComplete() {

    }

    @Override
    public void onComplete() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUpdateCache(int i) {

    }

    @Override
    public void onPause() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart(int i) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onInitComplete() {

    }
}
