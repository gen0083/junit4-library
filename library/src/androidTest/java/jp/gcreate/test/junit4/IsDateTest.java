package jp.gcreate.test.junit4;

import org.junit.Test;

import java.util.*;

import static jp.gcreate.test.junit4.IsDate.dateOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by gen0083 on 2014/07/10.
 */
public class IsDateTest {
    @Test
    public void 今日の日付が2014年7月10日か() throws Exception{
        //Setup
        Date date = new Date();
        //Excercise
        //Verify
        assertThat(date, is(dateOf(2014,7,11)));
    }
}
