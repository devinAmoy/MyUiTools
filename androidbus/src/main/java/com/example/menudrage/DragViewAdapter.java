package com.example.menudrage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leftsidemenu.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class DragViewAdapter extends BaseAdapter implements SwapItemInterface{

    private String dataStr ="[  {    \"ico\": \"app_wdrw_ico\",    \"id\": \"8b2abd6b-18c2-4f8b-9990-b2d45f1aa91b\",    \"sort\": \"1\",    \"num\": \"0\",    \"title\": \"我的任务\"  },  {    \"ico\": \"app_jhsp_ico\",    \"id\": \"afce4ddf-194a-492a-b4ce-db79fd14801f\",    \"sort\": \"2\",    \"num\": \"12\",    \"title\": \"计划审批\"  },  {    \"ico\": \"app_rwsp_ico\",    \"id\": \"ac888f31-8392-4820-9254-49b11f71e2d3\",    \"sort\": \"3\",    \"num\": \"2\",    \"title\": \"任务审批\"  },  {    \"ico\": \"app_zjsp_ico\",    \"id\": \"f5462bb1-7151-4d1c-8d8e-d3653dc53e9a\",    \"sort\": \"4\",    \"num\": \"0\",    \"title\": \"总结审批\"  },  {    \"ico\": \"app_jxpd_ico\",    \"id\": \"13673a54-fa67-4f02-aeea-e4725ffbc853\",    \"sort\": \"5\",    \"num\": \"1\",    \"title\": \"绩效等级评定\"  },  {    \"ico\": \"app_daiban_ico\",    \"id\": \"92e44b6a-027c-4cd5-b35e-f90d29fe093f\",    \"sort\": \"6\",    \"num\": \"4\",    \"title\": \"待办流程\"  },  {    \"ico\": \"app_lcsp_ico\",    \"id\": \"aa7f6c21-5227-4f4b-832e-e04b34a1389e\",    \"sort\": \"7\",    \"num\": \"0\",    \"title\": \"已办流程\"  },  {    \"ico\": \"app_wdjh_ico\",    \"id\": \"e924e4a9-0698-4624-8947-66cf883e8809\",    \"sort\": \"8\",    \"num\": \"1\",    \"title\": \"我的计划\"  },  {    \"ico\": \"app_wdzj_ico\",    \"id\": \"14c0f70a-5f6a-47c9-9ea4-4356773aa225\",    \"sort\": \"9\",    \"num\": \"0\",    \"title\": \"我的总结\"  },  {    \"ico\": \"app_lccy_ico\",    \"id\": \"a708b6d3-b5f5-439e-9544-5dc0508fc34b\",    \"sort\": \"10\",    \"num\": \"12\",    \"title\": \"流程阅看\"  },  {    \"ico\": \"app_lccgx_ico\",    \"id\": \"0c4ad7d6-cb7b-4a27-9adb-fbb82dbfe67f\",    \"sort\": \"11\",    \"num\": \"3\",    \"title\": \"流程草稿箱\"  },  {    \"ico\": \"app_wdlc_ico\",    \"id\": \"3d8b4e65-09b9-4731-ba97-6b3b1e317290\",    \"sort\": \"12\",    \"num\": \"2\",    \"title\": \"我的流程\"  },  {    \"ico\": \"app_yx_ico\",    \"id\": \"1437cd9c-4595-46cb-8fde-e866e43f0825\",    \"sort\": \"13\",    \"num\": \"0\",    \"title\": \"邮箱\"  },  {    \"ico\": \"app_gsfw_ico\",    \"id\": \"1cd85fc6-0b69-4f04-aa79-883c6ba8649e\",    \"sort\": \"14\",    \"num\": \"2\",    \"title\": \"公司发文\"  },  {    \"ico\": \"app_ggtz_ico\",    \"id\": \"a4f08830-adaa-4412-9adf-55b9e773118e\",    \"sort\": \"15\",    \"num\": \"5\",    \"title\": \"公告/通知\"  }]";

    private List<MenuDragEntity> list = new ArrayList<>();
    private Context context;

    public DragViewAdapter(Context context){
        this.context = context;
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray asJsonArray = parser.parse(dataStr).getAsJsonArray();
        for (JsonElement jsonElement : asJsonArray) {
            list.add(gson.fromJson(jsonElement, MenuDragEntity.class));
        }
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
        MenuDragEntity bean = list.get(position);
        DragViewHolder holder;
        if (convertView == null) {
            holder = new DragViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.drag_view_item, null);
            holder.deleteImg = (ImageView) convertView.findViewById(R.id.delete_img);
            holder.iconImg = (ImageView) convertView.findViewById(R.id.icon_img);
            holder.nameTv = (TextView) convertView.findViewById(R.id.name_tv);
            holder.container = convertView.findViewById(R.id.item_container);
            convertView.setTag(holder);
        } else {
            holder = (DragViewHolder) convertView.getTag();
        }

        //获取资源图片
        int drawableId = context.getResources().getIdentifier(bean.ico,"mipmap", context.getPackageName());
        holder.iconImg.setImageResource(drawableId);

        holder.nameTv.setText(bean.title);
        holder.container.setBackgroundColor(Color.WHITE);
        return convertView;
    }

    @Override
    public void swapItem(int startPosition, int endPosition) {
        if (endPosition < list.size()){
            MenuDragEntity removeItem = list.remove(startPosition);
            list.add(endPosition, removeItem);
            notifyDataSetChanged();
        }
    }


    class DragViewHolder {
        public ImageView deleteImg;
        public ImageView iconImg;
        public TextView nameTv;
        public View container;
    }
}
