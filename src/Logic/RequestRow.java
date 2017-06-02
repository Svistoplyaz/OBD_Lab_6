package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс, являющийся отображением данных БД в таблицу о запросах, хранит данные из нескольких таблиц
 * используется для интегратции tableview с запросами jdbc
 */
public class RequestRow {
    public String id;
    public String income;
    public String outcome;
    public String street;
    public String number;
    public String type;
    public String result;
    public String pk;

    public RequestRow(ResultSet rs) throws SQLException {
        pk = rs.getString("PK");
        setId(rs.getString("PK"));
        setIncome(rs.getString("INCOME"));
        setOutcome(rs.getString("OUTCOME"));
        setStreet(rs.getString("STREET"));
        setNumber(rs.getString("INDX"));
        setType(rs.getString("RTYPE"));
        setResult(rs.getString("RES"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

