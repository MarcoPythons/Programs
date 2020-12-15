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


using System.Runtime.Remoting;

namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class Window1 : MetroWindow
    {
        public Window1()
        {
            InitializeComponent();
        }

        

        private void Salir_Click(object sender, RoutedEventArgs e)
        {

            MainWindow ventana1 = new MainWindow();

            
            Close();

            ventana1.Show();


        }

       

        
    }
}
