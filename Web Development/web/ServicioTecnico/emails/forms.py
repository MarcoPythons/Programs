from django import forms 
from django.forms import ModelForm
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from emails.models import cliente






class ClienteForm(forms.ModelForm):
    class Meta:
        model = cliente
        fields = (  'rut', 'nombre', 'email', 'telefono', 'mensaje' )
        labels = {'rut':'', 
                'nombre':'', 
                'email':'', 
                'telefono':'',
                'mensaje':'' }

        widgets = {
           
                'rut' :forms.TextInput(
                attrs={
                    'class':'contactus',
                    'placeholder':'Rut',
                    'type':'text',
                    'name':'Rut',
                    'required':'required'

                    }),
                 'nombre' :forms.TextInput(
                attrs={
                    'class':'contactus',
                    'placeholder':'Nombre',
                    'type':'text',
                    'name':'Name',
                    'required':'required'

                    }),
                'email' :forms.TextInput(
                attrs={
                    'class':'contactus',
                    'placeholder':'Email',
                    'type':'text',
                    'name':'Email',
                    'required':'required'

                    }),
                'telefono' :forms.TextInput(
                attrs={
                    'class':'contactus',
                    'placeholder':'Telefono',
                    'type':'text',
                    'name':'Phone',
                    'required':'required'

                    }),
                'mensaje' :forms.TextInput(
                attrs={
                    'class':'textarea',
                    'placeholder':'Mensaje',
                    'type':'text',
                    'name':'Message',
                    'required':'required'

                    }),
                }

