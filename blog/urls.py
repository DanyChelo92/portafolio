from django.urls import path
from . import views

urlpatterns = [
    path('',views.blog,name='blog'),
    path('categoria/<int:categoria_id>',views.categoria,name='categoria'),
    path('contenido-blog/<int:blog_id>',views.contenido_blog,name='contenido_blog'),
]