from django.db import models
from django.contrib.auth.models import AbstractBaseUser, BaseUserManager


class UsuarioManager(BaseUserManager): #con esto se puede crear usuarios personalizados
    
    def create_user(self,username, password):   #asi creo un usuario normal
       
        usuario = self.model(
            username = username, 
        ) 
        usuario.set_password(password) # asi encriptamos la contraseña 
        usuario.save()

        return usuario

    def create_superuser(self, username, password): # asi se crea un usuario administrador
        usuario = self.create_user(
            username = username, 
            password = password
        )   

        usuario.usuario_administrador = True
        usuario.save()
        return usuario
    
class usuario(AbstractBaseUser): # usuario personalizado
    username = models.CharField(unique=True, max_length=30)
    is_active = models.BooleanField(default = True) #permisos de usuario normal
    usuario_administrador = models.BooleanField(default= False) #permisos de administrador
    objects = UsuarioManager()


    USERNAME_FIELD = 'username'

    def __str__(self):
        return f'{self.username}'

    def has_perm(self,perm,obj = None): #se debe crear este metodo para que el administrado de djnago pueda acceder al admin de djnago
        return True

    def has_perms(self,perm,obj = None):
        return True
    
    def has_module_perms(self,app_label): #este metodo sirve para usarse en el admin de django
        return True

    @property
    def is_staff(self):
        return self.usuario_administrador


    
    class Meta:
        db_table = 'Usuarios' # para que la tabla se llame "Cliente" en la base de datos
