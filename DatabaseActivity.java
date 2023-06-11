public class DatabaseActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.createTables();

        ListView listViewFuelTypes = findViewById(R.id.listViewFuelTypes);
        List<FuelType> fuelTypes = databaseHelper.getFuelTypes();
        FuelTypeAdapter adapter = new FuelTypeAdapter(this, fuelTypes);
        listViewFuelTypes.setAdapter(adapter);
    }
}
