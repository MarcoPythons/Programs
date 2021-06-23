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
using System.Windows.Shell;
using MahApps.Metro.Controls;
using OnBrakeDatos;
using MahApps.Metro.Controls.Dialogs;
namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para Listado_de_Contratos.xaml
    /// </summary>
    public partial class Listado_de_Contratos : MetroWindow
    {

        Administracion_de_contratos adminContratos = new Administracion_de_contratos();
        public Listado_de_Contratos()
        {
            InitializeComponent();
        }

        private void Salir_Click(object sender, RoutedEventArgs e)
        {
            LimpiarCampos();
            MainWindow principal = new MainWindow();
            Close();
            principal.Show();
        }

        public void LimpiarCampos()
        {
            NumeroContratoFiltro.Text = "";
            RutFiltro.Text = "";
            TipoCombobox.SelectedIndex = -1;
            ModalidadComboBox.SelectedIndex = -1;
            
        }

        private void datagridListadoClientes_AutoGeneratingColumn(object sender, DataGridAutoGeneratingColumnEventArgs e)
        {

            if (e.PropertyName.Equals("Creacion"))
            {
                (e.Column as DataGridTextColumn).Binding.StringFormat = "yyyy/MM/dd";
            }
            else if (e.PropertyName.Equals("Termino"))
            {
                (e.Column as DataGridTextColumn).Binding.StringFormat = "yyyy/MM/dd";
            }
            else if (e.PropertyName.Equals("FechaHoraInicio"))
            {
                (e.Column as DataGridTextColumn).Binding.StringFormat = "HH:mm:ss";
            }
            else if (e.PropertyName.Equals("FechaHoraTermino"))
            {
                (e.Column as DataGridTextColumn).Binding.StringFormat = "HH:mm:ss";
            }

        }

        private void NumeroContratoFiltrar_Click(object sender, RoutedEventArgs e)
        {
            RutFiltro.Text = "";
            TipoCombobox.SelectedIndex = -1;
            ModalidadComboBox.SelectedIndex = -1;
            string NroContrato = NumeroContratoFiltro.Text;
            using (OnBreak2Entities bd = new OnBreak2Entities())
            {
                var tabla = from contrato in bd.Contrato
                            join cliente in bd.Cliente
                            on contrato.RutCliente equals cliente.RutCliente
                            join tipo in bd.TipoEvento
                            on contrato.IdTipoEvento equals tipo.IdTipoEvento
                            join modalidad in bd.ModalidadServicio
                            on contrato.IdModalidad equals modalidad.IdModalidad
                            where contrato.Numero == NroContrato
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
                                Realizado = contrato.Realizado,
                                TipoEvento = tipo.Descripcion,
                                contrato.ValorTotalContrato,
                                contrato.Observaciones
                            };

                datagridListadoClientes.ItemsSource = tabla.ToList();


            }
        }

        private void RutClienteFiltro_Click(object sender, RoutedEventArgs e)
        {
            NumeroContratoFiltro.Text = "";
            TipoCombobox.SelectedIndex = -1;
            ModalidadComboBox.SelectedIndex = -1;
            string rut = RutFiltro.Text;
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

                datagridListadoClientes.ItemsSource = tabla.ToList();


            }
        }

        private void TipoContratoFiltro_Click_1(object sender, RoutedEventArgs e)
        {
            NumeroContratoFiltro.Text = "";
            RutFiltro.Text = "";
            ModalidadComboBox.SelectedIndex = -1;
            string tipoContrato = TipoCombobox.Text;
            
            using (OnBreak2Entities bd = new OnBreak2Entities())
            {

                var tabla = from contrato in bd.Contrato
                            join cliente in bd.Cliente
                            on contrato.RutCliente equals cliente.RutCliente
                            join tipo in bd.TipoEvento
                            on contrato.IdTipoEvento equals tipo.IdTipoEvento
                            join modalidad in bd.ModalidadServicio
                            on contrato.IdModalidad equals modalidad.IdModalidad
                            where tipo.Descripcion == tipoContrato
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


                datagridListadoClientes.ItemsSource = tabla.ToList();



            }
        }

        private void Salir_AdminClientes_Click(object sender, RoutedEventArgs e)
        {
            
            this.Close();
            adminContratos.BuscaPorNumeroContrato.Text = NumeroContratoFiltro.Text;
            LimpiarCampos();
            adminContratos.Show();

        }

        private  void datagridListadoClientes_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {
            

            var cellInfo = datagridListadoClientes.SelectedCells[0];

            var content = cellInfo.Column.GetCellContent(cellInfo.Item);

            string datos = content.DataContext.ToString();

            string datos1 = datos.Substring(11,21);

            string numeroContrato = datos1.Replace(", RutClient", "");
            NumeroContratoFiltro.Text = numeroContrato.Trim();
            RutClienteFiltrar.IsEnabled = false;


        }

        private void ModalidadBoton_Click(object sender, RoutedEventArgs e)
        {
            NumeroContratoFiltro.Text = "";
            RutFiltro.Text = "";
            TipoCombobox.SelectedIndex = -1;
            string TipoModalidad = ModalidadComboBox.Text;

            using (OnBreak2Entities bd = new OnBreak2Entities())
            {

                var tabla = from contrato in bd.Contrato
                            join cliente in bd.Cliente
                            on contrato.RutCliente equals cliente.RutCliente
                            join tipo in bd.TipoEvento
                            on contrato.IdTipoEvento equals tipo.IdTipoEvento
                            join modalidad in bd.ModalidadServicio
                            on contrato.IdModalidad equals modalidad.IdModalidad
                            where modalidad.Nombre == TipoModalidad
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
                                Realizdo = contrato.Realizado,
                                TipoEvento = tipo.Descripcion,
                                contrato.ValorTotalContrato,
                                contrato.Observaciones
                            };


                datagridListadoClientes.ItemsSource = tabla.ToList();
            }
        }

        private void ListadoClientes_Click(object sender, RoutedEventArgs e)
        {
            Listado_de_Clientes listado = new Listado_de_Clientes();
            listado.Salir.Visibility = Visibility.Hidden;
            listado.Salir_AdminClientes.Visibility = Visibility.Hidden;
            listado.Salir_AdminContratos.Visibility = Visibility.Hidden;
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

        
    }
}

