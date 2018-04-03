package com.example.luke.ceshi;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class WeixinFragment extends Fragment {

    Button button;
    EditText editText;
    ListView ListView_home;
    String[] names = {"北京一环", "上海虹桥", "旺角", "尖沙咀", "上下九", "珠村4号巷8栋301", "西关丽苑", "屯门色魔"};
    String[] things = {
            "广安大街是城市内环路的一部分，对中心城区起着一定的屏蔽作用。广安大街是南城地区唯一的贯通东西的主是南城地区交通集散的必经之路。",
            "位于中国上海市闵行区，为特等站，隶属于中国铁路上海局集团有限公司，于2008年7月20日开工建设，2010年7月1日投入使用。",
            "中国内地女演员，出生于1981年5月29日，2005年毕业于中央戏剧学院表演系本科班。",
            "1984年9月27日出生于加拿大安大略省，加拿大女歌手、词曲创作者、演员。",
            "原名刘诗施，中国内地影视女演员，出生于北京，毕业于北京舞蹈学院芭蕾舞专业。",
            "2001年，11岁的朴信惠拍摄了李承焕的第一部MV《爱吗》",
            "1990年5月30日出生于首尔，韩国女歌手、演员，女子演唱团体少女时代成员。",
            "屯门色魔，本名林国伟，曾多次在香港新界屯门区犯下强奸、抢劫和谋杀罪，令居住在屯门区的女士人心惶惶，并令香港于1990年代轰动一时。" +
                    "在香港奸杀罪案个案上，“屯门色魔”是继“雨夜屠夫”林过云后，最广为人知的一人。"
    };
    String[] price = {
            "3210.2", "1251", "6521", "202", "3333", "6666", "5152", "32111.2"
    };

    int[] icons = {R.drawable.w, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.a};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weixin_fragment, container, false);
        ListView_home = (ListView) view.findViewById(R.id.ListView_home);
        ListView_home.setAdapter(new MyListViewAdapter(getContext()));

        //列表触发事件
        ListView_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Toast.makeText(getContext(), names[position], Toast.LENGTH_SHORT).show();
            }
        });

        //搜索按钮
        button = (Button) view.findViewById(R.id.sousuo1);
        editText = (EditText) view.findViewById(R.id.neirong1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索内容扫描
                String inputtext = editText.getText().toString();
                Toast.makeText(getContext(), inputtext, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    class MyListViewAdapter extends BaseAdapter {
        Context context;

        public MyListViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHold vh;
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item, null);
                vh = new ViewHold();
                vh.iv = (ImageView) view.findViewById(R.id.ImgList);
                vh.tv = (TextView) view.findViewById(R.id.Lname);
                vh.tv2 = (TextView) view.findViewById(R.id.LinterView);
                vh.pv = (TextView) view.findViewById(R.id.Lprice);
                view.setTag(vh);
            } else {
                view = convertView;
                vh = (ViewHold) view.getTag();
            }
            vh.iv.setImageResource(icons[position]);
            vh.tv.setText(names[position]);
            vh.tv2.setText(things[position]);
            vh.pv.setText("$" + price[position] + "/月");
            return view;
        }

        class ViewHold {
            ImageView iv;
            TextView tv;
            TextView tv2;
            TextView pv;
        }
    }
}
