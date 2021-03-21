from django import forms 
from django.forms import ModelForm
from registros.models import usuario
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User




class ClienteForm(forms.ModelForm):
    # Formulario de registro de un usuario en la base de datos

    password = forms.CharField(label = 'Contraseña',widget = forms.PasswordInput( #con widgets se pueden editar las etiquetas html que crea la api form

        attrs = {
            'class':'form-control',
            'id':'clave',
            'name':'password',
            'placeholder':'Ingresa tu contraseña',
            'required':'required'
        }))
    password2 = forms.CharField(label = 'Ingrese Contraseña Nuevamente',widget = forms.PasswordInput(

        attrs = {
            'class':'form-control',
            'id':'clave2',
            'name':'password2',
            'placeholder':'Repite tu contraseña',
            'required':'required'
        }
))

    class Meta:
        model = usuario
        fields = ('username',) #aca se pueden editar los tags html de los campos del modelo
        labels = {
            'username':'Nombre de usuario',
            
        }
        widgets = {
            'username': forms.TextInput (
                
            attrs ={
                'class': 'form-control',
                'id': 'username',
                'name': 'username',
                'placeholder': 'Ingresa un Nombre de usuario',
                'required':'required'
            })}
    def clean_password(self): #aqui validamos la contraseña
        password1 = self.cleaned_data.get('password1')
        password2 = self.cleaned_data.get('password2')
        if password1 and password2 and password1 !=password2:
            raise forms.ValidationError('Las contraseñas no coinciden')
        return password2


    def save(self, commit = True): #aqui guardamos la contraseña cuando se valida
        user = super().save(commit = False)
        user.set_password(self.cleaned_data['password2'])
        if commit:
            user.save()
        return user


