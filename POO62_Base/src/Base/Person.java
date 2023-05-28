package Base;


import  Base.PackUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lambda
 */
public class Person {
    private long id;
    private String name;
    private long importe;
    private String modelo;
    private String fecha;
    private String talla;
    private static final int NAME_LIMIT = 30;
    private static final int Mod_LIMIT = 30;
    private static final int Fec_LIMIT = 30;
    private static final int Tall_LIMIT =30;
    public static final int SIZE = 8 + 2 * NAME_LIMIT  + 8 + 2 * Mod_LIMIT  + 2 * Fec_LIMIT 
                  + 2 * Tall_LIMIT ; // 176 BYTES
//  private long id;
//    private String name;
//    private int age;
//    private boolean married;
//    
//    private static final int NAME_LIMIT = 20;
//    public static final int SIZE = 8 + 2 * NAME_LIMIT + 4 + 1; //53 BYTES
    public Person(long id, String name, long importe, String modelo, String fecha, String talla) {
        this.id = id;
        this.name = name;
        this.importe = importe;
        this.modelo = modelo;
        this.fecha = fecha;
        this.talla = talla;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getImporte() {
        return importe;
    }

    public void setImporte(long importe) {
        this.importe = importe;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", importe=" + importe + ", modelo=" + modelo + ", fecha=" + fecha + ", talla=" + talla + '}';
    }

 

    

  
    
    public byte[] toBytes(){

        byte[] record = new byte[SIZE];
        int offset= 0;
        PackUtils.packLong(id, record, offset);
        offset +=8;
        PackUtils.packLimitedString(name, NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;
        PackUtils.packLong(importe, record, offset);
        offset +=8;
        PackUtils.packLimitedString(modelo, Mod_LIMIT, record, offset);
        offset += 2 * Mod_LIMIT;
        PackUtils.packLimitedString(fecha, Fec_LIMIT, record, offset);
        offset += 2 * Fec_LIMIT;
        PackUtils.packLimitedString(talla, Tall_LIMIT, record, offset);
        offset += 2 * Tall_LIMIT;
        
 
        return record;
    }
    
    public static Person fromBytes(byte[] record){
        int offset = 0;
        long id = PackUtils.unpackLong(record, offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;
        long importe = PackUtils.unpackLong(record, offset);
        offset += 8;
        String modelo = PackUtils.unpackLimitedString(Mod_LIMIT, record, offset);
        offset += 2 * Mod_LIMIT;
        String fecha = PackUtils.unpackLimitedString(Fec_LIMIT, record, offset);
        offset += 2 * Fec_LIMIT;
        String talla = PackUtils.unpackLimitedString(Tall_LIMIT, record, offset);
        offset += 2 * Tall_LIMIT;
        
        return new Person(id,name,importe, modelo,fecha,talla);
    }
}
