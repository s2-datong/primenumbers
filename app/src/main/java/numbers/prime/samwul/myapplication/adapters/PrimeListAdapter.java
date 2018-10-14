package numbers.prime.samwul.myapplication.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import numbers.prime.samwul.myapplication.R;

public class PrimeListAdapter extends BaseAdapter {

    private List<int[]> data;
    private Context mContext;

    public void setList(List<int[]> primelist){ data = primelist; }

    public PrimeListAdapter(Context c){
        mContext = c;
        data = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int[] items = data.get(position);
        TextView textView = new TextView(mContext);
        textView.setText(joinNumbers(items));
        textView.setTextColor(mContext.getResources().getColor(R.color.textblack));
        textView.setMaxLines(1);

        return textView;
    }

    public String joinNumbers(int[] numbers){
        StringBuilder val = new StringBuilder();
        int ct = 0;
        for(int i: numbers){
            if(ct == 0) val.append(i);
            else val.append(", " + i);
            ct++;
        }
        return val.toString();
    }
}
