from django.db import models
# Create your models here.

class Herramienta(models.Model):
    nombre=models.CharField(max_length=50)
    imagen=models.ImageField(upload_to='proyectos/imagenes')
    created=models.DateTimeField(auto_now_add=True)
    updated=models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name='herramienta'
        verbose_name_plural='herramientas'

    def __str__(self):
        return self.nombre

class Proyecto(models.Model):
    titulo=models.CharField(max_length=250)
    contenido=models.TextField(max_length=12000)
    imagen=models.ImageField(upload_to='proyectos/imagenes')
    proyecto=models.FileField(upload_to='proyectos/proyectos')
    herramientas=models.ManyToManyField(Herramienta)
    created=models.DateTimeField(auto_now_add=True)
    updated=models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name='proyecto'
        verbose_name_plural='proyectos'

    def __str__(self):
        return self.titulo