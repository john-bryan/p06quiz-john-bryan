package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText etNum1;
EditText etNum2;
Button btnReset;
TextView tvOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnReset = findViewById(R.id.btnReset);
        tvOp = findViewById(R.id.tvOperation);

        registerForContextMenu(tvOp);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNum1.setText("");
                etNum2.setText("");
                tvOp.setText("Operation");
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Integer ans = Integer.parseInt(etNum1.getText().toString()) + Integer.parseInt(etNum2.getText().toString());
            tvOp.setText(ans.toString());

            return true; //menu item successfully handled
        }

        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Integer ans = Integer.parseInt(etNum1.getText().toString()) - Integer.parseInt(etNum2.getText().toString());
            tvOp.setText(ans.toString());
            return true;  //menu item successfully handled
        }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}
