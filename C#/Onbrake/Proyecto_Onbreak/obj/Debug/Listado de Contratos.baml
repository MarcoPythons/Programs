   M S B A M L   `   `   `  ����K  GProyecto_Onbreak, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null3clr-namespace:Proyecto_OnbreakProyecto_Onbreak  5   	   H DMahApps.Metro, Version=1.6.5.1, Culture=neutral, PublicKeyToken=nullZ=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.MetroMahApps.Metro.Behaviours 5	   	   V;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.MetroMahApps.Metro.Controls 5
   	   +    %Proyecto_Onbreak.Listado_de_Contratos   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   0localclr-namespace:Proyecto_Onbreak     5   	   c _System.Windows.Interactivity, Version=4.5.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35Bi:http://schemas.microsoft.com/expression/2010/interactivity  5   	   N
behaviours=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.Metro  5	   	   JControls;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.Metro  5
   	     � Title$  Listado de contratos��5   	   $��416.705��6'   $��1029.622��68   $��0q�5   	   (  "MahApps.Metro.Controls.MetroWindow   	GlowBrush
 ��� � � 
ResizeMode$ NoResize=�6.    � WindowStartupLocation$ CenterScreen=�6D   .��5      � ��5   
   
� 5      .��5      �  � Color$ 	#FF3A00FF��6    � Offset$ 1Q�61   � 5      $ 	#FF0017FF��6   5      .+�5   
   �� -   5         ��Name$ TipoEmpresaFiltro��5      $��Rut del Cliente��6,   $
��Left=�6F      AccentedSquareButtonStyle#��[  6a   $��268,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 5   
   -   5        $ RutClienteFiltrar��5      $��Número de Contrato��6,   $
��Left=�6I   #��[  6d   $��
45,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 5   
   -   5        $ ActividadEmpresaFiltro��5      $��Tipo de Contrato��61   $
��Left=�6L   #��[  6g   $��522,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 5   
   $��Filtrar por:��6   $
��Left=�6'   $��	15,26,0,0q�6B   $	��Top=�6U   $��79��6m   
�������6x   &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ datagridListadoClientes��5      $
��Left=�6�   $	��157��6�   $��15,176,-29,0q�6�   $	��Top=�6�   $
��1000��6  ��5      �� 5       �� EndPoint$ 0.5,1&�6&   	 �� 
StartPoint$	 0.5,0&�67   .��5      � $ 	#FF3A00FF��6#   $ 1Q�65   � 5      $ 	#FF0017FF��6#   5      5       �� 5!   
   -   5        $ Salir��5!      $��Salir��6    $
��Left=�60   #��[  6K   $��
943,10,0,0q�6~   $	��Top=�6�   $��71��6�   $	��161��6�   6�   �� 5"   
   -   5        
 ��Name$
 NumeroContratoFiltro��5"      $
��Left=�61   *  $MahApps.Metro.Controls.TextBoxHelper   	Watermark$  ��6M   $��23��6q   $��	28,69,0,0q�6}    �� TextWrapping$
 Wrap=�6�   $	��Top=�6�   $	��170��6�   �� 5#   
   -   5        $
 	RutFiltro��5#       � ToolTip$! Rut SIN DIGíTO VERIFICADOR��6%   $
��Left=�6J   $  ��6f   $��23��6�   $��
248,69,0,0q�6�   $
 Wrap=�6�   $	��Top=�6�   $	��170��6�   �� 5$   
   -   5         ��Name$ TipoCombobox��5$      $
��Left=�6)   $��
491,69,0,0q�6D   $	��Top=�6X   $	��193��6p   $��26��6|   .@�5%      �� $��Coffee Break��6   $
��Left=�62   $	��191��6M   �� 5&      $��Cocktail��6   $
��Left=�6.   $	��191��6I   �� 5'      $��Cenas��6   $
��Left=�6+   $	��191��6F   5(      �� 5)   
   -	   5        $ Salir_AdminContrato��5)      $��Atras��6.   $
��Left=�6>   #��[  6Y   $��906,338,0,0q�6�   $	��Top=�6�   $	��108��6�   $��42��6�   6�   �� 5*   
   -
   5        $ ModalidadComboBox��5*      $
��Left=�6.   $��
718,69,0,0q�6I   $	��Top=�6]   $	��192��6u   $��26��6�   .@�5+      �� $��Light Break��6   $
��Left=�61   $	��191��6L   �� 5,      $��Journal Break��6   $
��Left=�63   $	��191��6N   �� 5-      $��	Day Break��6   $
��Left=�6/   $	��191��6J   �� 5.      $��	Ejecutiva��6   $
��Left=�6/   $	��191��6J   �� 5/      $��Celebración��6   $
��Left=�61   $	��191��6L   �� 50      $��Quick Cocktail��6   $
��Left=�64   $	��191��6O   �� 51      $��Ambient Cocktail��6   $
��Left=�66   $	��191��6Q   52      �� 53   
   -   5        $ ModalidadBoton��53      $��Modalidad Evento��6)   $
��Left=�6D   #��[  6_   $��746,105,0,0q�6�   $	��Top=�6�   $	��130��6�   $��59��6�   6�   �� 54   
   -   5        $ ListadoClientes��54      $��Listado de Clientes��6*   $
��Left=�6H   #��[  6c   $��344,338,0,0q�6�   $	��Top=�6�   $	��374��6�   $��42��6�   6�   55      56      