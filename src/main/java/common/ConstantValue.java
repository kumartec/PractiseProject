package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Senthil kumar
 */

public class ConstantValue {

    public String currentSystemTime() {
        String timeStamp = new SimpleDateFormat("HHmmssSSS").format(Calendar.getInstance().getTime());
        return timeStamp;

    }
}