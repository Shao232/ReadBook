package net.ss.read.book;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author shao
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookGatherUtils bookGatherUtils = new BookGatherUtils(this);
        bookGatherUtils.searchBook();
    }
}
