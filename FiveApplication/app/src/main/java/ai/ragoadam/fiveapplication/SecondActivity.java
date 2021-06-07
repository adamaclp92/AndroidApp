package ai.ragoadam.fiveapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(getIntent().hasExtra("result") && getIntent().hasExtra("text"));{
            TextView tv = (TextView) findViewById(R.id.resultText);
            TextView tv2 = (TextView) findViewById(R.id.resultTextWrite);
            int result = getIntent().getIntExtra("result", -1);
            String result2 = getIntent().getStringExtra("text");
            tv.setText("" + result);
            tv2.setText("" + result2);

            Button btnReturn1 = (Button) findViewById(R.id.btnReturn);
            btnReturn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = getIntent();
                    int result = intent.getIntExtra("result", -1);

                    Intent intent2 = new Intent();
                    intent2.putExtra("resultBack", result);
                    setResult(RESULT_OK,intent2);
                    finish();
                }
            }) ;
        }
    }
}
