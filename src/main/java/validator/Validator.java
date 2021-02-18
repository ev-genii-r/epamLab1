package validator;

public class Validator {

    public String exception="no exception";
    public Validator(){}
    public void nullNegativeValidation(double speed, double length){
        if(speed==0 || length==0) {
            exception="null speed or length";
        }
        if(speed<0||length<0) {
            exception="speed and length must be positive";
        }
    }
    public boolean dataValidation(String speed,String length){
        if(speed.matches("[0-9/s/./-]*")&&length.matches("[0-9/s/./-]*")&&length!=null&&speed!=null){
            return true;
        }else {
            return false;
        }
    }
    public String getException(){
        return exception;
    }
}
