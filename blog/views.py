from django.shortcuts import render
from .models import Blog,Categoria
# Create your views here.
def blog(request):
    blog=Blog.objects.all()
    categoria=Categoria.objects.all()
    return render(request,'blog/blog.html',{'blogs':blog,'categorias':categoria})

def categoria(request,categoria_id):
    categoria_todas= Categoria.objects.all()
    categoria=Categoria.objects.get(id=categoria_id)
    blog=Blog.objects.filter(categoria=categoria)
    return render(request,'blog/categoria.html',{'categoria':categoria,'blogs':blog,'categorias_todas':categoria_todas})

def contenido_blog(request,blog_id):
    blog=Blog.objects.filter(id=blog_id)
    return render(request,'blog/contenido-blog.html',{'blogs':blog})
