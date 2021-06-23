from django.db import models




class cliente(models.Model):
    rut= models.CharField(null = False, max_length=10)
    nombre = models.CharField(null = False, max_length=30)
    email= models.EmailField(null = False, max_length=100)
    telefono = models.CharField(null = False, max_length=20)
    mensaje= models.TextField() 
    
    class Meta:
       db_table='cliente'
       ordering = ['rut']
