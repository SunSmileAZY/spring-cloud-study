/**
 * 520 心形输出
 * @author anzy
 * @version 1.0
 * @date 2020/5/20 9:43
 **/
public class My520 {

    public static void main(String[] args) {

        System.out.println(love("*"));
        color();
    }

    public static String love(String input) {

        int[] array = {0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 4, 5, 2, 3, 4, 1, 0, 1,
                0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            if (i % 7 == 0)
                sb.append("  \n");
            if (array[i] == 0)
                sb.append("   ");
            else if (array[i] == 4)
                sb.append("  ");
            else if (array[i] == 5)
                redAppend(sb," I " );
            else if (array[i] == 2)
                redAppend(sb, "Lvoe ");
            else if (array[i] == 3)
                redAppend(sb, "You" );
            else
                redAppend(sb.append("  "),input );

        }

        return sb.toString();

    }

    public static void redAppend(StringBuffer sb,String str){
//        sb.append("\033[31;4m"  + str + "\033[0m");
        sb.append(str);

    }


    public static void color() {
        System.out.println("\033[30;4m" + "my color" + "\033[0m");
        System.out.println("\033[31;4m" + "my color" + "\033[0m");
        System.out.println("\033[32;4m" + "my color" + "\033[0m");
        System.out.println("\033[33;4m" + "my color" + "\033[0m");
        System.out.println("\033[34;4m" + "my color" + "\033[0m");
        System.out.println("\033[35;4m" + "my color" + "\033[0m");
        System.out.println("\033[36;4m" + "my color" + "\033[0m");
        System.out.println("\033[37;4m" + "my color" + "\033[0m");
        System.out.println("\033[40;31;4m" + "my color" + "\033[0m");
        System.out.println("\033[41;32;4m" + "my color" + "\033[0m");
        System.out.println("\033[42;33;4m" + "my color" + "\033[0m");
        System.out.println("\033[43;34;4m" + "my color" + "\033[0m");
        System.out.println("\033[44;35;4m" + "my color" + "\033[0m");
        System.out.println("\033[45;36;4m" + "my color" + "\033[0m");
        System.out.println("\033[46;37;4m" + "my color" + "\033[0m");
        System.out.println("\033[47;4m" + "my color" + "\033[0m");
    }


}
