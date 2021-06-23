from django.db import models


class usuario(models.Model):
    run= models.CharField(null = False, max_length=10)
    nombre = models.CharField(null = False, max_length=30)
    email= models.EmailField(null = False, max_length=20)
    telefono = models.CharField(null = False, max_length=20)
    mensaje= models.TextField() 
    
    class Meta:
       db_table='usuario'
       ordering = ['run']
