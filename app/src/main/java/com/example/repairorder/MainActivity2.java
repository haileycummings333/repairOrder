package com.example.repairorder;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //create a listener for the button to handle the user response
    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            submitButton.setText(R.string.submitted);

            double techSub = Double.parseDouble(technicianET.getText().toString()), inspectSub = Double.parseDouble(inspectionET.getText().toString()),
                paintSub = Double.parseDouble(paintET.getText().toString()), partsSub = Double.parseDouble(partsET.getText().toString()), laborSub = Double.parseDouble(laborET.getText().toString());

            double sub = (int)((techSub + inspectSub + paintSub + partsSub + laborSub)*100)/100.00;
            String subS = "$" + String.valueOf(sub);
            subtotalN.setText(subS);

            double tax = (sub*0.07);
            double taxAmount = ((int)(tax * 100)) / 100.00;
            String taxS = "$" + String.valueOf(taxAmount);
            taxN.setText(taxS);


            //add subtotal and tax
            double totalAmount = ((int)((sub+taxAmount) * 100)) / 100.00;
            String totalS = "$" + String.valueOf(totalAmount);
            totalN.setText(totalS);

            order = orderET.getText().toString();
        }
    };
    Button submitButton;
    EditText technicianET, inspectionET, paintET, partsET, laborET, orderET;


    TextView subtotalN, totalN, taxN;
    String  order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //create variable, use find by id and assign to that variable
        submitButton = findViewById(R.id.sButton); //sButton and submitButton are both of type Button, so textViews wouldn't work
        submitButton.setText(R.string.submit); //there is a 'set' method for every attribute for the widget (for ex changing the color)
        technicianET = findViewById(R.id.technicianEdit);
        inspectionET = findViewById(R.id.inspectionEdit);
        paintET = findViewById(R.id.PaintEdit);
        partsET = findViewById(R.id.partsEdit);
        laborET = findViewById(R.id.laborEdit);
        orderET = findViewById(R.id.orderTypeEdit);

        subtotalN =findViewById(R.id.subTotNum);
        totalN = findViewById(R.id.totalNum);
        taxN = findViewById(R.id.taxNum);

        //must assign the onClick listener to the button for it to work
        submitButton.setOnClickListener(submitListener);

    }


}