using OnBrakeDatos;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OnBrakeNegocio
{
    public class Cenas
    {

        public string numero { get; set; }
        public int idTipoAmbientacion { get; set; }
        public bool musicaAmbiental { get; set; }
        public bool localOnBrake { get; set; }
        public bool otroLocalOnBreak { get; set; }
        public double valorArriendo { get; set; }
        
        private void init()
        {
            numero = string.Empty;
            idTipoAmbientacion = 0;
            musicaAmbiental = false;
            localOnBrake = false;
            otroLocalOnBreak = false;
            valorArriendo = 0;
        }


        public bool createCena(string rutCliente)
        {
           try 
            {
                OnBreak2Entities bd = new OnBreak2Entities();
                    var tabla = from contrato in bd.Contrato
                                where contrato.RutCliente == rutCliente
                                select contrato;
                    foreach (var table in tabla)
                    {

                        this.numero = table.Numero;

                    }
                OnBrakeDatos.Cenas cenas = new OnBrakeDatos.Cenas();
                cenas.Numero = this.numero;
                cenas.IdTipoAmbientacion = this.idTipoAmbientacion;
                cenas.MusicaAmbiental = this.musicaAmbiental;
                cenas.LocalOnBreak = this.localOnBrake;
                cenas.OtroLocalOnBreak = this.otroLocalOnBreak;
                cenas.ValorArriendo = this.valorArriendo;
                CommonBC.ModeloOnbrake.Cenas.Add(cenas);
                CommonBC.ModeloOnbrake.SaveChanges();
                return true;

            } catch (SqlException) 
            {


                return false;

            }


            
        }  


    }
}
