class Solution {
    static boolean isLeapYear(int year)
    {
        return (year%400==0) || (year%4==0 && year%100!=0);
    }
    public String dayOfTheWeek(int day, int month, int year) {
        int daysInMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
        String[] weekDays={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int total=0;
        for(int y=1971;y<year;y++)
        {
            if(isLeapYear(y))
                total+=366;
            else
                total+=365;
        }
        for(int m=1;m<month;m++)
        {
            if(m==2 && isLeapYear(year))
                total++;
            else
                total+=daysInMonth[m-1];
        }
        total+=day-1;
        return weekDays[(total+5)%7];

    }
}