package jp.gcreate.test.junit4;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gen0083 on 2014/07/10.
 */
public class IsDate extends BaseMatcher<Date> {
    private final int yyyy;
    private final int mm;
    private final int dd;
    Object actual;

    IsDate(int yyyy,int mm, int dd){
        this.yyyy = yyyy;
        this.mm = mm;
        this.dd = dd;
    }

    public static Matcher<Date> dateOf(int yyyy, int mm, int dd){
        return new IsDate(yyyy, mm, dd);
    }

    @Override
    public boolean matches(Object actual) {
        this.actual = actual;
        if(!(actual instanceof Date)) return false;
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) actual);
        if(yyyy != cal.get(Calendar.YEAR)) return false;
        if(mm != cal.get(Calendar.MONTH) + 1) return false;
        if(dd != cal.get(Calendar.DATE)) return false;
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(String.format("%d,%2d,%2d",yyyy,mm,dd));
        if(actual != null){
            description.appendText(" but actual is ");
            description.appendValue(new SimpleDateFormat("yyyy/MM/dd").format((Date) actual));
        }
    }
}
