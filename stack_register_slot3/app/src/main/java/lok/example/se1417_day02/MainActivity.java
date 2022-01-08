package lok.example.se1417_day02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        //C1: kich hoat activity
//        Intent intent = this.getIntent();
//        String result = intent.getStringExtra("info");
//        if (result!=null) {
//            txtResult.setText(result);
//        }
    }

    public void clickToCreate(View view) {
        //empty activity
        Intent intent = new Intent(this, CreateProductActivity.class);
        //C1: startActivity(intent);
        startActivityForResult(intent,3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3000) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("info");
                txtResult.setText(result);
            }
        }
    }
}