package d9collection.exercise;

/**
 * @Description: 第一步
 * @Author Eva
 * @Date 2023/6/7 14:36 -> 2024/6/4 14:36
 */
public class MyDate implements Comparable {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate){
            MyDate m = (MyDate) o;

            int sumYear = this.getYear()-m.getYear();
            if (sumYear !=0){
                return sumYear;
            }
            int subMonth = this.getMonth()-m.getMonth();
            if (subMonth !=0){
                return subMonth;
            }
            return this.getDay()-m.getDay();
        }
        return 0;
    }
}
