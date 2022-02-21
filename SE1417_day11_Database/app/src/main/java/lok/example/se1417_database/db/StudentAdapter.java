package lok.example.se1417_database.db;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import lok.example.se1417_database.R;
import lok.example.se1417_database.dtos.StudentDTO;

public class StudentAdapter extends BaseAdapter {
    private List<StudentDTO> studentDTOList;

    public void setStudentDTOList(List<StudentDTO> studentDTOList) {
        this.studentDTOList = studentDTOList;
    }

    @Override
    public int getCount() {
        return studentDTOList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentDTOList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.item, viewGroup, false);
        }
        TextView txtID = view.findViewById(R.id.txtID);
        TextView txtFullname = view.findViewById(R.id.txtFullname);
        TextView txtMark = view.findViewById(R.id.txtMark);
        StudentDTO dto = studentDTOList.get(i);
        txtID.setText(dto.getId());
        txtFullname.setText(dto.getName());
        txtMark.setText(dto.getMark()+"");
        return view;
    }
}
