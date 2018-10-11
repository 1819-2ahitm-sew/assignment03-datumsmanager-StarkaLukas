package at.htl.mydate;

/**
 * Informationen zu Enums: http://tutorials.jenkov.com/java/enums.html
 *               zu split: https://stackoverflow.com/a/3481842/9818338
 *   zur Ermittlung des Wochentages: https://de.wikipedia.org/wiki/Wochentagsberechnung#Programmierung
 */
public class MyDate {

    private String dayString = "";
    private String monthString = "";
    private String yearString = "";
    private int dayInt = 0;
    private int monthInt = 0;
    private int yearInt = 0;
    private Weekday weekday;
    private String[] parts;
    private String date = "";
    private String weekdayString = "";
    private int year2 = 0;
    private int actualDay = 7;
    private int actualMonth = 10;
    private int actualYear = 2018;



    MyDate(String input) {
        if (correctDate(input)) {
            parts = input.split("\\.");
            dayString = parts[0];
            monthString = parts[1];
            yearString = parts[2];
            dayInt = Integer.valueOf(dayString);
            monthInt = Integer.valueOf(monthString);
            yearInt = Integer.valueOf(yearString);

            weekday = getWeekday(dayInt, monthInt, yearInt);
        }

    }

    private String getMonthString() {
        switch (monthInt) {
            case 1:
                monthString = "Jänner";
                break;
            case 2:
                monthString = "Februar";
                break;
            case 3:
                monthString = "März";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "Mai";
                break;
            case 6:
                monthString = "Juni";
                break;
            case 7:
                monthString = "Juli";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "Oktober";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "Dezember";
                break;
        }
        return monthString;
    }

    public boolean correctDate(String input) {
        boolean correctDate = true;

        parts = input.split("\\.");
        dayString = parts[0];
        monthString = parts[1];
        yearString = parts[2];
        dayInt = Integer.valueOf(dayString);
        monthInt = Integer.valueOf(monthString);
        yearInt = Integer.valueOf(yearString);

        if ((monthInt == 1) && (dayInt > 31)) {
            correctDate = false;
        }
        else if ((monthInt == 2) && (dayInt > 28)) {
            if ((dayInt == 29) && (!is29days())) {
                correctDate = false;
            }
        }
        else if ((monthInt == 3) && (dayInt > 31)) {
            correctDate = false;
        }
        else if ((monthInt == 4) && (dayInt > 30)) {
            correctDate = false;
        }
        else if ((monthInt == 5) && (dayInt > 31)) {
            correctDate = false;
        }
        else if ((monthInt == 6) && (dayInt > 30)) {
            correctDate = false;
        }
        else if ((monthInt == 7) && (dayInt > 31)) {
            correctDate = false;
        }
        else if ((monthInt == 8) && (dayInt > 31)) {
            correctDate = false;
        }
        else if ((monthInt == 9) && (dayInt > 30)) {
            correctDate = false;
        }
        else if ((monthInt == 10) && (dayInt > 31)) {
            correctDate = false;
        }
        else if ((monthInt == 11) && (dayInt > 30)) {
            correctDate = false;
        }
        else if ((monthInt == 12) && (dayInt > 31)) {
            correctDate = false;
        } else if ((yearInt > actualYear)) {
            correctDate = false;
        } else if ((yearInt == actualYear) && (monthInt > actualMonth)) {
            correctDate = false;
        } else if ((yearInt == actualYear) && (monthInt == actualMonth) && (dayInt > actualDay)) {
            correctDate = false;
        }


        return correctDate;
    }

    private boolean is29days() {
        boolean is29days = false;

        if (yearInt % 4 == 0) {
            if (yearInt % 100 == 0 && yearInt % 400 == 0) {
                is29days = true;
            } else if (yearInt % 100 == 0 && yearInt % 400 != 0) {
                is29days = true;
            }


        }
        return is29days;
    }

    private Weekday getWeekday(int dayInt, int monthInt, int yearInt) {
        int weekdayInt = 0;
        year2 = yearInt % 100;

        if (monthInt < 3) {
            year2 = year2 - 1;
        }
        weekdayInt = ((dayInt + (int)(2.6 * ((monthInt + 9) % 12 + 1) - 0.2)
                + year2 % 100 + (int)(year2 % 100 / 4) + (int)(year2 / 400)
                - 2 * (int)(year2 / 100) - 1) % 7 + 7) % 7 + 1;

        switch (weekdayInt) {
            case 1:
                weekday = Weekday.MONDAY;
                break;
            case 2:
                weekday = Weekday.TUESDAY;
                break;
            case 3:
                weekday = Weekday.WEDNESDAY;
                break;
            case 4:
                weekday = Weekday.THURSDAY;
                break;
            case 5:
                weekday = Weekday.FRIDAY;
                break;
            case 6:
                weekday = Weekday.SATURDAY;
                break;
            case 7:
                weekday = Weekday.SUNDAY;
                break;
        }
        return weekday;
    }

    private String getWeekdayString() {
        switch (weekday) {
            case MONDAY:
                weekdayString = "Montag";
                break;
            case TUESDAY:
                weekdayString = "Dienstag";
                break;
            case WEDNESDAY:
                weekdayString = "Mittwoch";
                break;
            case THURSDAY:
                weekdayString = "Donnerstag";
                break;
            case FRIDAY:
                weekdayString = "Freitag";
                break;
            case SATURDAY:
                weekdayString = "Samstag";
                break;
            case SUNDAY:
                weekdayString = "Sonntag";
                break;
        }

        return weekdayString;
    }
    public String formatDate() {
        monthString = getMonthString();
        weekdayString = getWeekdayString();

        date = weekdayString + ", " + dayInt + ". " + monthString + " " + yearInt;

        return date;

    }
    public boolean isYoungerThan(MyDate other) {
        boolean isYounger = false;

        if (yearInt > other.yearInt) {
            isYounger = true;
        } else if ((yearInt == other.yearInt) && (monthInt > other.monthInt)) {
            isYounger = true;
        } else if ((yearInt == other.yearInt) && (monthInt == other.monthInt) && (dayInt > other.dayInt)) {
            isYounger = true;
        }
        return isYounger;

    }

    //region Getter
    public int getDay() {
        return dayInt;
    }

    public int getYear() {
        return yearInt;
    }

    public int getMonth() {
        return monthInt;
    }

    public Weekday getWeekday() {
        return weekday;
    }
    //endregion
}
