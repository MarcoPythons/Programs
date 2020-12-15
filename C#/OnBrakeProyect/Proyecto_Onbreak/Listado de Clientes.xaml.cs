using System;
using System.Collections.Generic;
using System.Data;
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

namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para Listado_de_Clientes.xaml
    /// </summary>
    public partial class Listado_de_Clientes : MetroWindow
    {



        Window1 admiClientes = new Window1();
        public Listado_de_Clientes()
        {


            InitializeComponent();


        }

        private async void TipoEmpresaFiltro_Click(object sender, RoutedEventArgs e)
        {


            OnBrakeNegocio.Cliente cliente1 = new OnBrakeNegocio.Cliente();



            using (OnBreak2Entities db = new OnBreak2Entities())
            {

                string tipoEmpresa = TipoCombobox1.Text;

                int resultado = cliente1.ReadAllByTipoEmpresa(tipoEmpresa);

                if (resultado >= 1)
                {
                    AcividadListado.SelectedIndex = -1;
                    Filtrador.Text = string.Empty;
                    if (TipoCombobox1.SelectedIndex == -1)
                    {
                        await this.ShowMessageAsync("Atención !! ", string.Format("Se debe seleccionar un tipo de empresa"));
                    }
                    else
                    {


                        var tabla = from cliente in db.Cliente
                                    join AcEmpresa in db.ActividadEmpresa
                                    on cliente.IdActividadEmpresa equals AcEmpresa.IdActividadEmpresa
                                    join TiEmpresa in db.TipoEmpresa
                                    on cliente.IdTipoEmpresa equals TiEmpresa.IdTipoEmpresa
                                    where TiEmpresa.Descripcion == tipoEmpresa
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






                        datagridListadoClientes.ItemsSource = tabla.ToList();





                    }


                }

            }

        }

        private void Salir_Click(object sender, RoutedEventArgs e)
        {

            MainWindow main = new MainWindow();
            Close();
            main.Show();
        }
        private void Salir_AdminClientes_Click(object sender, RoutedEventArgs e)
        {

            this.Close();
            admiClientes.ConsultaTXT.Text = this.Filtrador.Text;
            admiClientes.Show();



        }



        private async void RutClienteFiltrar_Click(object sender, RoutedEventArgs e)
        {

            using (OnBreak2Entities db = new OnBreak2Entities())
            {
                TipoCombobox1.SelectedIndex = -1;
                AcividadListado.SelectedIndex = -1;


                string rut = string.Empty;
                if (Filtrador.Text.Equals(string.Empty))
                {
                    await this.ShowMessageAsync("Atención !! ", string.Format("Se debe ingresar el rut"));
                }
                else
                {
                    rut = Filtrador.Text;

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

                    if (resultado == 1)
                    {

                        datagridListadoClientes.ItemsSource = tabla.ToList();

                    }
                    else
                    {
                        await this.ShowMessageAsync("Atención !! ", string.Format("No se encontraron datos"));
                    }


                }

            }

        }

        private async void ActividadEmpresaFiltro_Click(object sender, RoutedEventArgs e)
        {

            using (OnBreak2Entities db = new OnBreak2Entities())
            {

                string actividadEmpresa = AcividadListado.Text;
                Filtrador.Text = string.Empty;
                TipoCombobox1.SelectedIndex = -1;

                if (AcividadListado.SelectedIndex == -1)
                {
                    await this.ShowMessageAsync("Atención !! ", string.Format("Se debe seleccionar una actividad"));
                }
                else
                {


                    var tabla = from cliente in db.Cliente
                                join AcEmpresa in db.ActividadEmpresa
                                on cliente.IdActividadEmpresa equals AcEmpresa.IdActividadEmpresa
                                join TiEmpresa in db.TipoEmpresa
                                on cliente.IdTipoEmpresa equals TiEmpresa.IdTipoEmpresa
                                where AcEmpresa.Descripcion == actividadEmpresa
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




                    datagridListadoClientes.ItemsSource = tabla.ToList();


                }
            }
        }

        private void datagridListadoClientes_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {




            

                var cellInfo = datagridListadoClientes.SelectedCells[0];

                var content = cellInfo.Column.GetCellContent(cellInfo.Item);

                string datos = content.DataContext.ToString();

                string datos1 = datos.Substring(11, 22);
                string rut = datos1.Replace(", RazonSoci", "");

                Filtrador.Text = rut.Trim();
            RutClienteFiltrar.IsEnabled = false;
            


        }

        private void datagridListadoClientes_AutoGeneratingColumn(object sender, DataGridAutoGeneratingColumnEventArgs e)
        {
            if (e.PropertyName.Equals("Nombre Completo"))
            {
                (e.Column as DataGridColumn).Header = "Nombre Cliente";
            }
        }

        private void Salir_AdminContratos_Click(object sender, RoutedEventArgs e)
        {
            Administracion_de_contratos adminC = new Administracion_de_contratos();
            this.Close();

            string rut = this.Filtrador.Text;
            string razon_social = string.Empty;
            string rutCliente = string.Empty;

            using (OnBreak2Entities bd = new OnBreak2Entities())
            {
                var tabla = from cliente in bd.Cliente
                            where cliente.RutCliente == rut
                            select cliente;

                foreach (var tablita in tabla)
                {
                    razon_social = tablita.RazonSocial;
                    rutCliente = tablita.RutCliente;
                }

            }

            adminC.RutCliente.Text = razon_social;
            adminC.rutCliente = rutCliente;
            adminC.Show();
        }

        private void ListadoClientes_Click(object sender, RoutedEventArgs e)
        {
            Listado_de_Contratos contratos = new Listado_de_Contratos();
            Close();
            contratos.Salir_AdminContrato.Visibility = Visibility.Hidden;
            string rut = Filtrador.Text;
            using (OnBreak2Entities bd = new OnBreak2Entities())
            {
                var tabla = from contrato in bd.Contrato
                            join cliente in bd.Cliente
                            on contrato.RutCliente equals cliente.RutCliente
                            join tipo in bd.TipoEvento
                            on contrato.IdTipoEvento equals tipo.IdTipoEvento
                            join modalidad in bd.ModalidadServicio
                            on contrato.IdModalidad equals modalidad.IdModalidad
                            where cliente.RutCliente == rut
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
            contratos.Show();
        }
    }
}
