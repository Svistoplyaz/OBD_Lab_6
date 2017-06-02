package DirectorView;

import Logic.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectorViewController extends PageController {

    //Position view elements
    public TextField po_name;
    public TableView po_table;
    public TableColumn po_id_T;
    public TableColumn po_name_T;

    //Answer type view elements
    public TextField at_name;
    public TableView at_table;
    public TableColumn at_id_T;
    public TableColumn at_name_T;

    //Request type view elements
    public TextField rt_name;
    public TableView rt_table;
    public TableColumn rt_id_T;
    public TableColumn rt_name_T;

    //Communication type view elements
    public TextField ct_name;
    public TableView ct_table;
    public TableColumn ct_id_T;
    public TableColumn ct_name_T;

    //House view elements
    public TextField hs_name;
    public TableView hs_table;
    public TableColumn hs_id_T;
    public TableColumn hs_name_T;

    //Repair view elements
    public CheckBox re_type;
    public DatePicker re_date;
    public ComboBox re_house;
    private Bank re_b = new Bank();
    public TableView re_table;
    public TableColumn re_id_T;
    public TableColumn re_type_T;
    public TableColumn re_date_T;
    public TableColumn re_house_T;

    //Flat view elements
    public TextField fl_number;
    public CheckBox fl_opinion;
    public DatePicker fl_date;
    public ComboBox fl_house;
    private Bank fl_b = new Bank();
    public TableView fl_table;
    public TableColumn fl_id_T;
    public TableColumn fl_number_T;
    public TableColumn fl_opinion_T;
    public TableColumn fl_date_T;
    public TableColumn fl_house_T;

    //Communication view elements
    public DatePicker co_date;
    public ComboBox co_comtype;
    private Bank co_b1 = new Bank();
    public ComboBox co_house;
    private Bank co_b2 = new Bank();
    public TableView co_table;
    public TableColumn co_id_T;
    public TableColumn co_date_T;
    public TableColumn co_comtype_T;
    public TableColumn co_house_T;

    //Worker view elements
    public TextField wo_lname;
    public TextField wo_fname;
    public TextField wo_mname;
    public TextField wo_sex;
    public ComboBox wo_position;
    private Bank wo_b = new Bank();
    public TableView wo_table;
    public TableColumn wo_id_T;
    public TableColumn wo_lname_T;
    public TableColumn wo_fname_T;
    public TableColumn wo_mname_T;
    public TableColumn wo_sex_T;
    public TableColumn wo_position_T;
    private boolean WT_loaded = false;

    //Citizen view elements
    public TextField ci_lname;
    public TextField ci_fname;
    public TextField ci_mname;
    public TextField ci_sex;
    public ComboBox ci_flat;
    private Bank ci_b = new Bank();
    public DatePicker ci_birthdate;
    public TextField ci_percent;
    public TextField ci_town;
    public TableView ci_table;
    public TableColumn ci_id_T;
    public TableColumn ci_lname_T;
    public TableColumn ci_fname_T;
    public TableColumn ci_mname_T;
    public TableColumn ci_sex_T;
    public TableColumn ci_birthdate_T;
    public TableColumn ci_percent_T;
    public TableColumn ci_town_T;
    public TableColumn ci_flat_T;
    public TableColumn ci_house_T;

    //Request view elements
    public TextField rq_cause;
    public TextField rq_answer;
    public DatePicker rq_date_request;
    public DatePicker rq_date_answer;
    public ComboBox rq_req_rt;
    private Bank rq_b1 = new Bank();
    public ComboBox rq_req_at;
    private Bank rq_b2 = new Bank();
    public ComboBox rq_req_worker;
    private Bank rq_b3 = new Bank();
    public ComboBox rq_req_citizen;
    private Bank rq_b4 = new Bank();
    public TableView rq_table;
    public TableColumn rq_id_T;
    public TableColumn rq_cause_T;
    public TableColumn rq_answer_T;
    public TableColumn rq_date_request_T;
    public TableColumn rq_date_answer_T;
    public TableColumn rq_req_rt_T;
    public TableColumn rq_req_at_T;
    public TableColumn rq_req_worker_T;
    public TableColumn rq_req_citizen_T;
    public TableColumn rq_req_flat_T;
    public TableColumn rq_req_house_T;

    //Communication overview elements
    public TextField cov_rating;
    public DatePicker cov_date;
    public ComboBox cov_communication;
    private Bank cov_b1 = new Bank();
    public ComboBox cov_worker;
    private Bank cov_b3 = new Bank();
    public TableView cov_table;
    public TableColumn cov_id_T;
    public TableColumn cov_rating_T;
    public TableColumn cov_date_T;
    public TableColumn cov_communication_T;
    public TableColumn cov_house_T;
    public TableColumn cov_worker_T;


    //House overview elements
    public TextField hov_rating;
    public DatePicker hov_date;
    public ComboBox hov_house;
    private Bank hov_b1 = new Bank();
    public ComboBox hov_worker;
    private Bank hov_b3 = new Bank();
    public TableView hov_table;
    public TableColumn hov_id_T;
    public TableColumn hov_rating_T;
    public TableColumn hov_date_T;
    public TableColumn hov_house_T;
    public TableColumn hov_worker_T;

    //Hosue specail page
    public ComboBox _hs_choose;
    private Bank _hs_b = new Bank();

    //House view elements
    public TextField _hs_name;
    public TableView _hs_table;
    public TableColumn _hs_id_T;
    public TableColumn _hs_name_T;


    //_House overview elements
    public TextField _hov_rating;
    public DatePicker _hov_date;
    public ComboBox _hov_house;
    private Bank _hov_b1 = new Bank();
    public ComboBox _hov_worker;
    private Bank _hov_b3 = new Bank();
    public TableView _hov_table;
    public TableColumn _hov_id_T;
    public TableColumn _hov_rating_T;
    public TableColumn _hov_date_T;
    public TableColumn _hov_house_T;
    public TableColumn _hov_worker_T;

    //Request view elements
    public TextField _rq_cause;
    public TextField _rq_answer;
    public DatePicker _rq_date_request;
    public DatePicker _rq_date_answer;
    public ComboBox _rq_req_rt;
    private Bank _rq_b1 = new Bank();
    public ComboBox _rq_req_at;
    private Bank _rq_b2 = new Bank();
    public ComboBox _rq_req_worker;
    private Bank _rq_b3 = new Bank();
    public ComboBox _rq_req_citizen;
    private Bank _rq_b4 = new Bank();
    public TableView _rq_table;
    public TableColumn _rq_id_T;
    public TableColumn _rq_cause_T;
    public TableColumn _rq_answer_T;
    public TableColumn _rq_date_request_T;
    public TableColumn _rq_date_answer_T;
    public TableColumn _rq_req_rt_T;
    public TableColumn _rq_req_at_T;
    public TableColumn _rq_req_worker_T;
    public TableColumn _rq_req_citizen_T;
    public TableColumn _rq_req_flat_T;
    public TableColumn _rq_req_house_T;

    //Repair view elements
    public CheckBox _re_type;
    public DatePicker _re_date;
    public ComboBox _re_house;
    private Bank _re_b = new Bank();
    public TableView _re_table;
    public TableColumn _re_id_T;
    public TableColumn _re_type_T;
    public TableColumn _re_date_T;
    public TableColumn _re_house_T;


    private Connection conn;
    private Statement stmt;

    @Override
    public String getStageName() {
        return "База домоуправления";
    }

    /**
     * Инициализация вида работника ГЖУ
     *
     * @throws SQLException
     */
    public void init() throws SQLException {

        conn = ai.getConnection();
        stmt = conn.createStatement();

        //Worker
//        wo_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        wo_lname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        wo_fname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        wo_mname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        wo_sex_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
        wo_position_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value5"));
        ResultSet rs = stmt.executeQuery("SELECT r.K_WORKER as NMBR, LAST_NAME as val1, FIRST_NAME as val2, MIDDLE_NAME as val3, SEX as val4, (select h.NAME from POSITION h where h.K_POSITION = r.K_W_POSITION) as val5 FROM WORKER r");
        ObservableList<HelpingRow> rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 5));
        wo_table.setItems(rr);
        try {
            rs = stmt.executeQuery("SELECT * FROM POSITION");
            wo_position.getItems().clear();
            wo_b.clear();
            while(rs.next()) {
                wo_position.getItems().add(rs.getString("NAME"));
                wo_b.add(Integer.parseInt(rs.getString("K_POSITION")));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }

        WT_loaded = true;


    }


    public void onSelectionWT(Event event)throws SQLException {
        if(WT_loaded){
            //Worker
//            wo_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
            wo_lname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
            wo_fname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
            wo_mname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
            wo_sex_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
            wo_position_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value5"));
            ResultSet rs = stmt.executeQuery("SELECT r.K_WORKER as NMBR, LAST_NAME as val1, FIRST_NAME as val2, MIDDLE_NAME as val3, SEX as val4, (select h.NAME from POSITION h where h.K_POSITION = r.K_W_POSITION) as val5 FROM WORKER r");
            ObservableList<HelpingRow> rr = FXCollections.observableArrayList();
            while (rs.next())
                rr.add(new HelpingRow(rs, 5));
            wo_table.setItems(rr);
            try {
                rs = stmt.executeQuery("SELECT * FROM POSITION");
                wo_position.getItems().clear();
                wo_b.clear();
                while(rs.next()) {
                    wo_position.getItems().add(rs.getString("NAME"));
                    wo_b.add(Integer.parseInt(rs.getString("K_POSITION")));
                }
            }catch (Exception e) {
                AlertBox.display("Ошибка","Неверно ввёденные значения");
                e.printStackTrace();
            }
        }
    }

    public void onSelectionCT(Event event)throws SQLException{
        //Citizen
//        ci_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        ci_lname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        ci_fname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        ci_mname_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        ci_sex_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
        ci_birthdate_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value5"));
        ci_percent_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value6"));
        ci_town_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value7"));
        ci_flat_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value8"));
        ci_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value9"));
        ResultSet rs = stmt.executeQuery("SELECT K_CITIZEN AS NMBR, LAST_NAME AS val1, FIRST_NAME as val2" +
                ", MIDDLE_NAME as val3, SEX as val4, TO_CHAR(r.\"DATE_OF_BIRTH\",'DD-MM-YYYY') as val5, SHARING_PERCENTAGE as val6, TOWN_NAME as val7," +
                "(select h.FLAT_NUMBER from FLAT h where h.K_FLAT = r.K_C_FLAT) as val8, (select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_C_HOUSE) as val9 from CITIZEN r");
        ObservableList rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 9));
        ci_table.setItems(rr);
        try {
            rs = stmt.executeQuery("SELECT f.FLAT_NUMBER,h.ADDRESS,f.K_FLAT FROM FLAT f, HOUSE h where f.K_F_HOUSE = h.K_HOUSE");
            ci_flat.getItems().clear();
            ci_b.clear();
            while(rs.next()) {
                ci_flat.getItems().add(rs.getString(2)+"/"+rs.getString(1));
                ci_b.add(Integer.parseInt(rs.getString(3)));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void onSelectionRT(Event event)throws SQLException{
        //Request
//        rq_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        rq_cause_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        rq_answer_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        rq_date_request_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        rq_date_answer_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
        rq_req_rt_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value5"));
        rq_req_at_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value6"));
        rq_req_worker_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value7"));
        rq_req_citizen_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value8"));
        rq_req_flat_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value9"));
        rq_req_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value10"));

        ResultSet rs = stmt.executeQuery("SELECT K_REQUEST AS NMBR, CAUSE AS val1, ANSWER as val2" +
                ",TO_CHAR(r.\"DATE_REQUEST\",'DD-MM-YYYY') as val3,TO_CHAR(r.\"DATE_ANSWER\",'DD-MM-YYYY') as val4, (select h.RT_NAME from REQUEST_TYPE h where h.K_RT = r.K_REQ_RT) as val5, " +
                "(select h.AT_NAME from ANSWER_TYPE h where h.K_AT = r.K_REQ_AT) as val6,(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_REQ_WORKER) as val7," +
                "(select h.LAST_NAME from CITIZEN h where h.K_CITIZEN = r.K_REQ_CITIZEN) as val8,(select h.FLAT_NUMBER from flat h where h.K_FLAT = r.K_REQ_FLAT) as val9," +
                "(select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_REQ_HOUSE) as val10 from REQUEST r");
        ObservableList rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 10));
        rq_table.setItems(rr);

        try {
            rs = stmt.executeQuery("select h.RT_NAME, h.K_RT from REQUEST_TYPE h");
            rq_req_rt.getItems().clear();
            rq_b1.clear();
            while (rs.next()){
                rq_req_rt.getItems().add(rs.getString(1));
                rq_b1.add(Integer.parseInt(rs.getString(2)));
            }

            rs = stmt.executeQuery("select h.AT_NAME,h.K_AT from ANSWER_TYPE h");
            rq_req_at.getItems().clear();
            rq_b2.clear();
            while (rs.next()){
                rq_req_at.getItems().add(rs.getString(1));
                rq_b2.add(Integer.parseInt(rs.getString(2)));
            }

            rs = stmt.executeQuery("select p.NAME, w.LAST_NAME, w.FIRST_NAME,w.K_WORKER from POSITION p,WORKER w where p.K_POSITION = w.K_W_POSITION");
            rq_req_worker.getItems().clear();
            rq_b3.clear();
            while (rs.next()){
                rq_req_worker.getItems().add(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
                rq_b3.add(Integer.parseInt(rs.getString(4)));
            }

            rs = stmt.executeQuery("SELECT LAST_NAME, ADDRESS, FLAT_NUMBER,c.K_CITIZEN FROM citizen c, flat f, house h where c.K_C_FLAT = f.K_FLAT and f.K_F_HOUSE = h.K_HOUSE");
            rq_req_citizen.getItems().clear();
            rq_b4.clear();
            while(rs.next()) {
                rq_req_citizen.getItems().add(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
                rq_b4.add(Integer.parseInt(rs.getString(4)));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }

    }

    public void onSelectionCOT(Event event)throws SQLException{
        //Communication overview
//        cov_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        cov_rating_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        cov_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        cov_communication_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        cov_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
        cov_worker_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value5"));

        ResultSet rs = stmt.executeQuery("SELECT K_COVERVIEW as NMBR, OVERVIEW_RATING AS val1, TO_CHAR(OVERVIEW_DATE,'DD-MM-YYYY') as val2," +
                "(select t.COMTYPE_NAME from COMMUNICATION c, COMMUNICATION_TYPE t where c.K_COMMUNICATION = r.K_COMMUNICATION and K_COM_COMTYPE = K_COMTYPE) as val3," +
                "(select t.ADDRESS from HOUSE t where t.K_HOUSE = r.K_HOUSE) as val4," +
                "(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_WORKER) as val5 from COMMUNICATION_OVERVIEW r");

        ObservableList rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 5));
        cov_table.setItems(rr);

        try {
            rs = stmt.executeQuery("select K_COMMUNICATION, COMTYPE_NAME, ADDRESS from communication, communication_type, house where K_COM_HOUSE = K_HOUSE and K_COMTYPE = K_COM_COMTYPE");
            cov_communication.getItems().clear();
            cov_b1.clear();
            while (rs.next()){
                cov_communication.getItems().add(rs.getString("COMTYPE_NAME")+"/"+rs.getString("ADDRESS"));
                cov_b1.add(Integer.parseInt(rs.getString("K_COMMUNICATION")));
            }

            rs = stmt.executeQuery("select p.NAME, w.LAST_NAME, w.FIRST_NAME,w.K_WORKER from POSITION p,WORKER w where p.K_POSITION = w.K_W_POSITION");
            cov_worker.getItems().clear();
            cov_b3.clear();
            while (rs.next()){
                cov_worker.getItems().add(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
                cov_b3.add(Integer.parseInt(rs.getString(4)));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void onSelectionHOT(Event event)throws SQLException{
        //House overview
//        hov_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        hov_rating_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        hov_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        hov_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        hov_worker_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));

        ResultSet rs = stmt.executeQuery("SELECT K_HOVERVIEW as NMBR, OVERVIEW_RATING AS val1, TO_CHAR(OVERVIEW_DATE,'DD-MM-YYYY') as val2," +
                "(select t.ADDRESS from HOUSE t where t.K_HOUSE = r.K_HO_HOUSE) as val3," +
                "(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_HO_WORKER) as val4 from HOUSE_OVERVIEW r");

        ObservableList rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 4));
        hov_table.setItems(rr);

        try {
            rs = stmt.executeQuery("select * from HOUSE");
            hov_house.getItems().clear();
            hov_b1.clear();
            while (rs.next()){
                hov_house.getItems().add(rs.getString("ADDRESS"));
                hov_b1.add(Integer.parseInt(rs.getString("K_HOUSE")));
            }

            rs = stmt.executeQuery("select p.NAME, w.LAST_NAME, w.FIRST_NAME,w.K_WORKER from POSITION p,WORKER w where p.K_POSITION = w.K_W_POSITION");
            hov_worker.getItems().clear();
            hov_b3.clear();
            while (rs.next()){
                hov_worker.getItems().add(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
                hov_b3.add(Integer.parseInt(rs.getString(4)));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void onSelectionHouT(Event event)throws SQLException{
        //House
//        _hs_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        _hs_name_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        ResultSet rs = stmt.executeQuery("SELECT K_HOUSE as NMBR, ADDRESS as val1 FROM HOUSE");
        ObservableList<HelpingRow> rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 1));
        _hs_table.setItems(rr);


        if(_hs_choose.getSelectionModel().getSelectedIndex() != -1) {
            //_House overview
//            _hov_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
            _hov_rating_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
            _hov_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
            _hov_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
            _hov_worker_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));

            if(_hs_choose.getSelectionModel().getSelectedIndex()!=0) {
                rs = stmt.executeQuery("SELECT K_HOVERVIEW as NMBR, OVERVIEW_RATING AS val1, TO_CHAR(OVERVIEW_DATE,'DD-MM-YYYY') as val2," +
                        "(select t.ADDRESS from HOUSE t where t.K_HOUSE = r.K_HO_HOUSE) as val3," +
                        "(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_HO_WORKER) as val4 from HOUSE_OVERVIEW r where r.K_HO_HOUSE = " + _hs_b.getI(_hs_choose.getSelectionModel().getSelectedIndex()));
            }else{
                rs = stmt.executeQuery("SELECT K_HOVERVIEW as NMBR, OVERVIEW_RATING AS val1, TO_CHAR(OVERVIEW_DATE,'DD-MM-YYYY') as val2," +
                        "(select t.ADDRESS from HOUSE t where t.K_HOUSE = r.K_HO_HOUSE) as val3," +
                        "(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_HO_WORKER) as val4 from HOUSE_OVERVIEW r");
            }
            rr = FXCollections.observableArrayList();
            while (rs.next())
                rr.add(new HelpingRow(rs, 4));
            _hov_table.setItems(rr);

            try {
                rs = stmt.executeQuery("select * from HOUSE");
                _hov_house.getItems().clear();
                _hov_b1.clear();
                while (rs.next()) {
                    _hov_house.getItems().add(rs.getString("ADDRESS"));
                    _hov_b1.add(Integer.parseInt(rs.getString("K_HOUSE")));
                }

                rs = stmt.executeQuery("select p.NAME, w.LAST_NAME, w.FIRST_NAME,w.K_WORKER from POSITION p,WORKER w where p.K_POSITION = w.K_W_POSITION");
                _hov_worker.getItems().clear();
                _hov_b3.clear();
                while (rs.next()) {
                    _hov_worker.getItems().add(rs.getString(1) + "/" + rs.getString(2) + "/" + rs.getString(3));
                    _hov_b3.add(Integer.parseInt(rs.getString(4)));
                }


            } catch (Exception e) {
                AlertBox.display("Ошибка","Неверно ввёденные значения");
                e.printStackTrace();
            }

            //Request
//            _rq_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
            _rq_cause_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
            _rq_answer_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
            _rq_date_request_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
            _rq_date_answer_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
            _rq_req_rt_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value5"));
            _rq_req_at_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value6"));
            _rq_req_worker_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value7"));
            _rq_req_citizen_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value8"));
            _rq_req_flat_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value9"));
            _rq_req_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value10"));

            if(_hs_choose.getSelectionModel().getSelectedIndex()!=0) {
                rs = stmt.executeQuery("SELECT K_REQUEST AS NMBR, CAUSE AS val1, ANSWER as val2" +
                        ",TO_CHAR(r.\"DATE_REQUEST\",'DD-MM-YYYY') as val3,TO_CHAR(r.\"DATE_ANSWER\",'DD-MM-YYYY') as val4, (select h.RT_NAME from REQUEST_TYPE h where h.K_RT = r.K_REQ_RT) as val5, " +
                        "(select h.AT_NAME from ANSWER_TYPE h where h.K_AT = r.K_REQ_AT) as val6,(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_REQ_WORKER) as val7," +
                        "(select h.LAST_NAME from CITIZEN h where h.K_CITIZEN = r.K_REQ_CITIZEN) as val8,(select h.FLAT_NUMBER from flat h where h.K_FLAT = r.K_REQ_FLAT) as val9," +
                        "(select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_REQ_HOUSE) as val10 from REQUEST r where r.K_REQ_HOUSE = " + _hs_b.getI(_hs_choose.getSelectionModel().getSelectedIndex()));
            }else{
                rs = stmt.executeQuery("SELECT K_REQUEST AS NMBR, CAUSE AS val1, ANSWER as val2" +
                        ",TO_CHAR(r.\"DATE_REQUEST\",'DD-MM-YYYY') as val3,TO_CHAR(r.\"DATE_ANSWER\",'DD-MM-YYYY') as val4, (select h.RT_NAME from REQUEST_TYPE h where h.K_RT = r.K_REQ_RT) as val5, " +
                        "(select h.AT_NAME from ANSWER_TYPE h where h.K_AT = r.K_REQ_AT) as val6,(select h.LAST_NAME from WORKER h where h.K_WORKER = r.K_REQ_WORKER) as val7," +
                        "(select h.LAST_NAME from CITIZEN h where h.K_CITIZEN = r.K_REQ_CITIZEN) as val8,(select h.FLAT_NUMBER from flat h where h.K_FLAT = r.K_REQ_FLAT) as val9," +
                        "(select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_REQ_HOUSE) as val10 from REQUEST r");
            }
            rr = FXCollections.observableArrayList();
            while (rs.next())
                rr.add(new HelpingRow(rs, 10));
            _rq_table.setItems(rr);

            try {
                rs = stmt.executeQuery("select h.RT_NAME, h.K_RT from REQUEST_TYPE h");
                _rq_req_rt.getItems().clear();
                _rq_b1.clear();
                while (rs.next()){
                    _rq_req_rt.getItems().add(rs.getString(1));
                    _rq_b1.add(Integer.parseInt(rs.getString(2)));
                }

                rs = stmt.executeQuery("select h.AT_NAME,h.K_AT from ANSWER_TYPE h");
                _rq_req_at.getItems().clear();
                _rq_b2.clear();
                while (rs.next()){
                    _rq_req_at.getItems().add(rs.getString(1));
                    _rq_b2.add(Integer.parseInt(rs.getString(2)));
                }

                rs = stmt.executeQuery("select p.NAME, w.LAST_NAME, w.FIRST_NAME,w.K_WORKER from POSITION p,WORKER w where p.K_POSITION = w.K_W_POSITION");
                _rq_req_worker.getItems().clear();
                _rq_b3.clear();
                while (rs.next()){
                    _rq_req_worker.getItems().add(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
                    _rq_b3.add(Integer.parseInt(rs.getString(4)));
                }

                rs = stmt.executeQuery("SELECT LAST_NAME, ADDRESS, FLAT_NUMBER,c.K_CITIZEN FROM citizen c, flat f, house h where c.K_C_FLAT = f.K_FLAT and f.K_F_HOUSE = h.K_HOUSE");
                _rq_req_citizen.getItems().clear();
                _rq_b4.clear();
                while(rs.next()) {
                    _rq_req_citizen.getItems().add(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
                    _rq_b4.add(Integer.parseInt(rs.getString(4)));
                }
            }catch (Exception e) {
                AlertBox.display("Ошибка","Неверно ввёденные значения");
                e.printStackTrace();
            }

            //Repair
//        re_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
            _re_type_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
            _re_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
            _re_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
            if(_hs_choose.getSelectionModel().getSelectedIndex()!=0) {
                rs = stmt.executeQuery("SELECT r.K_REPAIR as NMBR, TYPE as val1, TO_CHAR(r.\"Date\",'DD-MM-YYYY') as val2, " +
                        "(select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_R_HOUSE) as val3 FROM REPAIR r where r.K_R_HOUSE = " + _hs_b.getI(_hs_choose.getSelectionModel().getSelectedIndex()));
            }else{
                rs = stmt.executeQuery("SELECT r.K_REPAIR as NMBR, TYPE as val1, TO_CHAR(r.\"Date\",'DD-MM-YYYY') as val2, (select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_R_HOUSE) as val3 FROM REPAIR r");
            }
            rr = FXCollections.observableArrayList();
            while (rs.next())
                rr.add(new HelpingRow(rs, 3, 0));
            _re_table.setItems(rr);
            try {
                rs = stmt.executeQuery("SELECT * FROM HOUSE");
                _re_house.getItems().clear();
                _re_b.clear();
                while(rs.next()) {
                    _re_house.getItems().add(rs.getString("ADDRESS"));
                    _re_b.add(Integer.parseInt(rs.getString("K_HOUSE")));
                }
            }catch (Exception e) {
                AlertBox.display("Ошибка","Неверно ввёденные значения");
                e.printStackTrace();
            }
        }


        rs = stmt.executeQuery("SELECT K_HOUSE as NMBR, ADDRESS as val1 FROM HOUSE");

        _hs_choose.getItems().clear();
        _hs_b.clear();
        _hs_choose.getItems().add("Любой");
        _hs_b.add(0);
        while (rs.next()){
            _hs_choose.getItems().add(rs.getString("val1"));
            _hs_b.add(Integer.parseInt(rs.getString("NMBR")));
        }

    }

    /**
     * Метод апдейта всех вспомогательных таблиц
     * @param event
     * @throws SQLException
     */
    public void onSelectionHT(Event event) throws SQLException {
        //Position
        //po_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        po_name_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        ResultSet rs = stmt.executeQuery("SELECT K_POSITION as NMBR, NAME as val1 FROM POSITION");
        ObservableList<HelpingRow> rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 1));
        po_table.setItems(rr);


        //AnswerType
//        at_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        at_name_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        rs = stmt.executeQuery("SELECT K_AT as NMBR, AT_NAME as val1 FROM ANSWER_TYPE");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 1));
        at_table.setItems(rr);


        //RequestType
//        rt_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        rt_name_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        rs = stmt.executeQuery("SELECT K_RT as NMBR, RT_NAME as val1 FROM REQUEST_TYPE");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 1));
        rt_table.setItems(rr);


        //CommunicationType
//        ct_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        ct_name_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        rs = stmt.executeQuery("SELECT K_COMTYPE as NMBR, COMTYPE_NAME as val1 FROM COMMUNICATION_TYPE");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 1));
        ct_table.setItems(rr);

        //House
//        _hs_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        hs_name_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        rs = stmt.executeQuery("SELECT K_HOUSE as NMBR, ADDRESS as val1 FROM HOUSE");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 1));
        hs_table.setItems(rr);


        //Repair
//        re_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        re_type_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        re_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        re_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        rs = stmt.executeQuery("SELECT r.K_REPAIR as NMBR, TYPE as val1, TO_CHAR(r.\"Date\",'DD-MM-YYYY') as val2, (select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_R_HOUSE) as val3 FROM REPAIR r");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 3, 0));
        re_table.setItems(rr);
        try {
            rs = stmt.executeQuery("SELECT * FROM HOUSE");
            re_house.getItems().clear();
            re_b.clear();
            while(rs.next()) {
                re_house.getItems().add(rs.getString("ADDRESS"));
                re_b.add(Integer.parseInt(rs.getString("K_HOUSE")));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }


        //Flat
//        fl_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        fl_number_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        fl_opinion_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        fl_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        fl_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value4"));
        rs = stmt.executeQuery("SELECT r.K_FLAT as NMBR, FLAT_NUMBER as val1, OPINION as val2, TO_CHAR(r.\"LAST_DATE\",'DD-MM-YYYY') as val3, (select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_F_HOUSE) as val4 FROM FLAT r");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 4, 1));
        fl_table.setItems(rr);
        try {
            rs = stmt.executeQuery("SELECT * FROM HOUSE");
            fl_house.getItems().clear();
            fl_b.clear();
            while(rs.next()) {
                fl_house.getItems().add(rs.getString("ADDRESS"));
                fl_b.add(Integer.parseInt(rs.getString("K_HOUSE")));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }


        //Communication
//        co_id_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("Number"));
        co_date_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value1"));
        co_comtype_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value2"));
        co_house_T.setCellValueFactory(new PropertyValueFactory<HelpingRow, String>("value3"));
        rs = stmt.executeQuery("SELECT r.K_COMMUNICATION as NMBR, TO_CHAR(r.\"LAST_DATE\",'DD-MM-YYYY') as val1, (select h.COMTYPE_NAME from COMMUNICATION_TYPE h where h.K_COMTYPE = r.K_COM_COMTYPE) as val2,(select h.ADDRESS from HOUSE h where h.K_HOUSE = r.K_COM_HOUSE) as val3 FROM COMMUNICATION r");
        rr = FXCollections.observableArrayList();
        while (rs.next())
            rr.add(new HelpingRow(rs, 3));
        co_table.setItems(rr);
        try {
            rs = stmt.executeQuery("SELECT * FROM HOUSE");
            co_house.getItems().clear();
            co_b2.clear();
            while(rs.next()) {
                co_house.getItems().add(rs.getString("ADDRESS"));
                co_b2.add(Integer.parseInt(rs.getString("K_HOUSE")));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }

        try {
            rs = stmt.executeQuery("SELECT * FROM COMMUNICATION_TYPE");
            co_comtype.getItems().clear();
            co_b1.clear();
            while(rs.next()) {
                co_comtype.getItems().add(rs.getString("COMTYPE_NAME"));
                co_b1.add(Integer.parseInt(rs.getString("K_COMTYPE")));
            }
        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }




    }

    //Position options

    public void po_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO POSITION (NAME)" + " VALUES ('" + po_name.getText() + "')");
            onSelectionHT(null);
            po_name.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void po_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE POSITION SET NAME = '" + po_name.getText() + "' WHERE K_POSITION = '" +
                    ((HelpingRow) po_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            po_name.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void po_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM POSITION WHERE K_POSITION = '" +
                    ((HelpingRow) po_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            po_name.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите всех рабочих с этой должностью");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void po_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = po_table.getSelectionModel().getSelectedItems();
        HelpingRow poSelected = (HelpingRow) selectedItems.get(0);
        try{
            po_name.setText(poSelected.getValue1());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Answer type options
    public void at_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO ANSWER_TYPE (AT_NAME)" + " VALUES ('" + at_name.getText() + "')");
            onSelectionHT(null);
            at_name.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void at_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE ANSWER_TYPE SET AT_NAME = '" + at_name.getText() + "' WHERE K_AT = '" +
                    ((HelpingRow) at_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            at_name.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void at_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM ANSWER_TYPE WHERE K_AT = '" +
                    ((HelpingRow) at_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            at_name.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы этого типа");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void at_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = at_table.getSelectionModel().getSelectedItems();
        HelpingRow atSelected = (HelpingRow) selectedItems.get(0);
        try {
            at_name.setText(atSelected.getValue1());
        }catch (Exception e){

        }
    }


    //Request type options
    public void rt_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO REQUEST_TYPE (RT_NAME)" + " VALUES ('" + rt_name.getText() + "')");
            onSelectionHT(null);
            rt_name.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void rt_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE REQUEST_TYPE SET RT_NAME = '" + rt_name.getText() + "' WHERE K_RT = '" +
                    ((HelpingRow) rt_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            rt_name.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void rt_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM REQUEST_TYPE WHERE K_RT = '" +
                    ((HelpingRow) rt_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            rt_name.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы этого типа");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void rt_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = rt_table.getSelectionModel().getSelectedItems();
        HelpingRow rtSelected = (HelpingRow) selectedItems.get(0);
        try {
            rt_name.setText(rtSelected.getValue1());
        }catch (Exception e){

        }
    }


    //Communication type options
    public void ct_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO COMMUNICATION_TYPE (COMTYPE_NAME)" + " VALUES ('" + ct_name.getText() + "')");
            onSelectionHT(null);
            ct_name.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void ct_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE COMMUNICATION_TYPE SET COMTYPE_NAME = '" + ct_name.getText() + "' WHERE K_COMTYPE = '" +
                    ((HelpingRow) ct_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            ct_name.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void ct_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM COMMUNICATION_TYPE WHERE K_COMTYPE = '" +
                    ((HelpingRow) ct_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            ct_name.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все коммуникации этого типа");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void ct_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = ct_table.getSelectionModel().getSelectedItems();
        HelpingRow ctSelected = (HelpingRow) selectedItems.get(0);
        try {
            ct_name.setText(ctSelected.getValue1());
        }catch (Exception e){

        }
    }


    //House options
    public void hs_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO HOUSE (ADDRESS)" + " VALUES ('" + hs_name.getText() + "')");
            onSelectionHT(null);
            hs_name.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void hs_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE HOUSE SET ADDRESS = '" + hs_name.getText() + "' WHERE K_HOUSE = '" +
                    ((HelpingRow) hs_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            hs_name.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void hs_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM HOUSE WHERE K_HOUSE = '" +
                    ((HelpingRow) hs_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            hs_name.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы и всех жителей этого дома");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void hs_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = hs_table.getSelectionModel().getSelectedItems();
        HelpingRow hsSelected = (HelpingRow) selectedItems.get(0);
        try {
            hs_name.setText(hsSelected.getValue1());
        }catch (Exception e){

        }
    }


    //Repair options
    public void re_onClickAdd(ActionEvent actionEvent) {
        try {
            int type = re_type.isSelected() ? 1 : 0;
            String s = re_date.getValue().toString();
            stmt.executeQuery("INSERT INTO REPAIR (TYPE,REPAIR.\"Date\",K_R_HOUSE)" + " VALUES (" + type + ", to_date('"+s+"','yyyy-MM-dd'), "+re_b.getI(re_house.getSelectionModel().getSelectedIndex())+")");
            onSelectionHT(null);
            re_type.setSelected(false);
            re_date.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void re_onClickChange(ActionEvent actionEvent) {
        try {
            int type = re_type.isSelected() ? 1 : 0;
            String s = re_date.getValue().toString();
            stmt.execute("UPDATE REPAIR SET TYPE = '" + type + "', \"Date\" = to_date('" + s + "','yyyy-MM-dd'), K_R_HOUSE = '"+
                    re_b.getI(re_house.getSelectionModel().getSelectedIndex())+"' WHERE K_REPAIR = '" +
                    ((HelpingRow) re_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            re_type.setSelected(false);
            re_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void re_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM REPAIR WHERE K_REPAIR = '" +
                    ((HelpingRow) re_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            re_type.setSelected(false);
            re_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void re_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = re_table.getSelectionModel().getSelectedItems();
        HelpingRow reSelected = (HelpingRow) selectedItems.get(0);

        try {
            re_type.setSelected(reSelected.value1.equals("Капитальный"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(reSelected.getValue2(), formatter);
            re_date.setValue(date);

            ObservableList items = re_house.getItems();
            int i = items.indexOf(reSelected.getValue3());
            re_house.getSelectionModel().select(i);

        }catch (Exception e){

        }

    }


    //Flat options
    public void fl_onClickAdd(ActionEvent actionEvent) {
        try {
            int opinion = fl_opinion.isSelected() ? 1 : 0;

            String s = fl_date.getValue().toString();

            stmt.executeQuery("INSERT INTO FLAT (FLAT_NUMBER,OPINION,Last_Date,K_F_HOUSE)" + " VALUES ("+ fl_number.getText() +"," + opinion + ", to_date('"+s+"','yyyy-MM-dd'), "+fl_b.getI(fl_house.getSelectionModel().getSelectedIndex())+")");

            onSelectionHT(null);

            fl_opinion.setSelected(false);
            fl_number.setText("");
            fl_date.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void fl_onClickChange(ActionEvent actionEvent) {
        try {
            int opinion = fl_opinion.isSelected() ? 1 : 0;
            String s = fl_date.getValue().toString();

            stmt.execute("UPDATE FLAT SET FLAT_NUMBER = "+fl_number.getText()+", OPINION = " + opinion +",Last_Date = to_date('"+ s +"','yyyy-MM-dd'), K_F_HOUSE = "+fl_b.getI(fl_house.getSelectionModel().getSelectedIndex())+" WHERE K_FLAT = '" +
                    ((HelpingRow) fl_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            fl_opinion.setSelected(false);
            fl_number.setText("");
            fl_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void fl_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM FLAT WHERE K_FLAT = '" +
                    ((HelpingRow) fl_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            fl_opinion.setSelected(false);
            fl_number.setText("");
            fl_date.setValue(null);
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы и всех жителей этой квартиры");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void fl_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = fl_table.getSelectionModel().getSelectedItems();
        HelpingRow flSelected = (HelpingRow) selectedItems.get(0);

        try {
            fl_opinion.setSelected(flSelected.value2.equals("Да"));

            fl_number.setText(flSelected.getValue1());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(flSelected.getValue3(), formatter);
            fl_date.setValue(date);

            ObservableList items = fl_house.getItems();
            int i = items.indexOf(flSelected.getValue4());
            fl_house.getSelectionModel().select(i);

        }catch (Exception e){

        }

    }


    //Communication options
    public void co_onClickAdd(ActionEvent actionEvent) {
        try {
            String s = co_date.getValue().toString();

            stmt.executeQuery("INSERT INTO COMMUNICATION (LAST_DATE,K_COM_COMTYPE,K_COM_HOUSE)" + " VALUES (to_date('"+s+"','yyyy-MM-dd'), "+
                    co_b1.getI(co_comtype.getSelectionModel().getSelectedIndex())+","+co_b2.getI(co_house.getSelectionModel().getSelectedIndex())+")");
            onSelectionHT(null);
            co_date.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void co_onClickChange(ActionEvent actionEvent) {
        try {
            String s = co_date.getValue().toString();

            stmt.execute("UPDATE COMMUNICATION SET LAST_DATE = to_date('" + s + "','yyyy-MM-dd'), K_COM_COMTYPE = "+co_b2.getI(co_comtype.getSelectionModel().getSelectedIndex())+
                    ",K_COM_HOUSE = "+co_b1.getI(co_house.getSelectionModel().getSelectedIndex())+" WHERE K_COMMUNICATION = '" +
                    ((HelpingRow) co_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            co_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void co_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM COMMUNICATION WHERE K_COMMUNICATION = '" +
                    ((HelpingRow) co_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHT(null);
            co_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void co_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = co_table.getSelectionModel().getSelectedItems();
        HelpingRow coSelected = (HelpingRow) selectedItems.get(0);

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(coSelected.getValue1(), formatter);
            co_date.setValue(date);

            ObservableList items = co_comtype.getItems();
            int i = items.indexOf(coSelected.getValue2());
            co_comtype.getSelectionModel().select(i);

            items = co_house.getItems();
            i = items.indexOf(coSelected.getValue3());
            co_house.getSelectionModel().select(i);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Citizen options
    public void ci_onClickAdd(ActionEvent actionEvent) {
        try {
            String s = ci_birthdate.getValue().toString();

            int flat = ci_b.getI(ci_flat.getSelectionModel().getSelectedIndex());

            ResultSet rs = stmt.executeQuery("SELECT K_HOUSE "+"FROM HOUSE, FLAT where K_FLAT ='"+flat+"' and K_F_HOUSE = K_HOUSE");
            rs.next();
            String house = rs.getString(1);


            int per = Math.abs(Integer.parseInt(ci_percent.getText())%101);

            stmt.executeQuery("INSERT INTO CITIZEN (LAST_NAME,FIRST_NAME,MIDDLE_NAME,SEX,DATE_OF_BIRTH,SHARING_PERCENTAGE,TOWN_NAME,K_C_FLAT,K_C_HOUSE)" + " VALUES ('"
                    + ci_lname.getText() + "', '"+ci_fname.getText()+"', '"+ci_mname.getText()+"', '"+ci_sex.getText()+"', to_date('"+s+"','yyyy-MM-dd'),"+per+",'"+
                    ci_town.getText()+"',"+flat+","+house+")");
            onSelectionCT(null);
            ci_birthdate.setValue(null);
            ci_town.setText("");
            ci_fname.setText("");
            ci_mname.setText("");
            ci_lname.setText("");
            ci_sex.setText("");
            ci_percent.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void ci_onClickChange(ActionEvent actionEvent) {
        try {
            String s = ci_birthdate.getValue().toString();

            int flat = ci_b.getI(ci_flat.getSelectionModel().getSelectedIndex());

            ResultSet rs = stmt.executeQuery("SELECT K_HOUSE "+"FROM HOUSE, FLAT where K_FLAT ='"+flat+"' and K_F_HOUSE = K_HOUSE");
            rs.next();
            String house = rs.getString(1);


            int per = Math.abs(Integer.parseInt(ci_percent.getText())%101);

            stmt.execute("UPDATE CITIZEN SET LAST_NAME = '" + ci_lname.getText() + "',FIRST_NAME = '" + ci_fname.getText() + "',MIDDLE_NAME = '" + ci_mname.getText() +
                    "',SEX = '" + ci_sex.getText() + "',DATE_OF_BIRTH = to_date('"+s+"','yyyy-MM-dd'),SHARING_PERCENTAGE = "+per+",TOWN_NAME = '"+ci_town.getText()+
                    "',K_C_FLAT = '"+flat+"',K_C_HOUSE = '"+house+"' WHERE K_CITIZEN = '" +
                    ((HelpingRow) ci_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionCT(null);
            ci_birthdate.setValue(null);
            ci_town.setText("");
            ci_fname.setText("");
            ci_mname.setText("");
            ci_lname.setText("");
            ci_sex.setText("");
            ci_percent.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void ci_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM CITIZEN WHERE K_CITIZEN = '" +
                    ((HelpingRow) ci_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionCT(null);
            ci_birthdate.setValue(null);
            ci_town.setText("");
            ci_fname.setText("");
            ci_mname.setText("");
            ci_lname.setText("");
            ci_sex.setText("");
            ci_percent.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы этого жителя");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void ci_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = ci_table.getSelectionModel().getSelectedItems();
        HelpingRow ciSelected = (HelpingRow) selectedItems.get(0);

        try {
            ci_lname.setText(ciSelected.getValue1());
            ci_fname.setText(ciSelected.getValue2());
            ci_mname.setText(ciSelected.getValue3());
            ci_sex.setText(ciSelected.getValue4());

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(ciSelected.getValue5(),f);
            ci_birthdate.setValue(localDate);

            ci_percent.setText(ciSelected.getValue6());
            ci_town.setText(ciSelected.getValue7());


            ObservableList items = ci_flat.getItems();
            int i = items.indexOf(ciSelected.getValue9()+"/"+ciSelected.getValue8());
            ci_flat.getSelectionModel().select(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //Worker options
    public void wo_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO WORKER (LAST_NAME,FIRST_NAME,MIDDLE_NAME,SEX,K_W_POSITION)" + " VALUES ('" +
                    wo_lname.getText() + "', '"+wo_fname.getText()+"', '"+wo_mname.getText()+"', '"+wo_sex.getText()+"', "+wo_b.getI(wo_position.getSelectionModel().getSelectedIndex())+")");
            onSelectionWT(null);
            wo_fname.setText("");
            wo_mname.setText("");
            wo_lname.setText("");
            wo_sex.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void wo_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE WORKER SET LAST_NAME = '" + wo_lname.getText() + "',FIRST_NAME = '"
                    + wo_fname.getText() + "',MIDDLE_NAME = '" + wo_mname.getText() + "',SEX = '"
                    + wo_sex.getText() + "', K_W_POSITION = '"+wo_b.getI(wo_position.getSelectionModel().getSelectedIndex())
                    +"' WHERE K_WORKER = '" +
                    ((HelpingRow) wo_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionWT(null);
            wo_fname.setText("");
            wo_mname.setText("");
            wo_lname.setText("");
            wo_sex.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void wo_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM WORKER WHERE K_WORKER = '" +
                    ((HelpingRow) wo_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionWT(null);
            wo_fname.setText("");
            wo_mname.setText("");
            wo_lname.setText("");
            wo_sex.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы и осмотры этого работника");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void wo_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = wo_table.getSelectionModel().getSelectedItems();
        HelpingRow woSelected = (HelpingRow) selectedItems.get(0);

        try {
            wo_lname.setText(woSelected.getValue1());
            wo_fname.setText(woSelected.getValue2());
            wo_mname.setText(woSelected.getValue3());
            wo_sex.setText(woSelected.getValue4());

            ObservableList items = wo_position.getItems();
            int i = items.indexOf(woSelected.getValue5());
            wo_position.getSelectionModel().select(i);
        }catch (Exception e){

        }

    }


    //Request options notended
    public void rq_onClickAdd(ActionEvent actionEvent) {
        try {
            String s2 = rq_date_answer.getValue().toString();
            String s1 = rq_date_request.getValue().toString();

            String rt = rq_b1.getI(rq_req_rt.getSelectionModel().getSelectedIndex())+"";

            String at = rq_b2.getI(rq_req_at.getSelectionModel().getSelectedIndex())+"";

            String w = rq_b3.getI(rq_req_worker.getSelectionModel().getSelectedIndex())+"";

            String c = rq_b4.getI(rq_req_citizen.getSelectionModel().getSelectedIndex())+"";

            ResultSet rs = stmt.executeQuery("Select K_FLAT, K_HOUSE FROM FLAT f, HOUSE h, CITIZEN c WHERE K_CITIZEN = "+c+" and K_FLAT = K_C_FLAT and K_HOUSE = K_C_HOUSE");
            rs.next();
            stmt.executeQuery("INSERT INTO REQUEST (CAUSE,ANSWER,DATE_REQUEST,DATE_ANSWER,K_REQ_RT,K_REQ_AT,K_REQ_WORKER,K_REQ_CITIZEN,K_REQ_FLAT,K_REQ_HOUSE)" +
                    " VALUES ('" + rq_cause.getText()+"','"+rq_answer.getText()+"',to_date('"+s1+"','yyyy-MM-dd'),to_date('"+s2+"','yyyy-MM-dd'),"+rt+","+at+","+w+","+c+","
                    +rs.getString(1)+","+rs.getString(2)+")");
            onSelectionRT(null);

            rq_cause.setText("");
            rq_answer.setText("");
            rq_date_request.setValue(null);
            rq_date_answer.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void rq_onClickChange(ActionEvent actionEvent) {
        try {
            String s2 = rq_date_answer.getValue().toString();
            String s1 = rq_date_request.getValue().toString();

            String rt = rq_b1.getI(rq_req_rt.getSelectionModel().getSelectedIndex())+"";

            String at = rq_b2.getI(rq_req_at.getSelectionModel().getSelectedIndex())+"";

            String w = rq_b3.getI(rq_req_worker.getSelectionModel().getSelectedIndex())+"";

            String c = rq_b4.getI(rq_req_citizen.getSelectionModel().getSelectedIndex())+"";

            ResultSet rs = stmt.executeQuery("Select K_FLAT, K_HOUSE FROM FLAT f, HOUSE h, CITIZEN c WHERE K_CITIZEN = "+c+" and K_FLAT = K_C_FLAT and K_HOUSE = K_C_HOUSE");
            rs.next();
            stmt.execute("UPDATE REQUEST SET CAUSE = '"+rq_cause.getText()+"', ANSWER = '"+rq_answer.getText()+"',DATE_REQUEST = to_date('"+s1+"','yyyy-MM-dd'), DATE_ANSWER = to_date('"+
                s2 +"','yyyy-MM-dd'), K_REQ_RT = "+rt+",K_REQ_AT = "+at+",K_REQ_WORKER = "+w+",K_REQ_CITIZEN =" + c+
                ",K_REQ_FLAT = "+rs.getString(1)+",K_REQ_HOUSE = '" +rs.getString(2)+"' WHERE K_REQUEST = '" +
                ((HelpingRow) rq_table.getSelectionModel().getSelectedItem()).getNumber() + "'");

            onSelectionRT(null);
            rq_cause.setText("");
            rq_answer.setText("");
            rq_date_request.setValue(null);
            rq_date_answer.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void rq_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM REQUEST WHERE K_REQUEST = '" +
                    ((HelpingRow) rq_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionRT(null);
            rq_cause.setText("");
            rq_answer.setText("");
            rq_date_request.setValue(null);
            rq_date_answer.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void rq_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = rq_table.getSelectionModel().getSelectedItems();
        HelpingRow rqSelected = (HelpingRow) selectedItems.get(0);

        try {
            rq_cause.setText(rqSelected.getValue1());

            rq_answer.setText(rqSelected.getValue2());

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(rqSelected.getValue3(),f);
            rq_date_request.setValue(localDate);

            localDate = LocalDate.parse(rqSelected.getValue4(),f);
            rq_date_answer.setValue(localDate);

            ObservableList items = rq_req_rt.getItems();
            int i = items.indexOf(rqSelected.getValue5());
            rq_req_rt.getSelectionModel().select(i);

            items = rq_req_at.getItems();
            i = items.indexOf(rqSelected.getValue6());
            rq_req_at.getSelectionModel().select(i);

            ResultSet rs =stmt.executeQuery("Select NAME,LAST_NAME,FIRST_NAME from POSITION, WORKER where K_W_POSITION = K_POSITION and LAST_NAME = '"+rqSelected.getValue7()+"'");
            rs.next();
            items = rq_req_worker.getItems();
            i = items.indexOf(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
            rq_req_worker.getSelectionModel().select(i);

            items = rq_req_citizen.getItems();
            i = items.indexOf(rqSelected.getValue8()+"/"+rqSelected.getValue10()+"/"+rqSelected.getValue9());
            rq_req_citizen.getSelectionModel().select(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //Communication overview options notended
    public void cov_onClickAdd(ActionEvent actionEvent) {
        try {
            String s1 = cov_date.getValue().toString();

            ResultSet rs = stmt.executeQuery("Select K_HOUSE from HOUSE where ADDRESS = '"+((String)cov_communication.getSelectionModel().getSelectedItem()).split("/")[1]+"'");
            rs.next();
            int house = Integer.parseInt(rs.getString("K_HOUSE"));

            int per = Integer.parseInt(cov_rating.getText());

            if(per<0||per>100){
                throw (new IOException());
            }

            stmt.executeQuery("INSERT INTO COMMUNICATION_OVERVIEW (OVERVIEW_RATING,OVERVIEW_DATE,K_COMMUNICATION,K_HOUSE,K_WORKER)" +
                    " VALUES ("+per+",to_date('"+s1+"','yyyy-MM-dd'),"+cov_b1.getI(cov_communication.getSelectionModel().getSelectedIndex())
                    +","+house+","+cov_b3.getI(cov_worker.getSelectionModel().getSelectedIndex())+")");
            onSelectionCOT(null);
            cov_rating.setText("");
            cov_date.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void cov_onClickChange(ActionEvent actionEvent) {
        try {
            String s1 = cov_date.getValue().toString();

            ResultSet rs = stmt.executeQuery("Select K_HOUSE from HOUSE where ADDRESS = '"+((String)cov_communication.getSelectionModel().getSelectedItem()).split("/")[1]+"'");
            rs.next();
            int house = Integer.parseInt(rs.getString(1));

            int per = Math.abs(Integer.parseInt(cov_rating.getText())%101);

            stmt.execute("UPDATE COMMUNICATION_OVERVIEW SET OVERVIEW_RATING = " + per + ", OVERVIEW_DATE = to_date('"+s1+"','yyyy-MM-dd')," +
                    " K_COMMUNICATION = "+cov_b1.getI(cov_communication.getSelectionModel().getSelectedIndex())+
                    ",K_HOUSE = "+house+
                    ",K_WORKER = "+cov_b3.getI(cov_worker.getSelectionModel().getSelectedIndex())+
                    "WHERE K_COVERVIEW = '" + ((HelpingRow) cov_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionCOT(null);
            cov_rating.setText("");
            cov_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void cov_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM COMMUNICATION_OVERVIEW WHERE K_COVERVIEW = '" +
                    ((HelpingRow) cov_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionCOT(null);
            cov_rating.setText("");
            cov_date.setValue(null);
        }catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void cov_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = cov_table.getSelectionModel().getSelectedItems();
        HelpingRow covSelected = (HelpingRow) selectedItems.get(0);

        try {
            cov_rating.setText(covSelected.getValue1());

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(covSelected.getValue2(),f);
            cov_date.setValue(localDate);

            ObservableList items = cov_communication.getItems();
            int i = items.indexOf(covSelected.getValue3()+"/"+covSelected.getValue4());
            cov_communication.getSelectionModel().select(i);

            ResultSet rs =stmt.executeQuery("Select NAME,LAST_NAME,FIRST_NAME from POSITION, WORKER where K_W_POSITION = K_POSITION and LAST_NAME = '"+covSelected.getValue5()+"'");
            rs.next();
            items = cov_worker.getItems();
            i = items.indexOf(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
            cov_worker.getSelectionModel().select(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //House overview options notended
    public void hov_onClickAdd(ActionEvent actionEvent) {
        try {
            String s1 = hov_date.getValue().toString();

            int per = Integer.parseInt(hov_rating.getText());

            if(per<0||per>100){
                throw (new IOException());
            }
            stmt.executeQuery("INSERT INTO HOUSE_OVERVIEW (OVERVIEW_RATING,OVERVIEW_DATE,K_HO_HOUSE,K_HO_WORKER)" +
                    " VALUES ("+per+",to_date('"+s1+"','yyyy-MM-dd'),"+hov_b1.getI(hov_house.getSelectionModel().getSelectedIndex())
                    +","+hov_b3.getI(hov_worker.getSelectionModel().getSelectedIndex())+")");
            onSelectionHOT(null);

            hov_date.setValue(null);
            hov_rating.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void hov_onClickChange(ActionEvent actionEvent) {
        try {
            String s1 = hov_date.getValue().toString();

            int per = Math.abs(Integer.parseInt(hov_rating.getText())%101);

            stmt.execute("UPDATE HOUSE_OVERVIEW SET OVERVIEW_RATING = " + per + ", OVERVIEW_DATE = to_date('"+s1+"','yyyy-MM-dd')," +
                    " K_HO_HOUSE = "+hov_b1.getI(hov_house.getSelectionModel().getSelectedIndex())+
                    ",K_HO_WORKER = "+hov_b3.getI(hov_worker.getSelectionModel().getSelectedIndex())+
                    "WHERE K_HOVERVIEW = '" + ((HelpingRow) hov_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHOT(null);
            hov_date.setValue(null);
            hov_rating.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void hov_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM HOUSE_OVERVIEW WHERE K_HOVERVIEW = '" +
                    ((HelpingRow) hov_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHOT(null);
            hov_date.setValue(null);
            hov_rating.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void hov_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = hov_table.getSelectionModel().getSelectedItems();
        HelpingRow hovSelected = (HelpingRow) selectedItems.get(0);

        try {
            hov_rating.setText(hovSelected.getValue1());

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(hovSelected.getValue2(),f);
            hov_date.setValue(localDate);

            ObservableList items = hov_house.getItems();
            int i = items.indexOf(hovSelected.getValue3());
            hov_house.getSelectionModel().select(i);

            ResultSet rs =stmt.executeQuery("Select NAME,LAST_NAME,FIRST_NAME from POSITION, WORKER where K_W_POSITION = K_POSITION and LAST_NAME = '"+hovSelected.getValue4()+"'");
            rs.next();
            items = hov_worker.getItems();
            i = items.indexOf(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
            hov_worker.getSelectionModel().select(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //House special

    public void _hs_click(ActionEvent actionEvent){
        try{
            onSelectionHouT(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //House options
    public void _hs_onClickAdd(ActionEvent actionEvent) {
        try {
            stmt.executeQuery("INSERT INTO HOUSE (ADDRESS)" + " VALUES ('" + _hs_name.getText() + "')");
            onSelectionHouT(null);
            _hs_name.setText("");

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _hs_onClickChange(ActionEvent actionEvent) {
        try {
            stmt.execute("UPDATE HOUSE SET ADDRESS = '" + _hs_name.getText() + "' WHERE K_HOUSE = '" +
                    ((HelpingRow) _hs_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _hs_name.setText("");
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _hs_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM HOUSE WHERE K_HOUSE = '" +
                    ((HelpingRow) _hs_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _hs_name.setText("");
        } catch (SQLException e){
            AlertBox.display("Ошибка","Удалите все запросы и всех жителей этого дома");
        }
        catch (Exception e){
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void _hs_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = _hs_table.getSelectionModel().getSelectedItems();
        HelpingRow _hsSelected = (HelpingRow) selectedItems.get(0);
        try {
            _hs_name.setText(_hsSelected.getValue1());
        }catch (Exception e){

        }
    }

    //House overview options notended
    public void _hov_onClickAdd(ActionEvent actionEvent) {
        try {
            String s1 = _hov_date.getValue().toString();

            int per = Integer.parseInt(_hov_rating.getText());

            if(per<0||per>100){
                throw (new IOException());
            }
            stmt.executeQuery("INSERT INTO HOUSE_OVERVIEW (OVERVIEW_RATING,OVERVIEW_DATE,K_HO_HOUSE,K_HO_WORKER)" +
                    " VALUES ("+per+",to_date('"+s1+"','yyyy-MM-dd'),"+_hov_b1.getI(_hov_house.getSelectionModel().getSelectedIndex())
                    +","+_hov_b3.getI(_hov_worker.getSelectionModel().getSelectedIndex())+")");
            onSelectionHouT(null);
            _hov_rating.setText("");
            _hov_date.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _hov_onClickChange(ActionEvent actionEvent) {
        try {
            String s1 = _hov_date.getValue().toString();

            int per = Math.abs(Integer.parseInt(_hov_rating.getText())%101);

            stmt.execute("UPDATE HOUSE_OVERVIEW SET OVERVIEW_RATING = " + per + ", OVERVIEW_DATE = to_date('"+s1+"','yyyy-MM-dd')," +
                    " K_HO_HOUSE = "+_hov_b1.getI(_hov_house.getSelectionModel().getSelectedIndex())+
                    ",K_HO_WORKER = "+_hov_b3.getI(_hov_worker.getSelectionModel().getSelectedIndex())+
                    "WHERE K_HOVERVIEW = '" + ((HelpingRow) _hov_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _hov_rating.setText("");
            _hov_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _hov_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM HOUSE_OVERVIEW WHERE K_HOVERVIEW = '" +
                    ((HelpingRow) _hov_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _hov_rating.setText("");
            _hov_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void _hov_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = _hov_table.getSelectionModel().getSelectedItems();
        HelpingRow _hovSelected = (HelpingRow) selectedItems.get(0);

        try {
            _hov_rating.setText(_hovSelected.getValue1());

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(_hovSelected.getValue2(),f);
            _hov_date.setValue(localDate);

            ObservableList items = _hov_house.getItems();
            int i = items.indexOf(_hovSelected.getValue3());
            _hov_house.getSelectionModel().select(i);

            ResultSet rs =stmt.executeQuery("Select NAME,LAST_NAME,FIRST_NAME from POSITION, WORKER where K_W_POSITION = K_POSITION and LAST_NAME = '"+_hovSelected.getValue4()+"'");
            rs.next();
            items = _hov_worker.getItems();
            i = items.indexOf(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
            _hov_worker.getSelectionModel().select(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Request options notended
    public void _rq_onClickAdd(ActionEvent actionEvent) {
        try {
            String s2 = _rq_date_answer.getValue().toString();
            String s1 = _rq_date_request.getValue().toString();

            String rt = _rq_b1.getI(_rq_req_rt.getSelectionModel().getSelectedIndex())+"";

            String at = _rq_b2.getI(_rq_req_at.getSelectionModel().getSelectedIndex())+"";

            String w = _rq_b3.getI(_rq_req_worker.getSelectionModel().getSelectedIndex())+"";

            String c = _rq_b4.getI(_rq_req_citizen.getSelectionModel().getSelectedIndex())+"";

            ResultSet rs = stmt.executeQuery("Select K_FLAT, K_HOUSE FROM FLAT f, HOUSE h, CITIZEN c WHERE K_CITIZEN = "+c+" and K_FLAT = K_C_FLAT and K_HOUSE = K_C_HOUSE");
            rs.next();
            stmt.executeQuery("INSERT INTO REQUEST (CAUSE,ANSWER,DATE_REQUEST,DATE_ANSWER,K_REQ_RT,K_REQ_AT,K_REQ_WORKER,K_REQ_CITIZEN,K_REQ_FLAT,K_REQ_HOUSE)" +
                    " VALUES ('" + _rq_cause.getText()+"','"+_rq_answer.getText()+"',to_date('"+s1+"','yyyy-MM-dd'),to_date('"+s2+"','yyyy-MM-dd'),"+rt+","+at+","+w+","+c+","
                    +rs.getString(1)+","+rs.getString(2)+")");
            onSelectionHouT(null);
            _rq_cause.setText("");
            _rq_answer.setText("");
            _rq_date_answer.setValue(null);
            _rq_date_request.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _rq_onClickChange(ActionEvent actionEvent) {
        try {
            String s2 = _rq_date_answer.getValue().toString();
            String s1 = _rq_date_request.getValue().toString();

            String rt = _rq_b1.getI(_rq_req_rt.getSelectionModel().getSelectedIndex())+"";

            String at = _rq_b2.getI(_rq_req_at.getSelectionModel().getSelectedIndex())+"";

            String w = _rq_b3.getI(_rq_req_worker.getSelectionModel().getSelectedIndex())+"";

            String c = _rq_b4.getI(_rq_req_citizen.getSelectionModel().getSelectedIndex())+"";

            ResultSet rs = stmt.executeQuery("Select K_FLAT, K_HOUSE FROM FLAT f, HOUSE h, CITIZEN c WHERE K_CITIZEN = "+c+" and K_FLAT = K_C_FLAT and K_HOUSE = K_C_HOUSE");
            rs.next();
            stmt.execute("UPDATE REQUEST SET CAUSE = '"+_rq_cause.getText()+"', ANSWER = '"+_rq_answer.getText()+"',DATE_REQUEST = to_date('"+s1+"','yyyy-MM-dd'), DATE_ANSWER = to_date('"+
                    s2 +"','yyyy-MM-dd'), K_REQ_RT = "+rt+",K_REQ_AT = "+at+",K_REQ_WORKER = "+w+",K_REQ_CITIZEN =" + c+
                    ",K_REQ_FLAT = "+rs.getString(1)+",K_REQ_HOUSE = '" +rs.getString(2)+"' WHERE K_REQUEST = '" +
                    ((HelpingRow) _rq_table.getSelectionModel().getSelectedItem()).getNumber() + "'");

            onSelectionHouT(null);
            _rq_cause.setText("");
            _rq_answer.setText("");
            _rq_date_answer.setValue(null);
            _rq_date_request.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _rq_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM REQUEST WHERE K_REQUEST = '" +
                    ((HelpingRow) _rq_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _rq_cause.setText("");
            _rq_answer.setText("");
            _rq_date_answer.setValue(null);
            _rq_date_request.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void _rq_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = _rq_table.getSelectionModel().getSelectedItems();
        HelpingRow _rqSelected = (HelpingRow) selectedItems.get(0);

        try {
            _rq_cause.setText(_rqSelected.getValue1());

            _rq_answer.setText(_rqSelected.getValue2());

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(_rqSelected.getValue3(),f);
            _rq_date_request.setValue(localDate);

            localDate = LocalDate.parse(_rqSelected.getValue4(),f);
            _rq_date_answer.setValue(localDate);

            ObservableList items = _rq_req_rt.getItems();
            int i = items.indexOf(_rqSelected.getValue5());
            _rq_req_rt.getSelectionModel().select(i);

            items = _rq_req_at.getItems();
            i = items.indexOf(_rqSelected.getValue6());
            _rq_req_at.getSelectionModel().select(i);

            ResultSet rs =stmt.executeQuery("Select NAME,LAST_NAME,FIRST_NAME from POSITION, WORKER where K_W_POSITION = K_POSITION and LAST_NAME = '"+_rqSelected.getValue7()+"'");
            rs.next();
            items = _rq_req_worker.getItems();
            i = items.indexOf(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
            _rq_req_worker.getSelectionModel().select(i);

            items = _rq_req_citizen.getItems();
            i = items.indexOf(_rqSelected.getValue8()+"/"+_rqSelected.getValue10()+"/"+_rqSelected.getValue9());
            _rq_req_citizen.getSelectionModel().select(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //Repair options
    public void _re_onClickAdd(ActionEvent actionEvent) {
        try {
            int type = _re_type.isSelected() ? 1 : 0;
            String s = _re_date.getValue().toString();
            stmt.executeQuery("INSERT INTO REPAIR (TYPE,REPAIR.\"Date\",K_R_HOUSE)" + " VALUES (" + type + ", to_date('"+s+"','yyyy-MM-dd'), "+_re_b.getI(_re_house.getSelectionModel().getSelectedIndex())+")");
            onSelectionHouT(null);
            _re_type.setSelected(false);
            _re_date.setValue(null);

        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _re_onClickChange(ActionEvent actionEvent) {
        try {
            int type = _re_type.isSelected() ? 1 : 0;
            String s = _re_date.getValue().toString();
            stmt.execute("UPDATE REPAIR SET TYPE = '" + type + "', \"Date\" = to_date('" + s + "','yyyy-MM-dd'), K_R_HOUSE = '"+
                    _re_b.getI(_re_house.getSelectionModel().getSelectedIndex())+"' WHERE K_REPAIR = '" +
                    ((HelpingRow) _re_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _re_type.setSelected(false);
            _re_date.setValue(null);
        } catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }
    }

    public void _re_onClickDelete(ActionEvent actionEvent) {
        try {
            stmt.execute("DELETE FROM REPAIR WHERE K_REPAIR = '" +
                    ((HelpingRow) _re_table.getSelectionModel().getSelectedItem()).getNumber() + "'");
            onSelectionHouT(null);
            _re_type.setSelected(false);
            _re_date.setValue(null);
        }catch (Exception e) {
            AlertBox.display("Ошибка","Не выбран элемент в таблице");
            e.printStackTrace();
        }
    }

    public void _re_onClickTableSelect(MouseEvent mouseEvent) {
        ObservableList selectedItems = _re_table.getSelectionModel().getSelectedItems();
        HelpingRow _reSelected = (HelpingRow) selectedItems.get(0);

        try {
            _re_type.setSelected(_reSelected.value1.equals("Капитальный"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(_reSelected.getValue2(), formatter);
            _re_date.setValue(date);

            ObservableList items = _re_house.getItems();
            int i = items.indexOf(_reSelected.getValue3());
            _re_house.getSelectionModel().select(i);

        }catch (Exception e) {
            AlertBox.display("Ошибка","Неверно ввёденные значения");
            e.printStackTrace();
        }

    }

    public void worker_report(ActionEvent actionEvent) throws SQLException{
        ResultSet rs = stmt.executeQuery("select w.LAST_NAME,w.FIRST_NAME,count(re.K_REQUEST)\n" +
                "from worker w, request re\n" +
                "where w.K_WORKER = re.K_REQ_WORKER(+)\n" +
                "group by w.LAST_NAME,w.FIRST_NAME");

        ArrayList<String> last_name = new ArrayList<>();
        ArrayList<String> first_name = new ArrayList<>();
        ArrayList<String> request = new ArrayList<>();

        while(rs.next()){
            last_name.add(rs.getString(1));
            first_name.add(rs.getString(2));
            request.add(rs.getString(3));
        }

        rs = stmt.executeQuery("select w.LAST_NAME,w.FIRST_NAME,count(cov.K_COVERVIEW)\n" +
                "from worker w, communication_overview cov\n" +
                "where w.K_WORKER = cov.K_WORKER(+)\n" +
                "group by w.LAST_NAME,w.FIRST_NAME");

        ArrayList<String> coverview = new ArrayList<>();

        while (rs.next()){
            coverview.add(rs.getString(3));
        }

        rs = stmt.executeQuery("select w.LAST_NAME,w.FIRST_NAME,count(hov.K_HOVERVIEW)\n" +
                "from worker w, house_overview hov\n" +
                "where w.K_WORKER = hov.K_HO_WORKER(+)\n" +
                "group by w.LAST_NAME,w.FIRST_NAME");

        ArrayList<String> hoverview = new ArrayList<>();

        while (rs.next()){
            hoverview.add(rs.getString(3));
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");
        fileChooser.setInitialDirectory(new File("D:/Institute/БД"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XLS","*.xls"));
        File file = fileChooser.showSaveDialog(ai.getStage());
        if(file != null){
            try{
                FileOutputStream fos = new FileOutputStream(file);

                Workbook wb = new HSSFWorkbook();

                Sheet sheet = wb.createSheet("List");

                Row namerow = sheet.createRow(0);
                Cell namecell = namerow.createCell(0);
                namecell.setCellValue("Фамилия");
                namecell = namerow.createCell(1);
                namecell.setCellValue("Имя");
                namecell = namerow.createCell(2);
                namecell.setCellValue("Число обслуженных запросов");
                namecell = namerow.createCell(3);
                namecell.setCellValue("Число осмотренных коммуникаций");
                namecell = namerow.createCell(4);
                namecell.setCellValue("Число осмотренных домов");

                int len = hoverview.size();
                for(int i = 0; i < len; i++){
                    namerow = sheet.createRow(i+1);
                    namecell = namerow.createCell(0);
                    namecell.setCellValue(last_name.get(i));
                    namecell = namerow.createCell(1);
                    namecell.setCellValue(first_name.get(i));
                    namecell = namerow.createCell(2);
                    namecell.setCellValue(request.get(i));
                    namecell = namerow.createCell(3);
                    namecell.setCellValue(coverview.get(i));
                    namecell = namerow.createCell(4);
                    namecell.setCellValue(hoverview.get(i));
                }

                wb.write(fos);
                fos.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        int kek = 1;
    }

    public void house_report(ActionEvent actionEvent)throws SQLException{
        ResultSet rs = stmt.executeQuery("select h.ADDRESS, count(rq.K_REQUEST)\n" +
                "from house h, request rq\n" +
                "where h.K_HOUSE = rq.K_REQ_HOUSE(+)\n" +
                "group by h.ADDRESS");
        ArrayList<String> address = new ArrayList<>();
        ArrayList<String> request = new ArrayList<>();

        while(rs.next()){
            address.add(rs.getString(1));
            request.add(rs.getString(2));
        }

        rs = stmt.executeQuery("select h.ADDRESS, count(re.K_REPAIR)\n" +
                "from house h, repair re\n" +
                "where h.K_HOUSE = re.K_R_HOUSE(+)\n" +
                "group by h.ADDRESS");

        ArrayList<String> repair = new ArrayList<>();

        while(rs.next()){
            repair.add(rs.getString(2));
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");
        fileChooser.setInitialDirectory(new File("D:/Institute/БД"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XLS","*.xls"));
        File file = fileChooser.showSaveDialog(ai.getStage());
        if(file != null){
            try{
                FileOutputStream fos = new FileOutputStream(file);

                Workbook wb = new HSSFWorkbook();

                Sheet sheet = wb.createSheet("List");

                Row namerow = sheet.createRow(0);
                Cell namecell = namerow.createCell(0);
                namecell.setCellValue("Адрес");
                namecell = namerow.createCell(1);
                namecell.setCellValue("Число обслуженных запросов");
                namecell = namerow.createCell(2);
                namecell.setCellValue("Число ремонтов");

                int len = request.size();
                for(int i = 0; i < len; i++){
                    namerow = sheet.createRow(i+1);
                    namecell = namerow.createCell(0);
                    namecell.setCellValue(address.get(i));
                    namecell = namerow.createCell(1);
                    namecell.setCellValue(request.get(i));
                    namecell = namerow.createCell(2);
                    namecell.setCellValue(repair.get(i));
                }

                wb.write(fos);
                fos.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
