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
namespace Proyecto_Onbreak
{
    /// <summary>
    /// Lógica de interacción para CalculoValorContrato.xaml
    /// </summary>
    public partial class CalculoValorContrato : MetroWindow
    {
        public CalculoValorContrato()
        {
            InitializeComponent();
        }

        private void Calcular_Valor_Contrato_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }
    }
}
