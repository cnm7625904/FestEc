package com.tckj.festec.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tckj.latte.activities.ProxyActivity;
import com.tckj.latte.app.Latte;
import com.tckj.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelagate() {
        return new ExampleDelegate();
    }
}
