package helper;

public class Utils {



    public float removeDollor(String str){
        float num=0;
        try {
            num = Float.parseFloat(str.replace('$', ' ').trim());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return num;
    }

    public static String getTimeStamp(){
        long unixTime = System.currentTimeMillis() / 1000L;
        return String.valueOf(unixTime);
    }
}
