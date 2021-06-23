using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using MahApps.Metro.Controls;
using MahApps.Metro.Controls.Dialogs;
using OnBrakeDatos;
using OnBrakeNegocio;
using System.Windows.Threading;

namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para Administracion_de_contratos.xaml
    /// </summary>
    public partial class Administracion_de_contratos : MetroWindow
    {
        string diaInicio;
        string mesInicio;
        string agnoInicio;
        string diaFin;
        string mesFin;
        string agnoFin;
        long numeroContrato1;
        int horainicio;
        bool Realizacion;
        int numeroTipo;
        long NroContrato;
       public string rutCliente;
        int modalidad;
        string IdModalidad;
        int idTipoEvento;
        bool ambientacion;
        bool musicaAmbiental;
        bool musicaCliente;
        bool localOnbrake;
        bool otro;
        int valorArriendo;
        int tipoEvento;
        string modalidad_calculo;
        int Ambientacion;
        bool musica = false;
        bool local_Onbrake;


       
       /////////////////////////////////////////////////////////////////
      



        float idRespaldo;

        string eventoRealizado;
        string musica_ambiente;
        string Ambiente_musical_cliente;

        public Administracion_de_contratos()
        {
            InitializeComponent();

            Fecha.IsEnabled = false;
            FechaTermino.IsEnabled = false;
            Tipo_ambientacion.IsEnabled = false;
            MusicaA_si.IsEnabled = false;
            MusicaA_no.IsEnabled = false;
            MusicaC_si.IsEnabled = false;
            MusicaC_no.IsEnabled = false;
            local.IsEnabled = false;

            DispatcherTimer tem = new DispatcherTimer();
            tem.Interval = TimeSpan.FromMinutes(5);
            tem.Tick += gatillo;
            tem.Start();


        }


        private void gatillo(object sende , EventArgs e)
        {
            OnBreak2Entities bd = new OnBreak2Entities();

            var tabla = from resplado in bd.Respaldo
                        select resplado;

            foreach (var tablita in tabla)
            {
                idRespaldo = (tablita.Id + 1);
            }

           
            this.respaldo(idRespaldo.ToString());
            R.Content = "Respaldo " + idRespaldo + " se ha guardado correctamente";
        }

        private  void respaldo(string ID)
        {

            if (Realizado.IsChecked == true)
            {
                eventoRealizado = "si";
            }
            else if (NoRealizado.IsChecked == true)
            {
                eventoRealizado = "no";
            }

            if (MusicaA_si.IsChecked == true)
            {
                musica_ambiente = "si";
            }
            else if (MusicaA_no.IsChecked == true)
            {
                musica_ambiente = "no";
            }
            if (MusicaC_si.IsChecked == true)
            {
                Ambiente_musical_cliente = "si";
            }
            if (MusicaC_no.IsChecked == true)
            {
                Ambiente_musical_cliente = "no";
            }


            OnBrakeNegocio.Respaldo RespalDo = new OnBrakeNegocio.Respaldo()
            {
                RazonSocial = RutCliente.Text,
                fecha_inicio = Fecha.Text,
                hora_inicio = HoraInicio.Text,
                evento_realizado = eventoRealizado,
                Tipo_evento = TipoCombobox.Text,
                Modalidad_evento = ModalidadComboBox.Text,
                Tipo_ambientacion = Tipo_ambientacion.Text,
                Musica_ambiental = musica_ambiente,
                Musica_cliente = Ambiente_musical_cliente,
                Fecha_termino = FechaTermino.Text,
                Local = local.Text,
                Hora_termino = HoraTermino.Text,
                Observaciones = Observaciones.Text,
                Asistentes_evento = Asistentes.Text,
                Personal_adicional = PersonalAdicional.Text,
                Valor_contrato = ValorContrato.Text,
            };


            RespalDo.createRespaldo(ID);
        }


        private async void borrarRespaldo(string ID)
        {
            float IDD = float.Parse(ID);

            OnBreak2Entities bd = new OnBreak2Entities();
            OnBrakeNegocio.Respaldo RespalDo = new OnBrakeNegocio.Respaldo();
            var tabla = from respaldo in bd.Respaldo
                        where respaldo.Id == IDD
                        select respaldo;

            int resultado = tabla.Count();

            if (resultado >= 1)
            {
                RespalDo.deleteRespaldo(ID);



            }
            else
            {
                await this.ShowMessageAsync("Atención", string.Format("No se pudo  borrar los respaldo de los datos"));
            }

        }

        private void limpiarCampos()
        {
            RutCliente.Text = string.Empty;
            Fecha.Text = string.Empty;
            HoraInicio.Text = string.Empty;
            Realizado.IsChecked = false;
            NoRealizado.IsChecked = false;
            TipoCombobox.SelectedIndex = -1;
            Observaciones.Text = string.Empty;
            FechaTermino.Text = string.Empty;
            HoraTermino.Text = string.Empty;
            Asistentes.Text = string.Empty;
            PersonalAdicional.Text = string.Empty;
            ValorContrato.Text = string.Empty;
            BuscaPorNumeroContrato.Text = string.Empty;
            MusicaA_si.IsChecked = false;
            MusicaA_no.IsChecked = false;
            MusicaC_si.IsChecked = false;
            MusicaC_no.IsChecked = false;
            Tipo_ambientacion.SelectedIndex = -1;
            local.SelectedIndex = -1;
            ModalidadComboBox.SelectedIndex = -1;
        }
        private void MiCalendario_SelectedDatesChanged(object sender, SelectionChangedEventArgs e)
        {
            Fecha.Text = MiCalendario.SelectedDate.Value.Day.ToString() + "/" + MiCalendario.SelectedDate.Value.Month.ToString()
                + "/" + MiCalendario.SelectedDate.Value.Year.ToString();



            this.diaInicio = MiCalendario.SelectedDate.Value.Day.ToString();
            this.mesInicio = MiCalendario.SelectedDate.Value.Month.ToString();
            this.agnoInicio = MiCalendario.SelectedDate.Value.Year.ToString();

            int dia = int.Parse(diaInicio);
            int mes = int.Parse(mesInicio);
            if (dia < 10 && mes < 10)
            {
                this.diaInicio = "0" + diaInicio;
                this.mesInicio = "0" + mesInicio;
            }

            Expansor.IsExpanded = false;
        }
        private void MiCalendarioTermino_SelectedDatesChanged(object sender, SelectionChangedEventArgs e)
        {
            FechaTermino.Text = MiCalendarioTermino.SelectedDate.Value.Day.ToString() + "/" + MiCalendarioTermino.SelectedDate.Value.Month.ToString()
                + "/" + MiCalendarioTermino.SelectedDate.Value.Year.ToString();
            ExpansorTermino.IsExpanded = false;
            this.diaFin = MiCalendarioTermino.SelectedDate.Value.Day.ToString();
            this.mesFin = MiCalendarioTermino.SelectedDate.Value.Month.ToString();
            this.agnoFin = MiCalendarioTermino.SelectedDate.Value.Year.ToString();
        }
        private void Salir_Click(object sender, RoutedEventArgs e)
        {
            MainWindow ventana1 = new MainWindow();
            Close();

            ventana1.Show();
        }
        private  void Calcular_Valor_Contrato_Click(object sender, RoutedEventArgs e)
        {
            int asistentes = int.Parse(Asistentes.Text);
            int personalAdicional = int.Parse(PersonalAdicional.Text);
            string tipo_evento = TipoCombobox.Text;
           
           
            modalidad_calculo = ModalidadComboBox.Text;

            OnBreak2Entities bd = new OnBreak2Entities();

            var tabla = from modalidadServicio in bd.ModalidadServicio
                        join tipoevento in bd.TipoEvento on modalidadServicio.IdTipoEvento equals tipoevento.IdTipoEvento
                        where tipoevento.Descripcion == tipo_evento
                        select new { tipoevento.IdTipoEvento };


            foreach (var tablita in tabla)
            {
                tipoEvento = tablita.IdTipoEvento;
            }


            if (Tipo_ambientacion.Text.Equals("Personalizada"))
            {
                Ambientacion = 1; 
            }
            else if (Tipo_ambientacion.Text.Equals("Básica"))
            {
                Ambientacion = 2;
            }
            else 
            {
                Ambientacion = 3;
            }

            if (MusicaA_si.IsChecked == true)
            {
                musica = true;
            }
            if (local.Text.Equals("Local OnBrake"))
            {
                local_Onbrake = true;
            }
            else if (local.Text.Equals("Otro"))
            {
                local_Onbrake = false;
            }


            Valorizador valorizador = new Valorizador()
            {

                Asistentes = asistentes,
                PersonalAdicional = personalAdicional,
                Ambientacion = Ambientacion,
                MusicaAmbiental = musica,
                localOnbrake = local_Onbrake

            };

            //await this.ShowMessageAsync("Atención", string.Format(tipoEvento.ToString()));

            double totalContrato = valorizador.CalcularValorEvento(tipoEvento, modalidad_calculo);

            ValorContrato.Text = totalContrato.ToString();

        }
        private async void CrearContrato_Click(object sender, RoutedEventArgs e)
        {
            try
            {


                if (RutCliente.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                    string.Format("El rut del cliente no puede estar vacío"));
                }
                else if (Fecha.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                   string.Format("La fecha de inicio no puede estar vacía"));
                }
                else if (FechaTermino.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                  string.Format("La fecha de termino no puede estar vacía"));
                }
                else if (HoraInicio.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                  string.Format("La hora de inicio no puede estar vacía"));
                }
                else if (HoraTermino.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                  string.Format("La hora de termino no puede estar vacía"));
                }
                else if (Realizado.IsChecked == false && NoRealizado.IsChecked == false)
                {
                    await this.ShowMessageAsync("Atención!!",
                                 string.Format("Se debe seleccionar la vigencia del contrato"));
                }
                else if (TipoCombobox.SelectedIndex == -1)
                {
                    await this.ShowMessageAsync("Atención!!",
                                 string.Format("Se debe seleccionar un evento"));
                }
                else if (ModalidadComboBox.SelectedIndex == -1)
                {
                    await this.ShowMessageAsync("Atención!! ",
                                            string.Format("Se debe seleccionar la modalidad del evento"));
                }
                else if (Observaciones.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                 string.Format("Se deben agregar observaciones"));
                }
                if (TipoCombobox.Text.Equals("Coffee Break"))
                {
                    numeroTipo = 10;

                }
                else if (TipoCombobox.Text.Equals("Cocktail"))
                {
                    numeroTipo = 20;

                }
                else if (TipoCombobox.Text.Equals("Cenas"))
                {
                    numeroTipo = 30;



                }
                if (ModalidadComboBox.Text.Equals("Light Break"))
                {
                    modalidad = 10;
                    IdModalidad = "CB001";
                }
                else if (ModalidadComboBox.Text.Equals("	Journal Break"))
                {
                    modalidad = 10;
                    IdModalidad = "CB002";
                }
                else if (ModalidadComboBox.Text.Equals("	Day Break"))
                {
                    modalidad = 10;
                    IdModalidad = "CB003";
                }
                else if (ModalidadComboBox.Text.Equals("	Ejecutiva"))
                {
                    modalidad = 30;
                    IdModalidad = "CE001";
                }
                else if (ModalidadComboBox.Text.Equals("Celebración"))
                {
                    modalidad = 30;
                    IdModalidad = "CE002";
                }
                else if (ModalidadComboBox.Text.Equals("	Quick Cocktail"))
                {
                    modalidad = 20;
                    IdModalidad = "CO001";
                }
                else if (ModalidadComboBox.Text.Equals("	Ambient Cocktail"))
                {
                    modalidad = 20;
                    IdModalidad = "CO002";
                }
                if (Tipo_ambientacion.Text.Equals("Básica"))
                {
                    idTipoEvento = 10;
                }
                else if (Tipo_ambientacion.Text.Equals("Personalizada"))
                {
                    idTipoEvento = 20;
                }
                else if (Tipo_ambientacion.Text.Equals("Sin Ambientación"))
                {
                    idTipoEvento = 30;
                }
                if (MusicaA_si.IsChecked == true)
                {
                    musicaAmbiental = true;
                }
                else if (MusicaA_si.IsChecked == true)
                {
                    musicaAmbiental = false;
                }
                if (MusicaC_si.IsChecked == true)
                {
                    musicaCliente = true;
                }
                else if (MusicaC_no.IsChecked == true)
                {
                    musicaCliente = false;
                }



                this.horainicio = int.Parse(HoraInicio.Text.Replace(":", ""));
                this.numeroContrato1 = long.Parse(agnoInicio + mesInicio + diaInicio + horainicio);


                if (Realizado.IsChecked == true)
                {
                    Realizacion = true;
                }
                else if (Realizado.IsChecked == true)
                {
                    Realizacion = false;
                }



                int asistentes = int.Parse(Asistentes.Text);
                int personalAdicional = int.Parse(PersonalAdicional.Text);
                double valorContrato = double.Parse(ValorContrato.Text);

                OnBrakeNegocio.Contrato contrato = new OnBrakeNegocio.Contrato()
                {



                    NumeroContrato = numeroContrato1.ToString(),
                    FechaCreacion = agnoInicio + "/" + mesInicio + "/" + diaInicio,
                    FechaTermino = agnoFin + "/" + mesFin + "/" + diaFin,
                    HoraCreacion = HoraInicio.Text,
                    HoraTermino = HoraTermino.Text,
                    Realizado = Realizacion,
                    idTipoEvento = numeroTipo,
                    Observaciones = Observaciones.Text,
                    idModalidad = IdModalidad,
                    Asistentes = asistentes,
                    PersonalAdicional = personalAdicional,
                    ValorTotalContrato = valorContrato




                };
                if (Tipo_ambientacion.Text.Equals("Sin Ambientación"))
                {
                    ambientacion = false;
                }
                else
                {
                    ambientacion = true;
                }

                OnBrakeNegocio.Cocktail cocktail = new OnBrakeNegocio.Cocktail()
                {

                    numero = numeroContrato1.ToString(),
                    id_tipo_ambientacion = idTipoEvento,
                    ambientacion = ambientacion,
                    musica_ambiental = musicaAmbiental,
                    musica_cliente = musicaCliente

                };


                if (local.Text.Equals("Local OnBrake"))
                {
                    localOnbrake = true;
                    valorArriendo = 9;
                }
                else if (local.Text.Equals("Otro"))
                {
                    otro = true;
                    valorArriendo = 0;
                }

                OnBrakeNegocio.Cenas cenas = new OnBrakeNegocio.Cenas()
                {
                    numero = numeroContrato1.ToString(),
                    idTipoAmbientacion = idTipoEvento,
                    musicaAmbiental = musicaAmbiental,
                    localOnBrake = localOnbrake,
                    otroLocalOnBreak = otro,
                    valorArriendo = valorArriendo

                };


                string rut = RutCliente.Text;


                if (TipoCombobox.Text.Equals("Cocktail"))
                {
                    bool createContrato = contrato.create(rutCliente);
                    bool createCocktail = cocktail.createCocktail(rutCliente);
                    if (createContrato)
                    {
                        await this.ShowMessageAsync("Atención", string.Format("Contrato registrado correctamente. Nro Contrato: " + numeroContrato1));
                        this.limpiarCampos();
                    }
                    else
                    {
                        await this.ShowMessageAsync("Atención", string.Format("Contrato registrado incorrectamente"));
                    }

                }
                else if (TipoCombobox.Text.Equals("Cenas"))
                {
                    bool createContrato = contrato.create(rutCliente);
                    bool creaateCenas = cenas.createCena(rutCliente);

                    if (createContrato)
                    {
                        await this.ShowMessageAsync("Atención", string.Format("Contrato registrado correctamente. Nro Contrato: " + numeroContrato1));
                        this.limpiarCampos();
                    }
                    else
                    {
                        await this.ShowMessageAsync("Atención", string.Format("Contrato registrado incorrectamente"));
                    }

                }
            }
            catch (System.Data.SqlClient.SqlException)
            {

            }


            








        }

        

        private  void BuscarPorNumero_De_contrato_Click(object sender, RoutedEventArgs e)
        {
            
            using (OnBreak2Entities bd = new OnBreak2Entities())
            {
                string numContrato = BuscaPorNumeroContrato.Text;
                var tabla = from contrato in bd.Contrato
                            join cliente in bd.Cliente
                            on contrato.RutCliente equals cliente.RutCliente
                            join modalidad in bd.ModalidadServicio
                            on contrato.IdModalidad equals modalidad.IdModalidad
                            join tipo in bd.TipoEvento 
                            on modalidad.IdTipoEvento equals tipo.IdTipoEvento
                            where contrato.Numero == numContrato
                            select new
                            {
                                contrato.Numero,
                                cliente.RutCliente,
                                contrato.Creacion,
                                contrato.Termino,
                                tipoModalidad = modalidad.Nombre,
                                tipoEvento = tipo.Descripcion,
                                contrato.Asistentes,
                                contrato.PersonalAdicional,
                                contrato.FechaHoraInicio,
                                contrato.FechaHoraTermino,
                                realizado = contrato.Realizado,
                                contrato.ValorTotalContrato,
                                contrato.Observaciones
                            };


                foreach (var tablita in tabla)
                {
                    RutCliente.Text = tablita.RutCliente.ToString();
                    RutCliente.IsEnabled = false;
                    Fecha.Text = tablita.Creacion.ToShortDateString();
                    Fecha.IsEnabled = false;
                    FechaTermino.Text = tablita.Termino.ToShortDateString();
                    FechaTermino.IsEnabled = false;
                    HoraInicio.Text = tablita.FechaHoraInicio.ToShortTimeString(); ;
                    HoraInicio.IsEnabled = false;
                    HoraTermino.Text = tablita.FechaHoraTermino.ToShortTimeString();
                    HoraTermino.IsEnabled = false;
                    if (tablita.realizado == true)
                    {
                        Realizado.IsChecked = true;
                    }
                    else if (tablita.realizado == false)
                    {
                        NoRealizado.IsChecked = true;

                    }

                    TipoCombobox.Items.Add(tablita.tipoEvento);
                    TipoCombobox.SelectedItem = tablita.tipoEvento;
                    TipoCombobox.IsEnabled = false;
                    ModalidadComboBox.Items.Add(tablita.tipoModalidad);
                    ModalidadComboBox.SelectedItem = tablita.tipoModalidad;
                    ModalidadComboBox.IsEnabled = false;
                    Observaciones.Text = tablita.Observaciones;
                    Expansor.IsEnabled = false;
                    ExpansorTermino.IsEnabled = false;
                    Asistentes.Text = tablita.Asistentes.ToString();
                    PersonalAdicional.Text = tablita.PersonalAdicional.ToString();
                    ValorContrato.Text = tablita.ValorTotalContrato.ToString();
                   
                }
                

            }
        }

        private async void TerminarContrato_Click_1(object sender, RoutedEventArgs e)
        {
            

            string numContrato = BuscaPorNumeroContrato.Text;
            OnBrakeNegocio.Contrato contrato = new OnBrakeNegocio.Contrato();
            bool terminaContrato = contrato.terminarContrato(numContrato, rutCliente);
            if (terminaContrato)
            {
                await this.ShowMessageAsync("Atención!", string.Format("Contrato terminado correctamente"));
                this.limpiarCampos();
            }
            else
            {
                await this.ShowMessageAsync("Atención!", string.Format("Error al terminar el contrato"));
            }

        }

        private async void ActualizarContrato_Click(object sender, RoutedEventArgs e)
        {


            string numeroContrato = BuscaPorNumeroContrato.Text;
            string rutcliente = rutCliente;
            bool realizado = false;
            OnBrakeNegocio.Contrato contrato = new OnBrakeNegocio.Contrato();
            if (Realizado.IsChecked == true)
            {
                realizado = true;
            }


            int update = contrato.updateContrato(numeroContrato, rutcliente, Observaciones.Text, int.Parse(Asistentes.Text), int.Parse(PersonalAdicional.Text), double.Parse(ValorContrato.Text), realizado);

            if (update >= 1)
            {
                await this.ShowMessageAsync("Atención!", string.Format("Contrato actualizado correctamente"));
                this.limpiarCampos();
            }
            else
            {
                await this.ShowMessageAsync("Atención!", string.Format("hubo un error al actualizar el contrato"));
            }
        }

        private void ConsultaPrecios_Click(object sender, RoutedEventArgs e)
        {
            CalculoValorContrato valores = new CalculoValorContrato();
            valores.Show();

        }



       

        private void ListadoClientes_Click(object sender, RoutedEventArgs e)
        {
            Listado_de_Contratos listadoContratos = new Listado_de_Contratos();
            listadoContratos.Salir.Visibility = Visibility.Hidden;
            listadoContratos.ListadoClientes.Visibility = Visibility.Hidden;
            using (OnBreak2Entities bd = new OnBreak2Entities())
            {
                var tabla = from contrato in bd.Contrato
                            join cliente in bd.Cliente
                            on contrato.RutCliente equals cliente.RutCliente
                            join tipo in bd.TipoEvento
                            on contrato.IdTipoEvento equals tipo.IdTipoEvento
                            join modalidad in bd.ModalidadServicio
                            on contrato.IdModalidad equals modalidad.IdModalidad
                            select new
                            {
                                contrato.Numero,
                                cliente.RutCliente,
                                contrato.Creacion,
                                contrato.Termino,
                                TipoModalidad = modalidad.Nombre,
                                contrato.Asistentes,
                                contrato.PersonalAdicional,
                                contrato.FechaHoraInicio,
                                contrato.FechaHoraTermino,
                                Realizado = contrato.Realizado,
                                TipoEvento = tipo.Descripcion,
                                contrato.ValorTotalContrato,
                                contrato.Observaciones
                            };






                listadoContratos.datagridListadoClientes.ItemsSource = tabla.ToList();

            }
            listadoContratos.ShowDialog();
            Close();
        }

        private void ListadoClientes_Click_1(object sender, RoutedEventArgs e)
        {

            Listado_de_Clientes listado = new Listado_de_Clientes();
            listado.Owner = this;
            listado.Salir.Visibility = Visibility.Hidden;
            listado.Salir_AdminClientes.Visibility = Visibility.Hidden;
            listado.ListadoContratos.Visibility = Visibility.Hidden;


            using (OnBreak2Entities db = new OnBreak2Entities())
            {

                var tabla = from cliente in db.Cliente
                            join AcEmpresa in db.ActividadEmpresa
                            on cliente.IdActividadEmpresa equals AcEmpresa.IdActividadEmpresa
                            join TiEmpresa in db.TipoEmpresa
                            on cliente.IdTipoEmpresa equals TiEmpresa.IdTipoEmpresa

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

                listado.datagridListadoClientes.ItemsSource = tabla.ToList();

            }

            listado.ShowDialog();
            Close();
        }

        private void ComboBoxItem_Selected(object sender, RoutedEventArgs e)
        {
            Tipo_ambientacion.IsEnabled = true;
            MusicaA_si.IsEnabled = true;
            MusicaA_no.IsEnabled = true;
            MusicaC_si.IsEnabled = true;
            MusicaC_no.IsEnabled = true;
            ModalidadComboBox.Items.Clear();
            ModalidadComboBox.Items.Add("	Quick Cocktail");
            ModalidadComboBox.Items.Add("	Ambient Cocktail");
        }

        private void ComboBoxItem_Selected_1(object sender, RoutedEventArgs e)
        {
            Tipo_ambientacion.IsEnabled = true;
            MusicaA_si.IsEnabled = true;
            MusicaA_no.IsEnabled = true;
            local.IsEnabled = true;
            ModalidadComboBox.Items.Clear();
            ModalidadComboBox.Items.Add("	Ejecutiva");
            ModalidadComboBox.Items.Add("Celebración");
        }

        private void ComboBoxItem_Selected_2(object sender, RoutedEventArgs e)
        {
            ModalidadComboBox.Items.Clear();
            ModalidadComboBox.Items.Add("Light Break");
            ModalidadComboBox.Items.Add("	Journal Break");
            ModalidadComboBox.Items.Add("	Day Break");
        }
    }
}
