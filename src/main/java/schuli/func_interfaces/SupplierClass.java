package schuli.func_interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Supplier;

public class SupplierClass {
    public static void main( String[] args ) {
        Supplier<String> date = () -> {
            Calendar cl = Calendar.getInstance();
            return String.format( "%02d.%02d.%04d %02d:%02d:%02d.%03d",
                    cl.get( Calendar.DAY_OF_MONTH ),
                    cl.get( Calendar.MONTH ),
                    cl.get( Calendar.YEAR ),
                    cl.get( Calendar.HOUR_OF_DAY ),
                    cl.get( Calendar.MINUTE ),
                    cl.get( Calendar.SECOND ),
                    cl.get( Calendar.MILLISECOND )
            );
        };

        System.out.println( date.get() );
    }
}
