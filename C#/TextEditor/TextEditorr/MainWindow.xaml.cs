using System;
using System.Collections.Generic;
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

//cosas importantes
using System.IO;
using Microsoft.Win32;
using MahApps.Metro.Controls;
using MahApps.Metro.Controls.Dialogs;
using System.Drawing;


namespace TextEditorr
{
    public partial class MainWindow : MetroWindow
    { 

        string ruta = string.Empty;
        string file = string.Empty;
        string path = string.Empty;

        public MainWindow()
        {
            InitializeComponent();

            Editor.Focus();

            
        }

        

        public void saveFile()
        {


            try {
                
                FileStream fParameter = new FileStream(ruta, FileMode.Create, FileAccess.Write);
                StreamWriter m_WriterParameter = new StreamWriter(fParameter);
                m_WriterParameter.BaseStream.Seek(0, SeekOrigin.End);
                m_WriterParameter.Write(this.Editor.Text);
                m_WriterParameter.Flush();
                m_WriterParameter.Close();
            }
            catch (System.ArgumentException)
            {
                saveAs();
            }
           
        }



        public async void saveAs()
        {
            try
            {
                SaveFileDialog saveFileDialog1 = new SaveFileDialog();
                StreamWriter save;

                saveFileDialog1.Filter = "All Files (*.*)|*.*";
                saveFileDialog1.FilterIndex = 2;
                saveFileDialog1.RestoreDirectory = true;

                saveFileDialog1.ShowDialog();
                string path1 = saveFileDialog1.FileName;

                save = File.AppendText(path1);
                save.Write(Editor.Text);
                save.Flush();
                await this.ShowMessageAsync("Archivo guardado correctamente en: ", string.Format(path1));
                this.Editor.Clear();
                Bloc1.Title = "Black NotePad";

            }
            catch (System.ArgumentException)
            {
                await this.ShowMessageAsync("Atención", "Proceso Cancelado.");
                
            }
            
            
        }

        public async void openfile()
        {
            OpenFileDialog choofdlog = new OpenFileDialog();
            choofdlog.Filter = "All Files (*.*)|*.*";
            choofdlog.FilterIndex = 1;
            choofdlog.Multiselect = true;
            

            if (choofdlog.ShowDialog() == true)
            {
                ruta = choofdlog.FileName;

                Editor.Text = File.ReadAllText(ruta);
                


            }

            file = System.IO.Path.GetFileName(ruta);
            Bloc1.Title = file;
            try { path = System.IO.Path.GetDirectoryName(ruta); }

            catch { await this.ShowMessageAsync("Atención", "Proceso Cancelado."); }
        }

        public void close()
        {
            this.Close();
        }

        public void Open()
        {
            this.Editor.Clear();
            Bloc1.Title = "Black NotePad";
        }

        private void MenuItem_Click(object sender, RoutedEventArgs e)
        {
            close();

        }

        private  void MenuItem_Click_1(object sender, RoutedEventArgs e)
        {
            openfile();
        }

        private void MenuItem_Click_2(object sender, RoutedEventArgs e)
        {
            saveFile();
        }

        private void MenuItem_Click_3(object sender, RoutedEventArgs e)
        {
            Open();
        }

        private  void MenuItem_Click_4(object sender, RoutedEventArgs e)
        {
            saveAs();
        }

        private void NewShortcut(object sender, KeyEventArgs e)
        {
            if( e.Key == Key.F1 ) { Editor.Clear(); }
        }

        private void MenuItem_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.F1) { this.Editor.Clear(); }
        }

        private void Editor_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.F1) { Open(); }
            else if (e.Key == Key.F2) { openfile(); }
            else if (e.Key == Key.F3) { saveFile(); }
            else if (e.Key == Key.F4) { saveAs(); }
            else if (e.Key == Key.F5) { this.close(); }
        }
        private void edit(object sender, RoutedEventArgs e)
        {
            
        }
        private void Bloc1_Closing(object sender, System.ComponentModel.CancelEventArgs e)
        {
            if (Bloc1.Title == "Untitle Black NotePad")
            {
                if (MessageBox.Show("No has guardado el archivo", "¿Deseas cerrar la apliación?", MessageBoxButton.YesNo, MessageBoxImage.Warning) == MessageBoxResult.No)
                {
                    e.Cancel = true;
                }
                
            }
        }

        private void Editor_KeyDown(object sender, KeyEventArgs e)
        {
            Bloc1.Title = "Untitle Black NotePad";
        }
    }
}
