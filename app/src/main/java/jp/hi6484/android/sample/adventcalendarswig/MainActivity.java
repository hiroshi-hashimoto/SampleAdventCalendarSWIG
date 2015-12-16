package jp.hi6484.android.sample.adventcalendarswig;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.init_text)
    TextView mInitText;
    @Bind(R.id.add_text)
    TextView mAddText;
    @Bind(R.id.get_text)
    TextView mGetText;

    //libSampleAdventCalendarSWIG.soファイルの読み込み.
    static {
        System.loadLibrary("SampleAdventCalendarSWIG");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @OnClick({R.id.init_button, R.id.add_button, R.id.get_button})
    void onClick(View view) {
        if (view.getId() == R.id.init_button) {
            sample_advent.adventInitValue();
            mInitText.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.add_button) {
            sample_advent.adventAddValue(123);
            mAddText.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.get_button) {
            long value = sample_advent.adventGetValue();
            mGetText.setText(String.valueOf(value));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
