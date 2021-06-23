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


using ADO.Conn;
using OracleNegocio;


namespace Oracle
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        string estadoCivil = "";
        public MainWindow()
        {
            InitializeComponent();
            
        }

        public void limpiarCampos()
        {
            idEmpleado.Text = string.Empty;
            nombreEmpleado.Text = string.Empty;
            apellidoEmpleado.Text = string.Empty;
            rutEmpleado.Text = string.Empty;
            estadoCivilEmpelado.SelectedIndex = -1;
        }


        private void actualizarTabla()
        {


            using (Oradata bd = new Oradata())
            {

                var tabla = from empleado in bd.EMPLEADOes
                            select new
                            {
                                id = empleado.IDEMPLEADO,
                                nombre = empleado.NOMBRES,
                                apellido = empleado.APELLIDOS,
                                rut = empleado.RUT,
                                estadoCivil = empleado.ESTADO_CIVIL
                            };

                DataEmpleados.ItemsSource = tabla.ToList();

            }



        }


        public void insertEmpleado()
        {
            

            if (estadoCivilEmpelado.Text.Equals("Soltero"))
            {
                estadoCivil = "S";
            }
            else if (estadoCivilEmpelado.Text.Equals("Casado"))
            {
                estadoCivil = "C";
            }

            OracleNegocio.Empleado em = new Empleado()
            {

                idEmpleado = int.Parse(idEmpleado.Text),
                nombreEmpleado = nombreEmpleado.Text,
                apellidoEmpleado = apellidoEmpleado.Text,
                rutEmpleado = rutEmpleado.Text,
                estadoCivilEmpleado = estadoCivil

    

            };

            try
            {
                int id = int.Parse(idEmpleado.Text);
                Oradata bd = new Oradata();

                var tabla = from empleado in bd.EMPLEADOes
                            where empleado.IDEMPLEADO == id
                            select empleado;

                if (tabla.Count() == 1)
                {
                    MessageBox.Show("El empleado ya se encuentra registrado");
                }
                else
                {
                    bool registro = em.CreateCliente();
                    if (registro)
                    {
                        MessageBox.Show("Empelado registrado correctamente");
                        this.limpiarCampos();
                    }
                    else
                    {
                        MessageBox.Show("Hubo un error al registrar");
                    }
                }

            }
            catch (Exception)
            {

                MessageBox.Show("Error en la base de datos");
            }

           
        }


        public void deleteEmpelado()
        {
            int idEm = int.Parse(idEmpleado.Text);
            OracleNegocio.Empleado em = new Empleado();
            try
            {
                bool delete = em.DeleteCliente(idEm);
                if (delete)
                {
                    MessageBox.Show("Empleado con id " + idEm + "A sido eliminado");
                    this.actualizarTabla();
                    this.limpiarCampos();
                    idEmpleado.IsEnabled = true;

                }
                else
                {
                    MessageBox.Show("Hubo un error al eliminar un empleado");
                }
            }
            catch (Exception)
            {

                MessageBox.Show("Error en la base de datos");
            }
            


        }

        public void buscarEmpleado(int id)
        {
            
                Oradata bd = new Oradata();

                var tabla = from empleado in bd.EMPLEADOes
                            where empleado.IDEMPLEADO == id
                            select empleado;

                DataEmpleados.ItemsSource = tabla.ToList();       
        }



        public void modificar()
        {

            OracleNegocio.Empleado empleado = new Empleado();

            int id = int.Parse(idEmpleado.Text);
            string nombre = nombreEmpleado.Text;
            string apellido = apellidoEmpleado.Text;
            string estadoCivil = estadoCivilEmpelado.Text;

            if (estadoCivil.Equals("Soltero"))
            {
                estadoCivil = "S";

            }
            else if (estadoCivil.Equals("Casado"))
            {
                estadoCivil = "C";
            }

            bool update = empleado.updateCliente(id, nombre, apellido, estadoCivil);
            if (update)
            {
                MessageBox.Show("Empleado actualizado correctamente");
            }
            else
            {
                MessageBox.Show("error al modificar");
            }

        }



        private void Button_Click(object sender, RoutedEventArgs e)
        {
            this.buscarEmpleado(int.Parse(idEmpleado.Text));
        }

        private void Insertar_Click(object sender, RoutedEventArgs e)
        {
            this.insertEmpleado();
            this.actualizarTabla();
        }

        private void Modificar_Click(object sender, RoutedEventArgs e)
        {
            this.modificar();
            this.actualizarTabla();
        }

        private void Eliminar_Click(object sender, RoutedEventArgs e)
        {
            this.deleteEmpelado();
        }


        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            this.actualizarTabla();

        }
    }
}
