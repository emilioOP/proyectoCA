/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Emilio
 */
public class Data {

    private Conexion c;
    private String query;
    private ResultSet rs;

    private List<Partido> partidos;
    private List<DT> dts;
    private List<Arbitro> arbitros;
    private List<ClubDeportivo> clubes;
    private List<Nacionalidad> nacionalidades;
    private List<Seleccion> selecciones;
    private List<Estadio> estadios;
    private List<Fase> fases;

    public Data() throws SQLException {
        c = new Conexion(
                "localhost:1433", //servidor
                "proyectoCA", //base de datos 
                "sa", //permiso
                "123456" //clave
        );
    }

    public void crearPartido(Partido p) throws SQLException {
        query = "insert into tbl_partidos values("
                + "" + p.getIdSeleccion1() + ","
                + "" + p.getIdSeleccion2() + ","
                + "" + p.getArbitro() + ","
                + "" + p.getArbitroL1() + ","
                + "" + p.getArbitroL2() + ","
                + "" + p.getCuartoArbitro() + ","
                + "" + p.getIdEstadio() + ","
                + "" + p.getPublico() + ","
                + "'2016/" + p.getMes() + "/" + p.getDia() + "',"
                + "'" + p.getHoraInicio() + ":" + p.getMinInicio() + ":0', "
                + "'" + p.getHoraTermino() + ":" + p.getMinTermino() + ":0', "
                + "" + p.getFase() + ""
                + ");";
        System.out.println(query);
        c.ejecutar(query);
    }

