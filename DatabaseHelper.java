public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "autofuel.db";
    private static final int DATABASE_VERSION = 1;

    // SQL-запити для створення таблиць
    private static final String CREATE_FUEL_TYPE_TABLE = "CREATE TABLE fuel_types " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, quantity INTEGER, next_delivery_date TEXT)";

    private static final String CREATE_DISPLAY_TABLE = "CREATE TABLE displays " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, fuel_type_id INTEGER, price REAL)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FUEL_TYPE_TABLE);
        db.execSQL(CREATE_DISPLAY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Оновлення бази даних, якщо необхідно
    }

    public void createTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(CREATE_FUEL_TYPE_TABLE);
        db.execSQL(CREATE_DISPLAY_TABLE);
    }

    public List<FuelType> getFuelTypes() {
        List<FuelType> fuelTypes = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("fuel_types", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int quantity = cursor.getInt(cursor.getColumnIndex("quantity"));
                String nextDeliveryDate = cursor.getString(cursor.getColumnIndex("next_delivery_date"));
                FuelType fuelType = new FuelType(id, name, quantity, nextDeliveryDate);
                fuelTypes.add(fuelType);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return fuelTypes;
    }
}
