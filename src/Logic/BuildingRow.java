package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс используемый для отображения строений в tableview
 */
public class BuildingRow {
    public String number;
    public String street;
    public String type;
    public String status;
    public String flats;
    public String appartments;
    public String space;
    public String livingspace;
    public String mananger;
    public String post;
    public String id;

    public BuildingRow(ResultSet rs) throws SQLException {
        setId(rs.getString("ID"));
        setNumber(rs.getString("NAMB"));
        setStreet(rs.getString("STREET"));
        setType(rs.getString("TIP"));
        setStatus(rs.getString("STATUS"));
        setFlats(rs.getString("FLATS"));
        setAppartments(rs.getString("APPARTMENTS"));
        setSpace(rs.getString("TOTALSPACE"));
        setLivingspace(rs.getString("LIVINGSPACE"));
        setMananger(rs.getString("MANANGER"));
        setPost(rs.getString("POST"));
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlats() {
        return flats;
    }

    public void setFlats(String flats) {
        this.flats = flats;
    }

    public String getAppartments() {
        return appartments;
    }

    public void setAppartments(String appartments) {
        this.appartments = appartments;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getLivingspace() {
        return livingspace;
    }

    public void setLivingspace(String livingspace) {
        this.livingspace = livingspace;
    }

    public String getMananger() {
        return mananger;
    }

    public void setMananger(String mananger) {
        this.mananger = mananger;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}