    public void crearDT(DT dt) throws SQLException {
        query = "insert into tbl_DirectorTecnico values("
                + "'" + dt.getNombre() + "',"
                + "'" + dt.getApellido() + "',"
                + "" + dt.getEdad() + ","
                + "" + dt.getNacionalidad() + ","
                + "" + dt.getClubDeportivo() + ","
                + "" + dt.getAniosDT() + ","
                + "" + dt.getSueldoFifa() + ""
                + ");";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void crearArbitro(Arbitro a) throws SQLException {
        query = "insert into tbl_arbitro values("
                + "'" + a.getNombre() + "',"
                + "'" + a.getApellido() + "',"
                + "" + a.getEdad() + ","
                + "" + a.getPosision() + ","
                + "" + a.getPais() + ""
                + ");";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void crearClubDeportivo(String nombreClub) throws SQLException {
        query = "insert into tbl_ClubDeportivo values('" + nombreClub + "');";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void crearUsuario(Usuario u) throws SQLException {
        query = "insert into tbl_Usuario values ("
                + "" + u.getDescripcion() + ","
                + "" + u.getClave() + ","
                + "" + u.getPermiso() + ","
                + ");";
    }

    public void crearCT(CT ct) throws SQLException {
        query = "insert into tbl_CuerpoTecnico values ("
                + "" + ct.getNombre() + ","
                + "" + ct.getApellido() + ","
                + "" + ct.getEdad() + ","
                + "" + ct.getNacionalidad() + ","
                + "" + ct.getClubDeportivo() + ","
                + "" + ct.getAniosComoDT() + ","
                + "" + ct.getSueldoFIFA() + ","
                + ");";
    }

    public void crearJugador(Jugador j) throws SQLException {
        query = "insert into tbl_Jugador values ("
                + "" + j.getNombre() + ","
                + "" + j.getApellido() + ","
                + "" + j.getEdad() + ","
                + "" + j.getNacionalidad() + ","
                + "" + j.getClubDeportivo() + ","
                + "" + j.getEstadoFisico() + ","
                + "" + j.isTitular() + ","
                + "" + j.getPosicion() + ","
                + "" + j.getNroCamiseta() + ","
                + "" + j.getAniosComoJugador() + ","
                + "" + j.getGoles() + ","
                + "" + j.getAtajadas() + ","
                + "" + j.getSueldoFIFA() + ","
                + "" + j.getTarjetasRojas() + ","
                + "" + j.getTarjetasAmarillas() + ","
                + "" + j.isHabilitado() + ","
                + ");";

    }

    public void eliminarPartido(int id) throws SQLException {
        query = "delete from tbl_partidos where id=" + id + "";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void eliminarDT(int id) throws SQLException {
        query = "delete from tbl_DirectorTecnico where id=" + id + "";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void eliminarArbitro(int id) throws SQLException {
        query = "delete from tbl_arbitro where id=" + id + "";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void eliminarClubDeportivo(int id) throws SQLException {
        query = "delete from tbl_ClubDeportivo where id=" + id + "";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void eliminarUsuario(int id) throws SQLException {
        query = "delete from tbl_usuario where id = " + id;
        c.ejecutar(query);
    }

    public void eliminarCT(int id) throws SQLException {
        query = "delete from tbl_CuerpoTecnico where id =" + id;
        c.ejecutar(query);
    }

    public void eliminarJugador(int id) throws SQLException {
        query = "delete from tbl_Jugador where id = " + id;
        c.ejecutar(query);
    }

    public void actualizarPartido(Partido p) throws SQLException {
        query = "update tbl_partidos set "
                + "idSeleccion1=" + p.getIdSeleccion1() + ","
                + "idSeleccion2=" + p.getIdSeleccion2() + ","
                + "arbitro=" + p.getArbitro() + ","
                + "arbitroL1=" + p.getArbitroL1() + ","
                + "arbitroL2=" + p.getArbitroL2() + ","
                + "cuartoArbitro=" + p.getCuartoArbitro() + ","
                + "estadio=" + p.getIdEstadio() + ","
                + "publicoAsistente=" + p.getPublico() + ","
                + "fecha='2016/" + p.getMes() + "/" + p.getDia() + "',"
                + "horaInicio='" + p.getHoraInicio() + ":" + p.getMinInicio() + ":0', "
                + "horaTermino='" + p.getHoraTermino() + ":" + p.getMinTermino() + ":0', "
                + "fase=" + p.getFase() + " "
                + "where id=" + p.getId() + "";

//        System.out.println(query);
        c.ejecutar(query);
    }

    public void actualizarDT(DT dt) throws SQLException {
        query = "update tbl_DirectorTecnico set "
                + "nombre='" + dt.getNombre() + "', "
                + "apellido='" + dt.getApellido() + "', "
                + "edad=" + dt.getEdad() + " , "
                + "nacionalidad=" + dt.getNacionalidad() + ", "
                + "clubDeportivo=" + dt.getClubDeportivo() + ", "
                + "aniosComoDT=" + dt.getAniosDT() + ", "
                + "sueldoFIFA=" + dt.getSueldoFifa() + " "
                + "where id=" + dt.getId() + ";";
        System.out.println(query);
        c.ejecutar(query);
    }

    public void actualizarArbitro(Arbitro a) throws SQLException {
        query = "update tbl_arbitro set "
                + "nombre='" + a.getNombre() + "', "
                + "apellido='" + a.getApellido() + "', "
                + "edad=" + a.getEdad() + ", "
                + "posicion='" + a.getPosision() + "', "
                + "pais=" + a.getPais() + " "
                + "where id=" + a.getId() + ";";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public void actualizarClubDeportivo(ClubDeportivo cd) throws SQLException {
        query = "update tbl_ClubDeportivo set "
                + "nombre='" + cd.getNombre() + "' "
                + "where id= " + cd.getId() + ";";
//        System.out.println(query);
        c.ejecutar(query);
    }

    public Partido getPartido(int id) throws SQLException {
        Partido p = null;
        query = "select id, "
                + "idSeleccion1, "
                + "idSeleccion2, "
                + "arbitro, "
                + "arbitroL1, "
                + "arbitroL2, "
                + "cuartoArbitro, "
                + "estadio, "
                + "publicoAsistente, "
                + "DAY(fecha) as 'Dia',"
                + "MONTH(fecha) as 'Mes',"
                + "DATEPART(hour, CONVERT(VARCHAR(10), horaInicio, 108)) as 'horaInicio', "
                + "DATEPART(minute, CONVERT(VARCHAR(10), horaInicio, 108)) as 'MinInicio',"
                + "DATEPART(hour, CONVERT(VARCHAR(10), horaTermino, 108)) as 'horaTermino', "
                + "DATEPART(minute, CONVERT(VARCHAR(10), horaTermino, 108)) as 'MinTermino',"
                + "fase "
                + "from tbl_partidos "
                + "where id=" + id + "";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            p = new Partido();
            p.setId(rs.getInt(1));
            p.setIdSeleccion1(rs.getInt(2));
            p.setIdSeleccion2(rs.getInt(3));
            p.setArbitro(rs.getInt(4));
            p.setArbitroL1(rs.getInt(5));
            p.setArbitroL2(rs.getInt(6));
            p.setCuartoArbitro(rs.getInt(7));
            p.setIdEstadio(rs.getInt(8));
            p.setPublico(rs.getInt(9));
            p.setDia(rs.getString(10));
            p.setMes(rs.getString(11));
            p.setHoraInicio(rs.getString(12));
            p.setMinInicio(rs.getString(13));
            p.setHoraTermino(rs.getString(14));
            p.setMinTermino(rs.getString(15));
            p.setFase(rs.getInt(16));
        }

        c.desconectar();
        return p;
    }

    public DT getDT(int id) throws SQLException {
        DT dt = null;
        query = "select*from tbl_DirectorTecnico where id=" + id + "";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            dt = new DT();
            dt.setId(rs.getInt(1));
            dt.setNombre(rs.getString(2));
            dt.setApellido(rs.getString(3));
            dt.setEdad(rs.getInt(4));
            dt.setNacionalidad(rs.getInt(5));
            dt.setClubDeportivo(rs.getInt(6));
            dt.setAniosDT(rs.getInt(7));
            dt.setSueldoFifa(rs.getInt(8));
        }

        c.desconectar();
        return dt;
    }

    public Arbitro getArbitro(int id) throws SQLException {
        Arbitro a = null;
        query = "select*from tbl_arbitro where id=" + id + "";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            a = new Arbitro();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setApellido(rs.getString(3));
            a.setEdad(rs.getInt(4));
            a.setPosision(rs.getString(5));
            a.setPais(rs.getInt(6));
        }

        c.desconectar();
        return a;
    }

    public ClubDeportivo getClubDeportivo(int id) throws SQLException {
        ClubDeportivo cd = null;
        query = "select*from tbl_ClubDeportivo where id=" + id + "";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            cd = new ClubDeportivo();
            cd.setId(rs.getInt(1));
            cd.setNombre(rs.getString(2));
        }

        c.desconectar();
        return cd;
    }

    public Nacionalidad getNacionalidad(int id) throws SQLException {
        Nacionalidad n = null;
        query = "select*from tbl_pais where id=" + id + "";
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            n = new Nacionalidad();
            n.setId(rs.getInt(1));
            n.setPais(rs.getString(2));
        }

        c.desconectar();
        return n;
    }

    public Seleccion getSeleccion(int id) throws SQLException {
        Seleccion s = null;
        query = "select "
                + "tbl_Seleccion.id, "
                + "tbl_Seleccion.cantidadJugadores, "
                + "tbl_Seleccion.cuerpoTecnico, "
                + "tbl_Seleccion.estado, "
                + "tbl_Seleccion.pais, "
                + "tbl_Seleccion.rankingFIFA, "
                + "tbl_Seleccion.fase, "
                + "tbl_Seleccion.id_grupo, "
                + "tbl_pais.pais "
                + "from tbl_Seleccion inner join tbl_pais "
                + "on tbl_pais.id=tbl_Seleccion.pais "
                + "where tbl_Seleccion.id=" + id + "";
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            s = new Seleccion();
            s.setId(rs.getInt(1));
            s.setJugadores(rs.getInt(2));
            s.setCuerpoTecnico(rs.getInt(3));
            s.setEstado(rs.getBoolean(4));
            s.setPais(rs.getInt(5));
            s.setRankingFIFA(rs.getInt(6));
            s.setFase(rs.getInt(7));
            s.setGrupo(rs.getInt(8));
            s.setPaisStr(rs.getString(9));
        }

        c.desconectar();
        return s;
    }

    public Estadio getEstadio(int id) throws SQLException {
        Estadio e = null;
        query = "select*from tbl_estadio where id=" + id + "";
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            e = new Estadio();
            e.setId(rs.getInt(1));
            e.setNombre(rs.getString(2));
            e.setLugar(rs.getString(3));
            e.setCapacidad(rs.getInt(4));
        }

        c.desconectar();
        return e;
    }

    public Fase getFase(int id) throws SQLException {
        Fase f = null;
        query = "select*from tbl_Fase where id=" + id + "";
        rs = c.ejecutarSelect(query);

        if (rs.next()) {
            f = new Fase();
            f.setId(rs.getInt(1));
            f.setFase(rs.getString(2));
        }

        c.desconectar();
        return f;
    }

    public List<Partido> getPartidos() throws SQLException {
        partidos = new ArrayList<>();
        Partido p;
        query = "select id, "
                + "idSeleccion1, "
                + "idSeleccion2, "
                + "arbitro, "
                + "arbitroL1, "
                + "arbitroL2, "
                + "cuartoArbitro, "
                + "estadio, "
                + "publicoAsistente, "
                + "DAY(fecha) as 'Dia',"
                + "MONTH(fecha) as 'Mes',"
                + "DATEPART(hour, CONVERT(VARCHAR(10), horaInicio, 108)) as 'horaInicio', "
                + "DATEPART(minute, CONVERT(VARCHAR(10), horaInicio, 108)) as 'MinInicio',"
                + "DATEPART(hour, CONVERT(VARCHAR(10), horaTermino, 108)) as 'horaTermino', "
                + "DATEPART(minute, CONVERT(VARCHAR(10), horaTermino, 108)) as 'MinTermino',"
                + "fase "
                + "from tbl_partidos ";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            p = new Partido();
            p.setId(rs.getInt(1));
            p.setIdSeleccion1(rs.getInt(2));
            p.setIdSeleccion2(rs.getInt(3));
            p.setArbitro(rs.getInt(4));
            p.setArbitroL1(rs.getInt(5));
            p.setArbitroL2(rs.getInt(6));
            p.setCuartoArbitro(rs.getInt(7));
            p.setIdEstadio(rs.getInt(8));
            p.setPublico(rs.getInt(9));
            p.setDia(rs.getString(10));
            p.setMes(rs.getString(11));
            p.setHoraInicio(rs.getString(12));
            p.setMinInicio(rs.getString(13));
            p.setHoraTermino(rs.getString(14));
            p.setMinTermino(rs.getString(15));
            p.setFase(rs.getInt(16));
            partidos.add(p);
        }

        c.desconectar();
        return partidos;
    }

