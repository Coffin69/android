import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FuelTypeDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "fuel_type.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_FUEL_TYPE = "fuel_type";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_NEXT_DELIVERY_DATE = "next_delivery_date";

    public FuelTypeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_FUEL_TYPE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_QUANTITY + " INTEGER, " +
                COLUMN_NEXT_DELIVERY_DATE + " TEXT" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FUEL_TYPE);
        onCreate(db);
    }

    public void addFuelType(FuelType fuelType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, fuelType.getName());
        values.put(COLUMN_QUANTITY, fuelType.getQuantity());
        values.put(COLUMN_NEXT_DELIVERY_DATE, fuelType.getNextDeliveryDate());
        db.insert(TABLE_FUEL_TYPE, null, values);
        db.close();
    }

    public void updateFuelType(FuelType fuelType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, fuelType.getName());
        values.put(COLUMN_QUANTITY, fuelType.getQuantity());
        values.put(COLUMN_NEXT_DELIVERY_DATE, fuelType.getNextDeliveryDate());
        db.update(TABLE_FUEL_TYPE, values, COLUMN_ID + " = ?", new String[]{String.valueOf(fuelType.getId())});
        db.close();
    }

    public void deleteFuelType(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FUEL_TYPE, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<FuelType> getAllFuelTypes() {
        List<FuelType> fuelTypes = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_FUEL_TYPE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                int quantity = cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY));
                String nextDeliveryDate = cursor.getString(cursor.getColumnIndex(COLUMN_NEXT_DELIVERY_DATE));

                FuelType fuelType = new FuelType(id, name, quantity, nextDeliveryDate);
                fuelTypes.add(fuelType);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return fuelTypes;
    }
}
