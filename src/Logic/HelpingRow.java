package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс используемы для отображения вспомогательных таблиц в tableview
 * Костыль
 */
public class HelpingRow {
    public String number;
    public String value1;
    public String value2;
    public String value3;
    public String value4;
    public String value5;
    public String value6;
    public String value7;
    public String value8;
    public String value9;
    public String value10;

    public HelpingRow(ResultSet rs, int args) throws SQLException {
        setNumber(rs.getString("NMBR"));
        setValue1(rs.getString("VAL1"));
        setValue2("");
        setValue3("");
        setValue4("");
        setValue5("");
        setValue6("");
        setValue7("");
        setValue8("");
        setValue9("");
        if (args >= 2)
            setValue2(rs.getString("VAL2"));
        if (args >= 3)
            setValue3(rs.getString("VAL3"));
        if (args >= 4)
            setValue4(rs.getString("VAL4"));
        if (args >= 5)
            setValue5(rs.getString("VAL5"));
        if (args >= 6)
            setValue6(rs.getString("VAL6"));
        if (args >= 7)
            setValue7(rs.getString("VAL7"));
        if (args >= 8)
            setValue8(rs.getString("VAL8"));
        if (args >= 9)
            setValue9(rs.getString("VAL9"));
        if (args >= 10)
            setValue10(rs.getString("VAL10"));
    }

    public HelpingRow(ResultSet rs, int args,int numval) throws SQLException {
        setNumber(rs.getString("NMBR"));
        if(numval == 0) {
            String res = "Капитальный";
            if (rs.getString("VAL1").equals("0"))
                res = "Не капитальный";
            setValue1(res);
        }else setValue1(rs.getString("VAL1"));

        setValue2("");
        setValue3("");
        setValue4("");
        setValue5("");
        setValue6("");
        setValue7("");
        setValue8("");
        setValue9("");
        if (args >= 2)
            if(numval == 1) {
                String res = "Да";
                if (rs.getString("VAL2").equals("0"))
                    res = "Нет";
                setValue2(res);
            }else setValue2(rs.getString("VAL2"));
        if (args >= 3)
            setValue3(rs.getString("VAL3"));
        if (args >= 4)
            setValue4(rs.getString("VAL4"));
        if (args >= 5)
            setValue5(rs.getString("VAL5"));
        if (args >= 6)
            setValue6(rs.getString("VAL6"));
        if (args >= 7)
            setValue7(rs.getString("VAL7"));
        if (args >= 8)
            setValue8(rs.getString("VAL8"));
        if (args >= 9)
            setValue9(rs.getString("VAL9"));
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public String getValue6() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6 = value6;
    }

    public String getValue7() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7 = value7;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

    public String getValue9() {
        return value9;
    }

    public void setValue9(String value9) {
        this.value9 = value9;
    }


    public String getValue10() {
        return value10;
    }

    public void setValue10(String value10) {
        this.value10 = value10;
    }
}
