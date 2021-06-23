import tkinter as tk
import socket
import os
from tkinter import ttk
from time import strftime

class Inicio(tk.Frame):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
class Operacion(tk.Frame):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.lista_filtro = [
            'Rut', 'Nombre completo',
            'E-mail', 'Region',
            'Comuna', 'Fono'
            ]
        self.lista_region = [
            'Tarapaca', 'Antofagasta', 'Atacama', 'Coquimbo',
            'Valparaiso', 'Del Libertador B. OHiggins', 'Del Maule',
            'Del BioBio', 'La Araucania', 'Los Lagos',
            'Aysen del Gral C. Ibañez del Campo',
            'Magallanes y de la Antartica Chilena',
            'Metropolitana de Santiago',
            'Los Rios', 'Arica y Parinacota', 'Ñuble'
            ]
        self.lista_sexo = [
            'Masculino', 'Femenino', 'Otro'
            ]
        self.lista_dias = []
        self.lista_mes = [
            'Enero', 'Febrero', 'Marzo',
            'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre',
            'Octubre', 'Noviembre', 'Diciembre'
            ]
        self.lista_años = []
        self.lista_operacion = [
            'Registrar','Modificar',
            'Eliminar','Historial'
            ]
        self.labelFrame_operacion = tk.LabelFrame(
            self,
            text = 'Seleccione una operación',
            font = ('Ubuntu light', 13),
            relief = 'solid',
            bd = 1,
            background = '#FFFFFF'
            )
        self.labelFrame_operacion.pack(
            fill = 'x',
            expand = True
            )
        self.frame_listBox = tk.Frame(
            self.labelFrame_operacion,
            background = '#FFFFFF'
            )
        self.frame_listBox.pack(
            fill = 'x',
            expand = True,
            padx = 15,
            pady = 15
            )
        self.listBox_operacion = tk.Listbox(
            self.frame_listBox,
            relief = 'solid',
            bd = 1,
            justify = 'center')

        self.listBox_operacion.pack(
            fill = 'both',
            expand = True,
            side = tk.RIGHT
            )
        # Se le asignan las operaciones al listBox
        for operacion in self.lista_operacion:
            self.listBox_operacion.insert(tk.END, operacion)
        
        self.boton_confirmacion = tk.Button(
            self.labelFrame_operacion,
            text = 'Confirmar operación',
            relief = 'flat',
            width = 40,
            font = ('Ubuntu light', 14),
            fg = '#FFFFFF',
            justify = 'center',
            background = '#D5A27C',
            command = self.operacion_usuario
            )
        self.boton_confirmacion.pack(
            expand = True,
            pady = 12
            )
    def operacion_usuario(self):
        if self.listBox_operacion.get(
            self.listBox_operacion.curselection()
            ) == self.lista_operacion[0]:
            for dia in range(1,32):
                self.lista_dias.append(dia)
            for año in range(1901,2022):
                self.lista_años.append(año)
            # Registro
            self.modulo_registro = tk.Toplevel()
            self.modulo_registro.configure(
                background = '#786271'
                )
            self.modulo_registro.geometry(
                '1000x600'
                )
            self.modulo_registro.title(
                'Modulo de Registro'
                )
            self.frame_modulo_registro = tk.Frame(
                self.modulo_registro,
                background = '#FFFFFF'
                )
            self.frame_modulo_registro.pack(
                fill = 'x',
                expand = True,
                padx = 15
                )
            self.labelFrame_registro = tk.LabelFrame(
                self.frame_modulo_registro,
                text = 'Ingrese los datos',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF'
                )
            self.labelFrame_registro.pack(
                fill = 'x',
                expand = True,
                padx = 15,
                pady = 15
                )
            self.labelFrame_datos_personales = tk.LabelFrame(
                self.labelFrame_registro,
                text = 'Datos Personales',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF')
            self.labelFrame_datos_personales.pack(
                fill = 'both',
                expand = True,
                padx = 15,
                pady = 15,
                side = tk.LEFT
                )
            self.label_rut = tk.Label(
                self.labelFrame_datos_personales,
                text = 'Rut [XX.XXX.XXX-X]',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_rut.pack(
                expand = True
                )
            self.entry_rut = tk.Entry(
                self.labelFrame_datos_personales,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_rut.pack(
                expand = True,
                padx = 20
                )
            self.label_nombres = tk.Label(
                self.labelFrame_datos_personales,
                text = 'Nombres',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_nombres.pack(
                expand = True
                )
            self.entry_nombres = tk.Entry(
                self.labelFrame_datos_personales,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_nombres.pack(
                expand = True,
                padx = 20
                )
            self.label_apellidos = tk.Label(
                self.labelFrame_datos_personales,
                text = 'Apellidos',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_apellidos.pack(
                expand = True
                )
            self.entry_apellidos = tk.Entry(
                self.labelFrame_datos_personales,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_apellidos.pack(
                expand = True,
                padx = 20
                )
            self.label_nacionalidad = tk.Label(
                self.labelFrame_datos_personales,
                text = 'Nacionalidad',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_nacionalidad.pack(
                expand = True
                )
            self.entry_nacionalidad = tk.Entry(
                self.labelFrame_datos_personales,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_nacionalidad.pack(
                expand = True,
                padx = 20
                )
            self.label_sexo = tk.Label(
                self.labelFrame_datos_personales,
                text = 'Sexo',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_sexo.pack(
                expand = True
                )
            self.comboBox_sexo = ttk.Combobox(
                self.labelFrame_datos_personales,
                justify = 'center',
                value = self.lista_sexo,
                font = ('Ubuntu light', 13),
                width = 28,
                state = 'readonly')
            self.comboBox_sexo.pack(
                expand = True,
                padx = 20
                )
            self.label_fecha_nacimiento = tk.Label(
                self.labelFrame_datos_personales,
                text = 'Fecha de Nacimiento [DD/MM/AAAA]',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_fecha_nacimiento.pack(
                expand = True
                )            
            self.frame_fecha_nacimiento = tk.Frame(
                self.labelFrame_datos_personales
                )
            self.frame_fecha_nacimiento.pack(
                expand = True,
                pady = 10
                )
            self.comboBox_dia = ttk.Combobox(
                self.frame_fecha_nacimiento,
                justify = 'center',
                value = self.lista_dias,
                font = ('Ubuntu light', 13),
                width = 5,
                state = 'readonly'
                )
            self.comboBox_dia.pack(
                fill = 'x',
                expand = True,
                side = tk.LEFT,
                padx = 2
                )
            self.comboBox_mes = ttk.Combobox(
                self.frame_fecha_nacimiento,
                justify = 'center',
                value = self.lista_mes,
                font = ('Ubuntu light', 13),
                width = 12,
                state = 'readonly'
                )
            self.comboBox_mes.pack(
                fill = 'x',
                expand = True,
                side = tk.LEFT,
                padx = 2
                )
            self.comboBox_año = ttk.Combobox(
                self.frame_fecha_nacimiento,
                justify = 'center',
                value = self.lista_años,
                font = ('Ubuntu light', 13),
                width = 5,
                state = 'readonly'
                )
            self.comboBox_año.pack(
                fill = 'x',
                expand = True,
                side = tk.RIGHT,
                padx = 2
                )
            self.labelFrame_datos_origen = tk.LabelFrame(
                self.labelFrame_registro,
                text = 'Datos de Dirección',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF'
                )
            self.labelFrame_datos_origen.pack(
                fill = 'both',
                expand = True,
                padx = 15,
                pady = 15,
                side = tk.LEFT
                )
            self.label_region = tk.Label(
                self.labelFrame_datos_origen,
                text = 'Región',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_region.pack(
                expand = True
                )
            self.comboBox_region = ttk.Combobox(
                self.labelFrame_datos_origen,
                justify = 'center',
                value = self.lista_region,
                font = ('Ubuntu light', 13),
                width = 28,
                state = 'readonly'
                )
            self.comboBox_region.pack(
                expand = True,
                padx = 10
                )
            self.label_comuna = tk.Label(
                self.labelFrame_datos_origen,
                text = 'Comuna',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_comuna.pack(
                expand = True
                )
            self.entry_comuna = tk.Entry(
                self.labelFrame_datos_origen,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_comuna.pack(
                expand = True,
                padx = 20
                )
            self.label_direccion = tk.Label(
                self.labelFrame_datos_origen,
                text = 'Dirección',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_direccion.pack(
                expand = True
                )
            self.entry_direccion = tk.Entry(
                self.labelFrame_datos_origen,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_direccion.pack(
                expand = True,
                padx = 20
                )
            self.label_numero_domicilio = tk.Label(
                self.labelFrame_datos_origen,
                text = 'Número de Domicilio',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_numero_domicilio.pack(
                expand = True
                )
            self.entry_numero_domicilio = tk.Entry(
                self.labelFrame_datos_origen,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_numero_domicilio.pack(
                expand = True,
                padx = 20
                )
            self.labelFrame_datos_contacto = tk.LabelFrame(
                self.labelFrame_registro,
                text = 'Datos de Contacto',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF'
                )
            self.labelFrame_datos_contacto.pack(
                fill = 'both',
                expand = True,
                padx = 15,
                pady = 15
                )
            self.label_fono = tk.Label(
                self.labelFrame_datos_contacto,
                text = 'Fono',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_fono.pack(
                expand = True
                )
            self.entry_fono = tk.Entry(
                self.labelFrame_datos_contacto,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_fono.pack(
                expand = True,
                padx = 20
                )
            self.label_email = tk.Label(
                self.labelFrame_datos_contacto,
                text = 'E-mail',
                font = ('Ubuntu light', 12),
                background = '#FFFFFF'
                )
            self.label_email.pack(
                expand = True
                )
            self.entry_email = tk.Entry(
                self.labelFrame_datos_contacto,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 30
                )
            self.entry_email.pack(
                expand = True,
                padx = 20
                )
            self.labelFrame_operacion_usuario = tk.LabelFrame(
                self.frame_modulo_registro,
                text = 'Operaciones del Modulo',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF'
                )
            self.labelFrame_operacion_usuario.pack(
                fill = 'both',
                expand = True,
                padx = 15,
                pady = 15,
                side = tk.BOTTOM
                )
            self.boton_registrar = tk.Button(
                self.labelFrame_operacion_usuario,
                text = 'Registrar cliente',
                relief = 'flat',
                width = 40,
                font = ('Ubuntu light', 14),
                fg = '#FFFFFF',
                justify = 'center',
                background = '#D5A27C'
                )
            self.boton_registrar.pack(
                expand = True,
                pady = 12,
                padx = 15,
                side = tk.LEFT
                )
            self.boton_exportar = tk.Button(
                self.labelFrame_operacion_usuario,
                text = 'Exportar datos',
                relief = 'flat',
                width = 40,
                font = ('Ubuntu light', 14),
                fg = '#FFFFFF',
                justify = 'center',
                background = '#D5A27C'
                )
            self.boton_exportar.pack(
                expand = True,
                pady = 12,
                padx = 15,
                side = tk.RIGHT
                )
            self.modulo_registro.mainloop()

        elif self.listBox_operacion.get(
            self.listBox_operacion.curselection()
            ) == self.lista_operacion[1]:

            self.modulo_modificacion = tk.Toplevel()
            self.modulo_modificacion.configure(
                background = '#786271'
                )
            self.modulo_modificacion.geometry(
                '1000x600'
                )
            self.modulo_modificacion.title(
                'Modulo de Modificacion'
                )
            self.frame_busqueda_mod = tk.Frame(
                self.modulo_modificacion,
                background = '#FFFFFF'
                )
            self.frame_busqueda_mod.pack(
                fill = 'both',
                expand = True,
                padx = 10,
                pady = 15
                )
            self.labelFrame_busqueda = tk.LabelFrame(
                self.frame_busqueda_mod,
                text = 'Modificacion de Cliente',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF'
                )
            self.labelFrame_busqueda.pack(
                fill = 'both',
                expand = True,
                padx = 15,
                pady = 15
                )
            self.frame_treeView_busqueda = tk.Frame(
                self.labelFrame_busqueda,
                background = '#786271'
                )
            self.frame_treeView_busqueda.pack(
                fill = 'x',
                expand = False,
                padx = 10,
                pady = 10
                )
            self.label_busqueda = tk.Label(
                self.frame_treeView_busqueda,
                text = 'Buscador de Clientes',
                font = ('Ubuntu light', 14),
                background = '#786271',
                foreground = '#FFFFFF'
                )
            self.label_busqueda.pack(
                fill = 'x',
                expand = True,
                side = tk.LEFT
                )
            self.entry_busqueda = tk.Entry(
                self.frame_treeView_busqueda,
                justify = 'center',
                relief = 'solid',
                bd = 1,
                font = ('Ubuntu light', 13),
                fg = '#000000',
                width = 20
                )
            self.entry_busqueda.pack(
                fill = 'x',
                expand = True,
                padx = 15,
                side = tk.LEFT
                )
            self.boton_busqueda = tk.Button(
                self.frame_treeView_busqueda,
                text = 'Buscar cliente',
                relief = 'flat',
                width = 20,
                font = ('Ubuntu light', 10),
                fg = '#FFFFFF',
                justify = 'center',
                background = '#D5A27C'
                )
            self.boton_busqueda.pack(
                fill = 'x',
                expand = True,
                padx = 15,
                pady = 10,
                side = tk.RIGHT
                )
            self.frame_treeView_modificacion = tk.Frame(
                self.labelFrame_busqueda
                )
            self.frame_treeView_modificacion.pack(
                fill = 'both',
                expand = True,
                padx = 10,
                pady = 15
                )
            self.treeView_modificacion = ttk.Treeview(
                self.frame_treeView_modificacion,
                height = 58,
                column = ('#1','#2','#3'
                          '#4','#5','#6',
                          '#7','#8','#9',
                          '#10','#11','#12',
                          '#13'),
                show = 'headings'
                )
            self.treeView_modificacion.pack(
                fill = 'both',
                expand = True,
                side = tk.LEFT
                )
            self.treeView_modificacion.heading(
                '#1',
                text = 'Rut',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#2',
                text = 'Nombres',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#3',
                text = 'Apellidos',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#4',
                text = 'Nacionalidad',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#5',
                text = 'Sexo',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#6',
                text = 'Fecha de Nacimiento',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#7',
                text = 'Region',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#8',
                text = 'Comuna',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#9',
                text = 'Direccion',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#10',
                text = 'Nro de Domicilio',
                anchor = tk.CENTER)
            self.treeView_modificacion.heading(
                '#11',
                text = 'Fono',
                anchor = tk.CENTER
                )
            self.treeView_modificacion.heading(
                '#12',
                text = 'E-mail',
                anchor = tk.CENTER
                )
            self.scrollBar_treeView_mod_y = ttk.Scrollbar(
                self.treeView_modificacion,
                orient = 'vertical',
                command = self.treeView_modificacion.yview
                )
            self.scrollBar_treeView_mod_y.pack(
                fill = 'y',
                side = tk.RIGHT
                )
            self.scrollBar_treeView_mod_x = ttk.Scrollbar(
                self.treeView_modificacion,
                orient = 'horizontal',
                command = self.treeView_modificacion.xview
                )
            self.scrollBar_treeView_mod_x.pack(
                fill = 'x',
                side = tk.BOTTOM
                )
            self.treeView_modificacion.configure(
                yscrollcommand = self.scrollBar_treeView_mod_y.set,
                xscrollcommand = self.scrollBar_treeView_mod_x.set
                )
            self.boton_modificar = tk.Button(
                self.frame_busqueda_mod,
                text = 'Modificar cliente',
                relief = 'flat',
                width = 40,
                font = ('Ubuntu light', 14),
                fg = '#FFFFFF',
                justify = 'center',
                background = '#D5A27C'
                )
            self.boton_modificar.pack(
                fill = 'x',
                expand = True,
                padx = 15,
                pady = 10,
                side = tk.LEFT
                )
            self.boton_filtro_mod = tk.Button(
                self.frame_busqueda_mod,
                text = 'Opciones de filtrado',
                relief = 'flat',
                width = 40,
                font = ('Ubuntu light', 14),
                fg = '#FFFFFF',
                justify = 'center',
                background = '#D5A27C'
                )
            self.boton_filtro_mod.pack(
                fill = 'x',
                expand = True,
                padx = 15,
                pady = 10,
                side = tk.RIGHT
                )
            self.modulo_modificacion.mainloop()

        elif self.listBox_operacion.get(
            self.listBox_operacion.curselection()
            ) == self.lista_operacion[2]:
            self.modulo_eliminacion = tk.Toplevel()
            self.modulo_eliminacion.configure(
                background = '#786271'
                )
            self.modulo_eliminacion.geometry(
                '1000x600'
                )
            self.modulo_eliminacion.title(
                'Modulo de Eliminacion'
                )
            self.frame_busqueda_elim = tk.Frame(
                self.modulo_eliminacion,
                background = '#FFFFFF'
                )
            self.frame_busqueda_elim.pack(
                fill = 'both',
                expand = True,
                padx = 10,
                pady = 15
                )
            self.labelFrame_busqueda_elim = tk.LabelFrame(
                self.frame_busqueda_elim,
                text = 'Eliminacion de Cliente',
                font = ('Ubuntu light', 14),
                relief = 'solid',
                bd = 1,
                foreground = '#786271',
                background = '#FFFFFF'
                )
            self.labelFrame_busqueda_elim.pack(
                fill = 'both',
                expand = True,
                padx = 15,
                pady = 15
                )
            self.frame_treeView_busqueda_elim = tk.Frame(
                self.labelFrame_busqueda_elim,
                background = '#786271'
                )
            self.frame_treeView_busqueda_elim.pack(
                fill = 'x',
                expand = False,
                padx = 10,
                pady = 10
                )
            self.label_busqueda_elim = tk.Label(self.frame_treeView_busqueda_elim,
                                           text = 'Buscador de Clientes',
                                           font = ('Ubuntu light', 14),
                                           background = '#786271',
                                           foreground = '#FFFFFF')
            self.label_busqueda_elim.pack(fill = 'x',
                                     expand = True,
                                     side = tk.LEFT)
            self.entry_busqueda_elim = tk.Entry(self.frame_treeView_busqueda_elim,
                                           justify = 'center',
                                           relief = 'solid',
                                           bd = 1,
                                           font = ('Ubuntu light', 13),
                                           fg = '#000000',
                                           width = 20)
            self.entry_busqueda_elim.pack(fill = 'x',
                                     expand = True,
                                     padx = 15,
                                     side = tk.LEFT)
            self.boton_busqueda_elim = tk.Button(self.frame_treeView_busqueda_elim,
                                            text = 'Buscar cliente',
                                            relief = 'flat',
                                            width = 20,
                                            font = ('Ubuntu light', 10),
                                            fg = '#FFFFFF',
                                            justify = 'center',
                                            background = '#D5A27C')
            self.boton_busqueda_elim.pack(fill = 'x',
                                     expand = True,
                                     padx = 15,
                                     pady = 10,
                                     side = tk.RIGHT)

            self.frame_treeView_eliminacion = tk.Frame(self.labelFrame_busqueda_elim)
            self.frame_treeView_eliminacion.pack(fill = 'both',
                                                  expand = True,
                                                  padx = 10,
                                                  pady = 15)

            self.treeView_eliminacion = ttk.Treeview(self.frame_treeView_eliminacion,
                                                     height = 58,
                                                     column = ('#1','#2','#3'
                                                               '#4','#5','#6',
                                                               '#7','#8','#9',
                                                               '#10','#11','#12',
                                                               '#13'),
                                                     show = 'headings')
            self.treeView_eliminacion.pack(fill = 'both',
                                            expand = True,
                                            side = tk.LEFT)
            self.treeView_eliminacion.heading('#1',
                                               text = 'Rut',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#2',
                                               text = 'Nombres',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#3',
                                               text = 'Apellidos',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#4',
                                               text = 'Nacionalidad',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#5',
                                               text = 'Sexo',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#6',
                                               text = 'Fecha de Nacimiento',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#7',
                                               text = 'Region',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#8',
                                               text = 'Comuna',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#9',
                                               text = 'Direccion',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#10',
                                               text = 'Num. de Domicilio',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#11',
                                               text = 'Fono',
                                               anchor = tk.CENTER)
            self.treeView_eliminacion.heading('#12',
                                               text = 'E-mail',
                                               anchor = tk.CENTER)

            self.scrollBar_treeView_elim_y = ttk.Scrollbar(self.treeView_eliminacion,
                                                          orient = 'vertical',
                                                          command = self.treeView_eliminacion.yview)
            self.scrollBar_treeView_elim_y.pack(fill = 'y',
                                                side = tk.RIGHT)

            self.scrollBar_treeView_elim_x = ttk.Scrollbar(self.treeView_eliminacion,
                                                          orient = 'horizontal',
                                                          command = self.treeView_eliminacion.xview)
            self.scrollBar_treeView_elim_x.pack(fill = 'x',
                                               side = tk.BOTTOM)
            self.treeView_eliminacion.configure(yscrollcommand = self.scrollBar_treeView_elim_y.set)
            self.treeView_eliminacion.configure(xscrollcommand = self.scrollBar_treeView_elim_x.set)


            self.boton_eliminar = tk.Button(self.frame_busqueda_elim,
                                             text = 'Eliminar cliente',
                                             relief = 'flat',
                                             width = 40,
                                             font = ('Ubuntu light', 14),
                                             fg = '#FFFFFF',
                                             justify = 'center',
                                             background = '#D5A27C')
            self.boton_eliminar.pack(fill = 'x',
                                      expand = True,
                                      padx = 15,
                                      pady = 10,
                                      side = tk.LEFT)
            self.boton_opcion_filtrado_elim = tk.Button(self.frame_busqueda_elim,
                                                   text = 'Opciones de filtrado',
                                                   relief = 'flat',
                                                   width = 40,
                                                   font = ('Ubuntu light', 14),
                                                   fg = '#FFFFFF',
                                                   justify = 'center',
                                                   background = '#D5A27C')
            self.boton_opcion_filtrado_elim.pack(fill = 'x',
                                            expand = True,
                                            padx = 15,
                                            pady = 10,
                                            side = tk.RIGHT)
            self.modulo_eliminacion.mainloop()
        elif self.listBox_operacion.get(self.listBox_operacion.curselection()) == self.lista_operacion[3]:
            self.modulo_historial = tk.Toplevel()
            self.modulo_historial.configure(background = '#786271')
            self.modulo_historial.geometry('1000x600')
            self.modulo_historial.title('Modulo de Historial')

            self.frame_busqueda_historial = tk.Frame(self.modulo_historial,
                                           background = '#FFFFFF')
            self.frame_busqueda_historial.pack(fill = 'both',
                                          expand = True,
                                          padx = 10,
                                          pady = 15)

            self.labelFrame_busqueda_hist = tk.LabelFrame(self.frame_busqueda_historial,
                                                          text = 'Historial de Clientes',
                                                          font = ('Ubuntu light', 14),
                                                          relief = 'solid',
                                                          bd = 1,
                                                          foreground = '#786271',
                                                          background = '#FFFFFF')
            self.labelFrame_busqueda_hist.pack(fill = 'both',
                                               expand = True,
                                               padx = 15,
                                               pady = 15)
            self.frame_treeView_busqueda_hist = tk.Frame(self.labelFrame_busqueda_hist,
                                                         background = '#786271')
            self.frame_treeView_busqueda_hist.pack(fill = 'x',
                                                   expand = False,
                                                   padx = 10,
                                                   pady = 10)

            self.label_busqueda_hist = tk.Label(self.frame_treeView_busqueda_hist,
                                                text = 'Buscador de Clientes',
                                                font = ('Ubuntu light', 14),
                                                background = '#786271',
                                                foreground = '#FFFFFF')
            self.label_busqueda_hist.pack(fill = 'x',
                                     expand = True,
                                     side = tk.LEFT)
            self.entry_busqueda_elim = tk.Entry(self.frame_treeView_busqueda_hist,
                                           justify = 'center',
                                           relief = 'solid',
                                           bd = 1,
                                           font = ('Ubuntu light', 13),
                                           fg = '#000000',
                                           width = 20)
            self.entry_busqueda_elim.pack(fill = 'x',
                                     expand = True,
                                     padx = 15,
                                     side = tk.LEFT)
            self.boton_busqueda_elim = tk.Button(self.frame_treeView_busqueda_hist,
                                            text = 'Buscar cliente',
                                            relief = 'flat',
                                            width = 20,
                                            font = ('Ubuntu light', 10),
                                            fg = '#FFFFFF',
                                            justify = 'center',
                                            background = '#D5A27C')
            self.boton_busqueda_elim.pack(fill = 'x',
                                     expand = True,
                                     padx = 15,
                                     pady = 10,
                                     side = tk.RIGHT)

            self.frame_treeView_historial = tk.Frame(self.labelFrame_busqueda_hist)
            self.frame_treeView_historial.pack(fill = 'both',
                                                  expand = True,
                                                  padx = 10,
                                                  pady = 15)

            self.treeView_historial = ttk.Treeview(self.frame_treeView_historial,
                                                     height = 58,
                                                     column = ('#1','#2','#3'
                                                               '#4','#5','#6',
                                                               '#7','#8','#9',
                                                               '#10','#11','#12',
                                                               '#13'),
                                                     show = 'headings')
            self.treeView_historial.pack(fill = 'both',
                                            expand = True,
                                            side = tk.LEFT)
            self.treeView_historial.heading('#1',
                                               text = 'Rut',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#2',
                                               text = 'Nombres',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#3',
                                               text = 'Apellidos',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#4',
                                               text = 'Nacionalidad',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#5',
                                               text = 'Sexo',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#6',
                                               text = 'Fecha de Nacimiento',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#7',
                                               text = 'Region',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#8',
                                               text = 'Comuna',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#9',
                                               text = 'Direccion',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#10',
                                               text = 'Num. de Domicilio',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#11',
                                               text = 'Fono',
                                               anchor = tk.CENTER)
            self.treeView_historial.heading('#12',
                                               text = 'E-mail',
                                               anchor = tk.CENTER)

            self.scrollBar_treeView_histo_y = ttk.Scrollbar(self.treeView_historial,
                                                          orient = 'vertical',
                                                          command = self.treeView_historial.yview)
            self.scrollBar_treeView_histo_y.pack(fill = 'y',
                                                side = tk.RIGHT)

            self.scrollBar_treeView_histo_x = ttk.Scrollbar(self.treeView_historial,
                                                          orient = 'horizontal',
                                                          command = self.treeView_historial.xview)
            self.scrollBar_treeView_histo_x.pack(fill = 'x',
                                               side = tk.BOTTOM)
            self.treeView_historial.configure(yscrollcommand = self.scrollBar_treeView_histo_y.set)
            self.treeView_historial.configure(xscrollcommand = self.scrollBar_treeView_histo_x.set)


            self.boton_opcion_filtrado_histo = tk.Button(self.frame_busqueda_historial,
                                             text = 'Opciones de filtrado',
                                             relief = 'flat',
                                             width = 40,
                                             font = ('Ubuntu light', 14),
                                             fg = '#FFFFFF',
                                             justify = 'center',
                                             background = '#D5A27C')
            self.boton_opcion_filtrado_histo.pack(fill = 'x',
                                      expand = True,
                                      padx = 15,
                                      pady = 10,
                                      side = tk.LEFT)
            self.boton_opcion_ordenado = tk.Button(self.frame_busqueda_historial,
                                                   text = 'Opciones de ordenado',
                                                   relief = 'flat',
                                                   width = 40,
                                                   font = ('Ubuntu light', 14),
                                                   fg = '#FFFFFF',
                                                   justify = 'center',
                                                   background = '#D5A27C')
            self.boton_opcion_ordenado.pack(fill = 'x',
                                            expand = True,
                                            padx = 15,
                                            pady = 10,
                                            side = tk.RIGHT)
            self.modulo_historial.mainloop()
class Configuracion(tk.Frame):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.equipo_nombre = socket.gethostname()
        self.equipo_ip = socket.gethostbyname(self.equipo_nombre)

        self.__nombre_equipo = tk.StringVar()
        self.__nombre_equipo.set(self.equipo_nombre)
        self.__ip_equipo = tk.StringVar()
        self.__ip_equipo.set(self.equipo_ip)

        #os.path.join()
        self.__icono_configuracion = r'./icon/icono_configuracion.jpg'
        self.__icono_modo = r'./icon/icono_modo.jpg'
        self.__icono_usuario = r'./icon/icono_usuario.jpg'
        self.__modo_claro = True
        self.__modo_oscuro = False

        self.frame_barra_configuracion = tk.Frame(self,
                                                  background = '#D5A27C')
        self.frame_barra_configuracion.pack(fill = 'x',
                                            expand = True,
                                            side = tk.TOP)

        self.frame_panel = tk.Frame(self.frame_barra_configuracion,
                                    background = '#D5A27C')
        self.frame_panel.pack(fill = 'x',
                              expand = True,
                              side = tk.LEFT,
                              padx = 5,
                              pady = 8)

        self.__configuracion = tk.PhotoImage(file = self.__icono_configuracion)
        self.boton_configuracion = tk.Button(self.frame_panel,
                                             relief = 'flat')
        self.boton_configuracion.config(image = self.__configuracion,
                                        activebackground = '#000000',
                                        background = '#000000')
        self.boton_configuracion.pack(expand = True,
                                      side = tk.LEFT)

        self.__modo = tk.PhotoImage(file = self.__icono_modo)
        self.boton_modo = tk.Button(self.frame_panel, relief = 'flat')
        self.boton_modo.config(image = self.__modo,
                               activebackground = '#000000',
                               background = '#000000')
        self.boton_modo.pack(expand = True,
                             side = tk.RIGHT)

        self.__usuario = tk.PhotoImage(file = self.__icono_usuario)
        self.boton_usuario = tk.Button(self.frame_panel,
                                       relief = 'flat',
                                       command = self.__informacion_usuario)
        self.boton_usuario.config(image = self.__usuario,
                                  activebackground = '#000000',
                                  background = '#000000')
        self.boton_usuario.pack(expand = True,
                                side = tk.RIGHT)
    def __informacion_usuario(self):
        self.modulo_usuario = tk.Toplevel()
        self.modulo_usuario.geometry('500x400')
        self.modulo_usuario.resizable(tk.FALSE, tk.FALSE)
        self.modulo_usuario.configure(background = '#786271')
        self.modulo_usuario.title('Información del Usuario')

        self.frame_informacion_usuario = tk.Frame(self.modulo_usuario,
                                               bd = 10,
                                               relief = 'flat',
                                               background = '#FFFFFF')
        self.frame_informacion_usuario.pack(fill = 'both',
                                            expand = True,
                                            pady = 50)
        self.labelFrame_informacion = tk.LabelFrame(self.frame_informacion_usuario,
                                                      relief = 'solid',
                                                      bd = 1,
                                                      text = 'Información del Usuario',
                                                      font = ('Ubuntu light', 12),
                                                      fg = '#000000',
                                                      background = '#FFFFFF')
        self.labelFrame_informacion.pack(fill = 'both',
                                         expand = True,
                                         padx = 10,
                                         pady = 15)
        self.entry_nombre_equipo = tk.Entry(self.labelFrame_informacion,
                                         textvariable = self.__nombre_equipo,
                                         state = 'readonly',
                                         justify = 'center',
                                         relief = 'solid',
                                         bd = 1,
                                         font = ('Ubuntu light', 13),
                                         background = '#0078D7',
                                         fg = '#000000',
                                         width = 30)
        self.entry_nombre_equipo.pack(expand = True,
                                      padx = 20,
                                      pady = 10)
        self.entry_ip_equipo = tk.Entry(self.labelFrame_informacion,
                                     textvariable = self.__ip_equipo,
                                     state = 'readonly',
                                     justify = 'center',
                                     relief = 'solid',
                                     bd = 1,
                                     font = ('Ubuntu light', 13),
                                     background = '#0078D7',
                                     fg = '#000000',
                                     width = 30)
        self.entry_ip_equipo.pack(fill = 'none',
                                  expand = True,
                                  padx = 20,
                                  pady = 10)
        self.boton_cargar_datos = tk.Button(self.labelFrame_informacion,
                                         text = 'Finalizar',
                                         font = ('Ubuntu light', 12),
                                         fg = '#FFFFFF',
                                         relief = 'flat',
                                         width = 30,
                                         background = '#D5A27C')
        self.boton_cargar_datos.pack(expand = True, padx = 10, pady = 20)
        self.modulo_usuario.mainloop()
# Clase principal
class Ventana(ttk.Frame):
    def __init__(self, root):
        super().__init__(root)
        root.title(
            'app'
            )
        root.geometry(
            '700x480'
            )
        root.resizable(
            tk.FALSE,
            tk.FALSE
        )
        self.reloj = tk.Label(
            self,
            font = ('Ubuntu light', 14, 'bold'),
            background = '#786271',
            foreground = '#FFFFFF'
            )
        self.reloj.pack(
            fill = 'both',
            expand = True,
            padx = 15,
            pady = 15
            )
        self.reloj_sistema()
        self.ventana_notebook = ttk.Notebook(self)
        self.frame_inicio = Inicio(self.ventana_notebook,)
        self.frame_operacion = Operacion(self.ventana_notebook)
        self.frame_configuracion = Configuracion(self.ventana_notebook)

        self.frame_inicio.configure(
            background = '#FFFFFF'
            )
        self.frame_operacion.configure(
            background = '#FFFFFF'
            )
        self.frame_configuracion.configure(
            background = '#FFFFFF'
            )
        self.ventana_notebook.add(
            self.frame_inicio,
            text = 'Inicio',
            padding = 30
            )
        self.ventana_notebook.add(
            self.frame_operacion,
            text = 'Operación',
            padding = 30
            )
        self.ventana_notebook.add(
            self.frame_configuracion,
            text = 'Configuración',
            padding = 30
            )
        self.ventana_notebook.pack(
            fill = 'both',
            expand = True,
            padx = 12,
            pady = 12
            )
        self.pack(
            fill = 'both',
            expand = True
            )
    def reloj_sistema(self):
        hora = strftime('%H:%M:%S %p')
        self.reloj.config(
            text = hora
            )
        self.reloj.after(
            200,
            self.reloj_sistema
            )
root = tk.Tk()
Programa = Ventana(root)
Programa.mainloop()