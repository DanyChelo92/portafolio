from django.db import models
from django.contrib.auth.models import User
from django.forms import ModelForm, Textarea

# Create your models here.

class Categoria(models.Model):
    nombre=models.CharField(max_length=50)
    created=models.DateTimeField(auto_now_add=True)
    updated=models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name='categoria'
        verbose_name_plural='categorias'

    def __str__(self):
        return self.nombre

class Blog(models.Model):
    titulo=models.CharField(max_length=50)
    resumen=models.TextField(max_length=1000)
    contenido=models.TextField(max_length=20000)
    imagen=models.ImageField(upload_to='Blog', null=True, blank=True)
    autor=models.ForeignKey(User, on_delete=models.CASCADE)
    categoria=models.ManyToManyField(Categoria)
    created=models.DateTimeField(auto_now_add=True)
    updated=models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name='blog'
        verbose_name_plural='blogs'

    def __str__(self):
        return self.titulo