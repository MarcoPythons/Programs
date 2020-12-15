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

        
    }
}

