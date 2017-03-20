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

/**
 * Created by YoungH on 3/16/17.
 */

public class PlayListView extends LinearLayout {
    private final View view;
    private MainActivity mContext;

    @BindView(R.id.playlist_listview) ListView listView;

    public PlayListView(Context context) {
        super(context);
        this.mContext = (MainActivity)context;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.play_listview, this);
        ButterKnife.bind(this,view);
        initListView();

    }

    private void initListView() {
        listView.setAdapter(new PlayListAdapter(mContext,mContext.getContent()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
