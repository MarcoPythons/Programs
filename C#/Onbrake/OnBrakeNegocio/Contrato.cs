using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net.Http.Headers;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using OnBrakeDatos;


namespace OnBrakeNegocio
{
   public class Contrato
    {
        
        public string NumeroContrato { get; set; }
        public string FechaCreacion { get; set; }
        public string FechaTermino { get; set; }
        public string rutCliente { get; set; }
        public string idModalidad { get; set; }
        public int idTipoEvento { get; set; }
        public string HoraCreacion { get; set; }
        public string HoraTermino { get; set; }
        public int Asistentes { get; set; }
        public int PersonalAdicional { get; set; }
        public bool Realizado { get; set; }
        public double ValorTotalContrato { get; set; }
        public string Observaciones { get; set;}
        

        


        private void init()
        {
            NumeroContrato = string.Empty;
            FechaCreacion = DateTime.Now.ToShortDateString();
            FechaTermino = DateTime.Now.ToShortDateString();
            HoraCreacion = DateTime.Now.ToShortTimeString();
            HoraTermino =  DateTime.Now.ToShortTimeString();
            rutCliente = string.Empty;
            idModalidad = string.Empty;
            idTipoEvento = 0;
            Asistentes = 0;
            PersonalAdicional = 0;
            ValorTotalContrato = 0;
            Realizado = false;
            Observaciones = string.Empty;

        }
        //formato fecha DD/MM/AAAA
        //formato 24 horas es DateTime.Now.ToString("HH:mm:ss")

        public bool create(string rut)
        {

            OnBreak2Entities bd = new OnBreak2Entities();
            OnBrakeDatos.Contrato contrato = new OnBrakeDatos.Contrato();
            
            try
            {
                var tabla = from cliente in bd.Cliente
                            where cliente.RutCliente == rut
                            select new {cliente.RutCliente};

                string RutCliente = string.Empty;
                foreach (var tablita in tabla)
                {
                    RutCliente = tablita.RutCliente;
                }


                contrato.Numero = this.NumeroContrato;
                contrato.Creacion = DateTime.Parse(this.FechaCreacion); 
                contrato.Termino = DateTime.Parse(this.FechaTermino);
                contrato.FechaHoraInicio = DateTime.Parse(this.HoraCreacion);
                contrato.FechaHoraTermino = DateTime.Parse(this.HoraTermino);
                contrato.RutCliente = RutCliente;
                contrato.IdModalidad = this.idModalidad;
                contrato.IdTipoEvento = this.idTipoEvento;
                contrato.Asistentes = this.Asistentes;
                contrato.PersonalAdicional = this.PersonalAdicional;
                contrato.Realizado = this.Realizado;
                contrato.ValorTotalContrato = this.ValorTotalContrato;
                contrato.Observaciones = this.Observaciones;
                

                CommonBC.ModeloOnbrake.Contrato.Add(contrato);
                CommonBC.ModeloOnbrake.SaveChanges();

                return true;
            }
            catch (SqlException)
            {
                return false;
            }
            
        }


       public int updateContrato(string numeroContrato, string rutcliente, string observaciones, int asistentes, int personalAdicional, double valorTotal, bool realizado)
        {

            OnBreak2Entities bd = new OnBreak2Entities();
            var tabla = from contrato in bd.Contrato
                        join cliente in bd.Cliente
                        on contrato.RutCliente equals cliente.RutCliente 
                        where contrato.Numero == numeroContrato
                        where cliente.RutCliente == rutcliente
                        select contrato;

            int resultado = tabla.Count();
            if (resultado >= 1)
            {
                foreach (var update in tabla)
                {
                    update.Asistentes = asistentes;
                    update.PersonalAdicional = personalAdicional;
                    update.ValorTotalContrato = valorTotal;
                    update.Observaciones = observaciones;
                    update.Realizado = realizado;
                   

                }
                
                    bd.SaveChanges();
                    return resultado;
                
            }
            else
            {
                return resultado;
            }




       }


        public  bool terminarContrato(string numeroContrato, string rutcliente)
        {
            OnBreak2Entities bd = new OnBreak2Entities();

            var tabla = from contrato in bd.Contrato
                        join cliente in bd.Cliente
                        on contrato.RutCliente equals cliente.RutCliente
                        where contrato.Numero == numeroContrato
                        where cliente.RutCliente == rutcliente
                        select contrato;

            int resultado = tabla.Count();

            if (resultado >= 1)
            {
                foreach (var terminar in tabla)
                {
                    
                    terminar.Termino = DateTime.Now;
                    terminar.FechaHoraTermino = DateTime.Parse(DateTime.Now.ToShortTimeString());

                    if (terminar.Termino < terminar.Creacion)
                    {
                        terminar.Realizado = false;
                    }
                    else
                    {
                        terminar.Realizado = true;
                    }
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

        }
       

}

