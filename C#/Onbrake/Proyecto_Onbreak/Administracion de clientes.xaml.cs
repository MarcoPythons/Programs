 using MahApps.Metro.Controls;
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
using System.Data.SqlClient;
using System.Data;
using MahApps.Metro.Controls.Dialogs;
using OnBrakeDatos;
using System.Runtime.Remoting;
using System.Collections;
using System.Data.Common.CommandTrees.ExpressionBuilder;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;

namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class Window1 : MetroWindow
    {


        int con = 0;


        public Window1()
        {
            InitializeComponent();
            
            if (con == 0)
            {
                black.Visibility = Visibility.Hidden;
            }
        }

        //private static string conexion = "Data Source=MAILY;Initial Catalog=OnBrake1;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";
        #region

        private void ClearTextFields()
        {
            NombreCompletoTXT.Text = string.Empty;
            RutTXT.Text = string.Empty;
            RazozSocialTXT.Text = string.Empty;
            Acividad.SelectedIndex = -1;
            MailTXT.Text = string.Empty;
            DireccionTXT.Text = string.Empty;
            TelefonoTXT.Text = string.Empty;
            TipoCombobox.SelectedIndex = -1;
            ConsultaTXT.Text = string.Empty;
        }
        private void refrescarGrid()
        {

            using (OnBrakeDatos.OnBreak2Entities db = new OnBrakeDatos.OnBreak2Entities())
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


                TablaConsultas.ItemsSource = tabla.ToList();

            }
        }


        #endregion

        private void Salir_Click(object sender, RoutedEventArgs e)
        {

            MainWindow ventana1 = new MainWindow();


            Close();

            ventana1.Show();


        }

        private async void BuscarCliente_Click(object sender, RoutedEventArgs e)
        {

            OnBrakeNegocio.Cliente cliente = new OnBrakeNegocio.Cliente();

            if (ConsultaTXT.Text.Equals(string.Empty))
            {
                await this.ShowMessageAsync("Atención!!",
                                            string.Format("Se deben llenar los datos del rut completo"));

            }
            else if (ConsultaTXT.Text.Contains("."))
            {
                await this.ShowMessageAsync("Atención!!",
                                            string.Format("Formato del rut incorrecto"));
            }
            else
            {
                try
                {
                    int resultado = cliente.BuscarRut(ConsultaTXT.Text);
                    
                    if (resultado == 1)
                    {
                        using (OnBrakeDatos.OnBreak2Entities db = new OnBrakeDatos.OnBreak2Entities())
                        {
                            string rut = ConsultaTXT.Text;
                            var tabla = from cli in db.Cliente
                                        join AcEmpresa in db.ActividadEmpresa
                                        on cli.IdActividadEmpresa equals AcEmpresa.IdActividadEmpresa
                                        join TiEmpresa in db.TipoEmpresa
                                        on cli.IdTipoEmpresa equals TiEmpresa.IdTipoEmpresa
                                        where cli.RutCliente == rut
                                        select new
                                        {
                                            RutCliente = cli.RutCliente,
                                            cli.RazonSocial,
                                            cli.NombreContacto,
                                            cli.MailContacto,
                                            cli.Direccion,
                                            cli.Telefono,
                                            ActividadEmpresa = AcEmpresa.Descripcion,
                                            TipoEmpresa = TiEmpresa.Descripcion
                                        };



                            TablaConsultas.ItemsSource = tabla.ToList();
                        }
                        
                        
                        NombreCompletoTXT.IsEnabled = false;
                        RutTXT.IsEnabled = false;
                        Acividad.IsEnabled = false;
                        TipoCombobox.IsEnabled = false;

                    }
                    else
                    {
                        await this.ShowMessageAsync("Atención!!",
                                             string.Format("No se encontrarón datos"));
                    }

                }
                catch (FormatException)
                {
                    await this.ShowMessageAsync("Atención!!",
                                string.Format("El rut no puede contener caracteres"));
                }

            }
        }

        private async void Registrar_Click(object sender, RoutedEventArgs e)
        {
            int NumeroActividad = 0;
            int NumeroTipo = 0;
            string actividad1 = Acividad.Text;
            string tipo1 = TipoCombobox.Text;
            try
            {
                if (NombreCompletoTXT.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                    string.Format("El nombre no puede estar vacío"));
                }
                else if (RutTXT.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                                    string.Format("El Rut no puede estar vacío"));
                }
                else if (RazozSocialTXT.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                                    string.Format("La razón social no puede estar vacía"));
                }
                else if (Acividad.SelectedIndex == -1)
                {
                    await this.ShowMessageAsync("Atención!!",
                                                   string.Format("Se debe seleccionar almenos una actividad"));
                }
                else if (MailTXT.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                                    string.Format("El Mail no puede estar vacío"));
                }
                else if (DireccionTXT.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                                   string.Format("La dirección no puede estar vacío"));
                }
                else if (TelefonoTXT.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención!!",
                                                  string.Format("El teléfono no puede estar vacío"));
                }
                else if (TipoCombobox.SelectedIndex == -1)
                {
                    await this.ShowMessageAsync("Atención!!",
                                                   string.Format("Se debe seleccionar almenos un tipo"));
                }
                else
                {

                    if (actividad1.Equals("Agropecuaria"))
                    {
                        NumeroActividad = 1;

                    }
                    else if (actividad1.Equals("Minería"))
                    {
                        NumeroActividad = 2;
                    }
                    else if (actividad1.Equals("Manufactura"))
                    {
                        NumeroActividad = 3;
                    }
                    else if (actividad1.Equals("Hoteleria"))
                    {
                        NumeroActividad = 4;
                    }
                    else if (actividad1.Equals("Alimentos"))
                    {
                        NumeroActividad = 5;
                    }
                    else if (actividad1.Equals("Transporte"))
                    {
                        NumeroActividad = 6;
                    }
                    else if (actividad1.Equals("Servicios"))
                    {
                        NumeroActividad = 7;
                    }
                    else if (actividad1.Equals("Comercio"))
                    {
                        NumeroActividad = 8;
                    }

                    if (tipo1.Equals("SPA"))
                    {
                        NumeroTipo = 10;
                    }
                    else if (tipo1.Equals("EIRL"))
                    {
                        NumeroTipo = 20;
                    }
                    else if (tipo1.Equals("Limitada"))
                    {
                        NumeroTipo = 30;
                    }
                    else if (tipo1.Equals("Sociedad Anónima"))
                    {
                        NumeroTipo = 40;
                    }




                    OnBrakeNegocio.Cliente cliente = new OnBrakeNegocio.Cliente()
                    {


                        NombreCliente = NombreCompletoTXT.Text,
                        Rut = RutTXT.Text,
                        RazonSocial = RazozSocialTXT.Text,
                        Actividad = NumeroActividad,
                        MailContacto = MailTXT.Text,
                        Direccion = DireccionTXT.Text,
                        Telefono = TelefonoTXT.Text,
                        Tipo = NumeroTipo



                    };
                    try
                    {
                        string rut = RutTXT.Text;
                        OnBreak2Entities bd = new OnBreak2Entities();
                        var tabla = from cli in bd.Cliente
                                    where cli.RutCliente == rut
                                    select cli;

                        if (tabla.Count() == 1)
                        {
                            await this.ShowMessageAsync("Atención!!", string.Format("El cliente ya se encuentra registrado"));
                        }
                        else
                        {



                            bool isRegistro = cliente.CreateCliente();

                            if (isRegistro)
                            {
                                await this.ShowMessageAsync("Correcto!!",
                                                          string.Format("Se ha agregado un nuevo cliente "));
                                this.ClearTextFields();

                            }
                            else
                            {
                                await this.ShowMessageAsync("Atención!!",
                                                          string.Format("Hubo un error al registrar"));
                            }
                        }

                    }
                    catch (Exception)
                    {

                        await this.ShowMessageAsync("Atención!!",
                                                        string.Format("No es posible hacer esta accion"));
                    }


                }
            }
            catch (Exception)
            {
                await this.ShowMessageAsync("Atención!!",
                                                 string.Format("Caracteres del rut , revise los datos ingresados"));
            }
        }




        private async void Eliminar_Click(object sender, RoutedEventArgs e)
        {


            OnBrakeNegocio.Cliente cli = new OnBrakeNegocio.Cliente();
            try
            {
                bool borrado = cli.DeleteCliente(RutTXT.Text);

                if (borrado)
                {
                    await this.ShowMessageAsync("Atención!!",
                                                     string.Format("Cliente borrado exitosamente"));
                    this.ClearTextFields();
                    this.refrescarGrid();
                }
                else
                {
                    await this.ShowMessageAsync("Atención!!",
                                                     string.Format("Cliente no se a podido borrar o no existe"));
                }

            }
            catch (Exception)
            {

                await this.ShowMessageAsync("Atención!!",
                                                     string.Format("Cliente no existe o tiene un contrato asignado"));
            }






        }

        private void TablaConsultas_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {
            int actividad = 0;
            int tipo = 0;
            string consultaRut = ConsultaTXT.Text.Trim();
            using (OnBrakeDatos.OnBreak2Entities db = new OnBrakeDatos.OnBreak2Entities())
            {


                var tabla = from cliente in db.Cliente
                            where consultaRut == cliente.RutCliente
                            select cliente;



                foreach (var tablita in tabla)
                {
                    
                    actividad = int.Parse(tablita.IdActividadEmpresa.ToString());
                    tipo = int.Parse(tablita.IdTipoEmpresa.ToString());
                    int tipo1 = 0;
                    NombreCompletoTXT.Text = tablita.NombreContacto.ToString();
                    RutTXT.Text = tablita.RutCliente.ToString();
                    RazozSocialTXT.Text = tablita.RazonSocial.ToString();
                    Acividad.SelectedIndex = (actividad - 1);
                    MailTXT.Text = tablita.MailContacto.ToString();
                    DireccionTXT.Text = tablita.Direccion.ToString();
                    TelefonoTXT.Text = tablita.Telefono.ToString();
                    if (tipo == 10)
                    {
                        tipo1 = tipo - 9;
                        TipoCombobox.SelectedIndex = (tipo1 - 1);
                    }
                    else if (tipo == 20)
                    {
                        tipo1 = tipo - 18;
                        TipoCombobox.SelectedIndex = (tipo1 - 1);
                    }
                    else if (tipo == 30)
                    {
                        tipo1 = tipo - 27;
                        TipoCombobox.SelectedIndex = (tipo1 - 1);
                    }
                    else if (tipo == 40)
                    {
                        tipo1 = tipo - 36;
                        TipoCombobox.SelectedIndex = (tipo1 - 1);
                    }

                }


            }
        }

        private void LipiarCampos_Click(object sender, RoutedEventArgs e)
        {
            this.ClearTextFields();
            NombreCompletoTXT.IsEnabled = true;
            RutTXT.IsEnabled = true;
            Acividad.IsEnabled = true;
            TipoCombobox.IsEnabled = true;

        }

        private async void Actualizar_Click(object sender, RoutedEventArgs e)
        {
            OnBrakeNegocio.Cliente cliente = new OnBrakeNegocio.Cliente();
            try
            {
                string telefono = TelefonoTXT.Text;
                string rut = RutTXT.Text;
                bool actualiza = cliente.updateCliente(rut, RazozSocialTXT.Text, MailTXT.Text, DireccionTXT.Text, telefono);
                if (actualiza)
                {
                    await this.ShowMessageAsync("Atención!!",
                                    string.Format("Cliente actualizado correctamente"));
                    this.ClearTextFields();
                    this.refrescarGrid();
                }
                else
                {
                    await this.ShowMessageAsync("Atención !!",
                                            string.Format("Hubo un problema al actualizar el cliente o no existe"));
                }
            }
            catch (Exception)
            {

                await this.ShowMessageAsync("Atención !!",
                                           string.Format("cliente no existe"));
            }

        }


        private void TablaConsultas_AutoGeneratingColumn(object sender, DataGridAutoGeneratingColumnEventArgs e)
        {
            if (e.PropertyName.Equals("NombreCompleto"))
            {
                (e.Column as DataGridColumn).Header = "Nombre Cliente";
            }
        }




      

        private void ListadoClientes_Click(object sender, RoutedEventArgs e)
        {

            Listado_de_Clientes listado = new Listado_de_Clientes();
            listado.RutClienteFiltrar.IsEnabled = false;
            listado.Salir.Visibility = Visibility.Hidden;
            listado.Salir_AdminContratos.Visibility = Visibility.Hidden;
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

        private void AltoContraste_Click(object sender, RoutedEventArgs e)
        {
             con = 1;

            if (con == 1)
            {
                black.Visibility = Visibility.Visible;
            }
            Fondo.Background = Brushes.White;
            _1.Background = Brushes.Black;
            _2.Background = Brushes.Black;
            _3.Background = Brushes.Black;
            _4.Background = Brushes.Black;
            _5.Background = Brushes.Black;
            _6.Background = Brushes.Black;
            _7.Background = Brushes.Black;
            _8.Background = Brushes.Black;
            Registrar.Background = Brushes.Black;
            Eliminar.Background = Brushes.Black;
            LipiarCampos.Background = Brushes.Black;
            Actualizar.Background = Brushes.Black;
            BuscarClienteBoton.Background = Brushes.Black;
            ListadoClientes.Background = Brushes.Black;
            Salir.Background = Brushes.Black;
            TablaConsultas.Background = Brushes.White;
        }

        
    }
}
