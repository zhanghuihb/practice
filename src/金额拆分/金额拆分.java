package 金额拆分;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 请将金额（准确度到分）按拆分比例拆分：比如现有1000.01元，拆分比例为3:3:0:4，则拆分后金额为：300.00,300.00,0,400.01
 * 现有参数如下：
 * double total;//金额
 * double[]d;//拆分比例
 *
 * @author Tainy
 * @date 2018/9/19 12:01
 */
public class 金额拆分 {
    public static double[] split(double total, double[] doubles){
        double[] result = new double[doubles.length];
        double sum = 0;
        double temp = 0;
        for(int i = 0;i<doubles.length;i++){
            sum+=doubles[i];
        }
        for(int j = 0;j<doubles.length - 1;j++){
            result[j] =new BigDecimal(total).multiply(new BigDecimal(doubles[j]/sum)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            temp+=result[j];
        }

        result[doubles.length - 1] = total - temp;
        System.out.println(result);
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(split(1000.01, new double[]{3, 3, 0, 4}));
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(dateTimeFormatter));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(new DecimalFormat("#.00").format(1000.5123));
    }
}
