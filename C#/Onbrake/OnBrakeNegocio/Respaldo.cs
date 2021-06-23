using OnBrakeDatos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OnBrakeDatos;
using System.Data.SqlClient;

namespace OnBrakeNegocio
{
   public class Respaldo
    {
        public string id { get; set;  }
        public string RazonSocial { get; set;  }
        public string fecha_inicio { get; set;  }
        public string hora_inicio { get; set;  }
        public string evento_realizado { get; set;  }
        public string Tipo_evento { get; set;  }
        public string Modalidad_evento { get; set;  }
        public string Tipo_ambientacion { get; set;  }
        public string Musica_ambiental { get; set;  }
        public string Musica_cliente { get; set;  }
        public string Fecha_termino { get; set;  }
        public string Local { get; set;  }
        public string Hora_termino { get; set;  }
        public string Observaciones { get; set;  }
        public string Asistentes_evento { get; set;  }
        public string Personal_adicional { get; set;  }
        public string Valor_contrato { get; set;  }



        private void init()
        {
            id = string.Empty;
            RazonSocial = string.Empty;
            fecha_inicio = string.Empty;
            hora_inicio = string.Empty;
            evento_realizado = string.Empty;
            Tipo_evento = string.Empty;
            Modalidad_evento = string.Empty;
            Tipo_ambientacion = string.Empty;
            Musica_ambiental = string.Empty;
            Musica_cliente = string.Empty;
            Fecha_termino = string.Empty;
            Local = string.Empty;
            Hora_termino = string.Empty;
            Observaciones = string.Empty;
            Asistentes_evento = string.Empty;
            Personal_adicional = string.Empty;
            Valor_contrato = string.Empty;



        }



        public bool createRespaldo(string ID)
        {
            try
            {
                OnBreak2Entities bd = new OnBreak2Entities();
                OnBrakeDatos.Respaldo respaldo = new OnBrakeDatos.Respaldo();

                respaldo.Id = float.Parse(ID);
                respaldo.RazonSocial = RazonSocial;
                respaldo.fecha_inicio = fecha_inicio;
                respaldo.hora_inicio = hora_inicio;
                respaldo.evento_realizado = evento_realizado;
                respaldo.Tipo_evento = Tipo_evento;
                respaldo.Modalidad_evento = Modalidad_evento;
                respaldo.Tipo_ambientacion = Tipo_ambientacion;
                respaldo.Musica_ambiental = Musica_ambiental;
                respaldo.Musica_cliente = Musica_cliente;
                respaldo.Fecha_termino = Fecha_termino;
                respaldo.local_o = Local;
                respaldo.Hora_termino = Hora_termino;
                respaldo.Observaciones = Observaciones;
                respaldo.Asistentes_evento = Asistentes_evento;
                respaldo.Personal_adicional = Personal_adicional;
                respaldo.Valor_contrato = Valor_contrato;

                CommonBC.ModeloOnbrake.Respaldo.Add(respaldo);
                CommonBC.ModeloOnbrake.SaveChanges();






                return false;
            }
            catch (SqlException)
            {
                return false;
            }
        }


        public bool deleteRespaldo(string ID)
        {

            float IDD = float.Parse(ID);

            OnBreak2Entities bd = new OnBreak2Entities();

            var tabla = from respaldo in bd.Respaldo
                        where respaldo.Id == IDD
                        select respaldo;

            int resultado = tabla.Count();

            if (resultado >=1)
            {
                foreach (var tablita in tabla)
                {
                    bd.Respaldo.Remove(tablita);
                }

                try
                {
                    CommonBC.ModeloOnbrake.SaveChanges();
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



    }

    

}
