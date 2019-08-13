package com.zsquad.rateusdialog;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RateUsDialogDialog extends AlertDialog {
    private View mDialogView;
    private Button btnAccept;
    private TextView dialogtitletextView;
    private TextView dialogtextView;
    private ImageView mIcon;
    String _url;

    public RateUsDialogDialog(Context context) {
        super(context);
        mDialogView = View.inflate(context, R.layout.dialog, null);
        setView(mDialogView);
        btnAccept = mDialogView.findViewById(R.id.dialogbtn);
        dialogtitletextView = mDialogView.findViewById(R.id.dialogtitletextView);
        dialogtextView = mDialogView.findViewById(R.id.dialogtextView);
        mIcon = mDialogView.findViewById(R.id.imageView);
        //
        this.setCancelable(false);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InfoIntent;
                try {
                    InfoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(_url));
                    getContext().startActivity(InfoIntent);

                } catch (ActivityNotFoundException ignored) {

                }
            }
        });
    }


    public RateUsDialogDialog _btnContinueOnClickListener(View.OnClickListener onClickListener) {
        btnAccept.setOnClickListener(onClickListener);
        return this;
    }

    //
    public RateUsDialogDialog _setMessage(CharSequence message) {
        dialogtextView.setText(message);
        return this;
    }


    public RateUsDialogDialog _url_your_app(String url) {
        _url=url;
        return this;
    }

    public RateUsDialogDialog _setTitle(CharSequence text) {
        dialogtitletextView.setText(text);
        return this;
    }

    public RateUsDialogDialog _setIcon(int drawableResId) {
        mIcon.setImageResource(drawableResId);
        return this;
    }

    /// R ID Methodes
    public RateUsDialogDialog _setMessage(int message) {
        dialogtextView.setText(message);
        return this;
    }







    public void _close() {
        this.dismiss();
    }

    public void _show() {
        this.show();
    }

}
