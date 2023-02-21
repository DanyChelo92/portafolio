from django.contrib import admin
from .models import Herramienta,Proyecto
# Register your models here.

class HerramientaAdmin(admin.ModelAdmin):
    list_display=('nombre','updated')
    readonly_fields=('created','updated')
    
class ProyectoAdmin(admin.ModelAdmin):
    list_display=('titulo','updated')
    readonly_fields=('created','updated')   
    
admin.site.register(Herramienta,HerramientaAdmin)

admin.site.register(Proyecto,ProyectoAdmin)