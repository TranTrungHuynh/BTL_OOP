package create.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class RandomDate {
	Date getDateRandom()
	{
		GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2018);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        String dateRandom = gc.get(gc.DAY_OF_MONTH) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.YEAR);
        
        Date result = null;
        
	    try
	    {
	    	result = new SimpleDateFormat("dd-MM-yyyy").parse(dateRandom);
		}
	    catch (ParseException e)
	    {
			e.printStackTrace();
		}
	    return result;
	}
	
	private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}

