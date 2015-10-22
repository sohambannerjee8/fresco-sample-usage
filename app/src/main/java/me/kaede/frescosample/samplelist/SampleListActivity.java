package me.kaede.frescosample.samplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.kaede.frescosample.R;
import me.kaede.frescosample.photoview.PhotoViewActivity;
import me.kaede.frescosample.recyclerview.RecyclerViewActivity;
import me.kaede.frescosample.basicusage.BasicUsageActivity;
import me.kaede.frescosample.gif.GifActivity;
import me.kaede.frescosample.listener.ListenerActivity;
import me.kaede.frescosample.listview.ListViewActivity;
import me.kaede.frescosample.lowres.LowResActivity;
import me.kaede.frescosample.postprocessor.PostprocessorActivity;
import me.kaede.frescosample.progressivejpg.ProgressiveJPGActivity;
import me.kaede.frescosample.resize.ResizeActivity;

public class SampleListActivity extends AppCompatActivity {
    ActivityHolder activityHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samplelist);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar_samplelist);
        this.setSupportActionBar(toolbar);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerview_samplelist);
        activityHolder = new ActivityHolder();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        activityHolder.addActivity("Basic Usage", BasicUsageActivity.class);
        activityHolder.addActivity("Gif/WebP Animation Image", GifActivity.class);
        activityHolder.addActivity("LowRes Image", LowResActivity.class);
        activityHolder.addActivity("Controller Listener", ListenerActivity.class);
        activityHolder.addActivity("Progressive JPG Streaming", ProgressiveJPGActivity.class);
        activityHolder.addActivity("Resize Image", ResizeActivity.class);
        activityHolder.addActivity("Postprocessor", PostprocessorActivity.class);
        activityHolder.addActivity("ListView", ListViewActivity.class);
        activityHolder.addActivity("RecyclerView", RecyclerViewActivity.class);
        activityHolder.addActivity("PhotoView", PhotoViewActivity.class);
        adapter.notifyDataSetChanged();
    }

    public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_samplelist_recycleview, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.textView.setText(activityHolder.getNameList().get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activityHolder.startActivity(v.getContext(),position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return activityHolder.getNameList().size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item_samplelist_recyclerview);
        }
    }
}