   M S B A M L   `   `   `  ����K  GProyecto_Onbreak, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null3clr-namespace:Proyecto_OnbreakProyecto_Onbreak  5   	   H DMahApps.Metro, Version=1.6.5.1, Culture=neutral, PublicKeyToken=nullZ=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.MetroMahApps.Metro.Behaviours 5	   	   V;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.MetroMahApps.Metro.Controls 5
   	   *    $Proyecto_Onbreak.Listado_de_Clientes   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   0localclr-namespace:Proyecto_Onbreak     5   	   c _System.Windows.Interactivity, Version=4.5.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35Bi:http://schemas.microsoft.com/expression/2010/interactivity  5   	   N
behaviours=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.Metro  5	   	   JControls;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.Metro  5
   	     � Title$  Listado de clientes��5   	   $��416.705��6%   $��1029.622��66   $��0q�5   	   (  "MahApps.Metro.Controls.MetroWindow   	GlowBrush
 ��� � � 
ResizeMode$ NoResize=�6.    � WindowStartupLocation$ CenterScreen=�6D   .��5      �  � ColumnDefinitions 5   
   �� 5      ��5   
   
� 5      .��5      �  � Color$ 	#FF3A00FF��6    � Offset$ 1Q�61   � 5      $ 	#FF0017FF��6   5      .+�5   
   �� -   5         ��Name$ TipoEmpresaFiltro��5      $��Tipo Empresa��6,   $
��Left=�6C      AccentedSquareButtonStyle#��[  6^   $��440,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 5   
   -   5        $ RutClienteFiltrar��5      $��Rut Cliente��6,   $
��Left=�6B   #��[  6]   $��144,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 5   
   -   5        $ ActividadEmpresaFiltro��5      $��Actividad Empresa��61   $
��Left=�6M   #��[  6h   $��728,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 5   
   $��Filtrar por:��6   $
��Left=�6'   $��	15,26,0,0q�6B   $	��Top=�6U   $��79��6m   
�������6x   &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ datagridListadoClientes��5      $
��Left=�6�   $	��157��6�   $��
15,176,0,0q�6�   $	��Top=�6�   $
��1000��6  ��6  �� *People+��5      �� 5      	 �� EndPoint$	 0.5,1&�6&   
 �� 
StartPoint$
 0.5,0&�67   .��5      � $ 	#FF3A00FF��6#   $ 1Q�65   � 5      $ 	#FF0017FF��6#   5       5"      �� 5#   
   -   5        $ Salir��5#      $��Salir��6    $
��Left=�60   #��[  6K   $��
943,10,0,0q�6~   $	��Top=�6�   $��71��6�   $	��161��6�   6�   �� 5$   
   -   5         ��Name$ 	Filtrador��5$       � ToolTip$! Rut SIN DIGíTO VERIFICADOR��6%   $
��Left=�6J   *  $MahApps.Metro.Controls.TextBoxHelper   	Watermark$  ��6f   $��23��6�   $��
128,69,0,0q�6�    �� TextWrapping$
 Wrap=�6�   $	��Top=�6�   $	��170��6�   �� 5%   
   -   5         ��Name$ TipoCombobox1��5%      $
��Left=�6*   $��
408,69,0,0q�6E   $	��Top=�6Y   $	��194��6q   .@�5&      �� $	��SPA��6   $
��Left=�6)   $	��191��6D   �� 5'      $
��EIRL��6   $
��Left=�6*   $	��191��6E   �� 5(      $��Limitada��6   $
��Left=�6.   $	��191��6I   �� 5)      $��Sociedad Anónima��6   $
��Left=�66   $	��191��6Q   5*      �� 5+   
   -   5        $ AcividadListado��5+      $
��Left=�6,   $��
696,69,0,0q�6G   $	��Top=�6[   $	��194��6s   
�������.@�5,      �� $��Agropecuaria��6   $
��Left=�62   $	��192��6M   �� 5-      $��Minería��6   $
��Left=�6-   $	��192��6H   �� 5.      $��Manufactura��6   $
��Left=�61   $	��192��6L   �� 5/      $��	Hoteleria��6   $
��Left=�6/   $	��192��6J   �� 50      $��	Alimentos��6   $
��Left=�6/   $	��192��6J   �� 51      $��
Transporte��6   $
��Left=�60   $	��192��6K   �� 52      $��	Servicios��6   $
��Left=�6/   $	��192��6J   �� 53      $��Comercio��6   $
��Left=�6.   $	��192��6I   55      �� 56   
   -	   5        $ Salir_AdminClientes��56      $��Atras��6.   $
��Left=�6>   #��[  6Y   $��906,338,0,0q�6�   $	��Top=�6�   $	��108��6�   $��42��6�   6�   �� 57   
   -
   5        $ Salir_AdminContratos��57      $��Atras��6/   $
��Left=�6?   #��[  6Z   $��
15,338,0,0q�6�   $	��Top=�6�   $	��108��6�   $��42��6�   6�   �� 58   
   -   5        $ ListadoContratos��58      $#��Volver a listado de contratos��6+   $
��Left=�6S   #��[  6n   $��344,338,0,0q�6�   $	��Top=�6�   $	��374��6�   $��42��6�   6�   59      5:      