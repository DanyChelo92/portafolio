from django.contrib import admin
from .models import Categoria,Blog
# Register your models here.

class CategoriaAdmin(admin.ModelAdmin):
    readonly_fields=('created','updated')
    
class BlogAdmin(admin.ModelAdmin):
    list_display=('titulo','autor')
    readonly_fields=('created','updated')   
    
admin.site.register(Categoria,CategoriaAdmin)

admin.site.register(Blog,BlogAdmin)