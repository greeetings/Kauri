public class Main {
    public static void main(String[] args) {

        System.out.println(coder(257));
        System.out.println(decoder("100000100000000100000001"));

    }
    public static String coder(long num) {
        String result="";
        int octetsNumber = 0;

        //short form
        if ( (num - 127) <= 0 ) {
            result = Long.toBinaryString(num);
            //adding  zeros ( to make 8bit)
            if (result.length() < 8) {
                String temp = result;
                result = "";
                for (int j = 0 ; j < 8 -  temp.length() ;j++ )
                    result+="0";

                result+=temp;
            }
            //long form
        } else {
            octetsNumber = 1;
            double temp = num;
            String sTemp =  "";
            while (temp  > 255 ) {
                octetsNumber ++;
                temp /= 255;
            }
            result += Integer.toBinaryString(128 + octetsNumber);
            result+=" ";
            sTemp = Long.toBinaryString(num);

            //adding  zeros ( to make 8bit)
            int size = sTemp.length();
            int mod = 8 -  (size % 8);
            if (mod == 8)
                mod = 0;
            for (int j = 0 ; j < mod ; j++)
                result+="0";

            result += sTemp;
        }
        return result;
    }



    public static long decoder(String code) {
        long result = 0;
        int octetsNumber = 0;

        if (code.charAt(0) == '0') {
            result = Long.parseLong(code, 2);
        } else {
             octetsNumber = Integer.parseInt(code.substring(1,8),2) ;
             result = Long.parseLong(code.substring(8,8*(octetsNumber+1) ),2);
        }


        //System.out.println(code.substring(8,8*2));

        return result;
    }
}



