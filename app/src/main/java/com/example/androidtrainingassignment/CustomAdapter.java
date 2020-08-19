package com.example.androidtrainingassignment;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.ListAdapter;
        import android.widget.TextView;
        import com.squareup.picasso.Picasso;
        import java.util.ArrayList;
class CustomAdapter implements ListAdapter {
    ArrayList<Model> arrayList;
    Context context;

    public CustomAdapter(Context context, ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Model model = arrayList.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.listview_item, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("tittle", model.subjectName); //Optional parameters
                    intent.putExtra("imag", model.image); //Optional parameters
                    v.getContext().startActivity(intent);
                }
            });
            TextView tittle = convertView.findViewById(R.id.title);
            ImageView imag = convertView.findViewById(R.id.img);
            tittle.setText(model.subjectName);
            Picasso.with(context)
                    .load(model.image)
                    .into(imag);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}