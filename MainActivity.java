import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextQuantity;
    private EditText editTextNextDeliveryDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextNextDeliveryDate = findViewById(R.id.editTextNextDeliveryDate);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int quantity = Integer.parseInt(editTextQuantity.getText().toString());
                String nextDeliveryDate = editTextNextDeliveryDate.getText().toString();

                addFuelType(name, quantity, nextDeliveryDate);
            }
        });

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = // отримайте ID рядка, який потрібно оновити
                String name = editTextName.getText().toString();
                int quantity = Integer.parseInt(editTextQuantity.getText().toString());
                String nextDeliveryDate = editTextNextDeliveryDate.getText().toString();

                updateFuelType(id, name, quantity, nextDeliveryDate);
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = // отримайте ID рядка, який потрібно видалити

                deleteFuelType(id);
            }
        });
    }

    private void addFuelType(String name, int quantity, String nextDeliveryDate) {
        FuelTypeDBHelper dbHelper = new FuelTypeDBHelper(this);
        FuelType fuelType = new FuelType(name, quantity, nextDeliveryDate);
        dbHelper.addFuelType(fuelType);
    }

    private void updateFuelType(int id, String name, int quantity, String nextDeliveryDate) {
        FuelTypeDBHelper dbHelper = new FuelTypeDBHelper(this);
        FuelType fuelType = new FuelType(id, name, quantity, nextDeliveryDate);
        dbHelper.updateFuelType(fuelType);
    }

    private void deleteFuelType(int id) {
        FuelTypeDBHelper dbHelper = new FuelTypeDBHelper(this);
        dbHelper.deleteFuelType(id);
    }
}
