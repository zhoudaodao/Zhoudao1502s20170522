package bawei.com.zhoudao1502s20170522;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2017/5/22
 * author:周道(leovo)
 * funcation:
 */

public class OneFragment extends Fragment {

    private ListView mLv;
    private List<Bean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,null);
        mLv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inteData();
        mLv.setAdapter(new MyBaseAdpter(getActivity(),list));

    }

    private void inteData() {
        list=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            list.add(new Bean(R.mipmap.ic_launcher,"周道"+i,"你好啊"+i));
        }
    }
}
