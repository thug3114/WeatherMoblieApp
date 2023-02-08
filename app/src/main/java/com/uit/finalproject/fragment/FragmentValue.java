package com.uit.finalproject.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uit.finalproject.R;

public class FragmentValue extends Fragment {

    TextView tvName, tvValue, tvUnit, tvTime, tvType;

    public FragmentValue() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.normal_fragment,container,false);

        tvName =(TextView) view.findViewById(R.id.tv_attr_name);
        tvValue =(TextView) view.findViewById(R.id.tv_attr_value);
        tvUnit =(TextView) view.findViewById(R.id.tv_attr_unit);
        tvTime =(TextView) view.findViewById(R.id.tv_attr_time);
        tvType =(TextView) view.findViewById(R.id.tv_attr_type);

        return view;
    }


}
