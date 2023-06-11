package test;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstTableUnitTest {

    @Test
    public void testAddRow() {
        FirstTable table = new FirstTable();

        FuelType fuelType = new FuelType("Бензин", 50, "2023-06-15");
        table.addRow(fuelType);

        assertEquals(1, table.getRowCount());
        assertEquals(fuelType, table.getRow(0));
    }

    @Test
    public void testUpdateRow() {
        FirstTable table = new FirstTable();

        FuelType fuelType = new FuelType("Бензин", 50, "2023-06-15");
        table.addRow(fuelType);

        FuelType updatedFuelType = new FuelType("Дизель", 60, "2023-06-20");
        table.updateRow(0, updatedFuelType);

        assertEquals(updatedFuelType, table.getRow(0));
    }

    @Test
    public void testDeleteRow() {
        FirstTable table = new FirstTable();

        FuelType fuelType1 = new FuelType("Бензин", 50, "2023-06-15");
        FuelType fuelType2 = new FuelType("Дизель", 60, "2023-06-20");
        table.addRow(fuelType1);
        table.addRow(fuelType2);

        table.deleteRow(0);

        assertEquals(1, table.getRowCount());
        assertEquals(fuelType2, table.getRow(0));
    }
}
