package test;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServiceTableUnitTest {

    @Test
    public void testAddRow() {
        ServiceTable table = new ServiceTable();

        Display display = new Display("Рекламна вивіска", "Бензин", 100);
        table.addRow(display);

        assertEquals(1, table.getRowCount());
        assertEquals(display, table.getRow(0));
    }

    @Test
    public void testUpdateRow() {
        ServiceTable table = new ServiceTable();

        Display display = new Display("Рекламна вивіска", "Бензин", 100);
        table.addRow(display);

        Display updatedDisplay = new Display("Інформаційна вивіска", "Дизель", 150);
        table.updateRow(0, updatedDisplay);

        assertEquals(updatedDisplay, table.getRow(0));
    }

    @Test
    public void testDeleteRow() {
        ServiceTable table = new ServiceTable();

        Display display1 = new Display("Рекламна вивіска", "Бензин", 100);
        Display display2 = new Display("Інформаційна вивіска", "Дизель", 150);
        table.addRow(display1);
        table.addRow(display2);

        table.deleteRow(0);

        assertEquals(1, table.getRowCount());
        assertEquals(display2, table.getRow(0));
    }
}
