package com.example.moononyou.customadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class DriveAdapter extends ArrayAdapter<DriveVo> {
    Context context;
    int resId;
    ArrayList<DriveVo> datas;

    public DriveAdapter(Context context,int resId,ArrayList<DriveVo>datas){
        super(context,resId);
        this.context=context;
        this.resId=resId;
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //최초에 초기화될때 한번만 홀더를 만듦
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( resId, null );

            DriveHolder holder = new DriveHolder( convertView );
            convertView.setTag( holder );
        }
        //이미등록해 놓은  홀더를 계속해서 사용
        DriveHolder holder = (DriveHolder) convertView.getTag();

        ImageView typeImageView = holder.typeImageView;
        TextView titleView = holder.titleView;
        TextView dateView = holder.dateView;
        ImageView menuImageView = holder.menuImageView;

        final DriveVo vo = datas.get( position );

        titleView.setText( vo.title );
        dateView.setText( vo.date );

        if (vo.type.equals( "doc" )) {
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                            context.getResources(), R.drawable.ic_type_doc, null ) );
        } else if (vo.type.equals( "file" )) {
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                            context.getResources(), R.drawable.ic_type_file, null ) );
        } else if (vo.type.equals( "img" )) {
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                            context.getResources(), R.drawable.ic_type_image, null ) );
        }
            menuImageView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(
                            context, vo.title + "menu click", Toast.LENGTH_SHORT );
                    toast.show();
                }
            } );

            return convertView;

    }
}

