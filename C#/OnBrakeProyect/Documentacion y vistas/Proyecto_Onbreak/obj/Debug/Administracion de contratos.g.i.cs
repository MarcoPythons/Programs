﻿#pragma checksum "..\..\Administracion de contratos.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "98D0CDE11666C339E54594D765A3C72FA9374E2C19B1284DFD6DB30DE4C2C7A4"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using MahApps.Metro.Behaviours;
using MahApps.Metro.Controls;
using Proyecto_Onbreak;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interactivity;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace Proyecto_Onbreak {
    
    
    /// <summary>
    /// Administracion_de_contratos
    /// </summary>
    public partial class Administracion_de_contratos : MahApps.Metro.Controls.MetroWindow, System.Windows.Markup.IComponentConnector {
        
        
        #line 17 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox DireccionTXT;
        
        #line default
        #line hidden
        
        
        #line 19 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox Fecha;
        
        #line default
        #line hidden
        
        
        #line 20 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Expander Expansor;
        
        #line default
        #line hidden
        
        
        #line 33 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Calendar MiCalendario;
        
        #line default
        #line hidden
        
        
        #line 35 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label F;
        
        #line default
        #line hidden
        
        
        #line 36 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox FechaTermino;
        
        #line default
        #line hidden
        
        
        #line 37 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Expander ExpansorTermino;
        
        #line default
        #line hidden
        
        
        #line 50 "..\..\Administracion de contratos.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Calendar MiCalendarioTermino;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/Proyecto_Onbreak;component/administracion%20de%20contratos.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\Administracion de contratos.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.DireccionTXT = ((System.Windows.Controls.TextBox)(target));
            return;
            case 2:
            this.Fecha = ((System.Windows.Controls.TextBox)(target));
            return;
            case 3:
            this.Expansor = ((System.Windows.Controls.Expander)(target));
            return;
            case 4:
            this.MiCalendario = ((System.Windows.Controls.Calendar)(target));
            
            #line 33 "..\..\Administracion de contratos.xaml"
            this.MiCalendario.SelectedDatesChanged += new System.EventHandler<System.Windows.Controls.SelectionChangedEventArgs>(this.MiCalendario_SelectedDatesChanged);
            
            #line default
            #line hidden
            return;
            case 5:
            this.F = ((System.Windows.Controls.Label)(target));
            return;
            case 6:
            this.FechaTermino = ((System.Windows.Controls.TextBox)(target));
            return;
            case 7:
            this.ExpansorTermino = ((System.Windows.Controls.Expander)(target));
            return;
            case 8:
            this.MiCalendarioTermino = ((System.Windows.Controls.Calendar)(target));
            
            #line 50 "..\..\Administracion de contratos.xaml"
            this.MiCalendarioTermino.SelectedDatesChanged += new System.EventHandler<System.Windows.Controls.SelectionChangedEventArgs>(this.MiCalendarioTermino_SelectedDatesChanged);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

