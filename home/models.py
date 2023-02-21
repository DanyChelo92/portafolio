from django.db import models

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
    
class Tecnologia(models.Model):
    titulo=models.CharField(max_length=50)
    imagen=models.ImageField(upload_to='Home')
    categoria=models.ForeignKey(Categoria,on_delete=models.CASCADE)
    created=models.DateTimeField(auto_now_add=True)
    updated=models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name='tecnologia'
        verbose_name_plural='tecnologias'

    def __str__(self):
        return self.titulo    