    public List<DT> getDTs() throws SQLException {
        dts = new ArrayList<>();
        DT dt;

        query = "select*from tbl_DirectorTecnico;";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            dt = new DT();
            dt.setId(rs.getInt(1));
            dt.setNombre(rs.getString(2));
            dt.setApellido(rs.getString(3));
            dt.setEdad(rs.getInt(4));
            dt.setNacionalidad(rs.getInt(5));
            dt.setClubDeportivo(rs.getInt(6));
            dt.setAniosDT(rs.getInt(7));
            dt.setSueldoFifa(rs.getInt(8));
            dts.add(dt);
        }

        c.desconectar();
        return dts;
    }

    public List<Arbitro> getArbitros() throws SQLException {
        arbitros = new ArrayList<>();
        Arbitro a;

        query = "select*from tbl_arbitro;";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            a = new Arbitro();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setApellido(rs.getString(3));
            a.setEdad(rs.getInt(4));
            a.setPosision(rs.getString(5));
            a.setPais(rs.getInt(6));
            arbitros.add(a);
        }

        c.desconectar();
        return arbitros;
    }

    public List<ClubDeportivo> getClubDeportivos() throws SQLException {
        clubes = new ArrayList<>();
        ClubDeportivo cd;

        query = "select*from tbl_ClubDeportivo;";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            cd = new ClubDeportivo();
            cd.setId(rs.getInt(1));
            cd.setNombre(rs.getString(2));
            clubes.add(cd);
        }

        c.desconectar();
        return clubes;
    }

    public List<Nacionalidad> getNacionalidades() throws SQLException {
        nacionalidades = new ArrayList<>();
        Nacionalidad n;
        query = "select*from tbl_Pais";
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            n = new Nacionalidad();
            n.setId(rs.getInt(1));
            n.setPais(rs.getString(2));
            nacionalidades.add(n);
        }

        c.desconectar();
        return nacionalidades;
    }

    public List<Seleccion> getSelecciones() throws SQLException {
        selecciones = new ArrayList<>();
        Seleccion s;
        query = "select "
                + "tbl_Seleccion.id, "
                + "tbl_Seleccion.cantidadJugadores, "
                + "tbl_Seleccion.cuerpoTecnico, "
                + "tbl_Seleccion.estado, "
                + "tbl_Seleccion.pais, "
                + "tbl_Seleccion.rankingFIFA, "
                + "tbl_Seleccion.fase, "
                + "tbl_Seleccion.id_grupo, "
                + "tbl_pais.pais "
                + "from tbl_Seleccion inner join tbl_pais "
                + "on tbl_pais.id=tbl_Seleccion.pais ";
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            s = new Seleccion();
            s.setId(rs.getInt(1));
            s.setJugadores(rs.getInt(2));
            s.setCuerpoTecnico(rs.getInt(3));
            s.setEstado(rs.getBoolean(4));
            s.setPais(rs.getInt(5));
            s.setRankingFIFA(rs.getInt(6));
            s.setFase(rs.getInt(7));
            s.setGrupo(rs.getInt(8));
            s.setPaisStr(rs.getString(9));
            selecciones.add(s);
        }

        c.desconectar();
        return selecciones;
    }

    public List<Estadio> getEstadios() throws SQLException {
        estadios = new ArrayList<>();
        Estadio e;
        query = "select*from tbl_estadio";
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            e = new Estadio();
            e.setId(rs.getInt(1));
            e.setNombre(rs.getString(2));
            e.setLugar(rs.getString(3));
            e.setCapacidad(rs.getInt(4));
            estadios.add(e);
        }

        c.desconectar();
        return estadios;
    }

    public List<Fase> getFases() throws SQLException {
        fases = new ArrayList<>();
        Fase f;
        query = "select*from tbl_Fase";
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            f = new Fase();
            f.setId(rs.getInt(1));
            f.setFase(rs.getString(2));
            fases.add(f);
        }

        c.desconectar();
        return fases;
    }

    public List<Partido> buscarPartidos(String filtro) throws SQLException {
        partidos = new ArrayList<>();
        Partido p;
        query = "select*from tbl_partidos where "
                + "id like '%" + filtro + "%' or "
                + "idSeleccion1 like '%" + filtro + "%' or "
                + "idSeleccion2 like '%" + filtro + "%' or "
                + "arbitro like '%" + filtro + "%' or "
                + "arbitroL1 like '%" + filtro + "%' or "
                + "arbitroL2 like '%" + filtro + "%' or "
                + "cuartoArbitro like '%" + filtro + "%' or "
                + "estadio like '%" + filtro + "%' or "
                + "publicoAsistente like '%" + filtro + "%' or "
                + "fecha like '%" + filtro + "%' or "
                + "horaInicio like '%" + filtro + "%' or "
                + "horaTermino like '%" + filtro + "%' or "
                + "fase like '%" + filtro + "%'"
                + ";";
        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            p = new Partido();
            p.setId(rs.getInt(1));
            p.setIdSeleccion1(rs.getInt(2));
            p.setIdSeleccion2(rs.getInt(3));
            p.setArbitro(rs.getInt(4));
            p.setArbitroL1(rs.getInt(5));
            p.setArbitroL2(rs.getInt(6));
            p.setCuartoArbitro(rs.getInt(7));
            p.setIdEstadio(rs.getInt(8));
            p.setPublico(rs.getInt(9));
            p.setDia(rs.getString(10));
            p.setMes(rs.getString(11));
            p.setHoraInicio(rs.getString(12));
            p.setMinInicio(rs.getString(13));
            p.setHoraTermino(rs.getString(14));
            p.setMinTermino(rs.getString(15));
            p.setFase(rs.getInt(16));
            partidos.add(p);
        }

        c.desconectar();
        return partidos;
    }

    public List<DT> buscarDTs(String filtro) throws SQLException {
        dts = new ArrayList<>();
        DT dt;

        query = "select*from tbl_DirectorTecnico where "
                + "id like '%" + filtro + "%' or "
                + "nombre like '%" + filtro + "%' or "
                + "apellido like '%" + filtro + "%' or "
                + "edad like '%" + filtro + "%' or "
                + "nacionalidad like '%" + filtro + "%' or "
                + "clubDeportivo like '%" + filtro + "%' or "
                + "aniosComoDT like '%" + filtro + "%' or "
                + "sueldoFIFA like '%" + filtro + "%'"
                + ";";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            dt = new DT();
            dt.setId(rs.getInt(1));
            dt.setNombre(rs.getString(2));
            dt.setApellido(rs.getString(3));
            dt.setEdad(rs.getInt(4));
            dt.setNacionalidad(rs.getInt(5));
            dt.setClubDeportivo(rs.getInt(6));
            dt.setAniosDT(rs.getInt(7));
            dt.setSueldoFifa(rs.getInt(8));
            dts.add(dt);
        }

        c.desconectar();
        return dts;
    }

    public List<Arbitro> buscarArbitros(String filtro) throws SQLException {
        arbitros = new ArrayList<>();
        Arbitro a;

        query = "select*from tbl_arbitro where "
                + "id like '%" + filtro + "%' or "
                + "nombre like '%" + filtro + "%' or "
                + "apellido like '%" + filtro + "%' or "
                + "edad like '%" + filtro + "%' or "
                + "posicion like '%" + filtro + "%' or "
                + "pais like '%" + filtro + "%'"
                + ";";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            a = new Arbitro();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setApellido(rs.getString(3));
            a.setEdad(rs.getInt(4));
            a.setPosision(rs.getString(5));
            a.setPais(rs.getInt(6));
            arbitros.add(a);
        }

        c.desconectar();
        return arbitros;
    }

    public List<ClubDeportivo> buscarClubDeportivos(String filtro) throws SQLException {
        clubes = new ArrayList<>();
        ClubDeportivo cd;

        query = "select*from tbl_ClubDeportivo where "
                + "id like '%" + filtro + "%' or "
                + "nombre like '%" + filtro + "%'"
                + ";";
//        System.out.println(query);
        rs = c.ejecutarSelect(query);

        while (rs.next()) {
            cd = new ClubDeportivo();
            cd.setId(rs.getInt(1));
            cd.setNombre(rs.getString(2));
            clubes.add(cd);
        }

        c.desconectar();
        return clubes;
    }
}
