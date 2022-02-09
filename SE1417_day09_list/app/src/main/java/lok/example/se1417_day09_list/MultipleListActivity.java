package lok.example.se1417_day09_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MultipleListActivity extends AppCompatActivity {
    private ListView listViewSubject;
    private List<String> listChoose;
    private String[] listSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_list);
        listViewSubject = findViewById(R.id.listViewSubject);
        listViewSubject.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listSubject = getResources().getStringArray(R.array.listSubject);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,listSubject);
        listViewSubject.setAdapter(adapter);
        listViewSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listChoose = new ArrayList<>();
                for (int id=0; id< adapterView.getCount(); id++) {
                    boolean check = listViewSubject.getCheckedItemPositions().get(id);
                    if (check) {
                        String subject = adapterView.getAdapter().getItem(id).toString();
                        listChoose.add(subject);
                    }
                }
            }
        });
    }

    public void clickToSave(View view) {
        Intent intent = new Intent(this,DetailActivity.class);
        String subject ="";
        for (int i =0;i<listChoose.size();i++){
            subject += listChoose.get(i) + " - ";
        }
        intent.putExtra("subject",subject);
        startActivity(intent);
    }
}