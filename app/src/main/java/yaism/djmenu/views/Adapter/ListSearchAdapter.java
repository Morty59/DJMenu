package yaism.djmenu.views.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import yaism.djmenu.R;
import yaism.djmenu.database.Entity.RecipeEntity;

/**
 * Created by Administrateur on 10/04/2017.
 */

public class ListSearchAdapter extends BaseAdapter {
    private Activity activity;
    private List<RecipeEntity> data;
    private static LayoutInflater inflater=null;
    //public ImageLoader imageLoader;

    public ListSearchAdapter(Activity a, List<RecipeEntity> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.description); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        //ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image

        RecipeEntity recipe = data.get(position);

        // Setting all values in listview
        title.setText(recipe.getName());
        artist.setText(recipe.getDescription());
        duration.setText("20 mn");
        //imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}
