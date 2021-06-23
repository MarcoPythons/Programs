using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using ADO.Conn;


namespace OracleNegocio
{
  public class Empleado
  {
 
        public int idEmpleado { get; set; }
        public string nombreEmpleado { get; set; }
        public string apellidoEmpleado { get; set; }
        public string rutEmpleado { get; set; }
        public string estadoCivilEmpleado { get; set; }


        private void init()
        {
            idEmpleado =0;
            nombreEmpleado = string.Empty;
            apellidoEmpleado = string.Empty;
            rutEmpleado = string.Empty;
            estadoCivilEmpleado = string.Empty;
        }

        public bool CreateCliente()
        {
            ADO.Conn.Oradata bd = new ADO.Conn.Oradata();
            ADO.Conn.EMPLEADO empleado = new ADO.Conn.EMPLEADO();

            try
            {
                empleado.IDEMPLEADO = this.idEmpleado;
                empleado.NOMBRES = this.nombreEmpleado;
                empleado.APELLIDOS = this.apellidoEmpleado;
                empleado.RUT = this.rutEmpleado;
                empleado.ESTADO_CIVIL = this.estadoCivilEmpleado;

                CommonBC.ModeloOracle.EMPLEADOes.Add(empleado);

                CommonBC.ModeloOracle.SaveChanges();

                return true;

            }
            catch (Exception)
            {
                return false;
            }

        }

        public bool DeleteCliente(int id)
        {

            ADO.Conn.Oradata bd = new ADO.Conn.Oradata();

            var del = from empleado in bd.EMPLEADOes
                      where empleado.IDEMPLEADO == id
                      select empleado;

            int resultado = del.Count();

            if (resultado >= 1)
            {
                foreach (var cli in del)
                {
                    bd.EMPLEADOes.Remove(cli);

                }


                try
                {
                    bd.SaveChanges();
                    return true;
                }
                catch (Exception)
                {

                    return false;
                }
            }
            else
            {
                return false;
            }



        }

        public bool updateCliente(int id, string nombre, string apellido, string estadoCivil)
        {

            ADO.Conn.Oradata db = new ADO.Conn.Oradata();


            var up = from empleado in db.EMPLEADOes
                     where empleado.IDEMPLEADO == id
                     select empleado;


            int resultado = up.Count();
            if (resultado >= 1)
            {
                foreach (var update in up)
                {
                    update.NOMBRES = nombre;
                    update.APELLIDOS = apellido;
                    update.ESTADO_CIVIL = estadoCivil;
                    
                }

                try
                {
                    db.SaveChanges();

                    return true;

                }
                catch (Exception)
                {

                    return false;
                }
            }
            else
            {
                return false;
            }


        }

       

    }
}
