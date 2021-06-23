/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Contacto;

/**
 *
 * @author Informática
 */
public interface IContacto {
    public int create(Contacto contacto);
    public int delete(String correo);
    public int update(Contacto contacto);
    public Contacto findByEmail(String correo);
    public ArrayList<Contacto> findAll();
}
