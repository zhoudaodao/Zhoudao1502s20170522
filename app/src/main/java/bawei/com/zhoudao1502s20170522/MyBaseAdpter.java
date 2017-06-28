package bawei.com.zhoudao1502s20170522;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * date:2017/5/22
 * author:周道(leovo)
 * funcation:
 */

public class MyBaseAdpter extends BaseAdapter {
    private List<Bean> list;
    private Context context;

    public MyBaseAdpter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.baseadpter,null);
            v=new ViewHolder();
            v.iv= (ImageView) convertView.findViewById(R.id.iv);
            v.tv1= (TextView) convertView.findViewById(R.id.tv1);
            v.tv2= (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        v.iv.setImageResource(list.get(position).getPic());
        v.tv1.setText(list.get(position).getName());
        v.tv2.setText(list.get(position).getNews());
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv1,tv2;
    }
}
