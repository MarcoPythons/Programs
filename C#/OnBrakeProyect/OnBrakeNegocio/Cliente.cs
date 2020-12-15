using OnBrakeDatos;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OnBrakeNegocio
{
     public class Cliente
    {

        public string Rut { get; set; }
        public string RazonSocial { get; set; }
        public string NombreCliente { get; set; }
        public string MailContacto { get; set; }
        public string Direccion { get; set; }
        public string Telefono { get; set; }
        public int Actividad { get; set; }
        public int Tipo { get; set; }


        private void init()
        {
            Rut = string.Empty;
            RazonSocial = string.Empty;
            NombreCliente = string.Empty;
            MailContacto = string.Empty;
            Direccion = string.Empty;
            Telefono = string.Empty;
            Actividad = 0;
            Tipo = 0;

        }


        public bool CreateCliente()
        {
            OnBrakeDatos.OnBreak2Entities bd = new OnBrakeDatos.OnBreak2Entities();
            OnBrakeDatos.Cliente cliente = new OnBrakeDatos.Cliente();

            try
            {
                cliente.RutCliente = this.Rut;
                cliente.RazonSocial = this.RazonSocial;
                cliente.NombreContacto = this.NombreCliente;
                cliente.MailContacto = this.MailContacto;
                cliente.Direccion = this.Direccion;
                cliente.Telefono = this.Telefono;
                cliente.IdActividadEmpresa = this.Actividad;
                cliente.IdTipoEmpresa = this.Tipo;

                CommonBC.ModeloOnbrake.Cliente.Add(cliente);
                
                CommonBC.ModeloOnbrake.SaveChanges();

                return true;

           }
           catch (SqlException)
            {
                return false;
           }
            
        }

        public bool DeleteCliente(string rut)
        {

            OnBreak2Entities bd = new OnBreak2Entities();
                
                var del = from cliente in bd.Cliente
                          where cliente.RutCliente == rut
                          select cliente;

            int resultado = del.Count();

            if (resultado >= 1)
            {
                foreach (var cli in del)
                {
                    bd.Cliente.Remove(cli);

                }


                try
                {
                    bd.SaveChanges();
                    return true;
                }
                catch (SqlException)
                {

                    return false;
                }
            }
            else
            {
                return false;
            }


            
        }

        public bool updateCliente(string rut, string razonSocial, string mail, string direccion, string telefono)
        {

            OnBreak2Entities db = new OnBreak2Entities();
            

           var up = from cliente in db.Cliente
                    where cliente.RutCliente == rut
                         select cliente;


            int resultado = up.Count();
            if (resultado >= 1)
            {
                foreach (var update in up)
                {
                    update.RazonSocial = razonSocial;
                    update.MailContacto = mail;
                    update.Direccion = direccion;
                    update.Telefono = telefono;
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


        public int BuscarRut(string rut)
        {


            using (OnBrakeDatos.OnBreak2Entities db = new OnBrakeDatos.OnBreak2Entities())
            {
                var tabla = from cliente in db.Cliente
                            join AcEmpresa in db.ActividadEmpresa
                            on cliente.IdActividadEmpresa equals AcEmpresa.IdActividadEmpresa
                            join TiEmpresa in db.TipoEmpresa
                            on cliente.IdTipoEmpresa equals TiEmpresa.IdTipoEmpresa
                            where cliente.RutCliente == rut
                            select new
                            {
                                Cliente = cliente.RutCliente,
                                cliente.RazonSocial,
                                cliente.NombreContacto,
                                cliente.MailContacto,
                                cliente.Direccion,
                                cliente.Telefono,
                                ActividadEmpresa = AcEmpresa.Descripcion,
                                TipoEmpresa = TiEmpresa.Descripcion
                            };

                int resultado = tabla.Count();
                
                return resultado;
            }
        }


        public int ReadAllByTipoEmpresa(string TipoEmpresa)
        {

            using (OnBreak2Entities db = new OnBreak2Entities())
            {
                var tabla = from cliente in db.Cliente
                            join AcEmpresa in db.ActividadEmpresa
                            on cliente.IdActividadEmpresa equals AcEmpresa.IdActividadEmpresa
                            join TiEmpresa in db.TipoEmpresa
                            on cliente.IdTipoEmpresa equals TiEmpresa.IdTipoEmpresa
                            where TiEmpresa.Descripcion == TipoEmpresa
                            select new
                            {
                                Cliente = cliente.RutCliente,
                                cliente.RazonSocial,
                                cliente.NombreContacto,
                                cliente.MailContacto,
                                cliente.Direccion,
                                cliente.Telefono,
                                ActividadEmpresa = AcEmpresa.Descripcion,
                                TipoEmpresa = TiEmpresa.Descripcion
                            };


                int resultado = tabla.Count();
                return resultado;
            }




                
        }


    }
}
