package com.sunclub.ut3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    private AlertDialog mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //创建About按钮
        View aboutButton = rootView.findViewById(R.id.about_button);

        //设置About按钮监听
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.about_title);
                builder.setMessage(R.string.about_text);
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                mDialog = builder.show();
            }
        });

        //创建New Game按钮 和 Continue按钮
        View newButton = rootView.findViewById(R.id.new_button);
        View continueButton = rootView.findViewById(R.id.continue_button);

        //设置New Game监听
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                getActivity().startActivity(intent);
            }
        });

        //设置Continue监听
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(GameActivity.KEY_RESTORE,true);
                getActivity().startActivity(intent);
            }
        });



        return rootView;
    }

    public void onPause(){
        super.onPause();

        if (mDialog != null)
            mDialog.dismiss();
    }
}
