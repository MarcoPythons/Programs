from django.db import models
from registros.models import usuario



class Productos(models.Model):
    nombre = models.CharField(null=False, default= "",max_length=40)
    calorias = models.IntegerField(null=True)
    usuario = models.ForeignKey(usuario, on_delete=models.CASCADE)
