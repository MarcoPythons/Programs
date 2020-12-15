using OnBrakeDatos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OnBrakeNegocio
{
    public class Valorizador
    {
        public int Asistentes { get; set; }
        public int PersonalAdicional { get; set; }
        public int Ambientacion { get; set; }
        public bool MusicaAmbiental { get; set; }
        public bool localOnbrake { get; set; }

        
        private double ValorBase = 0;

        private double ValorContrato = 0;

        private int ambientacion = 0;
        private double musicaAmbiental = 0;
        private double local = 0;
        private double RecargoAsistentes = 0;
        private double RecargoPersonalAdicional = 0;

        private string tipoEvento =string.Empty ;
        public void init()
        {
            Asistentes = 0;
            PersonalAdicional = 0;
            Ambientacion = 0;
            MusicaAmbiental = false;
            localOnbrake = false;
        }

        public double CalcularValorEvento(int TipoEvento, string modalidad)
        {

            OnBreak2Entities bd = new OnBreak2Entities();

            var tabla = from modalidadServicio in bd.ModalidadServicio
                        join tipoevento in bd.TipoEvento on modalidadServicio.IdTipoEvento equals tipoevento.IdTipoEvento
                        where modalidadServicio.IdTipoEvento == TipoEvento
                        where modalidadServicio.Nombre == modalidad
                        select new {  modalidadServicio.ValorBase, tipoevento.Descripcion };

            foreach (var tablita in tabla)
            {

                this.ValorBase = tablita.ValorBase;
                this.tipoEvento = tablita.Descripcion;
            }

            if (tipoEvento.Equals("Coffee Break"))
            {



                if (Asistentes >= 1 && Asistentes <= 20)
                {
                    RecargoAsistentes = 3;
                }
                else if (Asistentes >= 21 && Asistentes <= 50)
                {
                    RecargoAsistentes = 5;
                }
                else if (Asistentes > 50)
                {


                    double AsistentesExtras = 0;
                    double a = 0;
                    double b = 0;
                    double resultadoFinal = 0;
                    double resultado = 0;
                    AsistentesExtras = Asistentes - 50;
                    a = AsistentesExtras / 20;
                    b = (a % 1);
                    if (b < 0.5 || b >= 0.5)
                    {
                        resultado = (Math.Ceiling(a));
                        resultadoFinal = resultado * 2;
                    }

                    RecargoAsistentes = 5 + resultadoFinal;

                }



                
                if (PersonalAdicional == 2)
                {
                    RecargoPersonalAdicional = 2;
                }
                else if (PersonalAdicional == 3)
                {
                    RecargoPersonalAdicional = 3;
                }
                else if (PersonalAdicional == 4)
                {
                    RecargoPersonalAdicional = 3.5;
                }
                else if (PersonalAdicional > 4)
                {
                    RecargoPersonalAdicional = 3.5 + (PersonalAdicional * 0.5);


                }
               


                ValorContrato = ValorBase + RecargoPersonalAdicional + RecargoAsistentes;


                return ValorContrato;
            }
            else if(tipoEvento.Equals("Cocktail"))
            {
                if (Asistentes >= 1 && Asistentes <= 20)
                {
                    RecargoAsistentes = 4;
                }
                else if (Asistentes >= 21 && Asistentes <= 50)
                {
                    RecargoAsistentes = 6;
                }
                else if (Asistentes > 50)
                {


                    double AsistentesExtras = 0;
                    double a = 0;
                    double b = 0;
                    double resultadoFinal = 0;
                    double resultado = 0;
                    AsistentesExtras = Asistentes - 50;
                    a = AsistentesExtras / 20;
                    b = (a % 1);
                    if (b < 0.5 || b >= 0.5)
                    {
                        resultado = (Math.Ceiling(a));
                        resultadoFinal = resultado * 2;
                    }

                    RecargoAsistentes = 6 + resultadoFinal;

                }
                if (PersonalAdicional == 2)
                {
                    RecargoPersonalAdicional = 2;
                }
                else if (PersonalAdicional == 3)
                {
                    RecargoPersonalAdicional = 3;
                }
                else if (PersonalAdicional == 4)
                {
                    RecargoPersonalAdicional = 3.5;
                }
                else if (PersonalAdicional > 4)
                {
                    RecargoPersonalAdicional = 3.5 + (PersonalAdicional * 0.5);


                }
               
                if (Ambientacion == 1)
                {
                    ambientacion = 5;
                }
                else if (Ambientacion == 2)
                {
                    ambientacion = 2;
                }
                else
                {
                    ambientacion = 0;
                }

                if (MusicaAmbiental == true)
                {
                    musicaAmbiental = 1;
                }
                else 
                {
                    musicaAmbiental = 0;
                }

                ValorContrato = ValorBase + musicaAmbiental + RecargoPersonalAdicional + RecargoAsistentes + ambientacion;

                return ValorContrato;
            }
            else if (tipoEvento.Equals("Cenas"))
            {
                if (Asistentes >= 1 && Asistentes <= 20)
                {
                    RecargoAsistentes = Asistentes*1.5;
                }
                else if (Asistentes >= 21 && Asistentes <= 50)
                {
                    RecargoAsistentes = Asistentes * 1.2;
                }
                else if (Asistentes > 50)
                {

                    RecargoAsistentes = Asistentes;

                }
                if (PersonalAdicional == 2)
                {
                    RecargoPersonalAdicional = 3;
                }
                else if (PersonalAdicional == 3)
                {
                    RecargoPersonalAdicional = 4;
                }
                else if (PersonalAdicional == 4)
                {
                    RecargoPersonalAdicional = 5;
                }
                else if (PersonalAdicional > 4)
                {
                    RecargoPersonalAdicional = 5 + (PersonalAdicional * 0.5);


                }

                if (Ambientacion == 1)
                {
                    ambientacion = 5;
                }
                else if (Ambientacion == 2)
                {
                    ambientacion = 3;
                }
                else
                {
                    ambientacion = 0;
                }

                if (MusicaAmbiental == true)
                {
                    musicaAmbiental = 1.5;
                }
                else
                {
                    musicaAmbiental = 0;
                }

                if (localOnbrake == true)
                {
                    local = (9*1.05);
                }
                else
                {
                    local = 0;
                }

                ValorContrato = ValorBase + musicaAmbiental + local + RecargoPersonalAdicional + RecargoAsistentes + ambientacion;


                return ValorContrato;
            }
            else
            {



                return ValorContrato;
            }

            
        }
    }
}
