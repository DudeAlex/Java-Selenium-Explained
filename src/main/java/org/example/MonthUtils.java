package org.example;

public class MonthUtils {

    static final Month JANUARY = new Month("January", 21, 31);
    static final Month FEBRUARY = new Month("February", 20, 28);

    static final Month[] months = {JANUARY,FEBRUARY};

    public static class Month{
        private String month;
        private int workDays;
        private int days;

        private Month(String month, int workDays, int days) {
            this.month = month;
            this.workDays = workDays;
            this.days = days;
        }

        public static Month[] getAllMonths(){
            return months;
        }
//        public static Month[] getQuater(int quarter){
//            if (quarter==1){
//                return new Month[]{JANUARY, FEBRUARY};
//            }else if(quarter==2){
//                return new
//            }
//        }

        public String getMonth() {
            return month;
        }

        public int getWorkDays() {
            return workDays;
        }

        public int getDays() {
            return days;
        }
    }
}
