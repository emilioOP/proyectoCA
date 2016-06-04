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
    
    public Data()throws SQLException{
        c = new Conexion(
            "localhost:1433", //servidor
            "proyectoCA", //base de datos 
            "sa", //permiso
            "123456" //clave
        );
    }
    
    public void crearPartido(Partido p) throws SQLException{
        query="insert into tbl_partidos values("
                + ""+p.getIdSeleccion1()+","
                + ""+p.getIdSeleccion2()+","
                + ""+p.getArbitro()+","
                + ""+p.getArbitroL1()+","
                + ""+p.getArbitroL2()+","
                + ""+p.getCuartoArbitro()+","
                + ""+p.getIdEstadio()+","
                + ""+p.getPublico()+","
                + ""+p.getFecha()+","
                + ""+p.getHoraInicio()+", "
                + ""+p.getHoraTermino()+","
                + ""+p.getFase()+""
                + ");";
//        System.out.println(query);
        c.ejecutar(query);
    }    
    public void crearDT(DT dt) throws SQLException{
        query="insert into tbl_DirectorTecnico values("
                + "'"+dt.getNombre()+"',"
                + "'"+dt.getApellido()+"',"
                + ""+dt.getEdad()+","
                + ""+dt.getNacionalidad()+","
                + ""+dt.getClubDeportivo()+","
                + ""+dt.getAniosDT()+","
                + ""+dt.getSueldoFifa()+""
                + ");";
//        System.out.println(query);
        c.ejecutar(query);
    }    
    public void crearArbitro(Arbitro a) throws SQLException{
        query="insert into tbl_arbitro values("
                + "'"+a.getNombre()+"',"
                + "'"+a.getApellido()+"',"
                + ""+a.getEdad()+","
                + ""+a.getPosision()+","
                + ""+a.getPais()+""
                + ");";
//        System.out.println(query);
        c.ejecutar(query);
    }    
    public void crearClubDeportivo(String nombreClub) throws SQLException{
        query="insert into tbl_ClubDeportivo values('"+nombreClub+"');";
//        System.out.println(query);
        c.ejecutar(query);
    }
    
    public void eliminarPartido(int id) throws SQLException{
        query="delete from tbl_partidos where id="+id+"";
//        System.out.println(query);
        c.ejecutar(query);     
    }
    public void eliminarDT(int id) throws SQLException{
        query="delete from tbl_DirectorTecnico where id="+id+"";
//        System.out.println(query);
        c.ejecutar(query);           
    }
    public void eliminarArbitro(int id) throws SQLException{
        query="delete from tbl_arbitro where id="+id+"";
//        System.out.println(query);
        c.ejecutar(query);         
    }
    public void eliminarClubDeportivo(int id) throws SQLException{
        query="delete from tbl_ClubDeportivo where id="+id+"";
//        System.out.println(query);
        c.ejecutar(query);        
    }
    
    public void actualizarPartido(Partido p) throws SQLException{
        query="update tbl_partidos set "
                + "idSeleccion1="+p.getIdSeleccion1()+", "
                + "idSeleccion2="+p.getIdSeleccion2()+", "
                + "arbitro="+p.getArbitro()+", "
                + "arbitroL1="+p.getArbitroL1()+", "
                + "arbitroL2="+p.getArbitroL2()+", "
                + "cuartoArbitro="+p.getCuartoArbitro()+", "
                + "estadio="+p.getIdEstadio()+", "
                + "publicoAsistente="+p.getPublico()+", "
                + "fecha='"+p.getFecha()+"', "
                + "horaInicio='"+p.getHoraInicio()+"', "
                + "horaTermino='"+p.getHoraTermino()+"', "
                + "fase="+p.getFase()+" "
                + "where id="+p.getId()+";";
//        System.out.println(query);
        c.ejecutar(query);
    }
    public void actualizarDT(DT dt) throws SQLException{
        query="update tbl_DirectorTecnico set "
                + "nombre='"+dt.getNombre()+"', "
                + "apellido='"+dt.getApellido()+"', "
                + "edad="+dt.getEdad()+" , "
                + "nacionalidad="+dt.getNacionalidad()+", "
                + "clubDeportivo="+dt.getClubDeportivo()+", "
                + "aniosComoDT="+dt.getAniosDT()+", "
                + "sueldoFIFA="+dt.getSueldoFifa()+" "
                + "where id="+dt.getId()+";";
        System.out.println(query);
        c.ejecutar(query);
    }
    public void actualizarArbitro(Arbitro a) throws SQLException{
        query="update tbl_arbitro set "
                + "nombre='"+a.getNombre()+"', "
                + "apellido='"+a.getApellido()+"', "
                + "edad="+a.getEdad()+", "
                + "posicion='"+a.getPosision()+"', "
                + "pais="+a.getPais()+" "
                + "where id="+a.getId()+";";
//        System.out.println(query);
        c.ejecutar(query);
    }
    public void actualizarClubDeportivo(ClubDeportivo cd) throws SQLException{
        query="update tbl_ClubDeportivo set "
                + "nombre='"+cd.getNombre()+"' "
                + "where id= "+cd.getId()+";";
//        System.out.println(query);
        c.ejecutar(query);
    }
    
    public Partido getPartido(int id) throws SQLException{
        Partido p=null;
        query="select*from tbl_partidos where id="+id+"";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        if(rs.next()){
            p=new Partido();
            p.setId(rs.getInt(1));
            p.setIdSeleccion1(rs.getInt(2));
            p.setIdSeleccion2(rs.getInt(3));
            p.setArbitro(rs.getInt(4));
            p.setArbitroL1(rs.getInt(5));
            p.setArbitroL2(rs.getInt(6));
            p.setCuartoArbitro(rs.getInt(7));
            p.setIdEstadio(rs.getInt(8));
            p.setPublico(rs.getInt(9));
            p.setFecha(rs.getString(10));
            p.setHoraInicio(rs.getString(11));
            p.setHoraTermino(rs.getString(12));
            p.setFase(rs.getInt(13));
        }
        
        c.desconectar();
        return p;
    }
    public DT getDT(int id) throws SQLException{
        DT dt=null;
        query="select*from tbl_DirectorTecnico where id="+id+"";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        if(rs.next()){
            dt=new DT();
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
    public Arbitro getArbitro(int id) throws SQLException{
        Arbitro a=null;
        query="select*from tbl_arbitro where id="+id+"";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        if(rs.next()){
            a=new Arbitro();
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
    public ClubDeportivo getClubDeportivo(int id) throws SQLException{
        ClubDeportivo cd=null;
        query="select*from tbl_ClubDeportivo where id="+id+"";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        if(rs.next()){
            cd=new ClubDeportivo();
            cd.setId(rs.getInt(1));
            cd.setNombre(rs.getString(2));
        }
        
        c.desconectar();        
        return cd;
    }
    public Nacionalidad getNacionalidad(int id) throws SQLException{
        Nacionalidad n=null;
        query="select*from tbl_pais where id="+id+"";
        rs=c.ejecutarSelect(query);
        
        if(rs.next()){
            n=new Nacionalidad();
            n.setId(rs.getInt(1));
            n.setPais(rs.getString(2));
        }
        
        c.desconectar();
        return n;
    }
    
    public List<Partido> getPartidos() throws SQLException{
        partidos=new ArrayList<>();
        Partido p;
        query="select*from tbl_partidos;";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            p=new Partido();
            p.setId(rs.getInt(1));
            p.setIdSeleccion1(rs.getInt(2));
            p.setIdSeleccion2(rs.getInt(3));
            p.setArbitro(rs.getInt(4));
            p.setArbitroL1(rs.getInt(5));
            p.setArbitroL2(rs.getInt(6));
            p.setCuartoArbitro(rs.getInt(7));
            p.setIdEstadio(rs.getInt(8));
            p.setPublico(rs.getInt(9));
            p.setFecha(rs.getString(10));
            p.setHoraInicio(rs.getString(11));
            p.setHoraTermino(rs.getString(12));
            p.setFase(rs.getInt(13));
            partidos.add(p);           
        }
        
        c.desconectar();
        return partidos;
    }
    public List<DT> getDTs() throws SQLException{
        dts=new ArrayList<>();
        DT dt;
        
        query="select*from tbl_DirectorTecnico;";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            dt=new DT();
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
    public List<Arbitro> getArbitros() throws SQLException{
        arbitros=new ArrayList<>();
        Arbitro a;
        
        query="select*from tbl_arbitro;";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            a=new Arbitro();
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
    public List<ClubDeportivo> getClubDeportivos() throws SQLException{
        clubes=new ArrayList<>();
        ClubDeportivo cd;
        
        query="select*from tbl_ClubDeportivo;";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            cd=new ClubDeportivo();
            cd.setId(rs.getInt(1));
            cd.setNombre(rs.getString(2));
            clubes.add(cd);
        }
        
        c.desconectar();
        return clubes;
    }
    public List<Nacionalidad> getNacionalidades() throws SQLException{
        nacionalidades = new ArrayList<>();
        Nacionalidad n;
        query="select*from tbl_Pais";
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){            
            n=new Nacionalidad();
            n.setId(rs.getInt(1));
            n.setPais(rs.getString(2));
            nacionalidades.add(n);
        }
        
        c.desconectar();
        return nacionalidades;
    }
    
    public List<Partido> buscarPartidos(String filtro) throws SQLException{
        partidos=new ArrayList<>();
        Partido p;
        query="select*from tbl_partidos where "
                + "id like '%"+filtro+"%', "
                + "idSeleccion1 like '%"+filtro+"%', "
                + "idSeleccion2 like '%"+filtro+"%', "
                + "arbitro like '%"+filtro+"%', "
                + "arbitroL1 like '%"+filtro+"%', "
                + "arbitroL2 like '%"+filtro+"%', "
                + "cuartoArbitro like '%"+filtro+"%', "
                + "estado like '%"+filtro+"%', "
                + "publicoAsistente like '%"+filtro+"%', "
                + "fecha like '%"+filtro+"%', "
                + "horaInicio like '%"+filtro+"%', "
                + "horaTermino like '%"+filtro+"%', "
                + "fase like '%"+filtro+"%'"
                + ";";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            p=new Partido();
            p.setId(rs.getInt(1));
            p.setIdSeleccion1(rs.getInt(2));
            p.setIdSeleccion2(rs.getInt(3));
            p.setArbitro(rs.getInt(4));
            p.setArbitroL1(rs.getInt(5));
            p.setArbitroL2(rs.getInt(6));
            p.setCuartoArbitro(rs.getInt(7));
            p.setIdEstadio(rs.getInt(8));
            p.setPublico(rs.getInt(9));
            p.setFecha(rs.getString(10));
            p.setHoraInicio(rs.getString(11));
            p.setHoraTermino(rs.getString(12));
            p.setFase(rs.getInt(13));
            partidos.add(p);           
        }
        
        c.desconectar();
        return partidos;
    }    
    public List<DT> buscarDTs(String filtro) throws SQLException{
        dts=new ArrayList<>();
        DT dt;
        
        query="select*from tbl_DirectorTecnico where "
                + "id like '%"+filtro+"%' or "
                + "nombre like '%"+filtro+"%' or "
                + "apellido like '%"+filtro+"%' or "
                + "edad like '%"+filtro+"%' or "
                + "nacionalidad like '%"+filtro+"%' or "
                + "clubDeportivo like '%"+filtro+"%' or "
                + "aniosComoDT like '%"+filtro+"%' or "
                + "sueldoFIFA like '%"+filtro+"%'"
                + ";";
        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            dt=new DT();
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
    public List<Arbitro> buscarArbitros(String filtro) throws SQLException{
        arbitros=new ArrayList<>();
        Arbitro a;
        
        query="select*from tbl_arbitro where "
                + "id like '%"+filtro+"%', "
                + "nombre like '%"+filtro+"%', "
                + "apellido like '%"+filtro+"%', "
                + "edad like '%"+filtro+"%', "
                + "posicion like '%"+filtro+"%', "
                + "pais like '%"+filtro+"%'"
                + ";";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            a=new Arbitro();
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
    public List<ClubDeportivo> buscarClubDeportivos(String filtro) throws SQLException{
        clubes=new ArrayList<>();
        ClubDeportivo cd;
        
        query="select*from tbl_ClubDeportivo where "
                + "id like '%"+filtro+"%', "
                + "nombre like '%"+filtro+"%'"
                + ";";
//        System.out.println(query);
        rs=c.ejecutarSelect(query);
        
        while(rs.next()){
            cd=new ClubDeportivo();
            cd.setId(rs.getInt(1));
            cd.setNombre(rs.getString(2));
            clubes.add(cd);
        }
        
        c.desconectar();
        return clubes;
    }
    public List<Nacionalidad> getNacionalidades(String filtro) throws SQLException{
        nacionalidades = new ArrayList<>();
        Nacionalidad n;
        query="select*from tbl_Pais where "
                + "id like '%"+filtro+"%', "
                + "pais '%"+filtro+"%'";
        rs=c.ejecutarSelect(query);
        
        int id=0;
        String pais=null;
        while(rs.next()){            
            n=new Nacionalidad(id, pais);
            nacionalidades.add(n);
        }
        
        c.desconectar();
        return nacionalidades;        
    }  
}


