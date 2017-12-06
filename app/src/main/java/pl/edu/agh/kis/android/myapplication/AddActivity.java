package pl.edu.agh.kis.android.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        Spinner spinner = findViewById(R.id.category);
        ArrayAdapter<CharSequence> categories = ArrayAdapter.createFromResource(this, R.array.categories, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(categories);

        RadioButton priNormal = findViewById(R.id.priority_normal);
        priNormal.setChecked(true);
    }

    public void onAddButtonClick(View view) {
        Intent data = new Intent();
        data.putExtra("name", ((EditText) findViewById(R.id.name)).getText().toString());
        data.putExtra("category", ((Spinner) findViewById(R.id.category)).getSelectedItem().toString());
        data.putExtra("priority", getPriority());
        setResult(RESULT_OK, data);
        finish();
    }

    private String getPriority() {
        RadioGroup radioGroup = findViewById(R.id.priority_group);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(checkedId);
        return radioButton.getText().toString();
    }
}
