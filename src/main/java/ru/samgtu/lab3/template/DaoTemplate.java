package ru.samgtu.lab3.template;

import ru.samgtu.lab3.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public abstract class DaoTemplate {

    protected Scanner scanner = new Scanner(System.in);
    protected final String TABLE_NAME;
    public final String ID_COLUMN;
    public final String[] COLUMNS;
    public final String findBy;

    protected DaoTemplate(String tableName, String idColumn, String[] columns, String findBy) {
        TABLE_NAME = tableName;
        ID_COLUMN = idColumn;
        COLUMNS = columns;
        this.findBy = findBy;
    }

    public void insert(Object... values) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO " + TABLE_NAME + " (" + String.join(",", COLUMNS) + ") VALUES (" + String.join(",", Arrays.stream(COLUMNS).map((s)->"?").toList())+")";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            for (int i = 1; i <= values.length; i++) {
                var val = values[i-1];
                if (val instanceof String)
                    pstmt.setString(i, (String) val);
                else if (val instanceof Integer)
                    pstmt.setInt(i, (Integer) val);
                else
                    pstmt.setObject(i, values[i-1]);
            }

            if (pstmt.executeUpdate() > 0) {
                System.out.println("Запись успешно добавлена.");
            }else {
                System.out.println("Запись не добавлена.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении SQL: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(int id, Map<String, Object> map) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String settingPart = String.join(" = ?, ", map.keySet()) + " = ?";
            String sql = "UPDATE " + TABLE_NAME + " set " + settingPart + " where " + ID_COLUMN + "=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            int i = 1;
            for (Object value : map.values()) {
                pstmt.setObject(i++, value);
            }

            pstmt.setObject(i, id);
            if (pstmt.executeUpdate() > 0) {
                System.out.println("Запись успешно обновлена.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении SQL: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM " + TABLE_NAME + " where " + ID_COLUMN + "=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setObject(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Запись успешно удалена.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении SQL: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getAll() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "select * from " + TABLE_NAME;
            show(connection, sql);
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении SQL: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void show(Connection connection, String sql) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID:" + rs.getObject(ID_COLUMN));
            for (String column : COLUMNS) {
                System.out.println(column + ":" + rs.getObject(column));
            }
            System.out.println("---------------------------");
        }
    }


    public void findBy(Object param) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "select * from " + TABLE_NAME + " where " + findBy + " like '%" + param + "%'";
            show(connection, sql);
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении SQL: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}