   M S B A M L   `   `   `  ����K  GProyecto_Onbreak, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null3clr-namespace:Proyecto_OnbreakProyecto_Onbreak  5   	   H DMahApps.Metro, Version=1.6.5.1, Culture=neutral, PublicKeyToken=nullZ=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.MetroMahApps.Metro.Behaviours 5	   	   V;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.MetroMahApps.Metro.Controls 5
   	   !    Proyecto_Onbreak.MainWindow   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   0localclr-namespace:Proyecto_Onbreak     5   	   c _System.Windows.Interactivity, Version=4.5.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35Bi:http://schemas.microsoft.com/expression/2010/interactivity  5   	   N
behaviours=clr-namespace:MahApps.Metro.Behaviours;assembly=MahApps.Metro  5	   	   JControls;clr-namespace:MahApps.Metro.Controls;assembly=MahApps.Metro  5
   	     � 
ResizeMode$  NoResize=�5   	    � WindowStartupLocation$ CenterScreen=�6    
����� �(  "MahApps.Metro.Controls.MetroWindow   	GlowBrush
 ��� � � Title$ OnBreak��5   	   $��449.5��6   $	��947��6(   .��5      � $��	0,0,-6,-5q�6   ��5   
   
� 5      .��5      �  � Color$ 	#FF3A00FF��6    � Offset$ 1Q�61   � 5      $ 	#FF0017FF��6   5       � RowDefinitions 5   
   �� 5      �� 5      $��0* �6    � ColumnDefinitions 5   
   �� 5      $
��521* �6   �� 5      $
��573* �6   �� 5      $��2* �6   .+�5   
   �� -   5         ��Name$! AdministracionClientesImage��5      $
��Left=�66   $��	18,10,0,0q�6R   $	��Top=�6e   $	��205��6}   $	��110��6�   $��48(�6�   $��Italic$�6�   $
��Bold"�6�   +  %MahApps.Metro.Controls.ControlsHelper	   ContentCharacterCasing$	 Upper=�6�   
���  ����5      �� 5      
 �� ImageSource$"
 Imagenes/20200505_192204.jpg��6   5!      �� 5"   
   -   5        $�� ��5"      $
��Left=�6   $��
40,114,0,0q�67   $	��Top=�5#      $	��208��6)   $	��106��65   $��1��6B   ��5$      �� 5%      $
 Imagenes/Imagenes.jpg��6   5'      �� 5(   
   -   5        $
��Left=�5(         AccentedSquareButtonStyle#��[  6,   $��
18,125,0,0q�6_   $	��Top=�6s   $	��472��6�   $��82��6�   ���	#FFB9B9B9$��2��6�   .��5)      �� $
��Wrap=�6   $��36��6,   $	��206��68   $
��Bold"�6D   $��22(�6V    �� TextAlignment$ Center=�6d   �� 6|   $�Listado de Clientes��6�   �� 6�   .F�5*      �� $��Label��6   5+      6'   5,      �� 5-   
   -   5        $
��Left=�5-      #��[  6,   $��221,220,0,0q�6_   $	��Top=�6t   $	��477��6�   $��82��6�   ���	#FF5850F3$��2��6�   .��5.      �� $
��Wrap=�6   $��78��6,   $	��229��68   $
��Bold"�6D   $��22(�6V   $ Center=�6d   �� 6|   $�Administraci��6�   �� 6�   $	�ón��6�   �� 6�   $� de Contratos��6�   6�   5/      �� 50   
   -   5        $
��Left=�50      #��[  6,   $��
25,325,0,0q�6_   $	��Top=�6s   $	��478��6�   $��82��6�   ���	#FF8A85FF$��2��6�   .��51      �� $
��Wrap=�6   $��Listado de Contratos��6,   $��58��6H   $	��207��6T   $
��Bold"�6`   $��22(�6r   $ Center=�6�   52      �� 53   
   -   5        $�� ��53      $
��Left=�6   $��
18,212,0,0q�67   $	��Top=�6K   $	��203��6c   $	��105��6o   ��54      �� 55      $"
 Imagenes/20200505_192216.jpg��6   57      �� 58   
   -   5        $# AdministracionClientesLetters��58      $
��Left=�68   #��[  6S   $��
223,24,0,0q�6�   $	��Top=�6�   $	��477��6�   $��2��6�   $��90��6�   ���	#FF4B7BBF.��59      �� $
��Wrap=�6   $��62��6,   $	��256��68   $��22(�6D   $
��Bold"�6R   $ Center=�6   ��6d   Z� �� 6�   $�
Administra��6�   �� 6�   $$�ción de              Clientes��6�   6�   5:      �� 5;   
   -   5        $�� ��5;      $
��Left=�6   #��[  67   $��
50,302,0,0q�6j   $	��Top=�6~   $	��203��6�   $	��124��6�   $��1��6�   ��5<      �� 5=      $"
 Imagenes/20200505_192154.jpg��6   5?      �� 5@   
   $�� ��6   $��1��6   $
��Left=�6+   $��290,114,0,0q�6F   $	��Top=�6[   $	��177��6s   $	��195��6�   ��5A      �� 5B      $.
 (Imagenes/logo_transparent_background.png��6   5D      5E      5F      