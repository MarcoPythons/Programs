   M S B A M L   `   `   `  ����K  GProyecto_Onbreak, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null3clr-namespace:Proyecto_OnbreakProyecto_Onbreak  5   	   H DMahApps.Metro, Version=1.6.5.1, Culture=neutral, PublicKeyToken=nullZ=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.MetroMahApps.Metro.Behaviours 5	   	   V;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.MetroMahApps.Metro.Controls 5
   	   +    %Proyecto_Onbreak.CalculoValorContrato   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   0localclr-namespace:Proyecto_Onbreak     5   	   c _System.Windows.Interactivity, Version=4.5.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35Bi:http://schemas.microsoft.com/expression/2010/interactivity  5   	   N
behaviours=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.Metro  5	   	   JControls;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.Metro  5
   	     � 
ResizeMode$  NoResize=�5   	    � WindowStartupLocation$ CenterScreen=�6    
����� �(  "MahApps.Metro.Controls.MetroWindow   	GlowBrush
 ��� � � Title$ Valores Evento��5   	   $��398.247��6    $��593.961��61   ��5      �� 5   
    �� EndPoint$ 0.5,1&�6    �� 
StartPoint$ 0.5,0&�6/   .��5      �  � Color$ Black��6    � Offset$ 0Q�6)   � 5      $ 	#FFBF1111��6   $ 1Q�6-   5      .��5      � ���	#FF0017FF � ColumnDefinitions 5   
   �� 5      $
��468* �6   �� 5      $��7* �6   .+�5   
   �� $
��Left=�6   $��4,-4,0,0q�6+   $	��Top=�6=   $	��358��6U   $	��578��6b   $��2��6n   ��5      �� 5      	 �� ImageSource$,	 &Imagenes/Tabla Valores Adicionales.png��6   
 j� Stretch$
 Uniform=�6R   5      �� 5   
   -   5         ��Name$ Calcular_Valor_Contrato��5      $��Salir��62   $
��Left=�6B      AccentedSquareButtonStyle#��[  6]   $��415,302,0,0q�6�   $	��Top=�6�   $	��154��6�   $��62��6�   6�   5      5       