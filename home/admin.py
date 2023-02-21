from django.contrib import admin
from .models import Categoria, Tecnologia
# Register your models here.

class CategoriaAdmin(admin.ModelAdmin):
    readonly_fields=('created','updated')
    
class TecnologiaAdmin(admin.ModelAdmin):
    list_display=('titulo','updated')
    readonly_fields=('created','updated')   
    
admin.site.register(Categoria,CategoriaAdmin)

admin.site.register(Tecnologia,TecnologiaAdmin)   