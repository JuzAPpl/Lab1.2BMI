package my.edu.tarc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Global variables
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById((R.id.imageViewResult));
    }

    protected void calculateBMI(View view){
        double dblHeight, dblWeight, dblBMI;

        //Parse and convert height and weight
        dblHeight = Double.parseDouble(editTextHeight.getText().toString());
        dblHeight /= 100;
        dblWeight = Double.parseDouble(editTextWeight.getText().toString());

        //Calculation of BMI
        dblBMI = dblWeight/(dblHeight*dblHeight);

        //Display results and image according to result
        textViewResult.setText(String.format("BMI: %.1f", dblBMI));

        if(dblBMI<=18.5){
            imageViewResult.setImageResource(R.drawable.under);
            textViewResult.setText(textViewResult.getText() + "\nYou are underweight.");
        }
        else if(dblBMI<25){
            imageViewResult.setImageResource(R.drawable.normal);
            textViewResult.setText(textViewResult.getText() + "\nYou are in normal weight.");
        }
        else{
            imageViewResult.setImageResource(R.drawable.over);
            textViewResult.setText(textViewResult.getText() + "\nYou are overweight.");
        }
    }

    protected void resetFields(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
