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
    public class Cocktail
    {
        public string numero { get; set; }
        public int id_tipo_ambientacion { get; set; }
        public bool ambientacion { get; set; }
        public bool musica_ambiental { get; set; }
        public bool musica_cliente { get; set; }

        private void init()
        {
            numero = string.Empty;
            id_tipo_ambientacion = 0;
            ambientacion = false;
            musica_ambiental = false;
            musica_cliente = false;
        }


        public bool createCocktail(string rutCliente)
        {
            try
            {
                OnBreak2Entities bd = new OnBreak2Entities();

                var tabla = from contrato in bd.Contrato
                            where contrato.RutCliente == rutCliente
                            select contrato;

                foreach (var table in tabla)
                {
                    this.numero = table.Numero ;
                }

                OnBrakeDatos.Cocktail cocktail = new OnBrakeDatos.Cocktail();

                cocktail.Numero = this.numero;
                cocktail.IdTipoAmbientacion = this.id_tipo_ambientacion;
                cocktail.Ambientacion = this.ambientacion;
                cocktail.MusicaAmbiental = this.musica_ambiental;
                cocktail.MusicaCliente = this.musica_cliente;

                CommonBC.ModeloOnbrake.Cocktail.Add(cocktail);
                CommonBC.ModeloOnbrake.SaveChanges();


                return true;
            }
            catch (SqlException)
            {
                return false;
            }


        }
    }
}
