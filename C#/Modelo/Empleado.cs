using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Controlador;

namespace Modelo
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
            idEmpleado = 0;
            nombreEmpleado = string.Empty;
            apellidoEmpleado = string.Empty;
            rutEmpleado = string.Empty;
            estadoCivilEmpleado = string.Empty;
        }

        public bool CreateCliente()
        {
            ModeloOracle bd = new ModeloOracle();
            EMPLEADO empleado = new EMPLEADO();

            try
            {
                empleado.IDEMPLEADO = this.idEmpleado;
                empleado.NOMBREEMPLEADO = this.nombreEmpleado;
                empleado.APELLIDOEMPLEADO = this.apellidoEmpleado;
                empleado.RUTEMPELADO = this.rutEmpleado;
                empleado.ESTADOCIVIL = this.estadoCivilEmpleado;

                ComonBC.oradata.EMPLEADOes.Add(empleado);

                ComonBC.oradata.SaveChanges();

                return true;

            }
            catch (Exception)
            {
                return false;
            }

        }

        public bool DeleteCliente(int id)
        {

            ModeloOracle bd = new ModeloOracle();

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

            ModeloOracle db = new ModeloOracle();


            var up = from empleado in db.EMPLEADOes
                     where empleado.IDEMPLEADO == id
                     select empleado;


            int resultado = up.Count();
            if (resultado >= 1)
            {
                foreach (var update in up)
                {
                    update.NOMBREEMPLEADO = nombre;
                    update.APELLIDOEMPLEADO = apellido;
                    update.ESTADOCIVIL = estadoCivil;

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
