/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ControladorCliente1 {

    private ConexionBD conexion;
    private String sent;

    public void buscarCliente() {

    }

    public boolean anadirCliente(Cliente cli) {
        conexion = new ConexionBD();
        System.out.println(cli.getCli_id());
        System.out.println(cli.getCli_apellido());
        System.out.println(cli.getCli_cedula());
        System.out.println(cli.getCli_fecha_registro());
        boolean r = false;
        String t = "to_Date";
        String sql = "Insert Into hip_clientes (cli_id,cli_cedula,cli_nombre,cli_apellido,cli_fecha_registro,cli_direccion,"
                + "cli_tel_convencional,cli_celular,cli_correo_electronico,cli_estado)"
                + " VALUES(clientes_seq.nextval,?,?,?,?,?,?,?,?,?)";

        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, cli.getCli_cedula());
            ps.setString(2, cli.getCli_nombre());
            ps.setString(3, cli.getCli_apellido());
            ps.setDate(4, (java.sql.Date) (Date) cli.getCli_fecha_registro());
            ps.setString(5, cli.getCli_direccion());
            ps.setString(6, cli.getCli_tel_convencional());
            ps.setString(7, cli.getCli_celular());
            ps.setString(8, cli.getCli_correo_electronico());
            ps.setString(9, "f");

            ps.executeQuery();
            conexion.getConexion().commit();

            r = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return r;
    }

    public int llenarId() {
        int llena = 0;
        conexion = new ConexionBD();
        String sql = "SELECT MAX (cli_id) FROM hip_clientes";
        try {

            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llena = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        return llena;
    }

    public void llenarTabla(DefaultTableModel dtm, Object[] o, String est) {
        conexion = new ConexionBD();

        try {
            if (est.equalsIgnoreCase("activo")) {
                sent = " WHERE cli_estado = 'f' ";
            } else if (est.equalsIgnoreCase("PASIVO")) {
                sent = " WHERE cli_estado = 't' ";
            } else {
                sent = "";
            }

            String sql = " SELECT * FROM hip_clientes " + sent + " order by cli_id asc";
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString("cli_id");
                o[1] = rs.getString("cli_cedula");
                o[2] = rs.getString("cli_nombre");
                o[3] = rs.getString("cli_apellido");
                o[4] = rs.getDate("cli_fecha_registro");
                o[5] = rs.getString("cli_direccion");
                o[6] = rs.getString("cli_tel_convencional");
                o[7] = rs.getString("cli_celular");
                o[8] = rs.getString("cli_correo_electronico");
                if (rs.getString("cli_estado").equals("t")) {
                    o[9] = "Pasivo";
                } else {
                    o[9] = "Activo";
                }

                dtm.addRow(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }

    public void filtro(DefaultTableModel dtm, Object[] o, String cl) {
        System.out.println(cl);

        conexion = new ConexionBD();

        try {
            String sql = " SELECT * FROM hip_clientes ";
            String sql2 = " UPPER(cli_cedula) LIKE"
                    + " UPPER('" + cl + "%') ORDER BY cli_id ASC";
            if (sent.isEmpty()) {
                sql = sql + sent + " WHERE " + sql2;
            } else {
                sql = sql + sent + " AND " + sql2;
            }
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //String ObjetoS[]=new String [8];
                o[0] = rs.getString("cli_id");
                o[1] = rs.getString("cli_cedula");
                o[2] = rs.getString("cli_nombre");
                o[3] = rs.getString("cli_apellido");
                o[4] = rs.getDate("cli_fecha_registro");
                o[5] = rs.getString("cli_direccion");
                o[6] = rs.getString("cli_tel_convencional");
                o[7] = rs.getString("cli_celular");
                o[8] = rs.getString("cli_correo_electronico");
                if (rs.getString("cli_estado").equals("f")) {
                    o[9] = "Activo";
                } else {
                    o[9] = "Pasivo";
                }

                dtm.addRow(o);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }

    public boolean actualizarCliente(Cliente cli) {

        boolean r = false;
        conexion = new ConexionBD();

        String sql = "UPDATE hip_clientes SET cli_cedula= ?, cli_nombre=?, cli_apellido=?, cli_fecha_registro=?, cli_direccion=?"
                + ", cli_tel_convencional=?, cli_celular=?, cli_correo_electronico=?"
                + " WHERE cli_id = ?";
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, cli.getCli_cedula());
            ps.setString(2, cli.getCli_nombre());
            ps.setString(3, cli.getCli_apellido());
            ps.setDate(4, (java.sql.Date) (Date) cli.getCli_fecha_registro());
            ps.setString(5, cli.getCli_direccion());
            ps.setString(6, cli.getCli_tel_convencional());
            ps.setString(7, cli.getCli_celular());
            ps.setString(8, cli.getCli_correo_electronico());
            ps.setInt(9, cli.getCli_id());
            ps.executeQuery();

            conexion.getConexion().commit();
            r = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar cliente:"
                    + e.getMessage());
        } finally {
            conexion.desconectar();
        }

        return r;

    }

    public boolean cambiarEstadoCliente(Cliente cli) {
        boolean cepb = false;
        PreparedStatement pre = null;
        conexion = new ConexionBD();

        String sql = "";
        sql += "UPDATE hip_clientes SET CLI_ESTADO=? WHERE CLI_ID=?";

        try {
            conexion.conectar();
            pre = conexion.getConexion().prepareStatement(sql);

            if (cli.getEstado().equalsIgnoreCase("activo")) {
                pre.setString(1, "t");
                pre.setInt(2, cli.getCli_id());
                pre.executeUpdate();
            } else if (cli.getEstado().equalsIgnoreCase("pasivo")) {
                pre.setString(1, "f");
                pre.setInt(2, cli.getCli_id());
                pre.executeUpdate();
            }

            conexion.getConexion().commit();

            cepb = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar estado del"
                    + " cliente:" + e.getMessage());
        }
        return cepb;
    }

    public boolean eliminarCliente(int id) {
        boolean r = false;
        conexion = new ConexionBD();

        String sql = "DELETE FROM  hip_clientes WHERE cli_id = " + id;
        try {
            conexion.conectar();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.executeQuery();

            conexion.getConexion().commit();
            r = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente:"
                    + e.getMessage());
        } finally {
            conexion.desconectar();
        }

        return r;
    }

    public static boolean valida(String x) {

        int suma = 0;
        if (x.length() == 9) {
            System.out.println("Ingrese su cedula de 10 digitos");
            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean validarEmail(String email) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        String e = email;

        Matcher mather = pattern.matcher(e);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }

    }

}
