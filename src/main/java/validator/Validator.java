package validator;
import com.epam.lab1.myExceptions.dataInputException;
public class Validator {

    public String exception="no exception";
    public Validator(){}
    public void nullNegativeValidation(double speed, double length) throws dataInputException{
        if(speed==0 || length==0) {
            throw new dataInputException("Null speed or length");
        }
        if(speed<0||length<0) {
            throw new dataInputException("Speed and length must be positive");
        }
    }
    public boolean dataValidation(String speed,String length) throws dataInputException{
        if(speed.matches("[0-9/s/./-]*")&&length.matches("[0-9/s/./-]*")&&(length.length()!=0)&&(speed.length()!=0)) {
            int flg1 = 0;
            int flg2 = 0;
            int flg3 = 0;
            int flg4 = 0;
            for (int i = 0; i < speed.length(); i++) {
                if (speed.charAt(i) == '-') {
                    flg1++;
                }
                if (speed.charAt(i) == '.') {
                    flg2++;
                }
            }
            for (int i = 0; i < length.length(); i++) {
                if (length.charAt(i) == '-') {
                    flg3++;
                }
                if (length.charAt(i) == '.') {
                    flg4++;
                }
            }
            if(length.length()==1) {
                if(length.charAt(0)=='-'||length.charAt(0)=='.')
                    throw new dataInputException("Incorrect data");
                    return false;
            }
            if(speed.length()==1) {
                if((speed.charAt(0) == '-') || (speed.charAt(0) == '.'))
                    throw new dataInputException("Incorrect data");
                    return false;
            }
            if (flg1 < 2 && flg2 < 2 && flg3 < 2 && flg4 < 2) {
                    return true;
             }
        }else {
            throw new dataInputException("Incorrect data");
        }
            return false;
    }
}
