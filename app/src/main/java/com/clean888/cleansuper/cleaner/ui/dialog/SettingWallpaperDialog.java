package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogWallpaperBinding;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

public class SettingWallpaperDialog extends BaseDialog implements View.OnClickListener {
    DialogWallpaperBinding a;
    Runnable b;
    Runnable c;

    public SettingWallpaperDialog(@NonNull Context context, Runnable runnable, Runnable runnable2) {
        super(context, R.style.transparent_dialog);
        this.b = runnable;
        this.c = runnable2;
    }

    @Override
    public void onClick(View view) {
        if (view == this.a.stop) {
            dismiss();
            this.b.run();
        } else {
            dismiss();
            this.c.run();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogWallpaperBinding inflate = DialogWallpaperBinding.inflate(LayoutInflater.from(getContext()));
        this.a = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(true);
        this.a.getRoot().setOnClickListener(this);
        this.a.stop.setOnClickListener(this);
        this.a.keepGoing.setOnClickListener(this);
    }
}
