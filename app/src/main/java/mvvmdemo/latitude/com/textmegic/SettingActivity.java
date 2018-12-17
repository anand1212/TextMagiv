package mvvmdemo.latitude.com.textmegic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class SettingActivity extends AppCompatActivity {
    CheckBox checkNewLineF, checkboxwhitespace, checkboxvericalespace, textwithbold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setupView();

    }

    private void setupView() {
        checkNewLineF = findViewById(R.id.checkNewLineF);
        checkboxwhitespace = findViewById(R.id.checkboxwhitespace);
        checkboxvericalespace = findViewById(R.id.checkboxvericalespace);
        textwithbold = findViewById(R.id.textwithbold);

        checkNewLineF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newline", "newline");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        checkboxwhitespace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("whitespace", "whitespace");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        checkboxvericalespace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("verticalspace", "verticalspace");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
        textwithbold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("bold", "bold");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }

}
