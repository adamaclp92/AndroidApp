package ai.ragoadam.fiveapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);


                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;

                Bundle bund = new Bundle();
                bund.putInt("result", result);
                bund.putString("text", "Az összeadás eredménye:");

                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtras(bund);
                startActivityForResult(startIntent, 101);

            }
        });

        Button kivonBtn = (Button) findViewById(R.id.subBtn);
        kivonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 - num2;

                Bundle bund = new Bundle();
                bund.putInt("result", result);
                bund.putString("text", "A kivonás eredménye:");

                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtras(bund);
                startActivityForResult(startIntent, 101);

            }
        });

        Button multBtn = (Button) findViewById(R.id.multBtn);
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 * num2;

                Bundle bund = new Bundle();
                bund.putInt("result", result);
                bund.putString("text", "A szorzás eredménye:");

                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtras(bund);
                startActivityForResult(startIntent, 101);
            }
        });

        Button dialing = (Button) findViewById(R.id.dial);
        dialing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText secondNumEditText2 = (EditText) findViewById(R.id.secondNumEditText);
                String num2 = secondNumEditText2.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num2));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
        EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
        // firstNumEditText.setText(null);
        secondNumEditText.setText(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch(requestCode){
                case 101:
                    TextView tv = (TextView) findViewById(R.id.firstNumEditText);
                    int result = data.getIntExtra("resultBack", -2);
                    tv.setText("" + result);
                    break;
            }
        }
    }
}
