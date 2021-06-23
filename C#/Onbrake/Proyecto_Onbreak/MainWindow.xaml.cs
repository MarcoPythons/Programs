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
using System.Windows.Navigation;
using System.Windows.Shapes;
using MahApps.Metro.Controls;
using System.Data.SqlClient;
using System.Data;
using OnBrakeDatos;
using System.Runtime.Serialization;

namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : MetroWindow
    {
        //private static string conexion = "Data Source=MAILY;Initial Catalog=OnBrake1;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";

        public MainWindow()
        {
            InitializeComponent();
        }
        

        private void AdministracionClientesImage_Click_1(object sender, RoutedEventArgs e)
        {
            Window1 ventana = new Window1();
            ventana.Show();
            Close();

        }

        private void AdministracionClientesLetters_Click(object sender, RoutedEventArgs e)
        {
            Window1 ventana = new Window1();
            ventana.Show();
            Close();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Administracion_de_contratos contratos = new Administracion_de_contratos();
            contratos.Show();
            Close();
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            Administracion_de_contratos contratos = new Administracion_de_contratos();
            contratos.Show();
            Close();
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            Listado_de_Clientes listado = new Listado_de_Clientes();
            listado.datagridListadoClientes.IsEnabled = false;
            listado.ListadoContratos.Visibility = Visibility.Hidden;
            listado.Salir_AdminClientes.Visibility = Visibility.Hidden;
            listado.Salir_AdminContratos.Visibility = Visibility.Hidden;
            listado.Show();
            this.Close();
            
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

        }

        private void Button_Click_3(object sender, RoutedEventArgs e)
        {
            Listado_de_Clientes listado = new Listado_de_Clientes();
            listado.datagridListadoClientes.IsEnabled = false;
            listado.Salir_AdminClientes.Visibility = Visibility.Hidden;
            listado.Salir_AdminContratos.Visibility = Visibility.Hidden;
            listado.Show();
            this.Close();

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

        }

        private void Button_Click_4(object sender, RoutedEventArgs e)
        {
            Listado_de_Contratos contratos = new Listado_de_Contratos();
            contratos.Show();
            contratos.Salir_AdminContrato.Visibility = Visibility.Hidden;
            contratos.datagridListadoClientes.IsEnabled = false;


            this.Close();
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
                                modalidad.Nombre,
                                contrato.Asistentes,
                                contrato.PersonalAdicional,
                                contrato.FechaHoraInicio,
                                contrato.FechaHoraTermino,
                                Vigencia = contrato.Realizado,
                                TipoEvento = tipo.Descripcion,
                                contrato.ValorTotalContrato,
                                contrato.Observaciones
                            };



                
                

                    contratos.datagridListadoClientes.ItemsSource = tabla.ToList();

                
                
                

            }
        }

        private void Button_Click_5(object sender, RoutedEventArgs e)
        {

            Listado_de_Contratos contratos = new Listado_de_Contratos();
            contratos.Show();
            contratos.Salir_AdminContrato.Visibility = Visibility.Hidden;
            contratos.datagridListadoClientes.IsEnabled = false;


            this.Close();
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
                                modalidad.Nombre,
                                contrato.Asistentes,
                                contrato.PersonalAdicional,
                                contrato.FechaHoraInicio,
                                contrato.FechaHoraTermino,
                                Vigencia = contrato.Realizado,
                                TipoEvento = tipo.Descripcion,
                                contrato.ValorTotalContrato,
                                contrato.Observaciones
                            };






                contratos.datagridListadoClientes.ItemsSource = tabla.ToList();





            }
        }
    }
}

